package pe.edu.upc.serviceimpls;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerfaces.CTarjetaDao;
import pe.edu.upc.entities.Tarjeta;
import pe.edu.upc.serviceinterfaces.CTarjetaService;

@Named
public class TarjetaServiceImpl implements CTarjetaService {

	@Inject
	private CTarjetaDao tDao;

	@Override
	public void insert(Tarjeta t) {

		tDao.insert(t);
	}

	@Override
	public List<Tarjeta> list() {
		return tDao.list();
	}


	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		tDao.delete(id);
	}

}
