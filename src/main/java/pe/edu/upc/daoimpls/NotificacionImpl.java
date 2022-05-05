package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.CNotificacionDao;
import pe.edu.upc.entities.Notificacion;

public class NotificacionImpl implements CNotificacionDao {

	@PersistenceContext(unitName = "majak")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Notificacion not) {
		try {
			em.persist(not);
		} catch (Exception e) {
			System.out.println("Error al insertar Notificación");
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Notificacion> list() {
		List<Notificacion> listaNotificacion = new ArrayList<Notificacion>();

		try {
			Query jpql = em.createQuery("from Notificacion n");
			listaNotificacion = (List<Notificacion>) jpql.getResultList();

		} catch (Exception e) {
			System.out.println("Error al listar en el dao Notificacion");
		}
		return listaNotificacion;
	}

	@Transactional
	@Override
	public void delete(int id) {
		Notificacion notif = em.find(Notificacion.class, id);
		em.remove(notif);

	}

	@Transactional
	@Override
	public void update(Notificacion not) {
		try {
			em.merge(not);
		} catch (Exception e) {
			System.out.println("Error al actualizar en el dao Notificación");
		}
	}

}
