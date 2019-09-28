package br.edu.faculdadedelta.api.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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

import br.edu.faculdadedelta.api.model.Genero;
import br.edu.faculdadedelta.api.service.GeneroService;

@RestController
@RequestMapping(value = "/generos")
public class GeneroResource {

	@Autowired
	private GeneroService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('ROLE_INCLUIR_GENERO')")
	public Genero inserir(@RequestBody @Valid Genero genero, HttpServletResponse response) {
		Genero retorno = service.inserir(genero);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(genero.getId()).toUri();
		response.setHeader(HttpHeaders.LOCATION, uri.toString());
		return retorno;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasAuthority('ROLE_LISTAR_GENERO')")
	public List<Genero> listar() {
		return service.listar();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_POR_ID_GENERO')")
	public Genero pesquisarPorId(@PathVariable("id") Long id) {
		return service.pesquisarPorId(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasAuthority('ROLE_ALTERAR_GENERO')")
	public Genero alterar(@RequestBody @Valid Genero genero, @PathVariable("id") Long id) {
		return service.alterar(genero,id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_EXCLUIR_GENERO')")
	public void excluir(@PathVariable("id") Long id) {
		service.excluir(id);
	}
}
