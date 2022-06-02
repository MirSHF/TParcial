package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Magnitud;

public interface IMagnitudService {
	public void insert(Magnitud magnitud);

	public List<Magnitud> list();

	public void delete(int idPerson);

	Optional<Magnitud> listId(int CodigoMagnitud);

}
