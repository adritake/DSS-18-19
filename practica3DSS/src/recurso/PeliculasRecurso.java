package recurso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import dao.PeliculaDao;
import modelo.Pelicula;

/**
 * Clase que proporcina los métodos GET para acceder al recurso desde el navegador o desde una aplicación cliente,
 * PUT para incluir contenidos y DELETE para suprimirlos.
 * @author atr_9
 *
 */
@Path("/peliculas")
public class PeliculasRecurso {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Pelicula> getTodosBrowser(){
		List<Pelicula> pelis = new ArrayList<Pelicula>();
		pelis.addAll(PeliculaDao.INSTANCE.getModel().values());
		return pelis;
		
	}
	
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		int count = PeliculaDao.INSTANCE.getModel().size();
		return String.valueOf(count);
	}
	
	@Path("{pelicula}")
	public PeliculaRecurso getPelicula(@PathParam("pelicula") String id) {
		
		return new PeliculaRecurso(uriInfo,request,id);
	}
	

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Pelicula> getPeliculas(){
		
		List<Pelicula> pelis = new ArrayList();
		
		pelis.addAll(PeliculaDao.INSTANCE.getModel().values());
		return pelis;
	}

	
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void newPelicula(@FormParam("id") String id,
							@FormParam("nombre") String nombre,
							@FormParam("director") String director,
							@Context HttpServletResponse servletResponse) throws IOException{
		
		Pelicula peli = new Pelicula(id,nombre,director);
		
		PeliculaDao.INSTANCE.getModel().put(id, peli);
		servletResponse.sendRedirect("../crear_pelicula.html");
		
	}
	
	
	
	
	
}
