package br.ufpa.tap2.dao;

import br.ufpa.tap2.dao.common.DAO;
import br.ufpa.tap2.model.Marca;
import br.ufpa.tap2.model.Modelo;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by domingossantos on 14/09/15.
 */
public class ModeloDAO extends DAO<Modelo> {

    public List<Modelo> listar(Marca marca) {
        if(marca == null) {
            return new ArrayList<>();
        }

        Query query = getEm().createQuery("select m from Modelo as m where m.marca.id = :marca");
        query.setParameter("marca", marca.getId());

        return query.getResultList();
    }
    //Teste
}
