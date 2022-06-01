package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Banco;
import pe.edu.upc.demo.repositories.IBancoRepository;
import pe.edu.upc.demo.serviceinterface.IBancoService;

@Service
public class BancoServiceImpl implements IBancoService{

	@Autowired
	private IBancoRepository bancoRepository;
	
	@Override
	public void insert(Banco banco) {
		bancoRepository.save(banco);
		
	}

	@Override
	public List<Banco> list() {
		
		return bancoRepository.findAll();
	}

	@Override
	public void delete(int codigoBanco) {
		// TODO Auto-generated method stub
		bancoRepository.deleteById(codigoBanco);
	}

	@Override
	public Optional<Banco> listId(int codigoBanco) {
		// TODO Auto-generated method stub
		return bancoRepository.findById(codigoBanco);
	}

}
