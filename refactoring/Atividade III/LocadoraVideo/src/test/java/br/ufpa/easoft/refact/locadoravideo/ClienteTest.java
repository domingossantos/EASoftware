package br.ufpa.easoft.refact.locadoravideo;
import junit.framework.TestCase;
/*
 * Created on 13/07/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

public class ClienteTest extends TestCase {
	private Cliente cliente;
	
	protected void setUp() throws Exception {
		super.setUp();
		cliente = new Cliente("cliente teste");
	}

	public void testConta() {
		String resultado = cliente.conta();
		assertEquals(
			"Registro de locação de cliente teste\nO valor devido é 0.0\nVocê ganhou 0 pontos de locador freqüente"
			, resultado);
		
		Filme filme1 = new Filme("filme1", Filme.NORMAL);
		Filme filme2 = new Filme("filme2", Filme.INFANTIL);
		Filme filme3 = new Filme("filme3", Filme.LANCAMENTO);
		
		cliente.adicionarLocacao(new Locacao(filme1, 1));
		cliente.adicionarLocacao(new Locacao(filme2, 5));
		cliente.adicionarLocacao(new Locacao(filme3, 3));
		// filmes normais com mais de 2 dias e filmes infantis com menos que 3
		cliente.adicionarLocacao(new Locacao(filme1, 6));
		cliente.adicionarLocacao(new Locacao(filme2, 2));
		
		resultado = cliente.conta();
		
		assertEquals(
			"Registro de locação de cliente teste\n\tfilme1\t2.0\n\tfilme2\t4.5\n\tfilme3" +
			"	9.0\n\tfilme1\t8.0\n\tfilme2\t1.5\nO valor devido é 25.0\n" +
			"Você ganhou 6 pontos de locador freqüente"
				, resultado);
	}
	
	public void testGetNome() {
		assertEquals("cliente teste", cliente.getNome());
	}

}