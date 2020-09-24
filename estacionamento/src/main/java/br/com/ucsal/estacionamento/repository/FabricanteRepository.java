package br.com.ucsal.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ucsal.estacionamento.model.Fabricante;

public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {

	Fabricante findByNome(String nomeFabricante);

}
