package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.CRenovacionDao;
import pe.edu.upc.entities.Renovacion;

public class RenovacionImpl implements CRenovacionDao {
	@PersistenceContext(unitName = "majak")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Renovacion r) {
		try {
			em.persist(r);
		} catch (Exception e) {
			System.out.println("Error al insertar Renovacion en Dao");
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Renovacion> list() {
		List<Renovacion> listRenovacions = new ArrayList<Renovacion>();
		try {
			Query jpql = em.createQuery("from Renovacion r");
			listRenovacions = (List<Renovacion>) jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar en el DAO de Renovacion");
		}
		return listRenovacions;
	}

	@Transactional
	@Override
	public void delete(int id) {
		Renovacion ren = em.find(Renovacion.class, id);
		em.remove(ren);
	}

}
