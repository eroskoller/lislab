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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author eros
 */
@Embeddable
public class LabOrigemPK implements Serializable{
   
    @Column(name="ORI_ST_CODIGO",nullable=false, updatable=false, insertable=false)
    private String oriStCodigo;
//    @ManyToOne
//    @JoinColumn(name="UNI_ST_CODIGO")
    @Column(name="UNI_ST_CODIGO")
    private String uniStCodigo;

    public LabOrigemPK() {
    }

    public LabOrigemPK(String oriStCodigo, String uniStCodigo) {
        this.oriStCodigo = oriStCodigo;
        this.uniStCodigo = uniStCodigo;
    }

    

    

    public String getOriStCodigo() {
        return oriStCodigo;
    }

    public void setOriStCodigo(String oriStCodigo) {
        this.oriStCodigo = oriStCodigo;
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
        final LabOrigemPK other = (LabOrigemPK) obj;
        if ((this.oriStCodigo == null) ? (other.oriStCodigo != null) : !this.oriStCodigo.equals(other.oriStCodigo)) {
            return false;
        }
        if (this.uniStCodigo != other.uniStCodigo && (this.uniStCodigo == null || !this.uniStCodigo.equals(other.uniStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (this.oriStCodigo != null ? this.oriStCodigo.hashCode() : 0);
        hash = 43 * hash + (this.uniStCodigo != null ? this.uniStCodigo.hashCode() : 0);
        return hash;
    }



}
