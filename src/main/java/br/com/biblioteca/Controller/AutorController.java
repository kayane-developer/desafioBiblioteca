package br.com.biblioteca.Controller;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.biblioteca.DTO.AutorDto;
import br.com.biblioteca.Service.AutorService;

@RestController
public class AutorController {
	
	@Autowired
	private AutorService autorService;
	
	@PostMapping("/cadastrarAutor")
	public void cadastrarAutor(@RequestBody @Valid AutorDto autorDto) throws SQLException {
		autorService.cadastrarAutor(autorDto);
	}
	
	@PostMapping("/alterarAutor")
	public void alterarAutor(@RequestBody @Valid AutorDto autorDto) {
		autorService.alterarAutor(autorDto);
	}
	
	@GetMapping("/retornarAutores")
	public List<AutorDto> retornarAutores(){
		return autorService.retornarAutores();
	}

	@DeleteMapping("/excluirAutor/{id}")
	public void excluirAutor(@PathVariable Long id) {
		autorService.excluirAutor(id);
	}
	

}
