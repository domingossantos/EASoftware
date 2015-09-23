package br.ufpa.tap2.dao;

import br.ufpa.tap2.dao.common.DAO;
import br.ufpa.tap2.model.Marca;

import java.util.List;

/**
 * Created by domingossantos on 14/09/15.
 */
public class MarcaDAO extends DAO<Marca> {

    public List<Marca> listar() {
        return super.listar(Marca.class);
    }
}
