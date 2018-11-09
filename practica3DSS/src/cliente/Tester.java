package cliente;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.representation.Form;
import com.sun.jersey.api.client.ClientResponse;


import modelo.Pelicula;

import java.net.URI;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;


/**
 * Clase para probar el funcionamiento del programa. Se encarga de usar los métodos PUT, GET, POST y DELETE
 * 
 * @author Adrián
 *
 */
public class Tester{

	public static void main(String[]args){
		//TODO Auto-generated method stub
		ClientConfig config = new DefaultClientConfig();
		
		Client client = Client.create(config);
		WebResource servicio = client.resource(getBaseURI());
		
		//Crear una pelicula
		Pelicula peli = new Pelicula("3","Interestelar","Christopher Nolan");
		ClientResponse respuesta = servicio.path("rest").path("peliculas").path(peli.getId()).accept(MediaType.APPLICATION_XML).put( ClientResponse.class,peli);
		System.out.print("Código recibido:");
		//El código debería ser:201==created
		System.out.println(respuesta.getStatus());
		
		// Mostrar el contenido del recurso Peliculass como texto XML
		System.out.println("Mostrar como Texto XML Plano");
		System.out.println(servicio.path("rest").path("peliculas").accept(MediaType.TEXT_XML).get(String.class));
		
		// Ahora nos crearemos un cuarto recurso Pelicula utilizando un formulario Web
		System.out.println("Creacion de 1 formulario");
		Form form = new Form();
		form.add("id", "4");
		form.add("nombre", "Pulp Fiction");
		form.add("director", "Quentin Tarantino");
		respuesta = servicio.path("rest").path("peliculas").type(MediaType.APPLICATION_FORM_URLENCODED).post(ClientResponse.class, form);
		System.out.println("Respuesta con el formulario:\n" + respuesta.getEntity(String.class));
		
		// Mostrar el contenido del recurso Peliculas, se ha debido crear el elemento con id = 4
		System.out.println("Contenidos del recurso, despues de enviar el elemento id=4");
		System.out.println(servicio.path("rest").path("peliculas").accept(MediaType.APPLICATION_XML).get(String.class));
		
		//Vamos a eliminar los objetos con id = 1 del recurso
		servicio.path("rest").path("peliculas/1").delete();
		//Enseñamos el contenido del recurso "Peliculas", el elemento con id=1 debería haber sido eliminado ya
		System.out.println("El elemento con id = 1 en el recurso ha sido eliminado");
		System.out.println(servicio.path("rest").path("peliculas").accept(MediaType.APPLICATION_XML).get(String.class));
	
	}
	
	
	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/practica3DSS").build();
	}
	
}



