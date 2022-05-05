package pe.edu.upc.serviceinterfaces;

import java.util.List;

import pe.edu.upc.entities.Magnitud;

public interface CMagnitudService {
	public void insert(Magnitud m);
	public List<Magnitud> list();
	public void delete(int id);

}
