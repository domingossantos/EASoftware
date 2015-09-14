package br.ufpa.easoft.refact.calculadora.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class FuncoesUtil {

    public static String alinhaStringDir(String valor) {
        String alinhador = "";
        for (int i = 0; i < (36 - valor.length()); i++) {
            alinhador += " ";
        }
        return alinhador + valor;
    }

    public static String formatStrNumerica(String valor, int digito) {
        DecimalFormat decimal = new DecimalFormat();
        decimal.setMinimumFractionDigits(digito);
        
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setGroupingSeparator('.');
        simbolos.setDecimalSeparator(',');
        decimal.setDecimalFormatSymbols(simbolos);
        
        return decimal.format(new BigDecimal(valor));
    }
    
}
