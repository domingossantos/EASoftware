package br.ufpa.easoft.refact.locadoravideo;

import java.util.Iterator;
import java.util.Vector;

public class Cliente {
	private String _nome;
	private Vector _locacoes = new Vector();

	public Cliente(String nome) {
		_nome = nome;
	}

	public void adicionarLocacao(Locacao arg) {
		_locacoes.addElement(arg);
	}

	public String getNome() {
		return _nome;
	}

	public String conta() {
		double quantiaTotal = 0;
		int pontosLocadorFrequente = 0;
		Iterator iLocacoes = _locacoes.iterator();
		String resultado = "Registro de loca��o de " + getNome() + "\n";

		while (iLocacoes.hasNext()) {
			double estaQuantia = 0;
			Locacao cada = (Locacao) iLocacoes.next();

			// determinar quantias para cada linha
			switch (cada.getFilme().getCodigoPreco()) {
			case Filme.NORMAL:
				estaQuantia += 2;
				if (cada.getDiasAlugados() > 2)
					estaQuantia += (cada.getDiasAlugados() - 2) * 1.5;
				break;
			case Filme.LANCAMENTO:
				estaQuantia += cada.getDiasAlugados() * 3;
				break;
			case Filme.INFANTIL:
				estaQuantia += 1.5;
				if (cada.getDiasAlugados() > 3)
					estaQuantia += (cada.getDiasAlugados() - 3) * 1.5;
				break;
			} // fim switch

			// adicionar os pontos do locador freq�ente
			pontosLocadorFrequente++;

			// adicionar b�nus para uma loca��o de lan�amentos por dois dias
			if ((cada.getFilme().getCodigoPreco() == Filme.LANCAMENTO)
					&& cada.getDiasAlugados() > 1)
				pontosLocadorFrequente++;

			// mostrar valores para esta loca��o

			resultado += "\t" + cada.getFilme().getTitulo() + "\t"
					+ String.valueOf(estaQuantia) + "\n";
			quantiaTotal += estaQuantia;

		}

		// adicionar linhas de rodap�
		resultado += "O valor devido � " + String.valueOf(quantiaTotal) + "\n";
		resultado += "Voc� ganhou " + String.valueOf(pontosLocadorFrequente)
				+ " pontos de locador freq�ente";
		return resultado;
	}

}
