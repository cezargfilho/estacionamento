package br.com.ucsal.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ucsal.estacionamento.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

	Veiculo findByPlaca(String placa);

}
