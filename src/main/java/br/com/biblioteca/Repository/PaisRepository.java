package br.com.biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.biblioteca.Entity.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long> {

}
