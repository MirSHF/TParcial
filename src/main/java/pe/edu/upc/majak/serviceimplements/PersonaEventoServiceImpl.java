package pe.edu.upc.majak.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.majak.entities.PersonaEvento;
import pe.edu.upc.majak.repositories.IPersonaEventoRepository;
import pe.edu.upc.majak.serviceinterface.IPersonaEventoService;

@Service
public class PersonaEventoServiceImpl implements IPersonaEventoService{

	@Autowired
	private IPersonaEventoRepository pvRepository;
	
	@Override
	public void insert(PersonaEvento personaEvento) {
		// TODO Auto-generated method stub
		pvRepository.save(personaEvento);
	}

	@Override
	public List<PersonaEvento> list() {
		// TODO Auto-generated method stub
		return pvRepository.findAll();
	}

	@Override
	public void delete(int codigopersonaevento) {
		// TODO Auto-generated method stub
		pvRepository.deleteById(codigopersonaevento);
	}

	@Override
	public Optional<PersonaEvento> listId(int codigopersonaevento) {
		// TODO Auto-generated method stub
		return pvRepository.findById(codigopersonaevento);
	}

}
