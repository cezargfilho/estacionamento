package br.com.ucsal.estacionamento.controller.forms;

import br.com.ucsal.estacionamento.model.Fabricante;
import br.com.ucsal.estacionamento.model.Usuario;
import br.com.ucsal.estacionamento.model.Veiculo;
import br.com.ucsal.estacionamento.repository.FabricanteRepository;
import br.com.ucsal.estacionamento.repository.UsuarioRepository;

public class VeiculoForm {

	private String placa;

	private String cpfUsuario;

	private String nomeFabricante;

	private String modelo;

	private String cor;

	public String getPlaca() {
		return placa;
	}

	public String getCpfUsuario() {
		return cpfUsuario;
	}

	public String getNomeFabricante() {
		return nomeFabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public String getCor() {
		return cor;
	}
	
	public Veiculo converter(FabricanteRepository fabRepository, UsuarioRepository userRepository) {
		Usuario usuario = userRepository.findByCpf(this.cpfUsuario);
		Fabricante fabricante = fabRepository.findByNome(this.nomeFabricante);
		
		return new Veiculo(this.placa, usuario, fabricante, this.modelo, this.cor);
	}

}
