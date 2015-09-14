package br.ufpa.easoft.refact.fatura;


import java.util.Calendar;
import java.util.Date;

public class Fatura_A_Pagar {

    double _valorConta;
    double _juros;
    Date _dataVencimento;

    public double calcularValorConta(int diaVenc, int mesVenc, int anoVenc, 
            double juros, double valorConta) {
        this._juros = juros;
        this._valorConta = valorConta;
        this._dataVencimento = new Date(anoVenc, mesVenc - 1, diaVenc);

        // calcula o número de dias do vencimento até a data corrente
        Calendar dataVencimento = Calendar.getInstance();
        Calendar dataCorrente = Calendar.getInstance();
        dataVencimento.set(anoVenc, mesVenc - 1, diaVenc);
        dataCorrente.setTime(new Date());

        float emAtraso = this.calculaAtraso(dataVencimento);

        // determinar o valor da conta
        int numeroDeDiasEmAtraso = (int) emAtraso;
        double valorAcrescimoPorAtraso = 0;
        if (numeroDeDiasEmAtraso > 10) {
            valorAcrescimoPorAtraso = 10.00;
        } else if (numeroDeDiasEmAtraso >= 5 && numeroDeDiasEmAtraso <= 10) {
            valorAcrescimoPorAtraso = 5.00;
        } else {
            valorAcrescimoPorAtraso = 2.00;
        }
        double valoTotalConta = this._valorConta + (this._valorConta * this._juros)
                + valorAcrescimoPorAtraso;

        // double valoTotalConta = calculaAtraso((int) emAtraso);
        return (valoTotalConta);
    }  // fim do método
    
    private int calculaAtraso(Calendar dataVencimento){
        return (int) (Calendar.getInstance().getTime().getTime() - dataVencimento.getTime().getTime()) / (24 * 3600 * 1000);
    }
} // fim da classe
