package br.gov.ufpa.easoftware.tapii.exercicioii.modelo.entidade;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CIDADES")
public class Cidade implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private Estado uf;
    private String nome;

    public Cidade() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CIDADE", columnDefinition = "smallint not null")
    public Integer getId() {
        return id;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "UF_ESTADO", referencedColumnName = "UF_ESTADO", nullable = false)
    public Estado getUf() {
        return uf;
    }

    @Column(name = "NM_CIDADE", length = 60, nullable = false)
    public String getNome() {
        return nome;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUf(Estado uf) {
        this.uf = uf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.uf);
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
        final Cidade other = (Cidade) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.uf, other.uf)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cidade{" + "id=" + id + ", uf=" + uf + ", nome=" + nome + '}';
    }
    
    
}
