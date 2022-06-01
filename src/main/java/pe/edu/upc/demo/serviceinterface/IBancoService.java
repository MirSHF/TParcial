package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Banco;


public interface IBancoService {
		
	public void insert(Banco banco);
	
	public List<Banco> list();
	public void delete(int idBanco);

	Optional<Banco> listId(int codigoBanco);
	
}
