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

import br.com.ucsal.estacionamento.controller.dto.PagamentoDto;
import br.com.ucsal.estacionamento.controller.forms.PagamentoForm;
import br.com.ucsal.estacionamento.model.Pagamento;
import br.com.ucsal.estacionamento.model.Vaga;
import br.com.ucsal.estacionamento.repository.EntradaRepository;
import br.com.ucsal.estacionamento.repository.PagamentoRepository;
import br.com.ucsal.estacionamento.repository.PrecoRepository;
import br.com.ucsal.estacionamento.repository.UsuarioRepository;
import br.com.ucsal.estacionamento.repository.VagaRepository;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private UsuarioRepository userRepository;

	@Autowired
	private PrecoRepository precoRepository;

	@Autowired
	private EntradaRepository entradaRepository;

	@Autowired
	private VagaRepository vagaRepository;

	@GetMapping(path = "/listar")
	public List<PagamentoDto> listar() {
		List<Pagamento> pagamentos = pagamentoRepository.findAll();
		return PagamentoDto.converter(pagamentos);
	}

	@PostMapping(path = "/cadastrar")
	public ResponseEntity<PagamentoDto> cadastrar(
			@RequestBody PagamentoForm form, 
			UriComponentsBuilder uriBuilder) {

		Optional<Vaga> optional = vagaRepository.findById(Long.parseLong(form.getVaga()));

		Vaga vaga = null;
		if (optional.isPresent()) {
			vaga = optional.get();
		}
		
		if (vaga != null) {
			Pagamento pagamento = form.converter(userRepository, precoRepository, entradaRepository, vaga);

			if (pagamento != null) {
				pagamentoRepository.save(pagamento);
				URI uri = uriBuilder.path("/detalhe/{id}").buildAndExpand(pagamento.getCodigo()).toUri();
				return ResponseEntity.created(uri).body(new PagamentoDto(pagamento));
			}
		}
		return ResponseEntity.badRequest().build();
	}

	@GetMapping(path = "/detalhe/{id}")
	public ResponseEntity<PagamentoDto> detalhar(@PathVariable Long id) {
		Optional<Pagamento> optional = pagamentoRepository.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(new PagamentoDto(optional.get()));
		}
		return ResponseEntity.notFound().build();
	}

}
