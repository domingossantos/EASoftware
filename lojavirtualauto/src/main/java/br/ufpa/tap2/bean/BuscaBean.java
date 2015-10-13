package br.ufpa.tap2.bean;

import br.ufpa.tap2.bean.common.PaginaBean;
import br.ufpa.tap2.dao.AutomovelDAO;
import br.ufpa.tap2.dao.MarcaDAO;
import br.ufpa.tap2.dao.ModeloDAO;
import br.ufpa.tap2.model.Automovel;
import br.ufpa.tap2.model.Marca;
import br.ufpa.tap2.model.Modelo;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.PhaseId;
import javax.inject.Inject;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gilson on 15/09/15.
 */
@ViewScoped
@ManagedBean
public class BuscaBean extends PaginaBean {

    @Inject
    private MarcaDAO marcaDAO;

    @Inject
    private ModeloDAO modeloDAO;

    @Inject
    private AutomovelDAO automovelDAO;

    private Marca marcaSelecionada;
    private Modelo modeloSelecionado;

    private Integer anoFabricacao;
    private Integer anoModelo;

    private Float precoMinimo;
    private Float precoMaximo;

    private Integer kilometragemMinima;
    private Integer kilometragemMaxima;

    private List<Automovel> automoveis;
    private List<Marca> marcas;
    private List<Modelo> modelos;

    @PostConstruct
    public void init() {
        automoveis = new ArrayList<>();
        marcas = new ArrayList<>();
        modelos = new ArrayList<>();
        marcas = marcaDAO.listar();
    }

    public void atualizarModelos(AjaxBehaviorEvent event) {
        modeloSelecionado = null;

        if(marcaSelecionada != null) {
            modelos = modeloDAO.listar(marcaSelecionada);
        } else {
            modelos = new ArrayList<>();
        }
    }

    public void buscar() {
        Automovel automovel = new Automovel();
        automovel.setModelo(modeloSelecionado);
        automovel.setAnoFabricacao(anoFabricacao);
        automovel.setAnoModelo(anoModelo);

        try {
            automoveis = automovelDAO.listaPorCaracteristica(automovel, precoMaximo, precoMinimo, kilometragemMaxima, kilometragemMinima);
        } catch (Exception e) {
            addWarn(e.getMessage());
        }
    }

    public String getImage(Integer id) throws IOException {
        return "/resources/image/" + id + ".png";
    }

    public Marca getMarcaSelecionada() {
        return marcaSelecionada;
    }

    public void setMarcaSelecionada(Marca marcaSelecionada) {
        this.marcaSelecionada = marcaSelecionada;
    }

    public Modelo getModeloSelecionado() {
        return modeloSelecionado;
    }

    public void setModeloSelecionado(Modelo modeloSelecionado) {
        this.modeloSelecionado = modeloSelecionado;
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

    public Float getPrecoMinimo() {
        return precoMinimo;
    }

    public void setPrecoMinimo(Float precoMinimo) {
        this.precoMinimo = precoMinimo;
    }

    public Float getPrecoMaximo() {
        return precoMaximo;
    }

    public void setPrecoMaximo(Float precoMaximo) {
        this.precoMaximo = precoMaximo;
    }

    public Integer getKilometragemMinima() {
        return kilometragemMinima;
    }

    public void setKilometragemMinima(Integer kilometragemMinima) {
        this.kilometragemMinima = kilometragemMinima;
    }

    public Integer getKilometragemMaxima() {
        return kilometragemMaxima;
    }

    public void setKilometragemMaxima(Integer kilometragemMaxima) {
        this.kilometragemMaxima = kilometragemMaxima;
    }

    public List<Automovel> getAutomoveis() {
        return automoveis;
    }

    public void setAutomoveis(List<Automovel> automoveis) {
        this.automoveis = automoveis;
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
}
