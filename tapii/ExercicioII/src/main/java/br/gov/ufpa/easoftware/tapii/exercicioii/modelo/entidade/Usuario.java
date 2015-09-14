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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIOS")
public class Usuario implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String sexo;
    private Pais paisNascimento;
    private Pais paisEndereco;
    private String interno;
    private String email;
    private String nome;
    private String tratamento;
    private Integer cpf;
    private String senha;
    private String loginAD;
    private String telResidencial;
    private String telComercial;
    private String telCelular;
    private List<Perfil> perfis;
    private List<Atividade> atividades;
    
    public Usuario() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO", nullable = false)
    public Integer getId() {
        return id;
    }

    @Column(name = "FL_SEXO", length = 1, nullable = false)
    public String getSexo() {
        return sexo;
    }

    @ManyToOne
    @JoinColumn(name = "ID_PAISNAC", referencedColumnName = "ID_PAIS", nullable = false)
    public Pais getPaisNascimento() {
        return paisNascimento;
    }

    @ManyToOne
    @JoinColumn(name = "ID_PAISEND", referencedColumnName = "ID_PAIS", nullable = false)
    public Pais getPaisEndereco() {
        return paisEndereco;
    }

    @Column(name = "FL_INTERNO", length = 1, nullable = false)
    public String getInterno() {
        return interno;
    }

    @Column(name = "DS_EMAIL", length = 60, nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    @Column(name = "NM_USUARIO", length = 60, nullable = false)
    public String getNome() {
        return nome;
    }

    @Column(name = "NM_TRATAMENTO", length = 30, nullable = false)
    public String getTratamento() {
        return tratamento;
    }

    @Column(name = "NU_CPF", unique = true)
    public Integer getCpf() {
        return cpf;
    }

    @Column(name = "VL_SENHA", length = 32)
    public String getSenha() {
        return senha;
    }

    @Column(name = "NM_LOGINAD", length = 30)
    public String getLoginAD() {
        return loginAD;
    }

    @Column(name = "NU_FONRES", length = 20)
    public String getTelResidencial() {
        return telResidencial;
    }

    @Column(name = "NU_FONCOM", length = 20)
    public String getTelComercial() {
        return telComercial;
    }

    @Column(name = "NU_CELULAR", length = 20)
    public String getTelCelular() {
        return telCelular;
    }

    @ManyToMany
    @JoinTable(
            name = "USUARIOS_PERFIS",
            joinColumns = @JoinColumn(name = "ID_USUARIO", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "ID_PERFIL", nullable = false)
    )
    public List<Perfil> getPerfis() {
        return perfis;
    }

    @ManyToMany(mappedBy = "usuarios")
    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setPaisNascimento(Pais paisNascimento) {
        this.paisNascimento = paisNascimento;
    }

    public void setPaisEndereco(Pais paisEndereco) {
        this.paisEndereco = paisEndereco;
    }

    public void setInterno(String interno) {
        this.interno = interno;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setLoginAD(String loginAD) {
        this.loginAD = loginAD;
    }

    public void setTelResidencial(String telResidencial) {
        this.telResidencial = telResidencial;
    }

    public void setTelComercial(String telComercial) {
        this.telComercial = telComercial;
    }

    public void setTelCelular(String telCelular) {
        this.telCelular = telCelular;
    }

    public void setPerfis(List<Perfil> perfis) {
        this.perfis = perfis;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.cpf);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + '}';
    }

    
}
