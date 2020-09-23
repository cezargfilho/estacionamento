package br.com.ucsal.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ucsal.estacionamento.model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

}
