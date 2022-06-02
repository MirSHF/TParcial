package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Epicentro;

public interface IEpicentroService {
	public void insert(Epicentro epicentro);
	
	public List<Epicentro> list();
	
	public void delete(int idEpicentro);
	
	Optional<Epicentro> listId(int idEpicentro);
	
	public void update(Epicentro epicentro);
}
