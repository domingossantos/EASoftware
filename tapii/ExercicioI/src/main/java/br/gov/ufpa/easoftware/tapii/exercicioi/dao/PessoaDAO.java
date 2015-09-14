package br.gov.ufpa.easoftware.tapii.exercicioi.dao;

import br.gov.ufpa.easoftware.tapii.exercicioi.dominio.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author correa
 */
public class PessoaDAO {
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("rhPU");
    private EntityManager manager;

    public PessoaDAO() {
        manager = emf.createEntityManager();
    }
    
    public boolean create(Pessoa pessoa){
        try{
            manager.getTransaction().begin();
            manager.persist(pessoa);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e){
            manager.getTransaction().rollback();
            e.getStackTrace();
            return false;
        }
    }
    
    public boolean update(Pessoa pessoa){
        try{
            manager.getTransaction().begin();
            manager.merge(pessoa);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e){
            manager.getTransaction().rollback();
            e.getStackTrace();
            return false;
        }
    }
    
    public boolean delete(Pessoa pessoa){
        try{
            pessoa = manager.find(Pessoa.class, pessoa.getId());
            manager.getTransaction().begin();
            manager.remove(pessoa);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e){
            manager.getTransaction().rollback();
            e.getStackTrace();
            return false;
        }
    }
    
    public Pessoa findById(long id){
        try{
            return manager.find(Pessoa.class, id);
        } catch (Exception e){
            manager.getTransaction().rollback();
            e.getStackTrace();
            return null;
        }
    }
    
    public List<Pessoa> findAll(){
        final Query qry = manager
                .createQuery("from Pessoa p", Pessoa.class);
        try{
            return qry.getResultList();
        } catch (Exception e){
            e.getStackTrace();
            return null;
        }
    }
    
    
    
}
