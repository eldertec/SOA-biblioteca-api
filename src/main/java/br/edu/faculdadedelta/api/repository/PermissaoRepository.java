package br.edu.faculdadedelta.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.faculdadedelta.api.model.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

}
