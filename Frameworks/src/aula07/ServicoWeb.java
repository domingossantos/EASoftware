package aula07;

/**
 * Created by domingossantos on 13/10/15.
 */
public class ServicoWeb {

    public static Double calcularINSS(Double salario){
        return salario * 0.11;
    }

    public static Double calculaIR(Double salario){
        return (salario  - calcularINSS(salario) ) * 0.275;
    }

}
