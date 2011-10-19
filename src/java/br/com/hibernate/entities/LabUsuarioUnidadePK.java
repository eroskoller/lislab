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
import javax.persistence.OneToOne;


/**
 *
 * @author eros
 */
@Embeddable
public class LabUsuarioUnidadePK implements Serializable  {

    
   
    @Column(name="UNI_ST_CODIGO")
    private String uniStCodigo;
    
   @ManyToOne(targetEntity=LabUsuario.class)
    @JoinColumn(name="USU_ST_CODIGO")
    private LabUsuario usuStCodigo;

    public LabUsuario getUsuStCodigo() {
        return usuStCodigo;
    }

    public void setUsuStCodigo(LabUsuario usuStCodigo) {
        this.usuStCodigo = usuStCodigo;
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
        final LabUsuarioUnidadePK other = (LabUsuarioUnidadePK) obj;
        if ((this.uniStCodigo == null) ? (other.uniStCodigo != null) : !this.uniStCodigo.equals(other.uniStCodigo)) {
            return false;
        }
        if ((this.usuStCodigo == null) ? (other.usuStCodigo != null) : !this.usuStCodigo.equals(other.usuStCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.uniStCodigo != null ? this.uniStCodigo.hashCode() : 0);
        hash = 53 * hash + (this.usuStCodigo != null ? this.usuStCodigo.hashCode() : 0);
        return hash;
    }

   

  
 


}
