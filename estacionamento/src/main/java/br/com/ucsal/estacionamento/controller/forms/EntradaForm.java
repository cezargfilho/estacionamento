package br.com.ucsal.estacionamento.controller.forms;

import java.util.Date;
import java.util.Optional;

import br.com.ucsal.estacionamento.model.Entrada;
import br.com.ucsal.estacionamento.model.Usuario;
import br.com.ucsal.estacionamento.model.Vaga;
import br.com.ucsal.estacionamento.repository.UsuarioRepository;
import br.com.ucsal.estacionamento.repository.VagaRepository;

public class EntradaForm {

	private String placa;

	private Integer numeroVaga;

	private String cpfUsuario;

	public String getPlaca() {
		return placa;
	}

	public Integer getVaga() {
		return numeroVaga;
	}

	public String getUsuario() {
		return cpfUsuario;
	}

	public Entrada converter(UsuarioRepository userRepository, VagaRepository vagaRepository) {
		Usuario usuario = userRepository.findByCpf(this.cpfUsuario);
		Optional<Vaga> optional = vagaRepository.findById(new Long(this.numeroVaga));

		if (optional.isPresent()) {
			Vaga vaga = optional.get();
			if (usuario.getTipo().equalsIgnoreCase("mensalista")) {
				return new Entrada(this.placa, vaga, null, usuario);
			}
			return new Entrada(this.placa, vaga, new Date(), usuario);
		}
		return null;

	}

}
