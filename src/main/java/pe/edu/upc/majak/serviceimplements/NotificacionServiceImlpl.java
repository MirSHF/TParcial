package pe.edu.upc.majak.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.majak.entities.Notificacion;
import pe.edu.upc.majak.repositories.INotificacionRepository;
import pe.edu.upc.majak.serviceinterface.INotificacionService;

@Service
public class NotificacionServiceImlpl implements INotificacionService{

	@Autowired
	private INotificacionRepository  nRepository;
	
	@Override
	public void insert(Notificacion notificacion) {
		// TODO Auto-generated method stub
		nRepository.save(notificacion);
	}

	@Override
	public List<Notificacion> list() {
		// TODO Auto-generated method stub
		return nRepository.findAll();
	}

	@Override
	public void delete(int codigoNotificacion) {
		// TODO Auto-generated method stub
		nRepository.deleteById(codigoNotificacion);
	}

	@Override
	public Optional<Notificacion> listId(int codigoNotificacion) {
		// TODO Auto-generated method stub
		return nRepository.findById(codigoNotificacion);
	}

	@Override
	public void update(Notificacion not) {
		// TODO Auto-generated method stub
		nRepository.save(not);
	}

}
