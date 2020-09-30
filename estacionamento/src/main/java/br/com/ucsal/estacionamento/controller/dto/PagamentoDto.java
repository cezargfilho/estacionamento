package br.com.ucsal.estacionamento.controller.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.ucsal.estacionamento.model.Pagamento;

public class PagamentoDto {
	
	private Long codigo;
	
	private PrecoDto preco;
	
	private String qtdHoras;
	
	private String dataPagamento;
	
	private String cpfUsuario;

	public PagamentoDto(Pagamento pagamento) {
		this.codigo = pagamento.getCodigo();
		this.preco = new PrecoDto(pagamento.getPreco());
		this.qtdHoras = pagamento.getQtdHoras();
		this.dataPagamento = dataConverter(pagamento.getDataPagamento());
		this.cpfUsuario = pagamento.getUsuario().getCpf();
	}

	public Long getCodigo() {
		return codigo;
	}

	public PrecoDto getPreco() {
		return preco;
	}

	public String getQtdHoras() {
		return qtdHoras;
	}

	public String getDataPagamento() {
		return dataPagamento;
	}

	public String getCpfUsuario() {
		return cpfUsuario;
	}

	public static List<PagamentoDto> converter(List<Pagamento> pagamentos) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String dataConverter(Date horario) {
		return new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(horario);
	}

}
