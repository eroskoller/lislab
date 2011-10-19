/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author eros
 */
@Entity
@Table(name="LAB_USUARIO")
public class LabUsuario implements Serializable {

    @Id
    @Column(name="USU_ST_CODIGO")
    private String usuStCodigo;
    @Column(name="USU_ST_NOME")
    private String usuStNome;
    @Column(name="USU_ST_SENHA")
    private String usuStSenha;
    @ManyToOne
    @JoinColumn(name="PUS_ST_CODIGO")
    private LabPerfilUsuario pusStCodigo;
    @Column(name="USU_CH_ATIVO")
    private char usuChAtivo;
    @Column(name="UNI_ST_CODIGO")
    private String uniStCodigo;
    @Column(name="USU_ST_EMAIL")
    private String usuStEmail;
    @Column(name="USU_ST_CIEMSN")
    private String usuStCieMSN;
    
    @ManyToOne
       @JoinColumns ({
                @JoinColumn(name="UNI_ST_CODIGO", referencedColumnName = "UNI_ST_CODIGO",insertable=false,updatable=false),
                @JoinColumn(name="SET_ST_CODIGO",referencedColumnName = "SET_ST_CODIGO",insertable=false,updatable=false)
    })
    private LabSetor setStCodigo;
    @Column(name="USU_CH_SENHABLOQUEADA")
    private Character usuChSenhaBloqueada;
    @Column(name="USU_ST_CARGO")
    private String usuStCardo;
    @Column(name="USU_ST_CONSELHO")
    private String usuStConselho;
    @Column(name="USU_CH_TIPO")
    private Character usuChTipo;
    @Column(name="USU_ST_CPF")
    private String usuStCpf;

    @OneToMany(mappedBy="usuStCodigo")
    private List<LabUsuarioUnidade> listLabUnidadeUsuario;
    


    public char getUsuChAtivo() {
        return usuChAtivo;
    }

    public void setUsuChAtivo(char usuChAtivo) {
        this.usuChAtivo = usuChAtivo;
    }

    public String getUsuStCodigo() {
        return usuStCodigo;
    }

    public void setUsuStCodigo(String usuStCodigo) {
        this.usuStCodigo = usuStCodigo;
    }

    public String getUsuStNome() {
        return usuStNome;
    }

    public void setUsuStNome(String usuStNome) {
        this.usuStNome = usuStNome;
    }

    public String getUsuStSenha() {
        return usuStSenha;
    }

    public void setUsuStSenha(String usuStSenha) {
        this.usuStSenha = usuStSenha;
    }

    public String getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(String uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }

   

    public String getUsuStCieMSN() {
        return usuStCieMSN;
    }

    public void setUsuStCieMSN(String usuStCieMSN) {
        this.usuStCieMSN = usuStCieMSN;
    }

    public String getUsuStEmail() {
        return usuStEmail;
    }

    public void setUsuStEmail(String usuStEmail) {
        this.usuStEmail = usuStEmail;
    }

    public List<LabUsuarioUnidade> getListLabUnidadeUsuario() {
        return listLabUnidadeUsuario;
    }

    public void setListLabUnidadeUsuario(List<LabUsuarioUnidade> listLabUnidadeUsuario) {
        this.listLabUnidadeUsuario = listLabUnidadeUsuario;
    }

    public LabPerfilUsuario getPusStCodigo() {
        return pusStCodigo;
    }

    public void setPusStCodigo(LabPerfilUsuario pusStCodigo) {
        this.pusStCodigo = pusStCodigo;
    }

    public LabSetor getSetStCodigo() {
        return setStCodigo;
    }

    public void setSetStCodigo(LabSetor setStCodigo) {
        this.setStCodigo = setStCodigo;
    }

    public Character getUsuChSenhaBloqueada() {
        return usuChSenhaBloqueada;
    }

    public void setUsuChSenhaBloqueada(Character usuChSenhaBloqueada) {
        this.usuChSenhaBloqueada = usuChSenhaBloqueada;
    }

    public Character getUsuChTipo() {
        return usuChTipo;
    }

    public void setUsuChTipo(Character usuChTipo) {
        this.usuChTipo = usuChTipo;
    }

    public String getUsuStCardo() {
        return usuStCardo;
    }

    public void setUsuStCardo(String usuStCardo) {
        this.usuStCardo = usuStCardo;
    }

    public String getUsuStConselho() {
        return usuStConselho;
    }

    public void setUsuStConselho(String usuStConselho) {
        this.usuStConselho = usuStConselho;
    }

    public String getUsuStCpf() {
        return usuStCpf;
    }

    public void setUsuStCpf(String usuStCpf) {
        this.usuStCpf = usuStCpf;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LabUsuario other = (LabUsuario) obj;
        if ((this.usuStCodigo == null) ? (other.usuStCodigo != null) : !this.usuStCodigo.equals(other.usuStCodigo)) {
            return false;
        }
        if ((this.usuStSenha == null) ? (other.usuStSenha != null) : !this.usuStSenha.equals(other.usuStSenha)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.usuStCodigo != null ? this.usuStCodigo.hashCode() : 0);
        hash = 41 * hash + (this.usuStSenha != null ? this.usuStSenha.hashCode() : 0);
        return hash;
    }
    




}
