package br.gov.ufpa.easoftware.tapii.exercicioii.modelo.entidade;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class PermissaoPerfilPK implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Interfaces interfaces;
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(name = "ID_INT", nullable = false)
    public Interfaces getInterfaces() {
        return interfaces;
    }

    @ManyToOne
    @JoinColumn(name = "ID_PERFIL", nullable = false)
    public Perfil getPerfil() {
        return perfil;
    }

    public void setInterfaces(Interfaces interfaces) {
        this.interfaces = interfaces;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.interfaces);
        hash = 59 * hash + Objects.hashCode(this.perfil);
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
        final PermissaoPerfilPK other = (PermissaoPerfilPK) obj;
        if (!Objects.equals(this.interfaces, other.interfaces)) {
            return false;
        }
        if (!Objects.equals(this.perfil, other.perfil)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PermissaoPerfilPK{" + "interfaces=" + interfaces + ", perfil=" + perfil + '}';
    }

}
