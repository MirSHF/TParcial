package pe.edu.upc.daointerfaces;

import java.util.List;

import pe.edu.upc.entities.Distrito;

public interface CDistritoDao {
	public void insert(Distrito d);

	public List<Distrito> list();

	public void delete(int id);
	
	public List<Distrito> findByNamDistrito(Distrito d);
}
