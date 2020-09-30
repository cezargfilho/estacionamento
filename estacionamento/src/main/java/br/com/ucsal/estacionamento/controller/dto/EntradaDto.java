package br.com.ucsal.estacionamento.controller.dto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.ucsal.estacionamento.model.Entrada;
import br.com.ucsal.estacionamento.model.Vaga;

public class EntradaDto {

	private Long codigo;

	private String placa;

	private Vaga vaga;

	private String horario;

	private String cpfUsuario;

	public EntradaDto(Entrada entrada) {
		this.codigo = entrada.getCodigo();
		this.placa = entrada.getPlaca();
		this.vaga = entrada.getVaga();
		this.horario = dataConverter(entrada.getHorario());
		this.cpfUsuario = entrada.getUsuario().getCpf();
	}

	public Long getCodigo() {
		return codigo;
	}

	public String getPlaca() {
		return placa;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public String getHorario() {
		return horario;
	}

	public String getCpfUsuario() {
		return cpfUsuario;
	}

	public static List<EntradaDto> converter(List<Entrada> entradas) {
		List<EntradaDto> entradasDto = new ArrayList<>();
		for (Entrada entrada : entradas) {
			entradasDto.add(new EntradaDto(entrada));
		}
		return entradasDto;
	}

	private String dataConverter(Date horario) {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(horario);
	}

}
