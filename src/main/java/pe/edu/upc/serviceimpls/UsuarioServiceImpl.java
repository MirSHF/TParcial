	package pe.edu.upc.serviceimpls;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerfaces.CUsuarioDao;
import pe.edu.upc.entities.Usuario;
import pe.edu.upc.serviceinterfaces.CUsuarioService;

@Named
public class UsuarioServiceImpl implements CUsuarioService {
	@Inject
	private CUsuarioDao uDao;

	@Override
	public void insert(Usuario u) {
		// TODO Auto-generated method stub
		uDao.insert(u);
	}

	@Override
	public List<Usuario> list() {
		// TODO Auto-generated method stub
		return uDao.list();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		uDao.delete(id);
	}

}
