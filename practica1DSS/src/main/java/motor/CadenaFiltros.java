package motor;

import java.util.ArrayList;

/**
 * Clase que contiene todos los filtros y el objetivo final,
 * se encarga de aplicar todos los filtros a una peticion y mandar
 * el resultado al objetivo
 * @author Adrián
 *
 */
public class CadenaFiltros{
	
	private ArrayList<Filtro> filtros;
	
	private Interfaz objetivo;
	
	public CadenaFiltros() {
		filtros = new ArrayList();
	}
	
	public void addFiltro(Filtro filtro){
		filtros.add(filtro);
	}
	
	/**
	 * Aplica la petición al primer filtro y va encadenando los
	 * resultados de aplicar un filtro al siguiente filtro
	 * @param peticion
	 */
	public void ejecutar(double peticion){
		
		double resultadoFiltro = peticion;
		for(Filtro filtro:filtros){
			resultadoFiltro = filtro.ejecutar(resultadoFiltro);
		}
		
		objetivo.ejecutar(resultadoFiltro);
	}
	
	public void setObjetivo(Interfaz objetivo){
		this.objetivo=objetivo;
	}
}
