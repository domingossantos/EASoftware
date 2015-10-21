/**
 * 
 */
package br.ufpa.easw;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.ufpa.easw.Conta;
import br.ufpa.easw.ContaRepositorio;

/**
 * ContaTest5.java 
 * 
 * <p>Another example of Mockito</p>
 * 
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 */
@RunWith(MockitoJUnitRunner.class)
public class ContaTest6 {
	
	@Mock
	private ContaRepositorio dao;

	/**
	 * Test method for {@link br.ufpa.easw.Conta#sacar(double)}.
	 */
	@Test
	public void testChamarMetodo() {
		
		Conta c = new Conta(dao, 10.0);
		c.sacar(5.0);
		
		// Verify is the atualizarSaldo was called
		Mockito.verify(dao).atualizarSaldo(c);

		// Verify is the atualizarSaldo was called with theses values
		Mockito.verify(dao).atualizarSaldo(Matchers.eq( c ) );
		
		// Verify is the atualizarSaldo was called once
		Mockito.verify(dao, Mockito.times(1)).atualizarSaldo(c);
		
	}

}
