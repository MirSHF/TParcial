package pe.edu.upc.serviceinterfaces;

import java.util.List;

import pe.edu.upc.entities.Banco;

public interface CBancoService {

	public void insert(Banco b);

	public List<Banco> list();

	public void delete(int id);
	
	public List<Banco> findByNameBanco(Banco b);
}
