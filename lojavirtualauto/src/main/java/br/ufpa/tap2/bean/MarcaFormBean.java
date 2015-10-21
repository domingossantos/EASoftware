package br.ufpa.tap2.bean;

import br.ufpa.tap2.bean.common.PaginaBean;
import br.ufpa.tap2.dao.MarcaDAO;
import br.ufpa.tap2.model.Marca;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

/**
 * Created by domingossantos on 24/09/15.
 */
@ManagedBean
public class MarcaFormBean extends PaginaBean{

    @Inject
    private MarcaDAO marcaDAO;

    private Marca marca;

    @PostConstruct
    public void init(){
        marca = new Marca();
    }

    public void salvar(){
        marcaDAO.salvar(marca);
        addInfo("Registro Salvo");
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
