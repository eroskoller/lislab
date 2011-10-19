/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author eros
 */
@Embeddable
public class LabDetalheRequisicaoPK implements Serializable {

    @Id
//    @ManyToOne
//    @JoinColumn(name="REQ_ST_CODIGO")
    @Column(name="REQ_ST_CODIGO")
    private String reqStCodigo;
    @Id
     @ManyToOne
     @JoinColumn(name="EXA_ST_CODIGO")
    private LabExame exaStCodigo;
    @Id
     @Column(name="SEQ_ST_CODIGO")
    private String seqStCodigo;

    public LabExame getExaStCodigo() {
        return exaStCodigo;
    }

    public void setExaStCodigo(LabExame exaStCodigo) {
        this.exaStCodigo = exaStCodigo;
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
        final LabDetalheRequisicaoPK other = (LabDetalheRequisicaoPK) obj;
        if ((this.reqStCodigo == null) ? (other.reqStCodigo != null) : !this.reqStCodigo.equals(other.reqStCodigo)) {
            return false;
        }
        if ((this.exaStCodigo == null) ? (other.exaStCodigo != null) : !this.exaStCodigo.equals(other.exaStCodigo)) {
            return false;
        }
        if ((this.seqStCodigo == null) ? (other.seqStCodigo != null) : !this.seqStCodigo.equals(other.seqStCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.reqStCodigo != null ? this.reqStCodigo.hashCode() : 0);
        hash = 97 * hash + (this.exaStCodigo != null ? this.exaStCodigo.hashCode() : 0);
        hash = 97 * hash + (this.seqStCodigo != null ? this.seqStCodigo.hashCode() : 0);
        return hash;
    }

  


     


}
