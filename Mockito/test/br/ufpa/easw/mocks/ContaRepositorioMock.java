/**
 * 
 */
package br.ufpa.easw.mocks;

import java.util.ArrayList;
import java.util.List;

import br.ufpa.easw.Conta;
import br.ufpa.easw.ContaRepositorio;

/**
 * ContaRepositorioMock.java 
 * 
 * <p>A mock class</p>
 * 
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 */
public class ContaRepositorioMock implements ContaRepositorio {

	/**
	 * @see br.ufpa.easw.ContaRepositorio#atualizarSaldo(br.ufpa.easw.Conta)
	 */
	@Override
	public void atualizarSaldo(Conta c) {
		// do nothing
	}

	@Override
	public List<Conta> buscaPorSaldoMaiorQue(double saldo) {
		return new ArrayList<Conta>();
	}

}
