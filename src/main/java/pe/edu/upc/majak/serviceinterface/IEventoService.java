package pe.edu.upc.majak.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.majak.entities.Evento;

<<<<<<< Updated upstream
=======

public interface IEventoService {
>>>>>>> Stashed changes


public interface IEventoService {
	public void insert(Evento evento);
	
	public List<Evento> list();
	
      public void delete(int codigoEvento);
	
	Optional<Evento> listId(int codigoEvento);
<<<<<<< Updated upstream
	
	
	
=======
	public void  update(Evento even);
	public List<String[]>eventodistrito();
>>>>>>> Stashed changes
}
