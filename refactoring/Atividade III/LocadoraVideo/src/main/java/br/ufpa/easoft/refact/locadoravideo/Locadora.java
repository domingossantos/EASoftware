package br.ufpa.easoft.refact.locadoravideo;

public class Locadora {
	  public static void main(String[] args) {
	    Cliente c1 = new Cliente("Juliana");

	    c1.adicionarLocacao(new Locacao(new Filme("O Exorcista                   ", Filme.NORMAL), 3));
	    c1.adicionarLocacao(new Locacao(new Filme("Men in Black                  ", Filme.NORMAL), 2));
	    c1.adicionarLocacao(new Locacao(new Filme("Jurassic Park III             ", Filme.LANCAMENTO), 3));
	    c1.adicionarLocacao(new Locacao(new Filme("Planeta dos Macacos           ", Filme.LANCAMENTO), 4));
	    c1.adicionarLocacao(new Locacao(new Filme("Pateta no Planeta dos Macacos ", Filme.INFANTIL), 10));
	    c1.adicionarLocacao(new Locacao(new Filme("O Rei Leao                    ", Filme.INFANTIL), 30));

	    System.out.println(c1.conta());
	  }
	}
