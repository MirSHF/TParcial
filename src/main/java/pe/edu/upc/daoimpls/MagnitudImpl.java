package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.CMagnitudDao;
import pe.edu.upc.entities.Magnitud;

public class MagnitudImpl implements CMagnitudDao {
	@PersistenceContext(unitName = "majak")
	private EntityManager em;

	@Transactional
	public void insert(Magnitud m) {

		try {

			em.persist(m);
		} catch (Exception e) {
			System.out.println("Error al insertar persona en DAO");

		}
	}

	@SuppressWarnings("unchecked")
	public List<Magnitud> list() {
		List<Magnitud> listaMagnituds = new ArrayList<Magnitud>();
		try {
			Query jpql = em.createQuery("from Magnitud m");
			listaMagnituds = (List<Magnitud>) jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar en el DAO de persona");
		}
		return listaMagnituds;
	}

	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		Magnitud mag = em.find(Magnitud.class, id);

		em.remove(mag);
	}
}
