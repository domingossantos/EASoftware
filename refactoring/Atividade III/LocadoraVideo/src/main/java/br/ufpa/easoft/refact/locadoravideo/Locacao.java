package br.ufpa.easoft.refact.locadoravideo;

public class Locacao {
	private Filme _filme;
	private int _diasAlugados;
	
	public Locacao (Filme filme, int diasAlugados)
	{
		_filme = filme;
		_diasAlugados = diasAlugados;
	}
	
	public int getDiasAlugados()
	{
		return _diasAlugados;
	}
	
	public Filme getFilme()
	{
		return _filme;
	}
}
