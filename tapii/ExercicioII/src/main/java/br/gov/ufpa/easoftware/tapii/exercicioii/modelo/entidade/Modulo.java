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
@Table(name = "MODULOS")
public class Modulo implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String sigla;
    private String nome;

    public Modulo() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MODULO", columnDefinition = "smallint not null")
    public Integer getId() {
        return id;
    }

    @Column(name = "NM_SIGLA", length = 4, nullable = false, unique = true)
    public String getSigla() {
        return sigla;
    }

    @Column(name = "NM_MODULO", length = 40, nullable = false)
    public String getNome() {
        return nome;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Modulo other = (Modulo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modulo{" + "id=" + id + ", sigla=" + sigla + '}';
    }
    
    
}
