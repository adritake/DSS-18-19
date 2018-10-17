package motor;

/**
 * Clase encargada de crear la cadena de filtros y rellenarla con los objetos necesarios
 * @author Adrián
 *
 */

public class GestorFiltros {
	
	CadenaFiltros cadenaFiltros;
	Interfaz objetivo;
	
	public GestorFiltros(Interfaz interfaz) {
		objetivo = interfaz;
		cadenaFiltros = new CadenaFiltros();
		cadenaFiltros.setObjetivo(objetivo);
	}
	
	public void setFiltro(Filtro filtro) {
		cadenaFiltros.addFiltro(filtro);
	}
	
	public void recibirPeticion(double peticion) {
		cadenaFiltros.ejecutar(peticion);
	}

}
