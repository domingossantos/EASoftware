package br.ufpa.easoft.refact.contabanco;

import java.util.List;
import java.util.ArrayList;

public abstract class Cliente {
    private String nome;
    private List conta;

    public Cliente(String nome) {
        this.nome = nome;
        this.conta = new ArrayList();
    }

    public void adicionaConta(Conta conta) {
        this.conta.add(conta);
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", conta=" + conta + '}';
    }
    
}
