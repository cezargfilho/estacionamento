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

	private String vaga;

	private String cpf;

	public String getPlaca() {
		return placa;
	}

	public String getVaga() {
		return vaga;
	}

	public String getCpf() {
		return cpf;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setVaga(String vaga) {
		this.vaga = vaga;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Entrada converter(UsuarioRepository userRepository, VagaRepository vagaRepository) {
		Usuario usuario = userRepository.findByCpf(this.cpf);
		Optional<Vaga> optional = vagaRepository.findById(Long.parseLong(this.vaga));

		if (optional.isPresent()) {
			Vaga vaga = optional.get();
			if (usuario.getTipo().equalsIgnoreCase("mensalista")) {
				return new Entrada(this.placa, vaga, new Date(), usuario);
			}
			return new Entrada(this.placa, vaga, new Date(), usuario);
		}
		return null;

	}

}
