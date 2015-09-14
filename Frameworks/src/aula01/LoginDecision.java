package aula01;

/**
 * Created by domingossantos on 10/09/15.
 */
public class LoginDecision extends Login{
    @Override
    protected void error() {
        System.out.println("Falha da autenticação");
    }

    @Override
    Object autentica(String id, String senha) {

        if(id.equals("usuario") && senha.equals("passwd")){
            return new Token(true);
        } else {
            return new Token(false);
        }

    }

    @Override
    void sucesso(Object tokenDeAutenticacao) {
        System.out.println("Token Valido!");
    }


    public static void main (String[] args){

        Login login = new LoginDecision();

        login.login();


    }
}
