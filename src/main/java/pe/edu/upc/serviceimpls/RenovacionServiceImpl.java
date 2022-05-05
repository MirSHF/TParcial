package pe.edu.upc.serviceimpls;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerfaces.CRenovacionDao;
import pe.edu.upc.entities.Renovacion;
import pe.edu.upc.serviceinterfaces.CRenovacionService;

@Named
public class RenovacionServiceImpl implements CRenovacionService {

	@Inject
	private CRenovacionDao rDao;

	@Override
	public void insert(Renovacion r) {

		rDao.insert(r);
	}

	@Override
	public List<Renovacion> list() {
		return rDao.list();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		rDao.delete(id);
	}

}
