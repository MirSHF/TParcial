package pe.edu.upc.serviceinterfaces;

import java.util.List;

import pe.edu.upc.entities.Notificacion;

public interface CNotificacionService {
	public void insert(Notificacion not);

	public List<Notificacion> list();

	public void delete(int id);

	public void update(Notificacion not);
}
