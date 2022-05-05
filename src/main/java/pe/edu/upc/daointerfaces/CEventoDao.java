package pe.edu.upc.daointerfaces;

import java.util.List;

import pe.edu.upc.entities.Evento;

public interface CEventoDao {

	public void insert(Evento ev);
	public List<Evento> list();
	public void delete(int id);
	public List<Evento> findByNameEvento(Evento ev);
}
