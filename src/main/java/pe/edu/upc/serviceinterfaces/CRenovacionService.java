package pe.edu.upc.serviceinterfaces;

import java.util.List;

import pe.edu.upc.entities.Renovacion;


public interface CRenovacionService {

	public void insert(Renovacion r);

	public List<Renovacion> list();

	public void delete(int id);
}
