/**
 * 
 */
package br.ufpa.easw;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.ufpa.easw.Conta;
import br.ufpa.easw.ContaRepositorio;

/**
 * ContaTest4.java 
 * 
 * <p>Another example of Mockito</p>
 * 
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 */
@RunWith(MockitoJUnitRunner.class)
public class ContaTest4 {
	
	@Mock
	private ContaRepositorio repositorio;
	
	/* Data for the test */
	private List<Conta> contasPremium;
	
	@Before
	public void setUp(){
		contasPremium = new ArrayList<Conta>();
		contasPremium.add(new Conta(repositorio, 100000.0) );
		contasPremium.add(new Conta(repositorio, 200000.0) );
		contasPremium.add(new Conta(repositorio, 300000.0) );
		contasPremium.add(new Conta(repositorio, 400000.0) );
		contasPremium.add(new Conta(repositorio, 500000.0) );
	}

	/**
	 * Test method for {@link br.ufpa.easw.Conta#sacar(double)}.
	 */
	@Test
	public void testSacarValorContasPremium() {
		
		// Define a set of banks account to use in the test
		Mockito.when(repositorio.buscaPorSaldoMaiorQue(100000.0)).thenReturn(contasPremium);
		
		List<Conta> contasMock = repositorio.buscaPorSaldoMaiorQue(100000.0);
		
		for (Conta cMock : contasMock) {
			cMock.sacar(1000.0);
			Assert.assertTrue(cMock.temSaldo());
		}
		
	}
	
}
