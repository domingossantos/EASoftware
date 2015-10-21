/**
 * 
 */
package br.ufpa.easw;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ufpa.easw.Conta;
import br.ufpa.easw.mocks.ContaRepositorioMock;

/**
 * ContaTest2.java 
 * 
 * <p>A test using mock</p>
 * 
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 */
public class ContaTest2 {
	
	@Test
	public void testSacarValor() {
		Conta c = new Conta(new ContaRepositorioMock(), 10.0);
		assertEquals(5.0, c.sacar(5.0), 0);
	}

}

