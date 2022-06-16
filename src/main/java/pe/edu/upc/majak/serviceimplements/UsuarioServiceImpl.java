package pe.edu.upc.majak.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.majak.entities.Usuario;
import pe.edu.upc.majak.repositories.IUsuarioRepository;
import pe.edu.upc.majak.serviceinterface.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private IUsuarioRepository uRepository;
	
	@Override
	public void insert(Usuario usuario) {
		// TODO Auto-generated method stub
		uRepository.save(usuario);
	}

	@Override
	public List<Usuario> list() {
		// TODO Auto-generated method stub
		return uRepository.findAll();
	}

}
