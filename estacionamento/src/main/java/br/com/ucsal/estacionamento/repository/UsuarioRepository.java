package br.com.ucsal.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ucsal.estacionamento.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
