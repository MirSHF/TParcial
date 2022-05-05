package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.CUsuarioDao;
import pe.edu.upc.entities.Usuario;

public class UsuarioImpl implements CUsuarioDao {
	@PersistenceContext(unitName = "majak")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Usuario u) {
		try {
			em.persist(u);

		} catch (Exception e) {
			System.out.println("Error al insertar usuario en DAO");
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> list() {
		List<Usuario> listaUsuario = new ArrayList<Usuario>();

		try {
			Query jpql = em.createQuery("from Usuario u");
			listaUsuario = (List<Usuario>) jpql.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listaUsuario;
	}

	@Transactional
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Usuario usua = em.find(Usuario.class, id);
		em.remove(usua);
	}

}
