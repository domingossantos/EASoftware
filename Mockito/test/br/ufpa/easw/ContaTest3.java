/**
 * 
 */
package br.ufpa.easw;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.ufpa.easw.Conta;
import br.ufpa.easw.ContaRepositorio;

/**
 * ContaTest3.java 
 * 
 * <p>A unit test using mockito framework</p>
 * 
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 */
@RunWith(MockitoJUnitRunner.class)
public class ContaTest3 {

	@Mock
	ContaRepositorio repositorio;
	
	/**
	 * Test method for {@link br.ufpa.easw.Conta#sacar(double)}.
	 */
	@Test
	public void testSacarValor() {
		Conta c = new Conta(repositorio, 10.0);
		assertEquals(5.0, c.sacar(5.0), 0);
	}

}

