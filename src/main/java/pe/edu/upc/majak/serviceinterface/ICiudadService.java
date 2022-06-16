package pe.edu.upc.majak.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.majak.entities.Ciudad;

public interface ICiudadService {
	
	public void insert(Ciudad ciudad);

	public List<Ciudad> list();

	public void delete(int codigoCiudad);

	Optional<Ciudad> listId(int codigoCiudad);
}
