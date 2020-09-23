package br.com.ucsal.estacionamento.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * Usuario HORISTA tera um codigo fixo;
 */

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo")
	private Long codigo;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "cpf", nullable = false)
	private String cpf;

	@Column(name = "dt_nascimento", nullable = true)
	private Date dataNascimento;

	@Column(name = "telefone", nullable = true)
	private String telefone;

	@Column(name = "tipo", nullable = false)
	private String tipo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id", referencedColumnName = "codigo")
	private Endereco endereco;

	@OneToMany(mappedBy = "usuario")
	private List<Entrada> entradas;
	
	public Usuario() {
		//construtor default
	}

	public Usuario(String nome, String cpf, Date dataNascimento, String telefone, String tipo, Endereco endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.tipo = tipo;
		this.endereco = endereco;
	}

	public Usuario(String cpf, String nome, String tipo) {
		this.cpf = cpf;
		this.nome = nome;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Long getCodigo() {
		return codigo;
	}

	public List<Entrada> getEntradas() {
		return entradas;
	}

	public void setEntradas(List<Entrada> entradas) {
		this.entradas = entradas;
	}

}
