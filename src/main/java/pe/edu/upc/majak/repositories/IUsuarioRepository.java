package pe.edu.upc.majak.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.majak.entities.Usuario;



@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

	public Usuario findByEmail(String email);
}
