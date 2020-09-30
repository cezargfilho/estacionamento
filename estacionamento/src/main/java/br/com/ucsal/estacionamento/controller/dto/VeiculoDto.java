package br.com.ucsal.estacionamento.controller.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.ucsal.estacionamento.model.Veiculo;

public class VeiculoDto {

	private String placa;

	// cpf usuario
	private String usuario;

	private String cor;
	// nome fabricante
	private String fabricante;

	private String modelo;

	public VeiculoDto(Veiculo veiculo) {
		this.placa = veiculo.getPlaca();
		this.usuario = veiculo.getUsuario().getCpf();
		this.fabricante = veiculo.getFabricante().getNome();
		this.cor = veiculo.getCor();
		this.modelo = veiculo.getModelo();
	}

	public String getPlaca() {
		return placa;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getCor() {
		return cor;
	}

	public String getFabricante() {
		return fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public static List<VeiculoDto> converter(List<Veiculo> veiculos) {
		List<VeiculoDto> veiculosDto = new ArrayList<>();
		for (Veiculo veiculo : veiculos) {
			veiculosDto.add(new VeiculoDto(veiculo));
		}
		return veiculosDto;
	}

}
