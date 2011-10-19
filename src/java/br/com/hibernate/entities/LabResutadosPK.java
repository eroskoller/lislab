/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;

/**
 *
 * @author eros
 */

@Embeddable
public class LabResutadosPK implements Serializable{

    
    
    @Column(name="REQ_ST_CODIGO")
    private String reqStCodigo;
    @Column(name="EXA_ST_CODIGO")
    private String exaStCodigo;
    @Column(name="SEQ_ST_CODIGO")
    private String seqStCodigo;
    @Column(name="MET_ST_CODIGO")
    private String metStCodigo;
    @Column(name="EMV_DT_VALIDADE")
    //@Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private java.sql.Timestamp emvDtValidade;
    @Column(name="CIN_ST_CODIGO")
    private String cinStCodigo;
    @Column(name="RES_DT_VALIDADE")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date resDtValidade;

    public String getCinStCodigo() {
        return cinStCodigo;
    }

    public void setCinStCodigo(String cinStCodigo) {
        this.cinStCodigo = cinStCodigo;
    }

    public Date getResDtValidade() {
        return resDtValidade;
    }

    public void setResDtValidade(Date resDtValidade) {
        this.resDtValidade = resDtValidade;
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
        final LabResutadosPK other = (LabResutadosPK) obj;
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
        if (this.emvDtValidade != other.emvDtValidade && (this.emvDtValidade == null || !this.emvDtValidade.equals(other.emvDtValidade))) {
            return false;
        }
        if ((this.cinStCodigo == null) ? (other.cinStCodigo != null) : !this.cinStCodigo.equals(other.cinStCodigo)) {
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
        hash = 23 * hash + (this.reqStCodigo != null ? this.reqStCodigo.hashCode() : 0);
        hash = 23 * hash + (this.exaStCodigo != null ? this.exaStCodigo.hashCode() : 0);
        hash = 23 * hash + (this.seqStCodigo != null ? this.seqStCodigo.hashCode() : 0);
        hash = 23 * hash + (this.metStCodigo != null ? this.metStCodigo.hashCode() : 0);
        hash = 23 * hash + (this.emvDtValidade != null ? this.emvDtValidade.hashCode() : 0);
        hash = 23 * hash + (this.cinStCodigo != null ? this.cinStCodigo.hashCode() : 0);
        hash = 23 * hash + (this.resDtValidade != null ? this.resDtValidade.hashCode() : 0);
        return hash;
    }

   

}
