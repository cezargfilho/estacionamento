package br.com.ucsal.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ucsal.estacionamento.model.Preco;

public interface PrecoRepository extends JpaRepository<Preco, Long> {

}
