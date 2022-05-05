package pe.edu.upc.serviceimpls;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerfaces.CMagnitudDao;
import pe.edu.upc.serviceinterfaces.CMagnitudService;
import pe.edu.upc.entities.Magnitud;

@Named
public class MagnitudServiceImpl implements CMagnitudService {
//inject para utilizar una variable
	@Inject
	private CMagnitudDao mDao;

	public void insert(Magnitud m) {

		mDao.insert(m);
	}

	public List<Magnitud> list() {
		// TODO Auto-generated method stub
		return mDao.list();
	}

	public void delete(int id) {
		mDao.delete(id);
	}

}
