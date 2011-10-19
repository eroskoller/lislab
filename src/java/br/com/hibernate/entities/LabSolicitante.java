/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.entities;

import java.io.Serializable;
import java.sql.Blob;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author eros
 */

@Entity
@Table(name="LAB_SOLICITANTE")
@IdClass(LabSolicitantePK.class)
public class LabSolicitante implements Serializable{



    @Id
    @Column(name="SOL_ST_ESTADO")
    private String solStEstado;
    @Id
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PRO_ST_CODIGO")//mappeded
    private LabProfissao proStCodigo;
    @Id
    @Column(name="SOL_ST_CODIGO")
    private String solStCodigo;







    @Column(name="SOL_ST_NOME")
    private String solStNome;
    @Column(name="SOL_ST_CEP")
    private String solStCEP;
    @Column(name="SOL_ST_ENDERECO")
    private String solStEndereco;
    @Column(name="SOL_ST_BAIRRO")
    private String solStBairro;
    @Column(name="SOL_ST_CIDADE")
    private String solStCidade;
    @Column(name="SOL_ST_COMPLEMENTO")
    private String solStComplemento;
    @Column(name="SOL_ST_FONE")
    private String solStFone;
    @Column(name="SOL_ST_FAX")
    private String solStFax;
    @Column(name="SOL_ST_CELULAR")
    private String solStCelular;
    @Column(name="SOL_ST_EMAIL")
    private String solStEmail;
    @Column(name="SOL_ST_ESPECIALIDADE")
    private String solStEspecialidade;
    @Column(name="SOL_ST_NUMERO")
    private String solStNumero;
    @Lob
    @Column(name="SOL_BL_OBS")
    private String solBlObs;
    @Column(name="SOL_ST_CHAVESOLICITANTE")
    private String solStChaveSolicitante;







    @OneToMany(mappedBy="solStCodigo")
    private List<LabAgendaPaciente> listLabAgendaPaciente;

    public LabProfissao getProStCodigo() {
        return proStCodigo;
    }

    public void setProStCodigo(LabProfissao proStCodigo) {
        this.proStCodigo = proStCodigo;
    }
   
    public String getSolBlObs() {
        return solBlObs;
    }

    public void setSolBlObs(String solBlObs) {
        this.solBlObs = solBlObs;
    }

    public String getSolStBairro() {
        return solStBairro;
    }

    public void setSolStBairro(String solStBairro) {
        this.solStBairro = solStBairro;
    }

    public String getSolStCEP() {
        return solStCEP;
    }

    public void setSolStCEP(String solStCEP) {
        this.solStCEP = solStCEP;
    }

    public String getSolStCelular() {
        return solStCelular;
    }

    public void setSolStCelular(String solStCelular) {
        this.solStCelular = solStCelular;
    }

    public String getSolStChaveSolicitante() {
        return solStChaveSolicitante;
    }

    public void setSolStChaveSolicitante(String solStChaveSolicitante) {
        this.solStChaveSolicitante = solStChaveSolicitante;
    }

    public String getSolStCidade() {
        return solStCidade;
    }

    public void setSolStCidade(String solStCidade) {
        this.solStCidade = solStCidade;
    }

    public String getSolStComplemento() {
        return solStComplemento;
    }

    public void setSolStComplemento(String solStComplemento) {
        this.solStComplemento = solStComplemento;
    }

    public String getSolStEmail() {
        return solStEmail;
    }

    public void setSolStEmail(String solStEmail) {
        this.solStEmail = solStEmail;
    }

    public String getSolStEndereco() {
        return solStEndereco;
    }

    public void setSolStEndereco(String solStEndereco) {
        this.solStEndereco = solStEndereco;
    }

    public String getSolStEspecialidade() {
        return solStEspecialidade;
    }

    public void setSolStEspecialidade(String solStEspecialidade) {
        this.solStEspecialidade = solStEspecialidade;
    }

    public String getSolStFax() {
        return solStFax;
    }

    public void setSolStFax(String solStFax) {
        this.solStFax = solStFax;
    }

    public String getSolStFone() {
        return solStFone;
    }

    public void setSolStFone(String solStFone) {
        this.solStFone = solStFone;
    }

    public String getSolStNome() {
        return solStNome;
    }

    public void setSolStNome(String solStNome) {
        this.solStNome = solStNome;
    }

    public String getSolStNumero() {
        return solStNumero;
    }

    public void setSolStNumero(String solStNumero) {
        this.solStNumero = solStNumero;
    }

    public List<LabAgendaPaciente> getListLabAgendaPaciente() {
        return listLabAgendaPaciente;
    }

    public void setListLabAgendaPaciente(List<LabAgendaPaciente> listLabAgendaPaciente) {
        this.listLabAgendaPaciente = listLabAgendaPaciente;
    }

   

    public String getSolStCodigo() {
        return solStCodigo;
    }

    public void setSolStCodigo(String solStCodigo) {
        this.solStCodigo = solStCodigo;
    }

    public String getSolStEstado() {
        return solStEstado;
    }

    public void setSolStEstado(String solStEstado) {
        this.solStEstado = solStEstado;
    }

    


    

   
}
