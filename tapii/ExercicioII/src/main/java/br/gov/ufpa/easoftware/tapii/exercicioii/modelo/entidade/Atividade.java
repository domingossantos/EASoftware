package br.gov.ufpa.easoftware.tapii.exercicioii.modelo.entidade;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ATIVIDADES")
public class Atividade implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String ativa;
    private String descricao;
    private List<Usuario> usuarios;

    public Atividade() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ATIDADE", columnDefinition = "smallint not null")
    public Integer getId() {
        return id;
    }

    @Column(name = "FL_ATIVA", length = 1, nullable = false)
    public String getAtiva() {
        return ativa;
    }

    @Column(name = "DS_ATIDADE", length = 40, nullable = false)
    public String getDescricao() {
        return descricao;
    }

    @ManyToMany
    @JoinTable(
            name = "ATIVIDADES_USUARIOS",
            joinColumns = @JoinColumn(name = "ID_ATIVIDADE", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "ID_USUARIO", nullable = false)
    )
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAtiva(String ativa) {
        this.ativa = ativa;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Atividade other = (Atividade) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Atividade{" + "id=" + id + ", descricao=" + descricao + '}';
    }
    
}
