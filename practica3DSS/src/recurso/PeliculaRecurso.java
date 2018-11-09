package recurso;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import dao.PeliculaDao;
import modelo.Pelicula;


/**
 * Clase que se encarga de devolver una instancia de la clase que representa al dominio de datos “Pelicula” de nuestra aplicación
 * @author Adrian
 *
 */
@Path("/pelicula")
public class PeliculaRecurso {

	@Context
	UriInfo uirInfo;
	
	@Context
	Request request;
	
	String id;
	
	public PeliculaRecurso(UriInfo uriInfo, Request request, String id) {
		this.uirInfo = uriInfo;
		this.request = request;
		this.id = id;
	}
	
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Pelicula getXML() {
		Pelicula peli = PeliculaDao.INSTANCE.getModel().get(id);
		
		if(peli == null)
			System.err.println("No se ha encontrado la película");
		
		return peli;
		
	}
	
	@GET
	@Produces({MediaType.TEXT_XML})
	public Pelicula getHTML() {
		Pelicula peli = PeliculaDao.INSTANCE.getModel().get(id);
		if(peli == null)
			System.err.println("No se ha encontrado la película");
		
		return peli;
	}
	
	@DELETE
	public void deletePelicula() {
		PeliculaDao.INSTANCE.getModel().remove(id);
		
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response putJugador(@PathParam("id") String id, Pelicula p) {
		
		PeliculaDao.INSTANCE.getModel().put(id, p);
		
		return Response.ok().entity(p).build();
		
		
	}
	

}
