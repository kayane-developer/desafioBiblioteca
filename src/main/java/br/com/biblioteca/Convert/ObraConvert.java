package br.com.biblioteca.Convert;

import org.springframework.stereotype.Component;

import br.com.biblioteca.DTO.ObraDto;
import br.com.biblioteca.Entity.Obra;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public final class ObraConvert {
	
	public ObraDto entityToDto(Obra obra) {

		ObraDto obraDto = new ObraDto();
		obraDto.setId(obra.getId());
		obraDto.setNome(obra.getNome());
		obraDto.setDescricao(obra.getDescricao());
		obraDto.setDataPublicacao(obra.getDataPublicacao());
		obraDto.setDataExposicao(obra.getDataExposicao());
		obraDto.setAutores(obra.getAutores());

		return obraDto;
	}
	
	public Obra dtoToEntity(ObraDto obraDto) {
		Obra obra = new Obra();
		obra.setId(obraDto.getId());
		obra.setNome(obraDto.getNome());
		obra.setDescricao(obraDto.getDescricao());
		obra.setDataPublicacao(obraDto.getDataPublicacao());
		obra.setDataExposicao(obraDto.getDataExposicao());
		obra.setAutores(obraDto.getAutores());
		
		return obra;
	}

}
