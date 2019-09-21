package br.edu.faculdadedelta.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.faculdadedelta.api.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
