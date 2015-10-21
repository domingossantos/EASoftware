package br.ufpa.easw;

import java.util.List;

/**
 * Conta.java 
 * 
 * <p>Represent a repository to persist a account</p>
 * 
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 */
public interface ContaRepositorio {
	
	public void atualizarSaldo(Conta c);
	
	public List<Conta> buscaPorSaldoMaiorQue(double saldo);

}
