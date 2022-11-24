package br.com.biblioteca.Convert;

import org.springframework.stereotype.Component;

import br.com.biblioteca.DTO.PaisDto;
import br.com.biblioteca.Entity.Pais;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class PaisConvert {
	
	public final PaisDto entityToDto(Pais pais) {
		PaisDto paisDto = new PaisDto();
		paisDto.setId(pais.getId());
		paisDto.setNome(pais.getNome());
		paisDto.setSigla(pais.getSigla());
		return paisDto;
	}
	

}
