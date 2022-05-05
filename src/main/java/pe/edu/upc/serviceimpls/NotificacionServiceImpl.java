package pe.edu.upc.serviceimpls;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerfaces.CNotificacionDao;
import pe.edu.upc.entities.Notificacion;
import pe.edu.upc.serviceinterfaces.CNotificacionService;

@Named
public class NotificacionServiceImpl implements CNotificacionService {

	@Inject
	CNotificacionDao nDao;

	@Override
	public void insert(Notificacion not) {
		nDao.insert(not);

	}

	@Override
	public List<Notificacion> list() {

		return nDao.list();
	}

	@Override
	public void delete(int id) {
		nDao.delete(id);

	}

	@Override
	public void update(Notificacion not) {
		// TODO Auto-generated method stub
		nDao.update(not);
	}

}
