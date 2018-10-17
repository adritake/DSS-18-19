package prueba;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;


@ManagedBean(name="holaMundo2",eager = true)
@RequestScoped
public class HolaMundo2 implements Serializable {
	
	@ManagedProperty(value = "#{mensaje}")
	private MensajeBean mensajeBean;
	
	private String mensaje = "Nada aun!";
	
	public HolaMundo2() {
		System.out.println("Hola mundo 2 ha comezado!");
		
	}
	
	public String getMensaje() {
		if (mensajeBean != null)
			mensaje = mensajeBean.getMensaje();
		return mensaje;
	}
	
	public void SetMensaje(String m) {
		mensaje = m;
	}
	
	public MensajeBean getMensajeBean() {
		return mensajeBean;
	}
	
	public void setMensajeBean(MensajeBean m) {
		mensajeBean = m;
	}
	
	
}
