package pe.edu.upc.serviceinterfaces;

import java.util.List;

import pe.edu.upc.entities.Evento;

public interface CEventoService {
	public void insert(Evento ev);

	public List<Evento> list();

	public void delete(int id);
}
