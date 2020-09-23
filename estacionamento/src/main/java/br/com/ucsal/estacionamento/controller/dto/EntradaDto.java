package br.com.ucsal.estacionamento.controller.dto;

import java.util.Date;

import br.com.ucsal.estacionamento.model.Usuario;
import br.com.ucsal.estacionamento.model.Vaga;

public class EntradaDto {

	private String placa;

	private Vaga vaga;

	private Date horario;

	private Usuario usuario;

	public String getPlaca() {
		return placa;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public Date getHorario() {
		return horario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

}
