package aula01;

/**
 * Created by domingossantos on 10/09/15.
 */
public class Token {

    Boolean validade;

    public Token(Boolean validade) {
        this.validade = validade;
    }

    public Boolean valido(){
        return validade;
    }
}
