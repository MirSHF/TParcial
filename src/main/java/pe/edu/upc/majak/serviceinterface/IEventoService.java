package pe.edu.upc.majak.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.majak.entities.Evento;


public interface IEventoService {

	public void insert(Evento evento);

	public List<Evento> list();

	public void delete(int codigoEvento);

	Optional<Evento> listId(int codigoEvento);
	public void  update(Evento even);
	public List<String[]>eventodistrito();
}
