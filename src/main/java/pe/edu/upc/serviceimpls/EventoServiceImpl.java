package pe.edu.upc.serviceimpls;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerfaces.CEventoDao;
import pe.edu.upc.entities.Evento;
import pe.edu.upc.serviceinterfaces.CEventoService;

@Named
public class EventoServiceImpl implements CEventoService{

	@Inject
	private CEventoDao evDao;
	@Override
	public void insert(Evento ev) {
		evDao.insert(ev);
		
	}

	@Override
	public List<Evento> list() {
	
		return evDao.list();
	}

	@Override
	public void delete(int id) {
	
		evDao.delete(id);
	}

}
