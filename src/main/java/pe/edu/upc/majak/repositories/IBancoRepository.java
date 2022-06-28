package pe.edu.upc.majak.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.majak.entities.Banco;

@Repository
public interface IBancoRepository extends JpaRepository<Banco, Integer>{
	@Query(value="select b.nombre_banco,count(t.codigo_tarjeta)\r\n"+ "from banco b join tarjeta t\r\n"+ "on b.codigo_banco=t.codigo_banco\r\n"+ "group by b.nombre_banco \r\n"+ "",nativeQuery = true)
	public List<String[]>tarjetaBanco();
}
