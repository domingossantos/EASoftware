package br.gov.ufpa.easoftware.tapii.exercicioii.modelo.entidade;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PERMISSOES_PERFIS")
public class PermissaoPerfil implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private PermissaoPerfilPK permissaoPerfilPK;
    private Boolean manutencao;
    private Boolean filtro;
    private Boolean log;

    public PermissaoPerfil() {
    }

    @EmbeddedId
    public PermissaoPerfilPK getPermissaoPerfilPK() {
        return permissaoPerfilPK;
    }

    @Column(name = "FL_MANUT", nullable = false)
    public Boolean getManutencao() {
        return manutencao;
    }

    @Column(name = "FL_FILTRO", nullable = false)
    public Boolean getFiltro() {
        return filtro;
    }

    @Column(name = "FL_LOG", nullable = false)
    public Boolean getLog() {
        return log;
    }

    public void setPermissaoPerfilPK(PermissaoPerfilPK permissaoPerfilPK) {
        this.permissaoPerfilPK = permissaoPerfilPK;
    }

    public void setManutencao(Boolean manutencao) {
        this.manutencao = manutencao;
    }

    public void setFiltro(Boolean filtro) {
        this.filtro = filtro;
    }

    public void setLog(Boolean log) {
        this.log = log;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.permissaoPerfilPK);
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
        final PermissaoPerfil other = (PermissaoPerfil) obj;
        if (!Objects.equals(this.permissaoPerfilPK, other.permissaoPerfilPK)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PermissaoPerfil{" + "permissaoPerfilPK=" + permissaoPerfilPK + ", manutencao=" + manutencao + ", filtro=" + filtro + ", log=" + log + '}';
    }

}
