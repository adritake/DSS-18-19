package modelo;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * Clase Pelicula que servirá para almacenar los datos de una película y poder ser codificada en xml
 * 
 * @author Adrian
 *
 */
@XmlRootElement
public class Pelicula {
	
	private String id;
	private String nombre;
	private String director;

	public Pelicula() {
		this.setId("");
		this.setNombre("");
		this.setDirector("");
	}
	
	public Pelicula(String id, String nombre, String director) {
		this.setId(id);
		this.setNombre(nombre);
		this.setDirector(director);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}
}
