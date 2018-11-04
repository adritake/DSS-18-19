package modelo;

import java.util.List;

import javax.persistence.*;


/**
 * Clase encargada de administrar la persistencia de los usuarios
 * @author Adrián
 *
 */
public class BDUsuario {
	private static final String PERSISTENCE_UNIT_NAME = "usuario";
	private static EntityManagerFactory factoria = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	
	public static void insertar(Usuario usuario) {
		
		if(factoria==null)
			factoria = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

		EntityManager em = factoria.createEntityManager();
		
		if(!existeEmail(usuario.getEmail())) {
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
			em.close();
		}
	}
	
	
	public static void eliminar(Usuario usuario) {
		
		if(factoria==null)
			factoria = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

		EntityManager em = factoria.createEntityManager();
		
		if(existeEmail(usuario.getEmail())) {
			Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email");
			q.setParameter("email", usuario.getEmail());
			
			Usuario resultado = (Usuario) q.getSingleResult();
			
			
			em.getTransaction().begin();
			em.remove(resultado);
			em.getTransaction().commit();
			em.close();
			
		}
	}
	
	
	public static void actualizar(Usuario usuario) {
		
		if(factoria==null)
			factoria = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

		EntityManager em = factoria.createEntityManager();
		
		if(!existeEmail(usuario.getEmail())) {
			Query q = em.createQuery("SELECT * FROM Usuario u WHERE u.email = :email");
			q.setParameter("email", usuario.getEmail());
			
			Usuario resultado = (Usuario) q.getSingleResult();
			resultado.setNombre(usuario.getNombre());
			resultado.setApellido(usuario.getApellido());
			
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
			em.close();
			
		} 
	}


	public static List<Usuario> listarUsuarios() {
		
		if(factoria==null)
			factoria = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		
		EntityManager em = factoria.createEntityManager();
		
		Query q = em.createQuery("SELECT u FROM Usuario u");
		
		@SuppressWarnings("unchecked")
		List<Usuario> resultado = q.getResultList();
		
		em.close();
		
		
		
		return resultado;
	}


	public static boolean existeEmail(String email) {
		
		if(factoria==null)
			factoria = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

		EntityManager em = factoria.createEntityManager();
		
		Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email");
		q.setParameter("email", email);
		
		boolean res = ! q.getResultList().isEmpty();
		em.close();
		
		return res;
		
		
		
	}


	public static Usuario seleccionarUsuario(String email) {
		
		if(factoria==null)
			factoria = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		
		EntityManager em = factoria.createEntityManager();
		
		Usuario us = null;
		
		if(existeEmail(email)) {
			
			
			
			Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email");
			
			q.setParameter("email", email);
			
			us = (Usuario)q.getSingleResult();
			em.close();
			
		}
		
		return us;
	}
	 
	
}
