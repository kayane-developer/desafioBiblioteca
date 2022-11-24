package br.com.biblioteca.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.biblioteca.DTO.ObraDto;
import br.com.biblioteca.Service.ObraService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ObraController {
	private final ObraService obraService;
	
	@PostMapping("/cadastrarObra")
	public void cadastrarObra(@RequestBody @Valid ObraDto obraDto) {
		obraService.cadastrarObra(obraDto);
	}
	
	@PostMapping("/alterarObra")
	public void alterarObra(@RequestBody @Valid ObraDto obraDto) {
		obraService.alterarObra(obraDto);
	}
	
	@GetMapping("/retornarObras")
	public List<ObraDto> retornarObras(){
		return obraService.retornarObras();
	}
	
	@DeleteMapping("/excluirObra/{id}")
	public void excluirObra(@PathVariable long id){
		obraService.excluirObra(id);
	}

}
