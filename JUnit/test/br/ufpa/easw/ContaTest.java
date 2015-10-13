package br.ufpa.easw;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.*;

/**
 * Created by domingossantos on 28/09/15.
 */
@Category(SlowTests.class)
public class ContaTest {

    private Conta conta;

    @Before
    public void setUp() throws Exception {
        this.conta = new Conta(10d);
    }

    @Test(expected = NullPointerException.class)
    public void testDepositarValorNulo() throws Exception {
        conta.depositar(new Double(null));
    }

    public void depositarValor(){
        conta.depositar(10d);
        assertEquals(10d, conta.verSaldo(), 20d);
    }

    @Test(expected = IllegalArgumentException.class)
    public void depositarValorNegativo(){
        conta.depositar(-10d);
    }





}