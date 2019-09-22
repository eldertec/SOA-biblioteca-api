package br.edu.faculdadedelta.api.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.edu.faculdadedelta.api.model.enuns.Sexo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O nome é obrigatório")
	private String nome;

	@NotBlank(message = "O cpf é obrigatório")
	private String cpf;

	@NotBlank(message = "O email é obrigatório")
	private String email;

	@NotBlank(message = "O telefone é obrigatório")
	private String telefone;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "O sexo é obrigatório")
	private Sexo sexo;

	@ManyToOne
	@JoinColumn(name = "id_endereco")
	@NotNull(message = "O endereço é obrigatório")
	private Endereco endereco;

}
