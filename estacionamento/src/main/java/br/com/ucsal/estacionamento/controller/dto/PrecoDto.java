package br.com.ucsal.estacionamento.controller.dto;

import br.com.ucsal.estacionamento.model.Preco;

public class PrecoDto {

	private Long codigo;

	private Double valor;

	public PrecoDto(Preco preco) {
		this.codigo = preco.getCodigo();
		this.valor = preco.getValor();
	}

	public Long getCodigo() {
		return codigo;
	}

	public Double getValor() {
		return valor;
	}

}
