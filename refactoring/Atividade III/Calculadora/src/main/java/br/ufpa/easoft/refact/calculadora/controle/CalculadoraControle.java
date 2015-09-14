package br.ufpa.easoft.refact.calculadora.controle;

import br.ufpa.easoft.refact.calculadora.util.FuncoesUtil;

public class CalculadoraControle {
    
    private String valor = "";
    private String operador = "";
    private String valorAnterior = "";
    private int casasDecimais = 2;
    private double resultado = 0;

    public CalculadoraControle() {
    }

    public void clean(){
        this.valor = "0";
    }

    public void cleanAndEraser(){
        this.valor     = "0";
        this.resultado = 0;
    }
    
    public void soma(){
        this.resultado = this.resultado + Double.parseDouble(this.valor);
    }
    
    public void subtracao(){
        this.resultado = this.resultado - Double.parseDouble(this.valor);
    }
    
    public void multiplicacao(){
        this.resultado = this.resultado * Double.parseDouble(this.valor);
    }
    
    public void divisao(){
        this.resultado = this.resultado / Double.parseDouble(this.valor);
    }
    
    public void percentualMult(){
//        calc.setResultado(calc.getResultado() * (Double.parseDouble(calc.getValor()) / 100));
        this.resultado = this.resultado * (Double.parseDouble(this.valor) / 100);
    }
    
    public void percentualDiv(){
        this.resultado = this.resultado / (Double.parseDouble(this.valor) / 100);
    }
    
    public String obterValorFormatado(){
        return FuncoesUtil.formatStrNumerica(valor, casasDecimais);
    }
    
    public String obterResultadoFormatado(){
        return FuncoesUtil.formatStrNumerica(""+resultado, casasDecimais);
    }
    
    //Getters and Setteres
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getValorAnterior() {
        return valorAnterior;
    }

    public void setValorAnterior(String valorAnterior) {
        this.valorAnterior = valorAnterior;
    }

    public int getCasasDecimais() {
        return casasDecimais;
    }

    public void setCasasDecimais(int casasDecimais) {
        this.casasDecimais = casasDecimais;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
    
}
