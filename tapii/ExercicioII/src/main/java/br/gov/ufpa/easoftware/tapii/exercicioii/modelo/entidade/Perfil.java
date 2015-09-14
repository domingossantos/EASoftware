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
@Table(name = "PERFIS")
public class Perfil implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String nome;
    private String descricao;

    public Perfil() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PERFIL", columnDefinition = "smallint not null")
    public Integer getId() {
        return id;
    }

    @Column(name = "NM_PERFIL", length = 40, nullable = false)
    public String getNome() {
        return nome;
    }

    @Column(name = "DS_PERFIL", length = 200, nullable = false)
    public String getDescricao() {
        return descricao;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricaoPerfil) {
        this.descricao = descricaoPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.id);
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
        final Perfil other = (Perfil) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Perfil{" + "id=" + id + ", nome=" + nome + '}';
    }
    
    
}
