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
public class LabColetorPK implements Serializable{


    @Column(name="COL_ST_CODIGO",nullable=false, updatable=false, insertable=false)
    private String colStCodigo;
    @ManyToOne
    @JoinColumn(name="UNI_ST_CODIGO")//mappeded
    private LabUnidade  uniStCodigo;

    public LabColetorPK() {
    }

    


    

    public String getColStCodigo() {
        return colStCodigo;
    }

    public void setColStCodigo(String colStCodigo) {
        this.colStCodigo = colStCodigo;
    }

    public LabUnidade getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(LabUnidade uniStCodigo) {
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
        final LabColetorPK other = (LabColetorPK) obj;
        if ((this.colStCodigo == null) ? (other.colStCodigo != null) : !this.colStCodigo.equals(other.colStCodigo)) {
            return false;
        }
        if (this.uniStCodigo != other.uniStCodigo && (this.uniStCodigo == null || !this.uniStCodigo.equals(other.uniStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (this.colStCodigo != null ? this.colStCodigo.hashCode() : 0);
        hash = 59 * hash + (this.uniStCodigo != null ? this.uniStCodigo.hashCode() : 0);
        return hash;
    }



    

}
