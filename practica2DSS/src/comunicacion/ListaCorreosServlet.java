package comunicacion;

import java.util.List;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.BDUsuario;
import modelo.Usuario;

/**
 * Servlet encargado de atender las peticiones del cliente y almacenar o borrar usuarios de la base
 * de datos.
 * 
 * @author Adrián
 *
 */
public class ListaCorreosServlet extends HttpServlet {

	/**
	 * Función encargada de realizar la operación indicada por el cliente y enviar los resultados
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String accion = request.getParameter("action");
		String name = request.getParameter("nombre");
		String surname = request.getParameter("apellido");
		String email = request.getParameter("email");

		if (accion == null) {
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			
			writer.println("<h1>Usuarios</h1>");
			writer.println("<h2>Nombre	Apellido	Email</h2>");
			for (Usuario usuario: BDUsuario.listarUsuarios()) {
				writer.println("<p>" + usuario.getNombre() + " - " + usuario.getApellido() + " - " + usuario.getEmail() + "</p>");
			}
			
			
		} else {
			//PrintWriter writer2 = response.getWriter();
			ObjectOutputStream objeto = new ObjectOutputStream(response.getOutputStream());
			
			switch (accion) {
			
			case "listarUsuarios":
				List<Usuario> listaUsuarios = BDUsuario.listarUsuarios();
				objeto.writeObject(listaUsuarios);
				objeto.flush();
				objeto.close();
				break;
				
			case "eliminarUsuario":
				if (BDUsuario.existeEmail(email)) {
					Usuario user = BDUsuario.seleccionarUsuario(email);
					BDUsuario.eliminar(user);

					objeto.writeInt(0);
					objeto.writeObject("Usuario eliminado correctamente");
				} else {
					objeto.writeInt(1);
					objeto.writeObject("Error eliminando usuario");
				}
				break;
			case "aniadirUsuario":
				if (!BDUsuario.existeEmail(email)) {
					Usuario usuario = new Usuario(name,surname,email);
					BDUsuario.insertar(usuario);
					objeto.writeInt(0);
					objeto.writeObject("Usuario aniadido correctamente");
				} else {
					objeto.writeInt(1);
					objeto.writeObject("Error anadiendo usuario");
				}
				break;
			case "actualizarUsuario":
				if (BDUsuario.existeEmail(email)) {
					Usuario user = BDUsuario.seleccionarUsuario(email);
					BDUsuario.actualizar(user);
					objeto.writeInt(0);
					objeto.writeObject("Usuario actualizado correctamente");
				} else {
					objeto.writeInt(1);
					objeto.writeObject("Error actualizando usuario");
				}
				break;
			}
			
			objeto.flush();
			objeto.close();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
