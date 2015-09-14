package br.ufpa.easoft.refact.calculadora.modelo;

import javax.swing.JLabel;

public class Visor extends JLabel{
    
    private int totalDigitos;
    private int casasDecimais;

    public Visor() {
    }

    public Visor(int totalDigitos, int casasDecimais) {
        this.totalDigitos = totalDigitos;
        this.casasDecimais = casasDecimais;
    }

    public int getTotalDigitos() {
        return totalDigitos;
    }

    public void setTotalDigitos(int totalDigitos) {
        this.totalDigitos = totalDigitos;
    }

    public int getCasasDecimais() {
        return casasDecimais;
    }

    public void setCasasDecimais(int casasDecimais) {
        this.casasDecimais = casasDecimais;
    }
    
}
