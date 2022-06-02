package pe.edu.upc.majak.serviceinterface;

import java.util.List;

import pe.edu.upc.majak.entities.Usuario;

public interface IUsuarioService {

	public void insert(Usuario usuario);
	
	List<Usuario> list();
}
