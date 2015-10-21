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
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.ufpa.easw.Conta;
import br.ufpa.easw.ContaDAO;

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
public class ContaTest5 {
	
	private ContaDAO dao;
	
	/* Data for the test */
	private List<Conta> contas;
	
	@Before
	public void setUp(){
		contas = new ArrayList<Conta>();
		contas.add(new Conta(dao, 100000.0) );
		contas.add(new Conta(dao, 100000.0) );
		contas.add(new Conta(dao, 100000.0) );
		contas.add(new Conta(dao, 100000.0) );
		contas.add(new Conta(dao, 100000.0) );
	}

	/**
	 * Test method for {@link br.ufpa.easw.Conta#sacar(double)}.
	 */
	@Test(expected = NullPointerException.class)
	public void testSacarValorContasPremium() {
		
		// Create partial Mock //
		dao = Mockito.spy(new ContaDAO());
		
		// Define a set of banks account to use in the test
		Mockito.when(dao.buscaPorSaldoMaiorQue(100000.0)).thenReturn(contas);
		
		// The private method getConnection() continues to be called, So we will have a error //
		List<Conta> contasMock = dao.buscaPorSaldoMaiorQue(100000.0);
		
		for (Conta cMock : contasMock) {
			cMock.sacar(1000.0);
			Assert.assertTrue(cMock.temSaldo());
		}
		
	}

}
