package dao;

import java.util.HashMap;
import java.util.Map;

import modelo.Pelicula;


/**
 * Singleton que actuar� como proveedor de contenidos
 * 
 * @author Adrian
 *
 */
public enum PeliculaDao {

	INSTANCE;
	
	private Map<String,Pelicula> contentsProvider = new HashMap<String,Pelicula>();
	
	private PeliculaDao() {
		
		Pelicula peli = new Pelicula("1","El se�or de los anillos","Peter Jackson");
		contentsProvider.put("1",peli);
		
		peli = new Pelicula("2", "Star Wars", "George Lucas");
		contentsProvider.put("2", peli);
		
	}
	
	public Map<String, Pelicula> getModel(){
		return contentsProvider;
	}
}
