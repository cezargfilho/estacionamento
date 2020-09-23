package br.com.ucsal.estacionamento.model.enums;

public enum TipoUsuario {

	HORISTA("HORISTA"), MENSALISTA("MENSALISTA");

	private String valor;

	TipoUsuario(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

}
