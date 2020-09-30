package br.com.ucsal.estacionamento.controller.forms;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;

import br.com.ucsal.estacionamento.model.Entrada;
import br.com.ucsal.estacionamento.model.Pagamento;
import br.com.ucsal.estacionamento.model.Preco;
import br.com.ucsal.estacionamento.model.Usuario;
import br.com.ucsal.estacionamento.model.Vaga;
import br.com.ucsal.estacionamento.model.enums.TipoUsuario;
import br.com.ucsal.estacionamento.repository.EntradaRepository;
import br.com.ucsal.estacionamento.repository.PrecoRepository;
import br.com.ucsal.estacionamento.repository.UsuarioRepository;

public class PagamentoForm {

	private String precoId;

	private String qtdHoras;

	private String cpfUsuario;

	private String vaga;

	public String getPrecoId() {
		return precoId;
	}

	public void setPrecoId(String precoId) {
		this.precoId = precoId;
	}

	public String getQtdHoras() {
		return qtdHoras;
	}

	public String getVaga() {
		return vaga;
	}

	public void setQtdHoras(String qtdHoras) {
		this.qtdHoras = qtdHoras;
	}

	public String getCpfUsuario() {
		return cpfUsuario;
	}

	public void setCpfUsuario(String cpfUsuario) {
		this.cpfUsuario = cpfUsuario;
	}

	public void setVaga(String vaga) {
		this.vaga = vaga;
	}

	public Pagamento converter(UsuarioRepository userRepository, PrecoRepository precoRepository, EntradaRepository entradaRepository, Vaga vagaUser) {
		Usuario usuario = userRepository.findByCpf(this.cpfUsuario);
		Optional<Preco> optional = precoRepository.findById(Long.parseLong(precoId));
		Entrada entrada = entradaRepository.findByUsuarioAndVaga(usuario, vagaUser);

		if (optional.isPresent()) {
			Preco preco = optional.get();
			if (entrada != null) {
				if (usuario.getTipo().equalsIgnoreCase(TipoUsuario.HORISTA.getValor())) {
					Date date = new Date();
					String qtdHora = calculaHorario(entrada.getHorario(), date);
					return new Pagamento(preco, qtdHora, date, usuario);
				}				
			}
		}
		return null;
	}

	private String calculaHorario(Date entrada, Date saida) {
		DateFormat format = new SimpleDateFormat("HH:mm:ss");

		String horaEntrada = format.format(entrada);
		String horaSaida = format.format(saida);
		LocalTime t1 = LocalTime.parse(horaEntrada);
		//LocalTime t2 = LocalTime.parse(horaSaida);
		LocalTime t2 = LocalTime.parse("23:00:00");
		long timeResult = t1.until(t2, ChronoUnit.HOURS);

		return String.valueOf(timeResult);
	}

}
