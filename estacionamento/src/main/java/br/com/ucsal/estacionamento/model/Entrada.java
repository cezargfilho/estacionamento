package br.com.ucsal.estacionamento.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "entrada")
public class Entrada {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "codigo")
	private Long codigo;

	@Column(name = "placa")
	private String placa;
	
	@ManyToOne
	@JoinColumn(name = "vaga_id")
	private Vaga vaga;

	@Column(name = "horario")
	private Date horario;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	public Entrada() {
		//construtor default
	}

	public Entrada(String placa, Vaga vaga, Date horario, Usuario usuario) {
		this.placa = placa;
		this.vaga = vaga;
		this.horario = horario;
		this.usuario = usuario;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getCodigo() {
		return codigo;
	}

}
