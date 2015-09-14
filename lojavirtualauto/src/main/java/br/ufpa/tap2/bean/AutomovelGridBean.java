package br.ufpa.tap2.bean;

import br.ufpa.tap2.dao.AutomovelDAO;
import br.ufpa.tap2.model.Automovel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.List;

/**
 * Created by domingossantos on 14/09/15.
 */
@ManagedBean
public class AutomovelGridBean {

    private AutomovelDAO automovelDAO;

    private List<Automovel> automoveis;

    @PostConstruct
    public void init(){
        automoveis = automovelDAO.listar(Automovel.class);
    }

    public List<Automovel> getAutomoveis() {
        return automoveis;
    }

    public void setAutomoveis(List<Automovel> automoveis) {
        this.automoveis = automoveis;
    }
}
