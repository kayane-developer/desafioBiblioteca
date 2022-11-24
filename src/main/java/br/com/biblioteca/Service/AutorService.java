package br.com.biblioteca.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.biblioteca.Convert.AutorConvert;
import br.com.biblioteca.DTO.AutorDto;
import br.com.biblioteca.Entity.Autor;
import br.com.biblioteca.Exception.NegocioException;
import br.com.biblioteca.Exception.RetornoException;
import br.com.biblioteca.Repository.AutorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class AutorService {

	private final AutorRepository autorRepository;
	private final PaisService paisService;
	private final AutorConvert autorConvert;

	public void alterarAutor(AutorDto autorDto) {
		Autor dadosAntigos = autorRepository.findById(autorDto.getId()).get();

		if (!autorDto.getEmail().equals(dadosAntigos.getEmail())) {
			if (autorRepository.findByEmail(autorDto.getEmail()) != null) {
				log.error("Falha na alteração!");
				throw new NegocioException("Email já cadastrado!");
			} else {
				autorDto.setPais(dadosAntigos.getPais());
				autorDto.setCpf(dadosAntigos.getCpf());
				autorDto.setDataNascimento(dadosAntigos.getDataNascimento());
				Autor autorAlterado = autorConvert.dtoToEntity(autorDto);
				autorRepository.save(autorAlterado);
				log.info("Alterando autor com id: {}", autorDto.getId());
			}
		} else {
			autorDto.setPais(dadosAntigos.getPais());
			autorDto.setCpf(dadosAntigos.getCpf());
			autorDto.setDataNascimento(dadosAntigos.getDataNascimento());
			Autor autorAlterado = autorConvert.dtoToEntity(autorDto);
			autorRepository.save(autorAlterado);
			log.info("Alterando autor com id: {}", autorDto.getId());
		}

	}

	public void cadastrarAutor(AutorDto autorDto) {
		Autor validaEmail = autorRepository.findByEmail(autorDto.getEmail());
		Autor validaCpf = autorRepository.findByCpf(autorDto.getCpf());
//		Long idNovoAutor;
		autorDto.setPais(paisService.findById(autorDto.getPais().getId()));

		if (validaEmail != null) {
			log.error("Falha no cadastro!");
			throw new NegocioException("Email já cadastrado!");
		} else if (autorDto.getPais().getSigla().equals("BR")) {
			if (validaCpf != null) {
				log.error("Falha no cadastro!");
				throw new NegocioException("Cpf já cadastrado!");
			} else {
				Autor novoAutor = autorConvert.dtoToEntity(autorDto);
				autorRepository.save(novoAutor);
//				idNovoAutor= autorRepository.findByEmail(autorDto.getEmail()).getId();
				log.info("Autor brasileiro cadastrado");
			}
		} else {
			autorDto.setCpf(null);
			Autor novoAutor = autorConvert.dtoToEntity(autorDto);
			autorRepository.save(novoAutor);
//			idNovoAutor= autorRepository.findByEmail(autorDto.getEmail()).getId();
			log.info("Autor estrangeiro cadastrado");
		}
		
//		if(autorDto.getObras() != null) {
//			List<Long> idObras = autorDto.getObras().stream().map(a-> a.getId()).collect(Collectors.toList());
//			
//			for(int i=0; i< idObras.size();i++) {
//				autorRepository.conectar(idObras.get(i), idNovoAutor);
//			}
//		}

	}

	public List<AutorDto> retornarAutores() {
		try {
			return ((List<Autor>) autorRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"))).stream()
					.map(autorConvert::entityToDto).collect(Collectors.toList());
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println(e.getMessage());
			throw new RetornoException("Erro no retorno de dados!");
		}

	}

	public void excluirAutor(Long id) {
		findAutorById(id);
		if (autorRepository.findObraRelation(id) == null) {
			autorRepository.deleteById(id);
		} else {
			throw new NegocioException("Falha! O autor possui obras cadastradas!");
		}
	}

	public Autor findAutorById(Long id) {
		return autorRepository.findById(id).orElseThrow(() -> new NegocioException("O autor não existe id: " + id));
	}

}
