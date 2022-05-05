package pe.edu.upc.daointerfaces;

import java.util.List;

import pe.edu.upc.entities.Tarjeta;

public interface CTarjetaDao {

	public void insert(Tarjeta t);

	public List<Tarjeta> list();

	public void delete(int id);

}
