package pe.edu.upc.majak.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.majak.entities.Persona;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Integer>{

	@Query (value ="Select  c.nombre_ciudad ,count(p.codigo_persona) from ciudad c join persona p on c.codigo_ciudad=p.codigo_ciudad group by  c.nombre_ciudad", nativeQuery = true)
	public List<String[]>personaciudad();
	
}
