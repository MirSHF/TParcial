package pe.edu.upc.serviceinterfaces;

import java.util.List;

import pe.edu.upc.entities.Usuario;


public interface CUsuarioService {
	public void insert(Usuario u);
	public List<Usuario> list();
	public void delete(int id);
}
