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
public class LabRegrasPK implements Serializable{

    @ManyToOne
    @JoinColumn(name="UNI_ST_CODIGO")//mappeded
     private LabUnidade uniStCodigo;
    //@ManyToOne
    //@JoinColumn(name="CON_ST_CODIGO")//mappeded
    @Column(name="CON_ST_CODIGO",nullable=false, updatable=false, insertable=false)
    private String conStCodigo;
    //@Column(name="REG_ST_CODIGO")
    @Column(name="REG_ST_CODIGO",nullable=false, updatable=false, insertable=false)
    private String regStCodigo;

    public LabRegrasPK() {
    }

   

   
    public String getRegStCodigo() {
        return regStCodigo;
    }

    public void setRegStCodigo(String regStCodigo) {
        this.regStCodigo = regStCodigo;
    }

    public String getConStCodigo() {
        return conStCodigo;
    }

    public void setConStCodigo(String conStCodigo) {
        this.conStCodigo = conStCodigo;
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
        final LabRegrasPK other = (LabRegrasPK) obj;
        if (this.uniStCodigo != other.uniStCodigo && (this.uniStCodigo == null || !this.uniStCodigo.equals(other.uniStCodigo))) {
            return false;
        }
        if (this.conStCodigo != other.conStCodigo && (this.conStCodigo == null || !this.conStCodigo.equals(other.conStCodigo))) {
            return false;
        }
        if ((this.regStCodigo == null) ? (other.regStCodigo != null) : !this.regStCodigo.equals(other.regStCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + (this.uniStCodigo != null ? this.uniStCodigo.hashCode() : 0);
        hash = 31 * hash + (this.conStCodigo != null ? this.conStCodigo.hashCode() : 0);
        hash = 31 * hash + (this.regStCodigo != null ? this.regStCodigo.hashCode() : 0);
        return hash;
    }

    


}
