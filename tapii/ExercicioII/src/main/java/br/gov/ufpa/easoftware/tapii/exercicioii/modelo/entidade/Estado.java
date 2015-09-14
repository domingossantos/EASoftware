package br.gov.ufpa.easoftware.tapii.exercicioii.modelo.entidade;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ESTADOS")
public class Estado implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String uf;
    private String descricao;

    public Estado() {
    }

    @Id
    @Column(name = "UF_ESTADO", columnDefinition = "char(2)")
    public String getUf() {
        return uf;
    }

    @Column(name = "DS_ESTADO", length = 40, nullable = false)
    public String getDescricao() {
        return descricao;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.uf);
        hash = 61 * hash + Objects.hashCode(this.descricao);
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
        final Estado other = (Estado) obj;
        if (!Objects.equals(this.uf, other.uf)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Estado{" + "uf=" + uf + ", descricao=" + descricao + '}';
    }

    
    
}
