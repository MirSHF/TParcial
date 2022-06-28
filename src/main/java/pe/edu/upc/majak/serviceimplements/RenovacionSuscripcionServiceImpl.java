package pe.edu.upc.majak.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.majak.entities.RenovacionSuscripcion;
import pe.edu.upc.majak.repositories.IRenovacionSuscripcionRepository;
import pe.edu.upc.majak.serviceinterface.IRenovacionSuscripcionService;

@Service
public class RenovacionSuscripcionServiceImpl implements IRenovacionSuscripcionService {

	@Autowired
	private IRenovacionSuscripcionRepository rRepository;
	
	@Override
	public void insert(RenovacionSuscripcion renovacionsuscripcion) {
		// TODO Auto-generated method stub
		rRepository.save(renovacionsuscripcion);
	}

	@Override
	public List<RenovacionSuscripcion> list() {
		// TODO Auto-generated method stub
		return rRepository.findAll();
	}

	@Override
	public void delete(int codigoSuscripcion) {
		// TODO Auto-generated method stub
		rRepository.deleteById(codigoSuscripcion);
	}

	@Override
	public Optional<RenovacionSuscripcion> listId(int codigoSuscripcion) {
		// TODO Auto-generated method stub
		return rRepository.findById(codigoSuscripcion);
	}

	@Override
	public void update(RenovacionSuscripcion renov) {
		// TODO Auto-generated method stub
		rRepository.save(renov);
	}

}
