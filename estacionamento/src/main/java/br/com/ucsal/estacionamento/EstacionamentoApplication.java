package br.com.ucsal.estacionamento;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.ucsal.estacionamento.model.Fabricante;
import br.com.ucsal.estacionamento.model.Preco;
import br.com.ucsal.estacionamento.model.Usuario;
import br.com.ucsal.estacionamento.model.Vaga;
import br.com.ucsal.estacionamento.model.enums.Situacao;
import br.com.ucsal.estacionamento.model.enums.TipoUsuario;
import br.com.ucsal.estacionamento.repository.FabricanteRepository;
import br.com.ucsal.estacionamento.repository.PrecoRepository;
import br.com.ucsal.estacionamento.repository.UsuarioRepository;
import br.com.ucsal.estacionamento.repository.VagaRepository;

@SpringBootApplication
public class EstacionamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstacionamentoApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(UsuarioRepository userRepository, FabricanteRepository fabRepository,
			VagaRepository vagaRepository, PrecoRepository precoRepository) {

		return (args) -> { // Criacao de usuario padrao HORISTA
			userRepository.save(
					new Usuario("USUARIO HORISTA", "00000000000", null, null, TipoUsuario.HORISTA.getValor(), null));

			// Criacao dos fabricantes pre definidos
			fabRepository.save(new Fabricante("FIAT"));
			fabRepository.save(new Fabricante("RENAULT"));
			fabRepository.save(new Fabricante("VOLKSWAGEN"));
			fabRepository.save(new Fabricante("CHEVROLLET"));
			fabRepository.save(new Fabricante("LAND HOVER"));
			fabRepository.save(new Fabricante("FERRARI"));
			fabRepository.save(new Fabricante("MERCEDES"));
			fabRepository.save(new Fabricante("TOYOTA"));

			// Criacao dos precos iniciais
			precoRepository.save(new Preco(6.00)); // Hora
			precoRepository.save(new Preco(250.00)); // Mes

			// Ciracao de 10 vagas iniciais
			int n = 0;
			while (n < 10) {
				vagaRepository.save(new Vaga(Situacao.LIVRE.getValor()));
				n++;
			}
		};

	}

}
