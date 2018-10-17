package motor;

/**
 * Clase main en la que se crean todas las clases y se envía la peticion
 * @author Adrián
 *
 */

public class demoInterceptor {

	public static void main(String[] args) {
		
		GestorFiltros gestorFiltros = new GestorFiltros(new Interfaz());
		

		gestorFiltros.setFiltro(new CalcularDistancia());
		gestorFiltros.setFiltro(new Calcular());
		Cliente cliente = new Cliente();
		cliente.setGestorFiltros(gestorFiltros);
		cliente.enviarPeticion(500);
		
	}

}
