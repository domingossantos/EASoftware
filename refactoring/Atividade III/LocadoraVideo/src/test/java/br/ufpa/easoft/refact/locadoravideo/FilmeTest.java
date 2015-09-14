package br.ufpa.easoft.refact.locadoravideo;
import junit.framework.TestCase;
/*
 * Created on 13/07/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

public class FilmeTest extends TestCase {
	private Filme filme;
 
	protected void setUp() throws Exception {
		super.setUp();
		filme = new Filme("titulo teste", Filme.NORMAL);
	}

	public void testGetCodigoPreco() {
		assertEquals(Filme.NORMAL, filme.getCodigoPreco());
	}

	public void testSetCodigoPreco() {
		filme.setCodigoPreco(Filme.INFANTIL);
		assertEquals(Filme.INFANTIL, filme.getCodigoPreco());
		filme.setCodigoPreco(Filme.LANCAMENTO);
		assertEquals(Filme.LANCAMENTO, filme.getCodigoPreco());
		filme.setCodigoPreco(Filme.NORMAL);
		assertEquals(Filme.NORMAL, filme.getCodigoPreco());
	}

	public void testGetTitulo() { assertEquals("titulo teste", filme.getTitulo()); 	}
	
	public void testEquals() {
		Filme filme2 = new Filme("titulo teste", Filme.NORMAL);
		assertEquals(filme2, filme);
		filme2 = new Filme("titulo testando", Filme.NORMAL);
		assertFalse(filme.equals(filme2));
		filme2 = new Filme("titulo teste", Filme.LANCAMENTO);
		assertFalse(filme.equals(filme2));
	}
}
