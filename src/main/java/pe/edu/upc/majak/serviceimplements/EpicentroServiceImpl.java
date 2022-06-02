package pe.edu.upc.majak.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.majak.entities.Epicentro;
import pe.edu.upc.majak.repositories.IEpicentroRepository;
import pe.edu.upc.majak.serviceinterface.IEpicentroService;

@Service
public class EpicentroServiceImpl implements IEpicentroService{

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
		// TODO Auto-generated method stub
		epicentroRepository.deleteById(idEpicentro);
	}

	@Override
	public Optional<Epicentro> listId(int idEpicentro) {
		// TODO Auto-generated method stub
		return epicentroRepository.findById(idEpicentro);
	}

}
