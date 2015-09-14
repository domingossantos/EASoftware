package br.gov.ufpa.easoftware.tapii.exercicioi.principal;

import br.gov.ufpa.easoftware.tapii.exercicioi.dao.PessoaDAO;
import br.gov.ufpa.easoftware.tapii.exercicioi.dominio.Pessoa;
import java.util.List;

public class Principal {
    
    public static void main(String[] args) {
        PessoaDAO dao = new PessoaDAO();
        
        //Cria Entidade Pessoa no Banco
        Pessoa cPessoa = new Pessoa("Fulano", "fulano@mail.com");
        dao.create(cPessoa);
        
        //Lista todos as entidade do banco
        List<Pessoa> lista = dao.findAll();
        
        for (Pessoa p : lista) {
            System.out.println("Nome: "+p.getNome());
            System.out.println("E-mail: "+p.getEmail());
        }
        
        //Busca Entidade Pessoa no Banco
        Pessoa bPessoa = dao.findById(1L);
        
        //Edita Entidade Pessoa
        bPessoa.setNome("Fulano Editado");
        
        //Deleta Entidade Pessoa do banco
        dao.delete(bPessoa);
        
        System.exit(0);
    }
    
}
