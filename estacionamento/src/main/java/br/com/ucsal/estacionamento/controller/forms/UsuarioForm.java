package br.com.ucsal.estacionamento.controller.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.ucsal.estacionamento.model.Usuario;

public class UsuarioForm {

	private String nome;

	private String cpf;

	private String dataNascimento;

	private String telefone;

	private String tipo;

	private EnderecoForm endereco;

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getTipo() {
		return tipo;
	}

	public EnderecoForm getEndereco() {
		return endereco;
	}

	public Usuario converter() {
		Date data = null;
		try {
			data = new SimpleDateFormat("dd/MM/yyyy").parse(this.dataNascimento);
		} catch (ParseException e) {
			Logger.getLogger(UsuarioForm.class.getName()).log(Level.WARNING,
					"Erro ao realizar o parse de Data ou criação de Endereco do Usuario", e);
		}
		return new Usuario(nome, cpf, data, telefone, tipo, endereco.converter());
	}

}
