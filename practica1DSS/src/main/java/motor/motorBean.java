package motor;


import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.event.ActionEvent;


/**
 * 
 * Managed bean encargado de simular el estado de un motor
 * 
 * @author Adrián
 *
 */

@ManagedBean(name="motorBean",eager = false)
@SessionScoped
public class motorBean implements Serializable {

	
	private String etiqueta;
	private String colorEtiqueta;
	private String colorBoton;
	private boolean encendido;
	private String valorBoton;
	
	public motorBean() {
		etiqueta = "APAGADO";
		encendido = false;
		valorBoton="ENCENDER";
		setColorEtiqueta("red");
		setColorBoton("black");
		System.out.println("Se crea el bean");
		
	}
	
		
	public String getEtiqueta() {	
		return etiqueta;
	}
	
	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}
	
	public boolean getEncendido() {
		return encendido;
	}
	public void setEncendido(boolean e) {
		encendido = e;
	}
	
	public String getValorBoton() {
		return valorBoton;
	}
	
	public void setValorBoton(String v) {
		valorBoton= v;
	}
	
	public void enciende(ActionEvent event) {
		
		if(!encendido) {
			etiqueta="ENCENDIDO";
			colorEtiqueta = "green";
			encendido = true;
			valorBoton = "APAGAR";
			colorBoton = "red";
		}
		else {
			encendido = false;
			etiqueta="APAGADO";
			colorEtiqueta = "red";
			valorBoton = "ENCENDER";
			colorBoton = "black";
		}
	
		
	}
	
	public void acelera(ActionEvent event) {
		
		if(encendido) {
			etiqueta="ACELERANDO";
			colorEtiqueta="blue";
		}
		

		
	}


	public String getColorEtiqueta() {
		return colorEtiqueta;
	}


	public void setColorEtiqueta(String colorEtiqueta) {
		this.colorEtiqueta = colorEtiqueta;
	}


	public String getColorBoton() {
		return colorBoton;
	}


	public void setColorBoton(String colorBoton) {
		this.colorBoton = colorBoton;
	}
	
	
}
