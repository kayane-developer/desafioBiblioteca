package br.com.biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.biblioteca.Entity.Autor;


public interface AutorRepository extends JpaRepository<Autor, Long>{
	
	Autor findByEmail(String email);
	Autor findByCpf(String cpf);
	
	@Query(value= "select * from obras_autores where autores_id= :id", nativeQuery= true)
	String findObraRelation(Long id);
	
	
	@Query(value= "insert into obras_autores values ( :idObra , :idAutor )", nativeQuery=true)
	void conectar(Long idObra, Long idAutor);

}
