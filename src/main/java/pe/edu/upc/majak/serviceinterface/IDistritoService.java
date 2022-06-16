package pe.edu.upc.majak.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.majak.entities.Distrito;

public interface IDistritoService {

	public void insert(Distrito distrito);
	
	public List<Distrito> list();
	
	public void delete(int codigoDistrito);
	
	Optional <Distrito> listId(int codigoDistrito);
}
