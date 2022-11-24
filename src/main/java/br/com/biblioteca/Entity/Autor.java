package br.com.biblioteca.Entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "autores")
public class Autor {

	@Id
	@GeneratedValue(generator = "sq_autor")
	@Column(name = "id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "sexo")
	private String sexo;
	@Column(name = "email")
	private String email;
	@Column(name = "data_nascimento")
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate dataNascimento;
	@OneToOne
	@JoinColumn(name= "fk_pais")
	private Pais pais;
	@Column(name = "cpf")
	private String cpf;

	@JsonIgnore
	@ManyToMany(mappedBy = "autores")
	private List<Obra> obras;


}
