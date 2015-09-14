package br.ufpa.easoft.refact.locadoravideo;
import junit.framework.TestCase;
/*
 * Created on 13/07/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

public class LocacaoTest extends TestCase {
	private Locacao locacao;
	
	protected void setUp() throws Exception {
		super.setUp();
		locacao = new Locacao(new Filme("titulo teste", Filme.NORMAL), 5);		
	}

	public void testGetDiasAlugados() {
		assertEquals(5, locacao.getDiasAlugados());
	}

	public void testGetFilme() {
		Filme filme = new Filme("titulo teste", Filme.NORMAL);
		assertEquals(filme, locacao.getFilme());
	}
}
