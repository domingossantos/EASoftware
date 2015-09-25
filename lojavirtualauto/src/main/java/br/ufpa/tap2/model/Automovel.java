package br.ufpa.tap2.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by domingossantos on 14/09/15.
 */
@Entity
public class Automovel {

    private Integer id;
    private Integer anoFabricacao;
    private Integer anoModelo;
    private String observacao;
    private Float preco;
    private Integer kilometragem;
    private Modelo modelo;
    private byte[] imagem;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "ano_fabricacao")
    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    @Column(name = "ano_modelo")
    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Integer getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(Integer kilometragem) {
        this.kilometragem = kilometragem;
    }

    @Basic(fetch = FetchType.LAZY)
    @Type(type = "org.hibernate.type.BinaryType")
    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "modelo_id", referencedColumnName = "id")
    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
}
