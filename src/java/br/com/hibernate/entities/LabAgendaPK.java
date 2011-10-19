/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


/**
 *
 * @author eros
 */
@Embeddable
public class LabAgendaPK implements  Serializable{

//    @ManyToOne
//    @JoinColumn(name="UNI_ST_CODIGO",nullable=false, updatable=false, insertable=false)
//    private LabUnidade uniStCodigo;//mappeded
    @ManyToOne
    @JoinColumns ({
        @JoinColumn(name="ALO_IN_CODIGO",referencedColumnName = "ALO_IN_CODIGO"),
         @JoinColumn(name="UNI_ST_CODIGO", referencedColumnName = "UNI_ST_CODIGO")
    })
    private LabAgendaLocal aloInCodigo;
    @Column(name="AGE_IN_CODIGO",nullable=false, updatable=false, insertable=false)
    private Long ageInCodigo;

    public LabAgendaPK() {
    }
    
   
    public Long getAgeInCodigo() {
        return ageInCodigo;
    }

    public void setAgeInCodigo(Long ageInCodigo) {
        this.ageInCodigo = ageInCodigo;
    }

    public LabAgendaLocal getAloInCodigo() {
        return aloInCodigo;
    }

    public void setAloInCodigo(LabAgendaLocal aloInCodigo) {
        this.aloInCodigo = aloInCodigo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LabAgendaPK other = (LabAgendaPK) obj;
        if (this.aloInCodigo != other.aloInCodigo && (this.aloInCodigo == null || !this.aloInCodigo.equals(other.aloInCodigo))) {
            return false;
        }
        if (this.ageInCodigo != other.ageInCodigo && (this.ageInCodigo == null || !this.ageInCodigo.equals(other.ageInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + (this.aloInCodigo != null ? this.aloInCodigo.hashCode() : 0);
        hash = 71 * hash + (this.ageInCodigo != null ? this.ageInCodigo.hashCode() : 0);
        return hash;
    }

   




    




}
