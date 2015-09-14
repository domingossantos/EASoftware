package br.ufpa.easoft.refact.contabanco;

public class Conta {
    private float limite;
    private float saldo;
    
    public Conta(float limite, float saldo) {
        this.limite = limite;
        this.saldo  = saldo;
    }

    public float getLimite() {
        return limite;
    }

    public float getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "Conta{" + "limite=" + limite + ", saldo=" + saldo + '}';
    }
    
	 
}
 
