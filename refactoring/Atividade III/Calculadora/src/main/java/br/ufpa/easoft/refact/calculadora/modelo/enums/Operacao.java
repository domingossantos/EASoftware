package br.ufpa.easoft.refact.calculadora.modelo.enums;

public enum Operacao {
    OP_SOMA("+"), 
    OP_SUBTRACAO("-"), 
    OP_MULTPLICACAO("*"), 
    OP_DIVISAO("/"), 
    OP_PERCENTE("%"), 
    OP_C("C"), 
    OP_CE("CE");
    
    private String operacao;

    private Operacao(String operacao) {
        this.operacao = operacao;
    }

    public String getOperacao() {
        return operacao;
    }
    
}
