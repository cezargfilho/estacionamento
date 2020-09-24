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

import br.com.ucsal.estacionamento.model.Pagamento;
import br.com.ucsal.estacionamento.repository.PagamentoRepository;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@GetMapping(path = "/listar")
	public List<Pagamento> listar() {
		List<Pagamento> pagamentos = pagamentoRepository.findAll();
		return pagamentos;
	}

	@PostMapping(path = "/cadastrar")
	public ResponseEntity<Pagamento> cadastrar() {
		/*
		 * TODO: Implementar calculo de pagamento para HORISTA e MENSALISTA
		 * 
		 */

		return null;
	}

	@GetMapping(path = "/detalhe/{id}")
	public ResponseEntity<Pagamento> detalhar(@PathVariable Long id) {
		Optional<Pagamento> optional = pagamentoRepository.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		return ResponseEntity.notFound().build();
	}

}
