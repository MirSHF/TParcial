package pe.edu.upc.majak.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.majak.entities.Evento;
import pe.edu.upc.majak.repositories.IEventoRepository;
import pe.edu.upc.majak.serviceinterface.IEventoService;

@Service
public class EventoServiceImpl implements IEventoService {

	
	@Autowired
	private IEventoRepository eventoRepository;
	
	@Override
	public void insert(Evento evento) {
		// TODO Auto-generated method stub
		eventoRepository.save(evento);
	}

	@Override
	public List<Evento> list() {
		// TODO Auto-generated method stub
		return eventoRepository.findAll();
	}

	@Override
	public void delete(int codigoEvento) {
		// TODO Auto-generated method stub
		eventoRepository.deleteById(codigoEvento);
	}

	@Override
	public Optional<Evento> listId(int codigoEvento) {
		// TODO Auto-generated method stub
		return eventoRepository.findById(codigoEvento);
	}

	
}
