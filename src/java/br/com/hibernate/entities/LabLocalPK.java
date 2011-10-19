/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author eros
 */

@Embeddable
public class LabLocalPK implements Serializable{


    @ManyToOne
    @JoinColumn(name="UNI_ST_CODIGO")
    private LabUnidade uniStCodigo;
    
    @Column(name="LOC_ST_CODIGO",nullable=false, updatable=false, insertable=false)
    private String locStCodigo;

    public LabLocalPK() {
    }

    public String getLocStCodigo() {
        return locStCodigo;
    }

    public void setLocStCodigo(String locStCodigo) {
        this.locStCodigo = locStCodigo;
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
        final LabLocalPK other = (LabLocalPK) obj;
        if (this.uniStCodigo != other.uniStCodigo && (this.uniStCodigo == null || !this.uniStCodigo.equals(other.uniStCodigo))) {
            return false;
        }
        if ((this.locStCodigo == null) ? (other.locStCodigo != null) : !this.locStCodigo.equals(other.locStCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + (this.uniStCodigo != null ? this.uniStCodigo.hashCode() : 0);
        hash = 43 * hash + (this.locStCodigo != null ? this.locStCodigo.hashCode() : 0);
        return hash;
    }


    


}
