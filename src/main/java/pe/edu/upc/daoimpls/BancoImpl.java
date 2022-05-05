package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.CBancoDao;
import pe.edu.upc.entities.Banco;


public class BancoImpl implements CBancoDao{
	@PersistenceContext(unitName = "majak")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert(Banco b) {
	try {
		em.persist(b);
	} catch (Exception e) {
		System.out.println("Error al insertar Banco en Dao");
	}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Banco> list() {
		List<Banco> listabancos = new ArrayList<Banco>();
		
	try {
		Query jpql=em.createQuery("from Banco b");
		listabancos=(List<Banco>) jpql.getResultList();
	} catch (Exception e) {
		System.out.println("Error al listar en Dao Banco");
	}
		return listabancos;
	}

	@Transactional
	@Override
	public void delete(int id) {
		Banco ban = em.find(Banco.class, id);
		em.remove(ban);
		
	}

}
