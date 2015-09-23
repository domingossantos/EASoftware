/**
 * 
 */
package br.ufpa.easw;

/**
 * Conta.java 
 * 
 * <p>Represent a bank account used as an example of simple class to test</p>
 * 
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 */
public class Conta {
	
	private Double saldo = 0.0d;
	
	public Conta(Double saldo){
		this.saldo = saldo;
	}
	
	public boolean temSaldo(){
		return saldo != null && saldo > 0;
	}
	
	public void sacar(double value){
		if(value <= 0 )
			throw new IllegalArgumentException("Invalid Value");
		saldo = saldo - value;
	}

	public void depositar(double valor){
		if(valor <= 0)
			throw  new IllegalArgumentException("Valor nulo ou negativo");

		saldo = saldo + valor;
	}

}




