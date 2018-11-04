package modelo;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Clase Usuario donde se almacenan todos los datos
 * @author Adri�n
 *
 */
@Entity
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;
	private String nombre;
	private String apellido;
	private String email;
	
	public Usuario() {}
	
	public Usuario(Usuario us) {
		
		id = us.getId();
		nombre = us.getNombre();
		apellido = us.getApellido();
		email = us.getEmail();
		
	}
	
	public Usuario(String nombre, String apellido, String email) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override 
	public String toString(){
		return nombre + " " + apellido + " - " + email;
	}

}
