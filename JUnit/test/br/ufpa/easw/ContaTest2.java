package br.ufpa.easw;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import br.ufpa.easw.Conta;

/**
 * ContaTest2.java 
 * 
 * <p>Test of a Bank Accout class with Junit Framework</p>
 * 
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 */
@Category(FastTests.class)
public class ContaTest2 {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testaContaComSaldo() {
		Conta c = new Conta(10.0);
		assertTrue(c.temSaldo());
	}
	
	@Test
	public void testaContaSemSaldo() {
		Conta c = new Conta(0.0);
		assertFalse(c.temSaldo());
	}

	@Test
	public void testaContaComSaldoNulo() {
		Conta c = new Conta(null);
		assertFalse(c.temSaldo());
	}
}
