package br.ufpa.tap2.bean;

import br.ufpa.tap2.bean.common.PaginaBean;
import br.ufpa.tap2.dao.AutomovelDAO;
import br.ufpa.tap2.dao.MarcaDAO;
import br.ufpa.tap2.dao.ModeloDAO;
import br.ufpa.tap2.model.Automovel;
import br.ufpa.tap2.model.Marca;
import br.ufpa.tap2.model.Modelo;
import org.apache.commons.io.IOUtils;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.Part;
import java.io.InputStream;
import java.util.List;

/**
 * Created by domingossantos on 24/09/15.
 */
@ManagedBean
@ViewScoped
public class AutomovelFormBean extends PaginaBean {

    @Inject
    private AutomovelDAO automovelDAO;

    @Inject
    private MarcaDAO marcaDAO;

    @Inject
    private ModeloDAO modeloDAO;

    private Automovel automovel;

    private List<Marca> marcas;

    private List<Modelo> modelos;

    private Marca marcaSelecionada;

    private Part foto;

    @PostConstruct
    public void init(){
        automovel = new Automovel();
        marcas = marcaDAO.listar(Marca.class);
        modelos = modeloDAO.listar(Modelo.class);
        marcaSelecionada = marcas.get(0);
    }

    public void listaMarcas(){
        modelos = modeloDAO.listar(marcaSelecionada);
    }

    public void salvar(){
        try {
            InputStream is = foto.getInputStream();
            byte[] dados = IOUtils.toByteArray(is);
            automovel.setImagem(dados);

            automovelDAO.salvar(automovel);
            addInfo("Registro Salvo!");
        }
        catch (Exception ex){
            ex.printStackTrace();
           addWarn("Erro ao salvar registro");
        }
    }

    public Automovel getAutomovel() {
        return automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

    public List<Marca> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<Marca> marcas) {
        this.marcas = marcas;
    }

    public List<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }

    public Marca getMarcaSelecionada() {
        return marcaSelecionada;
    }

    public void setMarcaSelecionada(Marca marcaSelecionada) {
        this.marcaSelecionada = marcaSelecionada;
    }

    public Part getFoto() {
        return foto;
    }

    public void setFoto(Part foto) {
        this.foto = foto;
    }
}
