package br.edu.faculdadedelta.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.faculdadedelta.api.model.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{

}
