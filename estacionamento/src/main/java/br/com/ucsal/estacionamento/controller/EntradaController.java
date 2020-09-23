package br.com.ucsal.estacionamento.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ucsal.estacionamento.controller.dto.EntradaDto;
import br.com.ucsal.estacionamento.model.Entrada;
import br.com.ucsal.estacionamento.repository.EntradaRepository;

@RestController
@RequestMapping("/entrada")
public class EntradaController {

	@Autowired
	private EntradaRepository entradaRepository;

	@GetMapping(path = "/listar")
	public List<Entrada> listar() {
		List<Entrada> entradas = entradaRepository.findAll();
		return entradas;
	}

	@PostMapping(path = "/cadastrar")
	public ResponseEntity<EntradaDto> cadastrar() {
		/*
		 * TODO: Implementar regra para cadastrar entrada de MENSALISTA e HORISTA
		 */
		return null;
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
