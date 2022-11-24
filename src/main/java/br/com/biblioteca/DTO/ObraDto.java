package br.com.biblioteca.DTO;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.biblioteca.Entity.Autor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ObraDto {
	
	private long id;
	@NotBlank(message ="Nome obrigatório!")
	private String nome;
	@NotBlank(message ="Descrição obrigatória!")
	private String descricao;
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate dataPublicacao;
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate dataExposicao;

	private List<Autor> autores;
	
}
