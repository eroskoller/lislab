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

/**
 *
 * @author eros
 */

@Embeddable
public class LabUsuarioPostoPK implements Serializable{
    
    
    
        
    @Column(name="UNI_ST_CODIGO")
    private String uniStCodigo;
    
    @ManyToOne
    @JoinColumns({@JoinColumn(name="ORI_ST_CODIGO",referencedColumnName = "ORI_ST_CODIGO"),
    @JoinColumn(name="UNI_ST_CODIGO",referencedColumnName = "UNI_ST_CODIGO")})
    private LabOrigem oriStCodigo;
 
    @Column(name="USU_ST_CODIGO")
    private String usuStCodigo;

    public LabUsuarioPostoPK() {
    }

    public LabUsuarioPostoPK(String uniStCodigo, LabOrigem oriStCodigo, String usuStCodigo) {
        this.uniStCodigo = uniStCodigo;
        this.oriStCodigo = oriStCodigo;
        this.usuStCodigo = usuStCodigo;
    }

 
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LabUsuarioPostoPK other = (LabUsuarioPostoPK) obj;
        if (this.uniStCodigo != other.uniStCodigo && (this.uniStCodigo == null || !this.uniStCodigo.equals(other.uniStCodigo))) {
            return false;
        }
        if ((this.oriStCodigo == null) ? (other.oriStCodigo != null) : !this.oriStCodigo.equals(other.oriStCodigo)) {
            return false;
        }
        if ((this.usuStCodigo == null) ? (other.usuStCodigo != null) : !this.usuStCodigo.equals(other.usuStCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (this.uniStCodigo != null ? this.uniStCodigo.hashCode() : 0);
        hash = 59 * hash + (this.oriStCodigo != null ? this.oriStCodigo.hashCode() : 0);
        hash = 59 * hash + (this.usuStCodigo != null ? this.usuStCodigo.hashCode() : 0);
        return hash;
    }
    
    
    
    
    
}
