package br.gov.ufpa.easoftware.tapii.exercicioii.modelo.entidade;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PAISES")
public class Pais implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String continente;
    private String nome;

    public Pais() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PAIS", columnDefinition = "smallint not null")
    public Integer getId() {
        return id;
    }

    @Column(name = "FL_CONTINENTE", length = 1, nullable = false)
    public String getContinente() {
        return continente;
    }

    @Column(name = "NM_PAIS", length = 40, nullable = false)
    public String getNome() {
        return nome;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Pais other = (Pais) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pais{" + "id=" + id + ", nome=" + nome + '}';
    }
}
