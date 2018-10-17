package prueba;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean (name="mensaje", eager = false)
@RequestScoped
public class MensajeBean implements Serializable{

	private String mensaje ="Hola todo el mundo y parte del extranjero";
	
	public String getMensaje() {
		return mensaje;
	}
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
