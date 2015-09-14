package br.ufpa.easoft.refact.calculadora.modelo;

import javax.swing.JButton;

public abstract class TeclaNumerica extends JButton implements Tecla{
    
    public abstract String getNumero();
    
}
