package br.ufpa.easw;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ufpa.easw.Conta;
import br.ufpa.easw.ContaDAO;

/**
 * ContaTest1.java 
 * 
 * <p>Test of a Bank Accout class without Mock</p>
 * 
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 */
public class ContaTest1 {

	@Test
	public void testSacarValor() {
		Conta c = new Conta(new ContaDAO(), 10.0);
		assertEquals(5.0, c.sacar(5.0), 0);
	}

}


