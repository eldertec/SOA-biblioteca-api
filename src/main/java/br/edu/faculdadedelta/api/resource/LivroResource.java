package br.edu.faculdadedelta.api.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.faculdadedelta.api.model.Livro;
import br.edu.faculdadedelta.api.service.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

	@Autowired
	private LivroService livroService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Livro inserir(@RequestBody @Valid Livro livro, HttpServletResponse response) {
		Livro retorno = livroService.inserir(livro);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(livro.getId()).toUri();
		response.setHeader(HttpHeaders.LOCATION, uri.toString());
		return retorno;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Livro> listar() {
		return livroService.listar();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Livro pesquisarPorId(@PathVariable("id") Long id) {
		return livroService.pesquisarPorId(id);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Livro alterar(@RequestBody @Valid Livro livro, @PathVariable("id") Long id) {
		return livroService.alterar(livro, id);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable("id") Long id) {
		livroService.excluir(id);
	}
}
