package br.edu.faculdadedelta.api.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.faculdadedelta.api.model.Emprestimo;
import br.edu.faculdadedelta.api.repository.EmprestimoRepository;

@Service
public class EmprestimoService {

	@Autowired
	private EmprestimoRepository repository;

	@Transactional
	public Emprestimo inserir(Emprestimo emprestimo) {
		emprestimo.setId(null);
		return repository.save(emprestimo);

	}

	public List<Emprestimo> listar() {
		return repository.findAll();
	}

	public Emprestimo pesquisarPorId(Long id) {
		return repository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

	@Transactional
	public Emprestimo alterar(Emprestimo emprestimo, Long id) {
		Emprestimo emprestimoPesquisado = pesquisarPorId(id);
		BeanUtils.copyProperties(emprestimo, emprestimoPesquisado, "id");
		return repository.save(emprestimoPesquisado);
	}

	@Transactional
	public void excluir(Long id) {
		repository.deleteById(id);

	}

}
