package br.edu.faculdadedelta.api.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.faculdadedelta.api.model.Editora;
import br.edu.faculdadedelta.api.repository.EditoraRepository;

@Service
public class EditoraService {

	@Autowired
	private EditoraRepository repository;

	@Transactional
	public Editora inserir(Editora editora) {
		editora.setId(null);
		return repository.save(editora);

	}

	public List<Editora> listar() {
		return repository.findAll();
	}

	public Editora pesquisarPorId(Long id) {
		return repository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

	@Transactional
	public Editora alterar(Editora editora, Long id) {
		Editora editoraPesquisado = pesquisarPorId(id);
		BeanUtils.copyProperties(editora, editoraPesquisado, "id");
		return repository.save(editoraPesquisado);
	}

	@Transactional
	public void excluir(Long id) {
		repository.deleteById(id);

	}

}
