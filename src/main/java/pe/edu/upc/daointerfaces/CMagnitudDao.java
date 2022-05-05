package pe.edu.upc.daointerfaces;

import java.util.List;

import pe.edu.upc.entities.Magnitud;

public interface CMagnitudDao {
	public void insert(Magnitud m);
	public List<Magnitud> list();
	public void delete(int id);
}
