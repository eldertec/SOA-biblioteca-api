package br.edu.faculdadedelta.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emprestimo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "A data de emprestimo é obrigatória!")
	private LocalDate dataEmprestimo;

	@NotNull(message = "A data de devolução é obrigatória!")
	private LocalDate dataDevolucao;

	@NotNull(message = "O valor é obrigatório!")
	private BigDecimal valorEmprestimo;

	@ManyToOne
	@JoinColumn(name = "id_livro")
	@NotNull(message = "O livro é obrigatório!")
	private Livro livro;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	@NotNull(message = "O cliente é obrigatório!")
	private Cliente cliente;
}
