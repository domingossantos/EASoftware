package br.gov.ufpa.easoftware.tapii.exercicioii.modelo.entidade;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ENDERECOS_EXTERIOR")
public class EnderecoExterior implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private Usuario usuario;
    private String endereco;
    private String cidade;
    private String complemento;
    private Integer codigoPostal;
    private String estado;

    public EnderecoExterior() {
    }

    @Id @ManyToOne
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    public Usuario getUsuario() {
        return usuario;
    }

    @Column(name = "DS_ENDERECO", length = 80, nullable = false)
    public String getEndereco() {
        return endereco;
    }

    @Column(name = "DS_CIDADE", length = 40, nullable = false)
    public String getCidade() {
        return cidade;
    }

    @Column(name = "DS_COMPLEMENTO", length = 40, nullable = false)
    public String getComplemento() {
        return complemento;
    }

    @Column(name = "NU_CODPOSTAL")
    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    @Column(name = "DS_ESTADO", length = 40)
    public String getEstado() {
        return estado;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.usuario);
        hash = 59 * hash + Objects.hashCode(this.cidade);
        hash = 59 * hash + Objects.hashCode(this.codigoPostal);
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
        final EnderecoExterior other = (EnderecoExterior) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.codigoPostal, other.codigoPostal)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EnderecoExterior{" + "usuario=" + usuario + ", cidade=" + cidade + ", codigoPostal=" + codigoPostal + ", estado=" + estado + '}';
    }
    
    
}
