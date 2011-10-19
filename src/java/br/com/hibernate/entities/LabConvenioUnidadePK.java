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
public class LabConvenioUnidadePK implements Serializable {


   
    @Column(name="UNI_ST_CODIGO")
    private String uniStCodigo;

    @ManyToOne
    @JoinColumn(name="CON_ST_CODIGO")
    private LabConvenio conStCodigo;

    public LabConvenio getConStCodigo() {
        return conStCodigo;
    }

    public void setConStCodigo(LabConvenio conStCodigo) {
        this.conStCodigo = conStCodigo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LabConvenioUnidadePK other = (LabConvenioUnidadePK) obj;
        if ((this.uniStCodigo == null) ? (other.uniStCodigo != null) : !this.uniStCodigo.equals(other.uniStCodigo)) {
            return false;
        }
        if (this.conStCodigo != other.conStCodigo && (this.conStCodigo == null || !this.conStCodigo.equals(other.conStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.uniStCodigo != null ? this.uniStCodigo.hashCode() : 0);
        hash = 47 * hash + (this.conStCodigo != null ? this.conStCodigo.hashCode() : 0);
        return hash;
    }

 

    
    



}
