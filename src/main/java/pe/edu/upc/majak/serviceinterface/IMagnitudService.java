package pe.edu.upc.majak.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.majak.entities.Magnitud;


public interface IMagnitudService {

	public void insert(Magnitud magnitud);

	public List<Magnitud> list();
	
	public void delete(int CodigoMagnitud);
	
	Optional<Magnitud> listId(int CodigoMagnitud);
	public void  update(Magnitud magn);
}
