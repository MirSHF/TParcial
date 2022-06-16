package pe.edu.upc.majak.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.majak.entities.Banco;

@Repository
public interface IBancoRepository extends JpaRepository<Banco, Integer>{

}
