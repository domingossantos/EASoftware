package aula07;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by domingossantos on 13/10/15.
 */
public class CalculaImposto {



    public static void main(String[] args){


        String retorno = "";
        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Digite seu salario");
            retorno = bufferRead.readLine();

            Double imposto = ServicoWeb.calcularimporto(Double.parseDouble(retorno));
            System.out.println("Valor do Importo é: "+imposto.toString());
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }


    }
}
