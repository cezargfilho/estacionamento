package br.com.ucsal.estacionamento.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.ucsal.estacionamento.controller.forms.EntradaForm;
import br.com.ucsal.estacionamento.model.Entrada;
import br.com.ucsal.estacionamento.repository.EntradaRepository;
import br.com.ucsal.estacionamento.repository.UsuarioRepository;
import br.com.ucsal.estacionamento.repository.VagaRepository;

@RestController
@RequestMapping("/entrada")
public class EntradaController {

	@Autowired
	private EntradaRepository entradaRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private VagaRepository vagaRepository;

	@GetMapping(path = "/listar")
	public List<Entrada> listar() {
		List<Entrada> entradas = entradaRepository.findAll();
		return entradas;
	}

	@PostMapping(path = "/cadastrar")
	public ResponseEntity<Entrada> cadastrar(@RequestBody EntradaForm form, UriComponentsBuilder uriBuilder) {

		Entrada entrada = form.converter(usuarioRepository, vagaRepository);
		entradaRepository.save(entrada);

		URI uri = uriBuilder.path("/detalhe/{id}").buildAndExpand(entrada.getCodigo()).toUri();

		return ResponseEntity.created(uri).body(entrada);
	}

	@GetMapping(path = "/detalhe/{id}")
	public ResponseEntity<Entrada> detalhar(@PathVariable Long id) {
		Optional<Entrada> optional = entradaRepository.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		return ResponseEntity.notFound().build();
	}

}
