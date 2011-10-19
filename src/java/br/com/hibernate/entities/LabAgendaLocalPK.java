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
public class LabAgendaLocalPK   implements Serializable {



    
    @Column(name="ALO_IN_CODIGO")
    private Long aloInCodigo;
    @ManyToOne
    @JoinColumn(name="UNI_ST_CODIGO")
    private LabUnidade uniStCodigo;

    public Long getAloInCodigo() {
        return aloInCodigo;
    }

    public void setAloInCodigo(Long aloInCodigo) {
        this.aloInCodigo = aloInCodigo;
    }

    

     public LabAgendaLocalPK() {
    }

  

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LabAgendaLocalPK other = (LabAgendaLocalPK) obj;
        if (this.aloInCodigo != other.aloInCodigo && (this.aloInCodigo == null || !this.aloInCodigo.equals(other.aloInCodigo))) {
            return false;
        }
        if ((this.uniStCodigo == null) ? (other.uniStCodigo != null) : !this.uniStCodigo.equals(other.uniStCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + (this.aloInCodigo != null ? this.aloInCodigo.hashCode() : 0);
        hash = 41 * hash + (this.uniStCodigo != null ? this.uniStCodigo.hashCode() : 0);
        return hash;
    }


    


}
