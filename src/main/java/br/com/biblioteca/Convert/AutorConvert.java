package br.com.biblioteca.Convert;

import org.springframework.stereotype.Component;

import br.com.biblioteca.DTO.AutorDto;
import br.com.biblioteca.Entity.Autor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public final class AutorConvert {

	public final AutorDto entityToDto(final Autor autor) {
		final AutorDto autorDto = new AutorDto();
		autorDto.setId(autor.getId());
		autorDto.setNome(autor.getNome());
		autorDto.setSexo(autor.getSexo());
		autorDto.setEmail(autor.getEmail());
		autorDto.setCpf(autor.getCpf());
		autorDto.setDataNascimento(autor.getDataNascimento());
		autorDto.setPais(autor.getPais());
		autorDto.setObras(autor.getObras());
		
		return autorDto;
	}
	
	public final Autor dtoToEntity(AutorDto autorDto){
		Autor autor = new Autor();
		autor.setId(autorDto.getId());
		autor.setNome(autorDto.getNome());
		autor.setSexo(autorDto.getSexo());
		autor.setEmail(autorDto.getEmail());
		autor.setDataNascimento(autorDto.getDataNascimento());
		autor.setCpf(autorDto.getCpf());
		autor.setPais(autorDto.getPais());
		autor.setObras(autorDto.getObras());
		return autor;
	}

	
}
