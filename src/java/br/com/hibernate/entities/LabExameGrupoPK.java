/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author eros
 */
@Embeddable
public class LabExameGrupoPK implements Serializable {

    
    @ManyToOne
    @JoinColumn(name="EXA_ST_CODIGO")
    private LabExame exaStCodigo;
    @Column(name="GRP_ST_CODIGO")
    private String grpStCodigo;
    @Column(name="SEQ_ST_CODIGO")
    private String seqStCodigo;

    public LabExame getExaStCodigo() {
        return exaStCodigo;
    }

    public void setExaStCodigo(LabExame exaStCodigo) {
        this.exaStCodigo = exaStCodigo;
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LabExameGrupoPK other = (LabExameGrupoPK) obj;
        if (this.exaStCodigo != other.exaStCodigo && (this.exaStCodigo == null || !this.exaStCodigo.equals(other.exaStCodigo))) {
            return false;
        }
        if ((this.grpStCodigo == null) ? (other.grpStCodigo != null) : !this.grpStCodigo.equals(other.grpStCodigo)) {
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
        hash = 47 * hash + (this.exaStCodigo != null ? this.exaStCodigo.hashCode() : 0);
        hash = 47 * hash + (this.grpStCodigo != null ? this.grpStCodigo.hashCode() : 0);
        hash = 47 * hash + (this.seqStCodigo != null ? this.seqStCodigo.hashCode() : 0);
        return hash;
    }




}
