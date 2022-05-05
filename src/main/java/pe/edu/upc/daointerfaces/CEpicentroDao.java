package pe.edu.upc.daointerfaces;

import java.util.List;

import pe.edu.upc.entities.Epicentro;

public interface CEpicentroDao {
	public void insert(Epicentro e);

	public List<Epicentro> list();

	public void delete(int id);
}
