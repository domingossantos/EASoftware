package aula01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by domingossantos on 10/09/15.
 */
public abstract class Login {

    private String id;
    private String senha;

    public void login(){
        prompt();
        avisoVisual();
        Token toten = (Token) autentica(id,senha);

        if(toten.valido()){
            sucesso(toten);
        } else {
            error();
        }

     }

    protected abstract void error();

    private void avisoVisual() {
        System.out.println("AUTENTICANDO");
    }

    private void prompt() {
        System.out.println("Entre com seu ID");
        id = lerConsole();
        System.out.println("Entre com sua Senha");
        senha = lerConsole();

    }

    private String lerConsole() {
        String retorno = "";

        try{
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            retorno = bufferRead.readLine();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        return retorno;
    }

    abstract Object autentica(String id, String senha);

    abstract void sucesso(Object tokenDeAutenticacao);


}
