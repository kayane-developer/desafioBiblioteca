package br.com.biblioteca.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.biblioteca.DTO.PaisDto;
import br.com.biblioteca.Service.PaisService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PaisController {
	
	private final PaisService paisService;
	
	@GetMapping("/retornarPaises")
	public List<PaisDto> retornarPaises(){
		return paisService.retornarPaises();
		
	}

}
