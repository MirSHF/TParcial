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
	
	@Query(value="select p.codigo_persona, count(r.codigo_suscripcion), p.nombre_persona \r\n"+ "from renovacion_suscripcion r join persona p\r\n"+ "on r.codigo_persona = p.codigo_persona\r\n"+ "group by p.codigo_persona",nativeQuery = true)
	public List<String[]>personaRenovacion();
}
