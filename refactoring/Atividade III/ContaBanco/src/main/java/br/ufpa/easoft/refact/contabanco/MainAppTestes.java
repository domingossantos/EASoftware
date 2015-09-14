package br.ufpa.easoft.refact.contabanco;

/**
 * Teste o codigo do projeto aqui.
 */
public class MainAppTestes {
     public static void main(String[] args) {
         // cria um cliente conta salario
         Cliente cli1 = new ContaSalario("JOAO SANTOS") ;
         Conta contCli1 = new Conta(0, 100F);
         cli1.adicionaConta(contCli1);
         System.out.println(cli1.toString());
         
         // cria um cliente conta especial
         Cliente cliEsp1 = new Especial("EIKE BATISTA") ;
         cliEsp1.adicionaConta( new Conta(2000, 10000F));
         cliEsp1.adicionaConta( new Conta(1000, 44000F));
         cliEsp1.adicionaConta( new Conta(12000, 34000F));
         System.out.println(cliEsp1.toString());
    }
}
