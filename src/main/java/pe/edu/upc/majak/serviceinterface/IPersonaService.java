package pe.edu.upc.majak.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.majak.entities.Persona;

<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
public interface IPersonaService {

	public void insert(Persona persona);
	
	List<Persona> list();
	
	public void delete(int codigoPersona);

	Optional<Persona> listId(int codigoPersona);
<<<<<<< Updated upstream
=======
	public void  update(Persona pers);
>>>>>>> Stashed changes
}
