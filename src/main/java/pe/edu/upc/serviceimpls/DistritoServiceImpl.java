package pe.edu.upc.serviceimpls;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerfaces.CDistritoDao;
import pe.edu.upc.entities.Distrito;
import pe.edu.upc.serviceinterfaces.CDistritoService;

@Named
public class DistritoServiceImpl implements CDistritoService {

	@Inject
	private CDistritoDao dDao;

	@Override

	public void insert(Distrito d) {
		dDao.insert(d);

	}

	@Override
	public List<Distrito> list() {

		return dDao.list();
	}

	@Override
	public void delete(int id) {
		dDao.delete(id);

	}

	@Override
	public List<Distrito> findByNamDistrito(Distrito d) {
		// TODO Auto-generated method stub
		return dDao.findByNamDistrito(d);
	}

}
