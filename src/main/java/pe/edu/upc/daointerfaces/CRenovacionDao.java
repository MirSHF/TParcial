package pe.edu.upc.daointerfaces;

import java.util.List;

import pe.edu.upc.entities.Renovacion;

public interface CRenovacionDao {

	public void insert(Renovacion r);

	public List<Renovacion> list();

	public void delete(int id);

}
