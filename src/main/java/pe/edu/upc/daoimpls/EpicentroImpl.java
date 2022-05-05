package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.CEpicentroDao;
import pe.edu.upc.entities.Epicentro;

public class EpicentroImpl implements CEpicentroDao {
	@PersistenceContext(unitName = "majak")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Epicentro e) {
		try {
			em.persist(e);
		} catch (Exception e2) {
			System.out.println("Error al insertar epicentro en DAO");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Epicentro> list() {
		List<Epicentro> listaEpicentro = new ArrayList<Epicentro>();

		try {
			Query jpql = em.createQuery("from Epicentro e");
			listaEpicentro = (List<Epicentro>) jpql.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return listaEpicentro;
	}

	@Transactional
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Epicentro epi = em.find(Epicentro.class, id);
		em.remove(epi);
	}

}
