package br.edu.faculdadedelta.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.faculdadedelta.api.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
