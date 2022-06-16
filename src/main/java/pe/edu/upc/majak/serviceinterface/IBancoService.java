package pe.edu.upc.majak.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.majak.entities.Banco;

public interface IBancoService {

	public void insert(Banco banco);

	public List<Banco> list();

	public void delete(int codigoBanco);

	Optional<Banco> listId(int codigoBanco);
}
