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
public class LabSubSetorPK implements Serializable{

    
    @Column(name="UNI_ST_CODIGO")
    private String uniStCodigo;
    @Column(name="SET_ST_CODIGO")
    private String setStCodigo;
    @Column(name="SUB_ST_CODIGO")
    private String subStCodigo;

    public String getSetStCodigo() {
        return setStCodigo;
    }

    public void setSetStCodigo(String setStCodigo) {
        this.setStCodigo = setStCodigo;
    }

    public String getSubStCodigo() {
        return subStCodigo;
    }

    public void setSubStCodigo(String subStCodigo) {
        this.subStCodigo = subStCodigo;
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
        final LabSubSetorPK other = (LabSubSetorPK) obj;
        if ((this.uniStCodigo == null) ? (other.uniStCodigo != null) : !this.uniStCodigo.equals(other.uniStCodigo)) {
            return false;
        }
        if ((this.setStCodigo == null) ? (other.setStCodigo != null) : !this.setStCodigo.equals(other.setStCodigo)) {
            return false;
        }
        if ((this.subStCodigo == null) ? (other.subStCodigo != null) : !this.subStCodigo.equals(other.subStCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.uniStCodigo != null ? this.uniStCodigo.hashCode() : 0);
        hash = 41 * hash + (this.setStCodigo != null ? this.setStCodigo.hashCode() : 0);
        hash = 41 * hash + (this.subStCodigo != null ? this.subStCodigo.hashCode() : 0);
        return hash;
    }


    

}
