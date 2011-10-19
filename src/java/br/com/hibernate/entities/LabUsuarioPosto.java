/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author eros
 */
@Entity
@Table(name="LAB_USUARIOPOSTO")
@IdClass(LabUsuarioPostoPK.class)
public class LabUsuarioPosto implements Serializable{
    @Id
    @Column(name="UNI_ST_CODIGO")
    private String uniStCodigo;
    
    @Id
    @ManyToOne
    @JoinColumns({@JoinColumn(name="ORI_ST_CODIGO",referencedColumnName = "ORI_ST_CODIGO"),
    @JoinColumn(name="UNI_ST_CODIGO",referencedColumnName = "UNI_ST_CODIGO")})
    private LabOrigem oriStCodigo;
    @Id
    @Column(name="USU_ST_CODIGO")
    private String usuStCodigo;

    public LabOrigem getOriStCodigo() {
        return oriStCodigo;
    }

    public void setOriStCodigo(LabOrigem oriStCodigo) {
        this.oriStCodigo = oriStCodigo;
    }

    public String getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(String uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }

    public String getUsuStCodigo() {
        return usuStCodigo;
    }

    public void setUsuStCodigo(String usuStCodigo) {
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
        final LabUsuarioPosto other = (LabUsuarioPosto) obj;
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
        int hash = 7;
        hash = 17 * hash + (this.uniStCodigo != null ? this.uniStCodigo.hashCode() : 0);
        hash = 17 * hash + (this.oriStCodigo != null ? this.oriStCodigo.hashCode() : 0);
        hash = 17 * hash + (this.usuStCodigo != null ? this.usuStCodigo.hashCode() : 0);
        return hash;
    }
    
    
    
    
}
