package pe.edu.upc.serviceinterfaces;

import java.util.List;

import pe.edu.upc.entities.Epicentro;

public interface CEpicentroService {
	public void insert(Epicentro e);

	public List<Epicentro> list();

	public void delete(int id);
}
