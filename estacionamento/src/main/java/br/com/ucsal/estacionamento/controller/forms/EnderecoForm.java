package br.com.ucsal.estacionamento.controller.forms;

import br.com.ucsal.estacionamento.model.Endereco;

public class EnderecoForm {

	private String cep;

	private String rua;

	private String numero;

	private String cidade;

	private String estado;

	private String pais;

	public String getCep() {
		return cep;
	}

	public String getRua() {
		return rua;
	}

	public String getNumero() {
		return numero;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public String getPais() {
		return pais;
	}

	public Endereco converter() {
		return new Endereco(this.cep, this.rua, this.numero, this.cidade, this.estado, this.pais);
	}

}
