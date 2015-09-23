package br.ufpa.tap2.util;

import br.ufpa.tap2.model.Marca;
import br.ufpa.tap2.model.Modelo;

import javax.faces.model.SelectItem;

/**
 * Created by gilson on 16/09/15.
 */
public class JSFUtil {

    public static SelectItem toSelectItem(Modelo modelo) {
        SelectItem selectItem = new SelectItem();
        selectItem.setValue(modelo);
        selectItem.setLabel(modelo.getDescricao());

        return selectItem;
    }

    public static SelectItem toSelectItem(Marca marca) {
        SelectItem selectItem = new SelectItem();
        selectItem.setValue(marca);
        selectItem.setLabel(marca.getNome());

        return selectItem;
    }
}