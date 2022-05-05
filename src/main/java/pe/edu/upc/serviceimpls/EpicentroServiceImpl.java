package pe.edu.upc.serviceimpls;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerfaces.CEpicentroDao;

import pe.edu.upc.entities.Epicentro;
import pe.edu.upc.serviceinterfaces.CEpicentroService;
@Named
public class EpicentroServiceImpl implements CEpicentroService{

	@Inject
	private CEpicentroDao eDao;
	@Override
	public void insert(Epicentro e) {
		// TODO Auto-generated method stub
		eDao.insert(e);
	}

	@Override
	public List<Epicentro> list() {
		// TODO Auto-generated method stub
		return eDao.list();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		eDao.delete(id);
	}

}
