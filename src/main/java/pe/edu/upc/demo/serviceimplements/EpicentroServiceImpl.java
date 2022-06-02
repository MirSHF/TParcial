package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Epicentro;
import pe.edu.upc.demo.repositories.IEpicentroRepository;
import pe.edu.upc.demo.serviceinterface.IEpicentroService;

@Service
public class EpicentroServiceImpl implements IEpicentroService {
	@Autowired
	private IEpicentroRepository epicentroRepository;

	@Override
	public void insert(Epicentro epicentro) {
		// TODO Auto-generated method stub
		epicentroRepository.save(epicentro);
	}

	@Override
	public List<Epicentro> list() {
		// TODO Auto-generated method stub
		return epicentroRepository.findAll();
	}
	
	@Override
	public void delete(int idEpicentro) {
		epicentroRepository.deleteById(idEpicentro);
		
	}

	@Override
	public Optional<Epicentro> listId(int idEpicentro) {
		// TODO Auto-generated method stub
		return epicentroRepository.findById(idEpicentro);
	}

	@Override
	public void update(Epicentro epicentro) {
		// TODO Auto-generated method stub
		epicentroRepository.save(epicentro);
	}
}
