package motor;


/**
 * Implementa la clase filtro y su objetivo es calcular la velocidad a raiz de una distancia
 * @author Adrián
 *
 */
public class Calcular implements Filtro {

	final double INTERVALO = 7200; //Para que la velociad salga en m/h en un intervalo de 2 horas
	
	public double ejecutar(double d) {
		double distancia = d ;
		double velocidad = distancia*3600/INTERVALO;
		System.out.println("Filtro Calcular: velocidad = " + velocidad + " m/h");
		return velocidad;
	}
	

}
