package pe.edu.upc.majak.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.majak.entities.Persona;
import pe.edu.upc.majak.repositories.IPersonaRepository;
import pe.edu.upc.majak.serviceinterface.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService{

	@Autowired
	private IPersonaRepository pRepository;
	
	@Override
	public void insert(Persona persona) {
		// TODO Auto-generated method stub
		pRepository.save(persona);
	}

	@Override
	public List<Persona> list() {
		// TODO Auto-generated method stub
		return pRepository.findAll();
	}

	@Override
	public void delete(int codigoPersona) {
		// TODO Auto-generated method stub
		pRepository.deleteById(codigoPersona);
	}

	@Override
	public Optional<Persona> listId(int codigoPersona) {
		// TODO Auto-generated method stub
		return pRepository.findById(codigoPersona);
	}

<<<<<<< Updated upstream
=======
	@Override
	public void update(Persona pers) {
		// TODO Auto-generated method stub
		pRepository.save(pers);
	}

>>>>>>> Stashed changes
}
