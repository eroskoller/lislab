/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author eros
 */
@Entity
@Table(name="LAB_RESULTADOS")
@IdClass(LabResutadosPK.class)
public class LabResultados implements Serializable {


    @Id
    @Column(name="REQ_ST_CODIGO")
    private String reqStCodigo;
    @Id
    @Column(name="EXA_ST_CODIGO")
    private String exaStCodigo;
    @Id
    @Column(name="SEQ_ST_CODIGO")
    private String seqStCodigo;
    @Id
    @Column(name="MET_ST_CODIGO")
    private String metStCodigo;
    @Id
    @Column(name="EMV_DT_VALIDADE")
    //@Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private java.sql.Timestamp emvDtValidade;
    @Id
    @Column(name="CIN_ST_CODIGO")
    private String cinStCodigo;
    @Id
    @Column(name="RES_DT_VALIDADE")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date resDtValidade;




    @Column(name="RES_ST_FLAG")
    private String resStFlag;
    @Column(name="RES_ST_INGRESSO")
    private String resStIngresso;
    @Column(name="RES_ST_COMENTARIO")
    private String resStComentario;
    @Column(name="RES_ST_RESULTADO")
    private String resStResultado;
    @Column(name="RES_CH_HIDDEN")
    private Character resChHidden;
    @Column(name="RES_IN_SEQUENCIA")
    private Integer resInSequencia;
    @Column(name="RES_ST_TIPORESULTADO")
    private String resStTipoResultado;
    @Column(name="DER_IN_CODIGO")
    private Long derInCodigo;
    @Column(name="DER_IN_VALIDADERES")
    private Integer derInValidadeRes;
    @Column(name="RES_CL_RESULTADOS")
    private String resClResultados;

    public String getCinStCodigo() {
        return cinStCodigo;
    }

    public void setCinStCodigo(String cinStCodigo) {
        this.cinStCodigo = cinStCodigo;
    }

    public Long getDerInCodigo() {
        return derInCodigo;
    }

    public void setDerInCodigo(Long derInCodigo) {
        this.derInCodigo = derInCodigo;
    }

    public Integer getDerInValidadeRes() {
        return derInValidadeRes;
    }

    public void setDerInValidadeRes(Integer derInValidadeRes) {
        this.derInValidadeRes = derInValidadeRes;
    }

    public Timestamp getEmvDtValidade() {
        return emvDtValidade;
    }

    public void setEmvDtValidade(Timestamp emvDtValidade) {
        this.emvDtValidade = emvDtValidade;
    }

   

    public String getExaStCodigo() {
        return exaStCodigo;
    }

    public void setExaStCodigo(String exaStCodigo) {
        this.exaStCodigo = exaStCodigo;
    }

    public String getMetStCodigo() {
        return metStCodigo;
    }

    public void setMetStCodigo(String metStCodigo) {
        this.metStCodigo = metStCodigo;
    }

    public String getReqStCodigo() {
        return reqStCodigo;
    }

    public void setReqStCodigo(String reqStCodigo) {
        this.reqStCodigo = reqStCodigo;
    }

    public Character getResChHidden() {
        return resChHidden;
    }

    public void setResChHidden(Character resChHidden) {
        this.resChHidden = resChHidden;
    }

    public String getResClResultados() {
        return resClResultados;
    }

    public void setResClResultados(String resClResultados) {
        this.resClResultados = resClResultados;
    }

    public Date getResDtValidade() {
        return resDtValidade;
    }

    public void setResDtValidade(Date resDtValidade) {
        this.resDtValidade = resDtValidade;
    }

    public Integer getResInSequencia() {
        return resInSequencia;
    }

    public void setResInSequencia(Integer resInSequencia) {
        this.resInSequencia = resInSequencia;
    }

    public String getResStComentario() {
        return resStComentario;
    }

    public void setResStComentario(String resStComentario) {
        this.resStComentario = resStComentario;
    }

    public String getResStFlag() {
        return resStFlag;
    }

    public void setResStFlag(String resStFlag) {
        this.resStFlag = resStFlag;
    }

    public String getResStIngresso() {
        return resStIngresso;
    }

    public void setResStIngresso(String resStIngresso) {
        this.resStIngresso = resStIngresso;
    }

    public String getResStResultado() {
        return resStResultado;
    }

    public void setResStResultado(String resStResultado) {
        this.resStResultado = resStResultado;
    }

    public String getResStTipoResultado() {
        return resStTipoResultado;
    }

    public void setResStTipoResultado(String resStTipoResultado) {
        this.resStTipoResultado = resStTipoResultado;
    }

    public String getSeqStCodigo() {
        return seqStCodigo;
    }

    public void setSeqStCodigo(String seqStCodigo) {
        this.seqStCodigo = seqStCodigo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LabResultados other = (LabResultados) obj;
        if ((this.reqStCodigo == null) ? (other.reqStCodigo != null) : !this.reqStCodigo.equals(other.reqStCodigo)) {
            return false;
        }
        if ((this.exaStCodigo == null) ? (other.exaStCodigo != null) : !this.exaStCodigo.equals(other.exaStCodigo)) {
            return false;
        }
        if ((this.seqStCodigo == null) ? (other.seqStCodigo != null) : !this.seqStCodigo.equals(other.seqStCodigo)) {
            return false;
        }
        if ((this.metStCodigo == null) ? (other.metStCodigo != null) : !this.metStCodigo.equals(other.metStCodigo)) {
            return false;
        }
        if ((this.cinStCodigo == null) ? (other.cinStCodigo != null) : !this.cinStCodigo.equals(other.cinStCodigo)) {
            return false;
        }
         if ((this.emvDtValidade == null) ? (other.emvDtValidade != null) : !this.emvDtValidade.equals(other.emvDtValidade)) {
            return false;
        }
         if ((this.resDtValidade == null) ? (other.resDtValidade != null) : !this.resDtValidade.equals(other.resDtValidade)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (this.reqStCodigo != null ? this.reqStCodigo.hashCode() : 0);
        hash = 59 * hash + (this.exaStCodigo != null ? this.exaStCodigo.hashCode() : 0);
        hash = 59 * hash + (this.seqStCodigo != null ? this.seqStCodigo.hashCode() : 0);
        hash = 59 * hash + (this.metStCodigo != null ? this.metStCodigo.hashCode() : 0);
        hash = 59 * hash + (this.cinStCodigo != null ? this.cinStCodigo.hashCode() : 0);
        hash = 59 * hash + (this.emvDtValidade != null ? this.emvDtValidade.hashCode() : 0);
        hash = 59 * hash + (this.resDtValidade != null ? this.resDtValidade.hashCode() : 0);
        return hash;
    }






}
