/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author eros
 */
@Embeddable
public class LabMapaTriagemPK implements Serializable{


    @Column(name="UNI_ST_CODIGO")
    private String uniStCodigo;
    @Column(name="GTR_ST_CODIGO")
    private String gtrStCodigo;
    @Column(name="REC_ST_CODIGO")
    private String recStCodigo;
    @Column(name="EXA_ST_CODIGO")
    private String exaStCodigo;

    public String getExaStCodigo() {
        return exaStCodigo;
    }

    public void setExaStCodigo(String exaStCodigo) {
        this.exaStCodigo = exaStCodigo;
    }

    public String getGtrStCodigo() {
        return gtrStCodigo;
    }

    public void setGtrStCodigo(String gtrStCodigo) {
        this.gtrStCodigo = gtrStCodigo;
    }

    public String getRecStCodigo() {
        return recStCodigo;
    }

    public void setRecStCodigo(String recStCodigo) {
        this.recStCodigo = recStCodigo;
    }

    public String getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(String uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LabMapaTriagemPK other = (LabMapaTriagemPK) obj;
        if ((this.uniStCodigo == null) ? (other.uniStCodigo != null) : !this.uniStCodigo.equals(other.uniStCodigo)) {
            return false;
        }
        if ((this.gtrStCodigo == null) ? (other.gtrStCodigo != null) : !this.gtrStCodigo.equals(other.gtrStCodigo)) {
            return false;
        }
        if ((this.recStCodigo == null) ? (other.recStCodigo != null) : !this.recStCodigo.equals(other.recStCodigo)) {
            return false;
        }
        if ((this.exaStCodigo == null) ? (other.exaStCodigo != null) : !this.exaStCodigo.equals(other.exaStCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (this.uniStCodigo != null ? this.uniStCodigo.hashCode() : 0);
        hash = 31 * hash + (this.gtrStCodigo != null ? this.gtrStCodigo.hashCode() : 0);
        hash = 31 * hash + (this.recStCodigo != null ? this.recStCodigo.hashCode() : 0);
        hash = 31 * hash + (this.exaStCodigo != null ? this.exaStCodigo.hashCode() : 0);
        return hash;
    }

    

}
