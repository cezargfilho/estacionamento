package br.com.ucsal.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ucsal.estacionamento.model.Vaga;

public interface VagaRepository extends JpaRepository<Vaga, Long> {

}
