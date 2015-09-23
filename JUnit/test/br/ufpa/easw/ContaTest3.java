package br.ufpa.easw;

import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;

import br.ufpa.easw.Conta;

/**
 * ContaTest3.java 
 * 
 * <p>Test of a Bank Accout class with Junit Framework</p>
 * 
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 */
@Category(SlowTests.class)
public class ContaTest3 {

	@Test(expected=IllegalArgumentException.class)
	public void testSacarValorNegativo() {
		Conta c = new Conta(10.0);
		c.sacar(-1.0);
	}
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	
	@Test
	public void testSacarValorNegativo2() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Invalid Value");
		
		Conta c = new Conta(10.0);
		c.sacar(-1.0);
	}

}
