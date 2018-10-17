package motor;

/**
 * Clase encargada de enviar una petición al gestor de filtros para que este se los aplique
 * y finalmente envie la peticion resultante al objetivo
 * @author atr_9
 *
 */
public class Cliente {
	
	GestorFiltros gestor;
	
	public void setGestorFiltros(GestorFiltros gestor) {
		this.gestor = gestor;
	}
	
	public void enviarPeticion(double peticion) {
		gestor.recibirPeticion(peticion);
	}

}
