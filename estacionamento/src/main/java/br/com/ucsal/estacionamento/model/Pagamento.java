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
@Table(name = "pagamento")
public class Pagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long codigo;

	@ManyToOne
	@JoinColumn(name = "cod_preco", nullable = false)
	private Preco preco;

	@Column(name = "qtd_horas", nullable = false)
	private String qtdHoras;

	@Column(name = "data_pagamento", nullable = false)
	private Date dataPagamento;

	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;
	
	public Pagamento() {
		//construtor default
	}

	public Pagamento(Preco preco, String qtdHoras, Date dataPagamento, Usuario usuario) {
		this.preco = preco;
		this.qtdHoras = qtdHoras;
		this.dataPagamento = dataPagamento;
		this.usuario = usuario;
	}

	public Preco getPreco() {
		return preco;
	}

	public void setPreco(Preco preco) {
		this.preco = preco;
	}

	public String getQtdHoras() {
		return qtdHoras;
	}

	public void setQtdHoras(String qtdHoras) {
		this.qtdHoras = qtdHoras;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
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
