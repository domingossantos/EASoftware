package br.ufpa.tap2.bean;

import br.ufpa.tap2.dao.AutomovelDAO;
import br.ufpa.tap2.dao.MarcaDAO;
import br.ufpa.tap2.dao.ModeloDAO;
import br.ufpa.tap2.model.Automovel;
import br.ufpa.tap2.model.Marca;
import br.ufpa.tap2.model.Modelo;
import br.ufpa.tap2.model.common.PaginaBean;
import org.apache.commons.io.IOUtils;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.Part;
import java.io.InputStream;
import java.util.List;

/**
 * Created by domingossantos on 23/09/15.
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

    private Part imagemCarro;

    private Marca marcaSelect;

    private List<Marca> marcas;

    private List<Modelo> modelos;

    private Automovel automovel;

    private Modelo modeloForm;

    private Integer anoFabricacao;

    private Integer anoModelo;



    @PostConstruct
    public void init(){
        automovel = new Automovel();
        marcas = marcaDAO.listar(Marca.class);
        modelos = modeloDAO.listar(marcas.get(0));
        marcaSelect = new Marca();
    }

    public void listaModeloPorMarca(){
        if(marcaSelect ==null){
            marcaSelect = marcas.get(0);
        }

        modelos = modeloDAO.listar(marcaSelect);
    }

    public String salvar(){

        try {
            InputStream is = imagemCarro.getInputStream();

            byte[] dados = IOUtils.toByteArray(is);

            automovel.setImagem(dados);

            automovel.setModelo(modeloForm);
            automovel.setAnoFabricacao(anoFabricacao);
            automovel.setAnoModelo(anoModelo);

            automovelDAO.salvar(this.automovel);

            init();

            addInfo("Registro salvo.");
        } catch (Exception ex){
            addWarn(ex.getMessage());
        } finally {
            return null;
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

    public Marca getMarcaSelect() {
        return marcaSelect;
    }

    public void setMarcaSelect(Marca marcaSelect) {
        this.marcaSelect = marcaSelect;
    }

    public Part getImagemCarro() {
        return imagemCarro;
    }

    public void setImagemCarro(Part imagemCarro) {
        this.imagemCarro = imagemCarro;
    }


    public Modelo getModeloForm() {
        return modeloForm;
    }

    public void setModeloForm(Modelo modeloForm) {
        this.modeloForm = modeloForm;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }
}
