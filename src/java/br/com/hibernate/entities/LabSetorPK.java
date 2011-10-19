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
public class LabSetorPK implements Serializable {

    @ManyToOne
    @JoinColumn(name="UNI_ST_CODIGO")
    private LabUnidade uniStCodigo;
    @Column(name="SET_ST_CODIGO")
    private String setStCodigo;

    public LabSetorPK() {
    }

    public LabSetorPK(LabUnidade uniStCodigo, String setStCodigo) {
        this.uniStCodigo = uniStCodigo;
        this.setStCodigo = setStCodigo;
    }

    



    public String getSetStCodigo() {
        return setStCodigo;
    }

    public void setSetStCodigo(String setStCodigo) {
        this.setStCodigo = setStCodigo;
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
        final LabSetorPK other = (LabSetorPK) obj;
        if (this.uniStCodigo != other.uniStCodigo && (this.uniStCodigo == null || !this.uniStCodigo.equals(other.uniStCodigo))) {
            return false;
        }
        if ((this.setStCodigo == null) ? (other.setStCodigo != null) : !this.setStCodigo.equals(other.setStCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + (this.uniStCodigo != null ? this.uniStCodigo.hashCode() : 0);
        hash = 23 * hash + (this.setStCodigo != null ? this.setStCodigo.hashCode() : 0);
        return hash;
    }



}
