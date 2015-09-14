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
@Table(name = "ENDERECOS_NACIONAIS")
public class EnderecoNacional implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private Usuario usuario;
    private Cidade cidade;
    private Integer cep;
    private String logradouro;
    private String bairro;
    private String numero;
    private String complemento;

    public EnderecoNacional() {
    }

    @Id @ManyToOne
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    public Usuario getUsuario() {
        return usuario;
    }

    @ManyToOne
    @JoinColumn(name = "ID_CIDADE", nullable = false)
    public Cidade getCidade() {
        return cidade;
    }

    @Column(name = "NU_CEP", nullable = false)
    public Integer getCep() {
        return cep;
    }

    @Column(name = "NM_LOGRADOURO", length = 80, nullable = false)
    public String getLogradouro() {
        return logradouro;
    }

    @Column(name = "NM_BAIRRO", length = 40, nullable = false)
    public String getBairro() {
        return bairro;
    }

    @Column(name = "NU_NUMERO", length = 10, nullable = false)
    public String getNumero() {
        return numero;
    }

    @Column(name = "DS_COMPLEMENTO", length = 40)
    public String getComplemento() {
        return complemento;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.usuario);
        hash = 41 * hash + Objects.hashCode(this.cidade);
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
        final EnderecoNacional other = (EnderecoNacional) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EnderecoNacional{" + "usuario=" + usuario + ", cidade=" + cidade + ", bairro=" + bairro + '}';
    }
    
}
