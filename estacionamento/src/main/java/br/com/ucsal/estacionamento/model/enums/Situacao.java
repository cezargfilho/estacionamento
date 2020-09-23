package br.com.ucsal.estacionamento.model.enums;

public enum Situacao {

	LIVRE("LIVRE"), OCUPADA("OCUPADA");

	private String valor;

	Situacao(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}
}
