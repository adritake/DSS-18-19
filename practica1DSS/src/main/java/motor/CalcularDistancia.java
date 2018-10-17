package motor;

/**
 * Implementa la interfaz Filtro y se encarga de calcular una distancia a partir de unas revoluciones
 * @author Adrián
 *
 */
public class CalcularDistancia implements Filtro {

	final double RADIO = 0.5;
	final double PI = 3.1416;
	
	public double ejecutar(double d) {
		double revoluciones = d;
		double distancia = revoluciones * 2 * RADIO * PI;
		System.out.println("Filtro CalcularDistancia: distancia = " + distancia + " m");
		return distancia;
	}

}
