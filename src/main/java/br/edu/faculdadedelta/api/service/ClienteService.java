package br.edu.faculdadedelta.api.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.faculdadedelta.api.model.Cliente;
import br.edu.faculdadedelta.api.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Transactional
	public Cliente inserir(Cliente cliente) {
		cliente.setId(null);
		return repository.save(cliente);

	}

	public List<Cliente> listar() {
		return repository.findAll();
	}

	public Cliente pesquisarPorId(Long id) {
		return repository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

	@Transactional
	public Cliente alterar(Cliente cliente, Long id) {
		Cliente clientePesquisado = pesquisarPorId(id);
		BeanUtils.copyProperties(cliente, clientePesquisado, "id");
		return repository.save(clientePesquisado);
	}

	@Transactional
	public void excluir(Long id) {
		repository.deleteById(id);

	}

}
