package br.com.ucsal.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ucsal.estacionamento.model.Entrada;

public interface EntradaRepository extends JpaRepository<Entrada, Long>{

}
