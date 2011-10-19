/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author eros
 */

@Entity
@Table(name="LAB_EXAMEGRUPO")
@IdClass(LabExameGrupoPK.class)
public class LabExameGrupo implements Serializable{


    @Id
    @ManyToOne
    @JoinColumn(name="EXA_ST_CODIGO")
    private LabExame exaStCodigo;
    @Id
    @Column(name="GRP_ST_CODIGO")
    private String grpStCodigo;
    @Id
    @Column(name="SEQ_ST_CODIGO")
    private String seqStCodigo;

    @Column(name="EXG_CH_FATURA")
    private Character exgChFatura;
    @Column(name="UNI_ST_CODIGO")
    private String uniStCodigo;
    @Column(name="EXG_CH_OMITE")
    private Character  exgChOmite;

    public LabExame getExaStCodigo() {
        return exaStCodigo;
    }

    public void setExaStCodigo(LabExame exaStCodigo) {
        this.exaStCodigo = exaStCodigo;
    }

    public Character getExgChOmite() {
        return exgChOmite;
    }

    public void setExgChOmite(Character exgChOmite) {
        this.exgChOmite = exgChOmite;
    }

    public Character getExgChFatura() {
        return exgChFatura;
    }

    public void setExgChFatura(Character exgChFatura) {
        this.exgChFatura = exgChFatura;
    }

  

   

    public String getGrpStCodigo() {
        return grpStCodigo;
    }

    public void setGrpStCodigo(String grpStCodigo) {
        this.grpStCodigo = grpStCodigo;
    }

    public String getSeqStCodigo() {
        return seqStCodigo;
    }

    public void setSeqStCodigo(String seqStCodigo) {
        this.seqStCodigo = seqStCodigo;
    }

    public String getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(String uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }





}
