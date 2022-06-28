package pe.edu.upc.majak.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.majak.entities.Banco;
import pe.edu.upc.majak.repositories.IBancoRepository;
import pe.edu.upc.majak.serviceinterface.IBancoService;

@Service
public class BancoServiceImpl implements IBancoService {

	@Autowired
	private IBancoRepository bancoRepository;
	@Override
	public void insert(Banco banco) {
		// TODO Auto-generated method stub
		bancoRepository.save(banco);
	}

	@Override
	public List<Banco> list() {
		// TODO Auto-generated method stub
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

	@Override
	public void update(Banco banc) {
		// TODO Auto-generated method stub
		bancoRepository.save(banc);
	}

	@Override
	public List<String[]> tarjetaBanco() {
		// TODO Auto-generated method stub
		return bancoRepository.tarjetaBanco();
	}

}
