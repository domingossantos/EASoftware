package br.ufpa.tap2.bean;

import br.ufpa.tap2.model.Automovel;
import br.ufpa.tap2.model.Marca;
import br.ufpa.tap2.util.JSFUtil;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gilson on 15/09/15.
 */
@ManagedBean
public class BuscaBean {

    private Marca marcaSelecionada;
    private SelectItem modeloSelecionado;

    private Integer anoFabricacao;
    private Integer anoModelo;

    private Double precoMinimo;
    private Double precoMaximo;

    private Double kilometragemMinima;
    private Double kilometragemMaxima;

    private List<Automovel> automoveis;
    private List<SelectItem> marcas;
    private List<SelectItem> modelos;

    @PostConstruct
    public void init() {
        automoveis = new ArrayList<>();
        marcas = new ArrayList<>();
        modelos = new ArrayList<>();

        Marca marca = new Marca();
        marca.setId(1);
        marca.setNome("Fiat");

        marcas.add(JSFUtil.toSelectItem(marca));
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

    public SelectItem getModeloSelecionado() {
        return modeloSelecionado;
    }

    public void setModeloSelecionado(SelectItem modeloSelecionado) {
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

    public List<SelectItem> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<SelectItem> marcas) {
        this.marcas = marcas;
    }

    public List<SelectItem> getModelos() {
        return modelos;
    }

    public void setModelos(List<SelectItem> modelos) {
        this.modelos = modelos;
    }
}
