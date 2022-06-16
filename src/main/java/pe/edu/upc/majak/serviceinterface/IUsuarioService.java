package pe.edu.upc.majak.serviceinterface;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import pe.edu.upc.majak.entities.Usuario;
import pe.edu.upc.majak.entities.UsuarioRegistroDTO;

public interface IUsuarioService extends UserDetailsService {

	public Usuario guardar(UsuarioRegistroDTO registroDTO);
	
	public List<Usuario> listarUsuarios();
}
