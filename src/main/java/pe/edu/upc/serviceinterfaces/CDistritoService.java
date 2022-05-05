package pe.edu.upc.serviceinterfaces;

import java.util.List;

import pe.edu.upc.entities.Distrito;

public interface CDistritoService {
	public void insert(Distrito d);

	public List<Distrito> list();

	public void delete(int id);
}
