package br.com.ucsal.estacionamento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "veiculo")
public class Veiculo {

	@Id
	@Column(name = "placa", nullable = false)
	private String placa;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "id_fabricante", nullable = false)
	private Fabricante fabricante;

	@Column(name = "modelo")
	private String modelo;

	@Column(name = "cor")
	private String cor;

	public Veiculo() {
		// construtor default
	}

	public Veiculo(String placa, Usuario usuario) {
		this.placa = placa;
		this.usuario = usuario;
	}

	public Veiculo(String placa, Usuario usuario, Fabricante fabricante, String modelo, String cor) {
		this.placa = placa;
		this.usuario = usuario;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

}
