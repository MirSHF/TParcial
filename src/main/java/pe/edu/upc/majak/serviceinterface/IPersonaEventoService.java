package pe.edu.upc.majak.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.majak.entities.PersonaEvento;

public interface IPersonaEventoService {

	public void insert(PersonaEvento personaEvento);

	public List<PersonaEvento> list();

	public void delete(int codigopersonaevento);

	Optional<PersonaEvento> listId(int codigopersonaevento);
	
}
