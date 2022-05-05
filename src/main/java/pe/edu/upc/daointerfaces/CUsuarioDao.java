package pe.edu.upc.daointerfaces;

import java.util.List;

import pe.edu.upc.entities.Usuario;

public interface CUsuarioDao {
	public void insert(Usuario u);
	public List<Usuario> list();
	public void delete(int id);
}
