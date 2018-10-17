package prueba;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;


@ManagedBean(name="holaMundo",eager = true)
@RequestScoped
public class HolaMundo implements Serializable {
	
	//@ManagedProperty(value="#{mensaje}")
	private String  mensaje;
	
	public HolaMundo() {
		System.out.println("Hola mundo ha comezado!");
		mensaje = "El mensaje de hola mundo";
	}
	
	public String getMensaje() {
		return mensaje;
	}
	
	public void SetBeanMensaje(String m) {
		mensaje = m;
	}
	
}
