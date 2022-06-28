package pe.edu.upc.majak.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.majak.entities.Evento;

@Repository
public interface IEventoRepository extends JpaRepository<Evento, Integer> {

	
	@Query (value ="Select  d.nombre_distrito, SUM(e.cantidad_afectados) from evento e join distrito d on e.codigo_distrito=d.codigo_distrito group by  d.nombre_distrito", nativeQuery = true)
	public List<String[]>eventodistrito();
}
