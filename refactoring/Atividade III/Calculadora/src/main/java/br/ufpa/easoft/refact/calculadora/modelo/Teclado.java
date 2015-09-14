package br.ufpa.easoft.refact.calculadora.modelo;

import java.util.HashMap;
import java.util.Map;

public class Teclado {
    
    private Teclado teclado;
    private final Map<String, Tecla> teclas;

    public Teclado() {
        this.teclas = new HashMap<>();
    }

    public Teclado getTeclado() {
        return teclado;
    }

    public void setTeclado(Teclado teclado) {
        this.teclado = teclado;
    }

    public Map getTeclas() {
        return teclas;
    }

    public void addTecla(String key, Tecla tecla){
        teclas.put(key, tecla);
    }
    
}
