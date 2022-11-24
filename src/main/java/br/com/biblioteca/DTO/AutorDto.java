package br.com.biblioteca.DTO;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.biblioteca.Entity.Obra;
import br.com.biblioteca.Entity.Pais;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AutorDto {

	private Long id;
	
	@NotBlank(message = "Nome obrigatório!")
	private String nome;
	
	@NotBlank(message = "Sexo obrigatório!")
	private String sexo;
	
	@NotBlank(message = "Email obrigatório!")
	@Email(message = "Email inválido!")
	private String email;
	
	//@NotNull(message = "Data de nascimento obrigatória!")
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate dataNascimento;

	private String cpf;

	private Pais pais;
	
	private List<Obra> obras;
	
}
