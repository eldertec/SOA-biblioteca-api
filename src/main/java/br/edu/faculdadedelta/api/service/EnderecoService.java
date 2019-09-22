package br.edu.faculdadedelta.api.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.faculdadedelta.api.model.Endereco;
import br.edu.faculdadedelta.api.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;

	@Transactional
	public Endereco inserir(Endereco endereco) {
		endereco.setId(null);
		return repository.save(endereco);

	}

	public List<Endereco> listar() {
		return repository.findAll();
	}

	public Endereco pesquisarPorId(Long id) {
		return repository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

	@Transactional
	public Endereco alterar(Endereco endereco, Long id) {
		Endereco enderecoPesquisado = pesquisarPorId(id);
		BeanUtils.copyProperties(endereco, enderecoPesquisado, "id");
		return repository.save(enderecoPesquisado);
	}

	@Transactional
	public void excluir(Long id) {
		repository.deleteById(id);

	}

}
