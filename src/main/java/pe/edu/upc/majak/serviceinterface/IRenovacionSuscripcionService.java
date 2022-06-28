package pe.edu.upc.majak.serviceinterface;

import java.util.List;
import java.util.Optional;


import pe.edu.upc.majak.entities.RenovacionSuscripcion;


public interface IRenovacionSuscripcionService {

	public void insert(RenovacionSuscripcion renovacionsuscripcion);

	List<RenovacionSuscripcion> list();
	
	public void delete(int codigoSuscripcion);

	Optional<RenovacionSuscripcion> listId(int codigoSuscripcion);
	public void  update(RenovacionSuscripcion renov);
}
