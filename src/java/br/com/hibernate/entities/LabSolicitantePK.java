/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author eros
 */

@Embeddable
public class LabSolicitantePK implements Serializable{

    @Column(name="SOL_ST_ESTADO",nullable=false, updatable=false, insertable=false)
    private String solStEstado;
    @ManyToOne
    @JoinColumn(name="PRO_ST_CODIGO")//mappeded
     private LabProfissao proStCodigo;
    
    @Column(name="SOL_ST_CODIGO",nullable=false, updatable=false, insertable=false)
    private String solStCodigo;

    public LabSolicitantePK() {
    }

    public LabProfissao getProStCodigo() {
        return proStCodigo;
    }

    public void setProStCodigo(LabProfissao proStCodigo) {
        this.proStCodigo = proStCodigo;
    }


    public String getSolStCodigo() {
        return solStCodigo;
    }

    public void setSolStCodigo(String solStCodigo) {
        this.solStCodigo = solStCodigo;
    }

    public String getSolStEstado() {
        return solStEstado;
    }

    public void setSolStEstado(String solStEstado) {
        this.solStEstado = solStEstado;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LabSolicitantePK other = (LabSolicitantePK) obj;
        if ((this.solStEstado == null) ? (other.solStEstado != null) : !this.solStEstado.equals(other.solStEstado)) {
            return false;
        }
        if (this.proStCodigo != other.proStCodigo && (this.proStCodigo == null || !this.proStCodigo.equals(other.proStCodigo))) {
            return false;
        }
        if ((this.solStCodigo == null) ? (other.solStCodigo != null) : !this.solStCodigo.equals(other.solStCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.solStEstado != null ? this.solStEstado.hashCode() : 0);
        hash = 41 * hash + (this.proStCodigo != null ? this.proStCodigo.hashCode() : 0);
        hash = 41 * hash + (this.solStCodigo != null ? this.solStCodigo.hashCode() : 0);
        return hash;
    }


    
    

}
