package br.com.ucsal.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ucsal.estacionamento.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	Endereco findByCepAndNumero(String cep, String numero);

}
