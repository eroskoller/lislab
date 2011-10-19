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
public class LabSistemaPK implements Serializable{


    @Column(name="SIS_ST_CODIGO",nullable=false, updatable=false, insertable=false)
    private String sisStCodigo;
    @ManyToOne
    @JoinColumn(name="UNI_ST_CODIGO")//mappeded
    private LabUnidade uniStCodigo;

    public LabSistemaPK() {
    }

  

    

    public String getSisStCodigo() {
        return sisStCodigo;
    }

    public void setSisStCodigo(String sisStCodigo) {
        this.sisStCodigo = sisStCodigo;
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
        final LabSistemaPK other = (LabSistemaPK) obj;
        if ((this.sisStCodigo == null) ? (other.sisStCodigo != null) : !this.sisStCodigo.equals(other.sisStCodigo)) {
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
        hash = 89 * hash + (this.sisStCodigo != null ? this.sisStCodigo.hashCode() : 0);
        hash = 89 * hash + (this.uniStCodigo != null ? this.uniStCodigo.hashCode() : 0);
        return hash;
    }

    


}
