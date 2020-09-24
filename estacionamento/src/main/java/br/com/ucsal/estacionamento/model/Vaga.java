package br.com.ucsal.estacionamento.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.ucsal.estacionamento.model.enums.Situacao;

@Entity
@Table(name = "VAGA")
public class Vaga {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo")
	private Long codigo;

	@Column(name = "situacao", nullable = false)
	private String situacao = Situacao.LIVRE.getValor();
	
	@OneToMany(mappedBy = "vaga")
	private List<Entrada> entradas;
	
	public Vaga() {
		//construtor default
	}
	
	public Vaga(String situacao) {
		this.situacao = situacao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

}
