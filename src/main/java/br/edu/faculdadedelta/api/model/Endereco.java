package br.edu.faculdadedelta.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "A rua é obrigatória")
	private String rua;

	@NotBlank(message = "O bairro é obrigatório")
	private String bairro;
	private String quadra;
	private String lote;
	private String numero;
	private String complemento;

	@NotBlank(message = "A cidade é obrigatória")
	private String cidade;

	@NotBlank(message = "O estado é obrigatório")
	private String estado;

	@NotBlank(message = "O pais é obrigatório")
	private String pais;
}
