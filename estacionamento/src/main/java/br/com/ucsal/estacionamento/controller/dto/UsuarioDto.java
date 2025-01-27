package br.com.ucsal.estacionamento.controller.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.ucsal.estacionamento.model.Usuario;

public class UsuarioDto {

	private Long codigo;

	private String nome;

	private String cpf;

	private String tipo;

	public UsuarioDto(Usuario usuario) {
		this.codigo = usuario.getCodigo();
		this.nome = usuario.getNome();
		this.cpf = usuario.getCpf();
		this.tipo = usuario.getTipo();
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getTipo() {
		return tipo;
	}

	public Long getCodigo() {
		return codigo;
	}

	public Usuario converter() {
		return new Usuario(this.cpf, this.nome, this.tipo);
	}

	public static List<UsuarioDto> converter(List<Usuario> usuarios) {
		List<UsuarioDto> usuariosDto = new ArrayList<>();
		for (Usuario usuario : usuarios) {
			usuariosDto.add(new UsuarioDto(usuario));
		}
		return usuariosDto;
	}

}
