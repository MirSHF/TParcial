package pe.edu.upc.majak.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.majak.entities.Distrito;
import pe.edu.upc.majak.repositories.IDistritoRepository;
import pe.edu.upc.majak.serviceinterface.IDistritoService;

@Service
public class DistritoServiceImpl implements IDistritoService {

	@Autowired
	private IDistritoRepository distritoRepository;

	@Override
	public void insert(Distrito distrito) {
		distritoRepository.save(distrito);

	}

	@Override
	public List<Distrito> list() {
		// TODO Auto-generated method stub
		return distritoRepository.findAll();
	}

	@Override
	public void delete(int codigoDistrito) {
		// TODO Auto-generated method stub
		distritoRepository.deleteById(codigoDistrito);
	}

	@Override
	public Optional<Distrito> listId(int codigoDistrito) {
		// TODO Auto-generated method stub
		return distritoRepository.findById(codigoDistrito);
	}

	
}
