package br.edu.faculdadedelta.api.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.faculdadedelta.api.model.Livro;
import br.edu.faculdadedelta.api.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;

	@Transactional
	public Livro inserir(Livro livro) {
		livro.setId(null);
		return repository.save(livro);
	}

	public List<Livro> listar() {
		return repository.findAll();
	}

	public Livro pesquisarPorId(Long id) {
		return repository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

	@Transactional
	public Livro alterar(Livro livro,Long id) {
		Livro livroPesquisado = pesquisarPorId(id);
		BeanUtils.copyProperties(livro, livroPesquisado, "id");
		return repository.save(livroPesquisado);
	}

	@Transactional
	public void excluir(Long id) {
		repository.deleteById(id);

	}

}
