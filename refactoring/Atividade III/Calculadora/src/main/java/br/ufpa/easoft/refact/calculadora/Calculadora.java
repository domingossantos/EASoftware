package br.ufpa.easoft.refact.calculadora;

import br.ufpa.easoft.refact.calculadora.visao.CalculadoraGUI;
import javax.swing.JFrame;

public class Calculadora {

    public static void main(String[] args) {
        CalculadoraGUI application = new CalculadoraGUI();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
