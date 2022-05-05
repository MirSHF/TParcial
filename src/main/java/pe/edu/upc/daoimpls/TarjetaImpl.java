package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.CTarjetaDao;
import pe.edu.upc.entities.Tarjeta;

public class TarjetaImpl implements CTarjetaDao {
	@PersistenceContext(unitName = "majak")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Tarjeta t) {
		try {
			em.persist(t);
		} catch (Exception e) {
			System.out.println("Error al insertar tarjeta en Dao");
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tarjeta> list() {
		List<Tarjeta> listTarjetas = new ArrayList<Tarjeta>();
		try {
			Query jpql = em.createQuery("from Tarjeta t");
			listTarjetas = (List<Tarjeta>) jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar en el DAO de tarjeta");
		}
		return listTarjetas;
	}

	@Transactional
	@Override
	public void delete(int id) {
		Tarjeta tar = em.find(Tarjeta.class, id);
		em.remove(tar);
	}

}
