package br.ufpa.tap2.rest;

import br.ufpa.tap2.dao.AutomovelDAO;
import br.ufpa.tap2.model.Automovel;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Created by gilson on 25/09/15.
 */
@Path("/image")
public class ImageRest {

    @Inject
    private AutomovelDAO automovelDAO;

    @GET
    @Path("/{id}.png")
    @Produces("image/png")
    public byte[] get(@PathParam("id") Integer id) {
        Automovel _automovel = automovelDAO.getUm(id, Automovel.class);
        return _automovel.getImagem();
    }
}
