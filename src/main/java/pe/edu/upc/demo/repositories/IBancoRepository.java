package pe.edu.upc.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.entities.Banco;
@Repository
public interface IBancoRepository extends JpaRepository<Banco, Integer>{

}
