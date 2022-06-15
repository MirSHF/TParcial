package pe.edu.upc.majak.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.majak.entities.Tarjeta;

public interface ITarjetaService {

    public void insert(Tarjeta tarjeta);

	List<Tarjeta> list();
	
	public void delete(int codigoTarjeta);

	Optional<Tarjeta> listId(int codigoTarjeta);
}
