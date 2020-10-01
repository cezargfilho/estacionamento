package br.com.ucsal.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ucsal.estacionamento.model.Entrada;
import br.com.ucsal.estacionamento.model.Usuario;
import br.com.ucsal.estacionamento.model.Vaga;

public interface EntradaRepository extends JpaRepository<Entrada, Long>{

	Entrada findByUsuarioAndVaga(Usuario usuario, Vaga vagaId);

}
