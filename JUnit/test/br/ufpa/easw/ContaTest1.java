/**
 * 
 */
package br.ufpa.easw;

import br.ufpa.easw.Conta;

/**
 * Conta1Test.java 
 * 
 * <p>A example of simple Unit Test without any framework</p>
 * 
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 */
public class ContaTest1 {

	public void testaContaComSaldo() {
		Conta c = new Conta(10.0);
		if(c.temSaldo())
			System.out.println("OK");
		else
			System.out.println("Erro");
	}
	
	public void testaContaSemSaldo() {
		Conta c = new Conta(0.0);
		if(c.temSaldo())
			System.out.println("Erro");
		else
			System.out.println("OK");
	}

	public void testaContaComSaldoNulo() {
		Conta c = new Conta(null);
		if (c.temSaldo())
			System.out.println("Erro");
		else
			System.out.println("OK");
	}
	
	public static void main(String[] args) {
		new ContaTest1().testaContaComSaldo();
		new ContaTest1().testaContaSemSaldo();
		new ContaTest1().testaContaComSaldoNulo();
	}
}
