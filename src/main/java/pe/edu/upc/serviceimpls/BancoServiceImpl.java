package pe.edu.upc.serviceimpls;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerfaces.CBancoDao;
import pe.edu.upc.entities.Banco;
import pe.edu.upc.serviceinterfaces.CBancoService;

@Named
public class BancoServiceImpl implements CBancoService {
	
	@Inject
	private CBancoDao bdao;

	@Override
	public void insert(Banco b) {
		bdao.insert(b);
	}

	@Override
	public List<Banco> list() {

		return bdao.list();
	}

	@Override
	public void delete(int id) {
		bdao.delete(id);
	}

	@Override
	public List<Banco> findByNameBanco(Banco b) {
		// TODO Auto-generated method stub
		return bdao.findByNameBanco(b);
	}

}
