package pe.edu.upc.majak.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.majak.entities.Tarjeta;
import pe.edu.upc.majak.repositories.ITarjetaRespository;
import pe.edu.upc.majak.serviceinterface.ITarjetaService;


@Service
public class TarjetaServiceImpl implements ITarjetaService{


	@Autowired
	private ITarjetaRespository tRepository;
	
	@Override
	public void insert(Tarjeta tarjeta) {
		// TODO Auto-generated method stub
		tRepository.save(tarjeta);
	}

	@Override
	public List<Tarjeta> list() {
		// TODO Auto-generated method stub
		return tRepository.findAll();
	}

	@Override
	public void delete(int codigoTarjeta) {
		// TODO Auto-generated method stub
		tRepository.deleteById(codigoTarjeta);
	}

	@Override
	public Optional<Tarjeta> listId(int codigoTarjeta) {
		// TODO Auto-generated method stub
		return tRepository.findById(codigoTarjeta);
	}

	@Override
	public void update(Tarjeta tar) {
		// TODO Auto-generated method stub
		tRepository.save(tar);
	}

}
