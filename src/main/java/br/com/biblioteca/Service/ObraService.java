package br.com.biblioteca.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.biblioteca.Convert.ObraConvert;
import br.com.biblioteca.DTO.ObraDto;
import br.com.biblioteca.Entity.Obra;
import br.com.biblioteca.Exception.ModificacaoException;
import br.com.biblioteca.Exception.NegocioException;
import br.com.biblioteca.Exception.RetornoException;
import br.com.biblioteca.Repository.ObraRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Service
public class ObraService {

	private final ObraRepository obraRepository;
	private final ObraConvert obraConvert;

	public void alterarObra(ObraDto obraDto) {
		LocalDate dataPublicacao = obraDto.getDataPublicacao();
		LocalDate dataExposicao = obraDto.getDataExposicao();

		if (dataPublicacao == null && dataExposicao == null) {
			log.error("Falha na alteração!");
			throw new NegocioException("A obra precisa ter uma data de exposição ou publicação!");
		} else if (dataPublicacao != null && dataExposicao != null) {
			log.error("Falha na alteração!");
			throw new NegocioException("A obra só pode ter uma data de exposição ou de publicação!");
		}else if(obraDto.getAutores() == null) {
			log.error("Falha na alteração!");
			throw new NegocioException("A obra precisa ter pelo menos um autor!");
		}else {
			Obra obraAlterada = obraConvert.dtoToEntity(obraDto);
			obraRepository.save(obraAlterada);
			log.info("Alterando obra com id: {}", obraDto.getId());
		}

	}

	public void cadastrarObra(ObraDto obraDto) {
		LocalDate dataPublicacao = obraDto.getDataPublicacao();
		LocalDate dataExposicao = obraDto.getDataExposicao();
		Obra obraExistente = obraRepository.findByNomeContainingIgnoreCase(obraDto.getNome());

		if ((dataPublicacao == null && dataExposicao == null) || (dataPublicacao != null && dataExposicao != null)) {
			log.error("Falha no cadastro!");
			throw new NegocioException("A obra precisa ter somente uma data de exposição OU de publicação!");
		} else if (obraExistente != null) {
			log.error("Falha no cadastro!");
			throw new NegocioException("Essa obra já existe!");
		} else {
			Obra obra = obraConvert.dtoToEntity(obraDto);
			obraRepository.save(obra);
			log.info("Obra cadastrada.");
		}
	}

	public void excluirObra(long id) {
		try {
			findObraById(id);
			obraRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ModificacaoException("Falha! Obra não excluida!");
		}

	}

	public List<ObraDto> retornarObras() {
		try {
			return ((List<Obra>) obraRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"))).stream()
					.map(obraConvert::entityToDto).collect(Collectors.toList());
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println(e.getMessage());
			throw new RetornoException("Erro no retorno de dados!");
		}

	}

	public Obra findObraById(Long id) {
		return obraRepository.findById(id).orElseThrow(() -> new NegocioException("A obra não existe id: " + id));
	}
	

}
