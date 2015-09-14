package br.gov.ufpa.easoftware.refatoracao.atividadeii;

import br.ufpa.easoft.refact.fatura.Fatura_A_Pagar;
import org.junit.Test;
import static org.junit.Assert.*;

public class Fatura_A_PagarTest {
    
    public Fatura_A_PagarTest() {
    }
    
    @Test
    public void deveCalcularValorAPagarCom222DiasDeAtrasoComJurosDe10PorCento() {
        System.out.println("Calcula Valor a pagar de 222 dias de atraso com 10% Juros do valor 10.0");
        Fatura_A_Pagar aPagar = new Fatura_A_Pagar();
        
        double valorDaFatura = 10.0;
        double juros = 0.1;
        double esperado = 21.0;
        double recebido = aPagar.calcularValorConta(7, 1, 2015, juros, valorDaFatura);
        System.out.println("Esperado: "+esperado);
        System.out.println("Recebido: "+recebido );
        assertEquals(esperado, recebido, 0);
    }
    
    @Test
    public void deveCalcularValorAPagarSemAtrasoComJurosDe5PorCento() {
        System.out.println("Calcula Valor a pagar sem atraso com 5% Juros do valor 100.0");
        Fatura_A_Pagar aPagar = new Fatura_A_Pagar();
        
        double valorDaFatura = 100.0;
        double juros = 0.05;
        double esperado = 107.0;
        double recebido = aPagar.calcularValorConta(17, 8, 2015, juros, valorDaFatura);
        System.out.println("Esperado: "+esperado);
        System.out.println("Recebido: "+recebido );
        assertEquals(esperado, recebido, 0);
    }

    @Test
    public void deveCalcularValorAPagarCom10DiasDeAtrasoComJurosDe1PorCento() {
        System.out.println("Calcula Valor a pagar de 10 dias de atraso com 1% Juros do valor 1000.0");
        Fatura_A_Pagar aPagar = new Fatura_A_Pagar();
        
        double valorDaFatura = 1000.0;
        double juros = 0.01;
        double esperado = 1015.0;
        double recebido = aPagar.calcularValorConta(7, 8, 2015, juros, valorDaFatura);
        System.out.println("Esperado: "+esperado);
        System.out.println("Recebido: "+recebido );
        assertEquals(esperado, recebido, 0);
    }

    @Test
    public void deveCalcularValorAPagarCom4DiasDeAtrasoComJurosDe5PorCento() {
        System.out.println("Calcula Valor a pagar de 4 dias de atraso com 5% Juros do valor 9900.0");
        Fatura_A_Pagar aPagar = new Fatura_A_Pagar();
        
        double valorDaFatura = 9900.0;
        double juros = 0.05;
        double esperado = 10397.0;
        double recebido = aPagar.calcularValorConta(13, 8, 2015, juros, valorDaFatura);
        System.out.println("Esperado: "+esperado);
        System.out.println("Recebido: "+recebido );
        assertEquals(esperado, recebido, 0);
    }
    
}
