package interfaz;

import modelo.Usuario;

import java.awt.EventQueue;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JTextPane;

import javafx.scene.control.TableColumn;

import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToolBar;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;


/**
 * Interfaz gráfica del cliente
 * @author Adrián
 *
 */
public class MiCliente implements ActionListener {

	private JFrame frame;
	JTextPane panelUsuarios = new JTextPane();
	
	final String urlString = "http://localhost:8080/practica2DSS/ListaCorreosServlet";
	private JTextField txtCorreoElectrnico;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCorreoElectrnico_1;
	JButton btnAadirUsuario = new JButton("A\u00F1adir usuario");
	JButton btnEliminarUsuario = new JButton("Eliminar usuario");
	JPanel panelBorrarUsuario = new JPanel();
	JButton btnBorrarUser = new JButton("Borrar");
	JPanel panelAniadirUsuario = new JPanel();
	JButton btnAadir = new JButton("A\u00F1adir");
	JButton btnCancelar = new JButton("Cancelar");
	private final JPanel panelOpciones = new JPanel();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiCliente window = new MiCliente();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MiCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 344);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow][grow]", "[][grow][grow]"));
		
		
		btnAadirUsuario.setActionCommand("SHOW_ADD_USER");
		btnAadirUsuario.addActionListener(this);
		frame.getContentPane().add(btnAadirUsuario, "cell 0 0");
		
		
		btnEliminarUsuario.setActionCommand("SHOW_DELETE_USER");
		btnEliminarUsuario.addActionListener(this);
		frame.getContentPane().add(btnEliminarUsuario, "cell 1 0");
		
		
		frame.getContentPane().add(panelUsuarios, "cell 0 1,grow");
		
		frame.getContentPane().add(panelOpciones, "cell 1 1,grow");
		panelOpciones.setLayout(new CardLayout(0, 0));
		panelOpciones.add(panelBorrarUsuario, "name_9586802226511");
		panelBorrarUsuario.setLayout(new MigLayout("", "[grow]", "[][]"));
		
		txtCorreoElectrnico = new JTextField();
		txtCorreoElectrnico.setText("Correo electr\u00F3nico");
		panelBorrarUsuario.add(txtCorreoElectrnico, "cell 0 0,growx");
		txtCorreoElectrnico.setColumns(10);
		
		
		btnBorrarUser.setActionCommand("DELETE_USER");
		btnBorrarUser.addActionListener(this);
		panelBorrarUsuario.add(btnBorrarUser, "cell 0 1");
		panelOpciones.add(panelAniadirUsuario, "name_9589572108964");
		panelAniadirUsuario.setLayout(new MigLayout("", "[grow]", "[][][][][]"));
		
		txtNombre = new JTextField();
		txtNombre.setText("Nombre");
		panelAniadirUsuario.add(txtNombre, "cell 0 0,growx");
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setText("Apellido");
		panelAniadirUsuario.add(txtApellido, "cell 0 1,growx");
		txtApellido.setColumns(10);
		
		txtCorreoElectrnico_1 = new JTextField();
		txtCorreoElectrnico_1.setText("Correo electr\u00F3nico");
		panelAniadirUsuario.add(txtCorreoElectrnico_1, "cell 0 2,growx");
		txtCorreoElectrnico_1.setColumns(10);
		
		
		btnAadir.setActionCommand("ADD_USER");
		btnAadir.addActionListener(this);
		panelAniadirUsuario.add(btnAadir, "cell 0 3");
		
		btnCancelar.setActionCommand("CANCEL_ADD");
		btnCancelar.addActionListener(this);
		panelAniadirUsuario.add(btnCancelar, "cell 0 4");
		panelAniadirUsuario.setVisible(false);
		panelBorrarUsuario.setVisible(false);
		
		//Mostrar usuarios
		ActualizarPanelUsuarios();
		
	
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("SHOW_ADD_USER")) {
			panelAniadirUsuario.setVisible(true);
			panelBorrarUsuario.setVisible(false);
		}
		else if(e.getActionCommand().equals("SHOW_DELETE_USER")) {
			panelAniadirUsuario.setVisible(false);
			panelBorrarUsuario.setVisible(true);
		}
		else if(e.getActionCommand().equals("ADD_USER")) {
			
			String nombre = txtNombre.getText();
			String apellido = txtApellido.getText();
			String correo = txtCorreoElectrnico_1.getText();
			try {
				Map<String,String> parametros = new HashMap<String, String>();
				parametros.put("action", "aniadirUsuario");
				parametros.put("nombre", nombre);
				parametros.put("apellido", apellido);
				parametros.put("email", correo);		
				ObjectInputStream respuesta = new ObjectInputStream(realizarPeticionPost(urlString, parametros));
			}
			catch (Exception e1) {
				e1.printStackTrace();
			}
			
			ActualizarPanelUsuarios();
			panelAniadirUsuario.setVisible(false);	
		}
		else if(e.getActionCommand().equals("CANCEL_ADD")) {
			panelAniadirUsuario.setVisible(false);
		}
		else if(e.getActionCommand().equals("DELETE_USER")) {
			try {
				String correo = txtCorreoElectrnico.getText();
				Map<String,String> parametros = new HashMap<String, String>();
				parametros.put("action", "eliminarUsuario");
				parametros.put("email", correo);
				ObjectInputStream respuesta = new ObjectInputStream(realizarPeticionPost(urlString, parametros));
				
				ActualizarPanelUsuarios();
			}
			catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	
		
		
	}
	
	private void ActualizarPanelUsuarios() {
		
		List<Usuario> lu = obtenerUsuarios();
		String texto = "Vacío";
		if(!lu.isEmpty()) {
			texto = "";
			for(Usuario u: lu) {
				texto += u.toString();
				texto += "\n";
			}
		}
		panelUsuarios.setText(texto);
		
	}
	
	private List<Usuario> obtenerUsuarios(){
		
		try {
			Map<String,String> parametros = new HashMap<String, String>();
			parametros.put("action", "listarUsuarios");
			ObjectInputStream respuesta = new ObjectInputStream(realizarPeticionPost(urlString, parametros));
			List<Usuario> listaUsuarios = (List<Usuario>) respuesta.readObject();	
			return listaUsuarios;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//Realiza una peticion POST a una URL con los parametros que se le pasan
	//@param urlString : Direccion a la que se desea realizar la peticion
	//@param parametros : Parametros de la peticion
	//@return : Respuesta obtenida tras la peticion o <tt>null</tt> en caso de fallar la peticion/respuesta 
	@SuppressWarnings("deprecation")
	public InputStream realizarPeticionPost(String urlString, Map<String,String> parametros) {
		String cadenaParametros = "";
		boolean primerPar = true;
		for (Map.Entry<String, String> entry : parametros.entrySet()) {
			if (!primerPar) {
				cadenaParametros += "&";
			} else {
				primerPar = false;
			}
		    String parDeParametro = String.format("%s=%s", 
					URLEncoder.encode(entry.getKey()), 
					URLEncoder.encode(entry.getValue()));
		    cadenaParametros += parDeParametro;
		}
		try {
			URL url = new URL(urlString);
			HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
			conexion.setUseCaches(false);
			conexion.setRequestMethod("POST");
			conexion.setDoOutput(true);
			OutputStream output = conexion.getOutputStream();
			output.write(cadenaParametros.getBytes());
			output.flush();
			output.close();
			return conexion.getInputStream();
		} catch (MalformedURLException | ProtocolException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}

}
