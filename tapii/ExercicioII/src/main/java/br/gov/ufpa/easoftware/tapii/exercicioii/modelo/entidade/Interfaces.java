package br.gov.ufpa.easoftware.tapii.exercicioii.modelo.entidade;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "INTERFACES")
public class Interfaces implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private Modulo modulo;
    private String descricao;
    private byte[] imagem;

    public Interfaces() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_INT")
    public Integer getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "ID_MODULO", referencedColumnName = "ID_MODULO", nullable = false)
    public Modulo getModulo() {
        return modulo;
    }

    @Column(name = "DS_INT", length = 300, nullable = false)
    public String getDescricao() {
        return descricao;
    }

    @Basic(fetch = FetchType.LAZY)
    @Lob @Column(name = "IM_INT", nullable = false)
    public byte[] getImagem() {
        return imagem;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Interfaces other = (Interfaces) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Interface{" + "id=" + id + ", modulo=" + modulo + ", descricao=" + descricao + '}';
    }

    
}
