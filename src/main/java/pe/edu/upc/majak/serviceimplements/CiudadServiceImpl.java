package pe.edu.upc.majak.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.majak.entities.Ciudad;
import pe.edu.upc.majak.repositories.ICiudadRepository;
import pe.edu.upc.majak.serviceinterface.ICiudadService;

@Service
public class CiudadServiceImpl implements ICiudadService {

	@Autowired
	private ICiudadRepository ciudadRepository;

	@Override
	public void insert(Ciudad ciudad) {
		// TODO Auto-generated method stub
		ciudadRepository.save(ciudad);
	}

	@Override
	public List<Ciudad> list() {
		// TODO Auto-generated method stub
		return ciudadRepository.findAll();
	}

	@Override
	public void delete(int codigoCiudad) {
		// TODO Auto-generated method stub
		ciudadRepository.deleteById(codigoCiudad);
	}

	@Override
	public Optional<Ciudad> listId(int codigoCiudad) {
		// TODO Auto-generated method stub
		return ciudadRepository.findById(codigoCiudad);
	}

	@Override
	public void update(Ciudad ciud) {
		// TODO Auto-generated method stub
		ciudadRepository.save(ciud);
	}

}
