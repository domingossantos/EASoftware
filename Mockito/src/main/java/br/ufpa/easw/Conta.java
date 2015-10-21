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
	
	private ContaRepositorio repositorio;
	
	public Conta(Double saldo){
		this.saldo = saldo;
	}
	
	public Conta(ContaRepositorio repositorio, Double saldo){
		this(saldo);
		this.repositorio = repositorio;
	}
	
	public boolean temSaldo(){
		return saldo != null && saldo > 0;
	}
	
	public double sacar(double value) {
		try {
			if (value <= 0)
				throw new IllegalArgumentException("Invalid Value");


			if(value >= saldo ){
				throw  new IllegalArgumentException("Valor maior que o saldo");
			}

			saldo = saldo - value;
			repositorio.atualizarSaldo(this);
			return saldo;
		} catch (NullPointerException e){
			throw new NullPointerException("Valor não pode ser nulo");
		}
	}

	public double getSaldo() {
		return saldo;
	}
}
