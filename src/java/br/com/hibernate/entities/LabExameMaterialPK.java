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
public class LabExameMaterialPK   implements Serializable {


    @Column(name="EXA_ST_CODIGO")
    private String exaStCodigo;
    @ManyToOne
    @JoinColumn(name="MAT_ST_CODIGO")
    private LabMaterial matStCodigo;

    public String getExaStCodigo() {
        return exaStCodigo;
    }

    public void setExaStCodigo(String exaStCodigo) {
        this.exaStCodigo = exaStCodigo;
    }

    public LabMaterial getMatStCodigo() {
        return matStCodigo;
    }

    public void setMatStCodigo(LabMaterial matStCodigo) {
        this.matStCodigo = matStCodigo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LabExameMaterialPK other = (LabExameMaterialPK) obj;
        if ((this.exaStCodigo == null) ? (other.exaStCodigo != null) : !this.exaStCodigo.equals(other.exaStCodigo)) {
            return false;
        }
        if (this.matStCodigo != other.matStCodigo && (this.matStCodigo == null || !this.matStCodigo.equals(other.matStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.exaStCodigo != null ? this.exaStCodigo.hashCode() : 0);
        hash = 79 * hash + (this.matStCodigo != null ? this.matStCodigo.hashCode() : 0);
        return hash;
    }



}
