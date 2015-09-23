package br.ufpa.tap2.bean;

import br.ufpa.tap2.dao.MarcaDAO;
import br.ufpa.tap2.dao.ModeloDAO;
import br.ufpa.tap2.model.Automovel;
import br.ufpa.tap2.model.Marca;
import br.ufpa.tap2.model.Modelo;
import br.ufpa.tap2.util.JSFUtil;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gilson on 15/09/15.
 */
@ManagedBean
@ViewScoped
public class BuscaBean {

    @Inject
    private MarcaDAO marcaDAO;

    @Inject
    private ModeloDAO modeloDAO;

    private Marca marcaSelecionada;
    private Modelo modeloSelecionado;

    private Integer anoFabricacao;
    private Integer anoModelo;

    private Double precoMinimo;
    private Double precoMaximo;

    private Double kilometragemMinima;
    private Double kilometragemMaxima;

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

    public String buscar() {
        Automovel automovel = new Automovel();
        return null;
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

    public Double getPrecoMinimo() {
        return precoMinimo;
    }

    public void setPrecoMinimo(Double precoMinimo) {
        this.precoMinimo = precoMinimo;
    }

    public Double getPrecoMaximo() {
        return precoMaximo;
    }

    public void setPrecoMaximo(Double precoMaximo) {
        this.precoMaximo = precoMaximo;
    }

    public Double getKilometragemMinima() {
        return kilometragemMinima;
    }

    public void setKilometragemMinima(Double kilometragemMinima) {
        this.kilometragemMinima = kilometragemMinima;
    }

    public Double getKilometragemMaxima() {
        return kilometragemMaxima;
    }

    public void setKilometragemMaxima(Double kilometragemMaxima) {
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
