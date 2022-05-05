package pe.edu.upc.daointerfaces;

import java.util.List;

import pe.edu.upc.entities.Banco;

public interface CBancoDao {

	public void insert(Banco b);

	public List<Banco> list();

	public void delete(int id);

}
