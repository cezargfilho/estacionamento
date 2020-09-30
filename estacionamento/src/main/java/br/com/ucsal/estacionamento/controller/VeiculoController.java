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

import br.com.ucsal.estacionamento.controller.dto.VeiculoDto;
import br.com.ucsal.estacionamento.controller.forms.VeiculoForm;
import br.com.ucsal.estacionamento.model.Veiculo;
import br.com.ucsal.estacionamento.repository.FabricanteRepository;
import br.com.ucsal.estacionamento.repository.UsuarioRepository;
import br.com.ucsal.estacionamento.repository.VeiculoRepository;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoRepository veiculoRepository;

	@Autowired
	private FabricanteRepository fabRepository;

	@Autowired
	private UsuarioRepository userRepository;

	@GetMapping(path = "/listar")
	public List<VeiculoDto> listar() {
		List<Veiculo> veiculos = veiculoRepository.findAll();
		return VeiculoDto.converter(veiculos);
	}

	@PostMapping(path = "/cadastrar")
	public ResponseEntity<VeiculoDto> cadastrar(
			@RequestBody VeiculoForm veiculoForm, 
			UriComponentsBuilder uriBuilder) {

		String placa = veiculoForm.getPlaca().toUpperCase();
		Veiculo veiculo = veiculoRepository.findByPlaca(placa);

		if (veiculo == null) {
			veiculo = veiculoForm.converter(fabRepository, userRepository);
			veiculoRepository.save(veiculo);
		} else {
			return ResponseEntity.badRequest().build();
		}

		URI uri = uriBuilder.path("/detalhe/{id}").buildAndExpand(veiculoForm.getPlaca()).toUri();
		return ResponseEntity.created(uri).body(new VeiculoDto(veiculo));
	}

	@GetMapping(path = "/detalhe/{id}")
	public ResponseEntity<VeiculoDto> detalhar(@PathVariable Long id) {
		Optional<Veiculo> optional = veiculoRepository.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(new VeiculoDto(optional.get()));
		}
		return ResponseEntity.notFound().build();
	}

}
