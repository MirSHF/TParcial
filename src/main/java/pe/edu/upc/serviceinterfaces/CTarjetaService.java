package pe.edu.upc.serviceinterfaces;

import java.util.List;

import pe.edu.upc.entities.Tarjeta;

public interface CTarjetaService {

	public void insert(Tarjeta t);

	public List<Tarjeta> list();

	public void delete(int id);
}
