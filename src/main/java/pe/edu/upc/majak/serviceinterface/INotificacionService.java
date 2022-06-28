package pe.edu.upc.majak.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.majak.entities.Notificacion;


public interface INotificacionService {

	public void insert(Notificacion notificacion);

	public List<Notificacion> list();

	public void delete(int codigoNotificacion);

	Optional<Notificacion> listId(int codigoNotificacion);
	public void  update(Notificacion not);
}
