package pe.edu.upc.majak.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.majak.entities.Magnitud;
import pe.edu.upc.majak.repositories.IMagnitudRepository;
import pe.edu.upc.majak.serviceinterface.IMagnitudService;

@Service
public class MagnitudServiceImpl implements IMagnitudService{

	@Autowired
	private IMagnitudRepository magnitudRepository;
	@Override
	public void insert(Magnitud magnitud) {
		// TODO Auto-generated method stub
		magnitudRepository.save(magnitud);
	}

	@Override
	public List<Magnitud> list() {
		// TODO Auto-generated method stub
		return magnitudRepository.findAll();
	}

	@Override
	public void delete(int CodigoMagnitud) {
		// TODO Auto-generated method stub
		magnitudRepository.deleteById(CodigoMagnitud);
	}

	@Override
	public Optional<Magnitud> listId(int CodigoMagnitud) {
		// TODO Auto-generated method stub
		return magnitudRepository.findById(CodigoMagnitud);
	}

	@Override
	public void update(Magnitud magn) {
		// TODO Auto-generated method stub
		magnitudRepository.save(magn);
	}

}
