package br.com.biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.biblioteca.Entity.Obra;

public interface ObraRepository extends JpaRepository<Obra, Long>{

	Obra findByNomeContainingIgnoreCase(String nome);


}
