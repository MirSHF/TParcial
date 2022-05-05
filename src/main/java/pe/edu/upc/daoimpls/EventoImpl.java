package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.CEventoDao;
import pe.edu.upc.entities.Evento;

public class EventoImpl implements CEventoDao {

	@PersistenceContext(unitName = "majak")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Evento ev) {

		try {
			em.persist(ev);
		} catch (Exception e) {
			System.out.println("Error al insertar evento");
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Evento> list() {
		List<Evento> listaEvento = new ArrayList<Evento>();

		try {
			Query jpql = em.createQuery("from Evento ev");
			listaEvento = (List<Evento>) jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar en el dao Evento");
		}
		return listaEvento;
	}

	@Transactional
	@Override
	public void delete(int id) {
		Evento even = em.find(Evento.class, id);
		em.remove(even);

	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Evento> findByNameEvento(Evento ev) {
		List<Evento> lista = new ArrayList<Evento>();
		try {
			Query q=em.createQuery("from Evento ev where ev.nombreEvento like ?1");
			q.setParameter(1, "%"+ev.getNombreEvento() +"%");
			lista=(List<Evento>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al buscar evento en el DAO");
		}
		return lista;
	}

}
