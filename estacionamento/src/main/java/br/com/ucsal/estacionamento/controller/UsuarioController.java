package br.com.ucsal.estacionamento.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.ucsal.estacionamento.controller.dto.UsuarioDto;
import br.com.ucsal.estacionamento.controller.forms.UsuarioForm;
import br.com.ucsal.estacionamento.model.Usuario;
import br.com.ucsal.estacionamento.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping(path = "/listar")
	public List<Usuario> listar() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		return usuarios;
	}

	@PostMapping(path = "/cadastrar/mensalista")
	public ResponseEntity<UsuarioDto> cadastrar(
			@RequestBody UsuarioForm form,
			UriComponentsBuilder uriBuilder) {
		
		Usuario usuario = form.converter();
		
		usuarioRepository.save(usuario);

		URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
	}

	@GetMapping(path = "/detalhe/{id}")
	public ResponseEntity<Usuario> detalhar(@PathVariable Long id) {
		Optional<Usuario> optional = usuarioRepository.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping(path = "/deletar/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Usuario> optional = usuarioRepository.findById(id);
		if (optional.isPresent()) {
			usuarioRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
