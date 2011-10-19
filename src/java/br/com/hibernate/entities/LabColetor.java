/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.entities;

import java.io.Serializable;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name="LAB_COLETOR")
@IdClass(LabColetorPK.class)
public class LabColetor implements Serializable{


    @Id
    @Column(name="COL_ST_CODIGO",nullable=false, updatable=false, insertable=false)
    private String colStCodigo;
    @Id
    @ManyToOne
    @JoinColumn(name="UNI_ST_CODIGO")//mappeded
    private LabUnidade  uniStCodigo;

    public String getColStCodigo() {
        return colStCodigo;
    }

    public void setColStCodigo(String colStCodigo) {
        this.colStCodigo = colStCodigo;
    }

   







    @Column(name="COL_ST_NOME")
    private String colStNome;
    @Column(name="COL_ST_CEP")
    private String colStCEP;
    @Column(name="COL_ST_ENDERECO")
    private String colStEndereco;
    @Column(name="COL_ST_BAIRRO")
    private String colStBairro;
    @Column(name="COL_ST_CIDADE")
    private String colStCidade;
    @Column(name="COL_ST_COMPLEMENTO")
    private String colStComplemento;
    @Column(name="COL_ST_FONE")
    private String colStFone;
    @Column(name="COL_ST_FAX")
    private String colStFax;
    @Column(name="COL_ST_CELULAR")
    private String colStCelular;
    @Column(name="COL_ST_EMAIL")
    private String colStEmail;
    @Column(name="COL_ST_NUMERO")
    private String colStNumero;
    @Lob
    @Column(name="COL_BL_OBS")
    private String colBlObs;
    @Column(name="COL_ST_ESTADO")
    private String colStEstado;


//    @OneToMany(mappedBy="colStCodigo")
//    private List<LabRequisicao> listLabRequisicao;



  
    public String getColBlObs() {
        return colBlObs;
    }

    public void setColBlObs(String colBlObs) {
        this.colBlObs = colBlObs;
    }

    public String getColStBairro() {
        return colStBairro;
    }

    public void setColStBairro(String colStBairro) {
        this.colStBairro = colStBairro;
    }

    public String getColStCEP() {
        return colStCEP;
    }

    public void setColStCEP(String colStCEP) {
        this.colStCEP = colStCEP;
    }

    public String getColStCelular() {
        return colStCelular;
    }

    public void setColStCelular(String colStCelular) {
        this.colStCelular = colStCelular;
    }

    public String getColStCidade() {
        return colStCidade;
    }

    public void setColStCidade(String colStCidade) {
        this.colStCidade = colStCidade;
    }

   

    public String getColStComplemento() {
        return colStComplemento;
    }

    public void setColStComplemento(String colStComplemento) {
        this.colStComplemento = colStComplemento;
    }

    public String getColStEmail() {
        return colStEmail;
    }

    public void setColStEmail(String colStEmail) {
        this.colStEmail = colStEmail;
    }

    public String getColStEndereco() {
        return colStEndereco;
    }

    public void setColStEndereco(String colStEndereco) {
        this.colStEndereco = colStEndereco;
    }

    public String getColStEstado() {
        return colStEstado;
    }

    public void setColStEstado(String colStEstado) {
        this.colStEstado = colStEstado;
    }

    public String getColStFax() {
        return colStFax;
    }

    public void setColStFax(String colStFax) {
        this.colStFax = colStFax;
    }

    public String getColStFone() {
        return colStFone;
    }

    public void setColStFone(String colStFone) {
        this.colStFone = colStFone;
    }

    public String getColStNome() {
        return colStNome;
    }

    public void setColStNome(String colStNome) {
        this.colStNome = colStNome;
    }

    public String getColStNumero() {
        return colStNumero;
    }

    public void setColStNumero(String colStNumero) {
        this.colStNumero = colStNumero;
    }

    public LabUnidade getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(LabUnidade uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }

   

    
}
