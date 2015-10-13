package br.ufpa.easw;

import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;

import br.ufpa.easw.Conta;

@Category(SlowTests.class)
public class ContaTest3 {

	@Test(expected=IllegalArgumentException.class)
	public void testSacarValorNegativo() {
		Conta c = new Conta(10.0);
		c.sacar(-1.0);
	}
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testSacarValorNegativo2() {

		Conta c = new Conta(10.0);
		c.sacar(-1.0);
	}

}
