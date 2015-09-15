package br.ufpa.tap2.dao.common;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by domingossantos on 14/09/15.
 */

public class EntityManagerFactory {
    @PersistenceContext(name = "tap2PU")
    private EntityManager manager;


    public EntityManagerFactory() {

    }

    @Produces @Default
    public EntityManager create(){
        return this.manager;
    }
}

