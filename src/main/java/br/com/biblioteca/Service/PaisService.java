package br.com.biblioteca.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.biblioteca.Convert.PaisConvert;
import br.com.biblioteca.DTO.PaisDto;
import br.com.biblioteca.Entity.Pais;
import br.com.biblioteca.Repository.PaisRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PaisService {

	private final PaisRepository paisRepository;
	private final PaisConvert paisConvert;
	
	public List<PaisDto> retornarPaises(){
		return ( (List<Pais>) paisRepository.findAll(Sort.by(Sort.Direction.ASC, "nome")))
				.stream()
				.map(paisConvert::entityToDto).collect(Collectors.toList());
	}
	
	
	public Pais findById(Long id) {
		return paisRepository.findById(id).orElse(null);
	}

}
