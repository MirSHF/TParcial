package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.CDistritoDao;
import pe.edu.upc.entities.Distrito;

public class DistritoImpl implements CDistritoDao {
	@PersistenceContext(unitName = "majak")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Distrito d) {

		try {
			em.persist(d);
		} catch (Exception e) {
			System.out.println("Error al insertar Distrito en Dao");
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Distrito> list() {
		List<Distrito> listadistritos = new ArrayList<Distrito>();

		try {
			Query jpql = em.createQuery("from Distrito d");
			listadistritos = (List<Distrito>) jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar en Dao Distrito");
		}

		return listadistritos;
	}

	@Transactional
	@Override
	public void delete(int id) {

		Distrito dis = em.find(Distrito.class, id);
		em.remove(dis);
	}

}
