/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

/**
 *
 * @author eros
 */
@Embeddable
public class LabExameDependentePK implements Serializable{


    @Id
    @Column(name="UNI_ST_CODIGO")
    private String uniStCodigo;
    @Id
    @Column(name="EXA_ST_CODIGO")
    private String exaStCodigo;
    @Id
    @Column(name="DEP_ST_CODIGO")
    private String depStCodigo;

    public LabExameDependentePK() {
    }

    public LabExameDependentePK(String uniStCodigo, String exaStCodigo, String depStCodigo) {
        this.uniStCodigo = uniStCodigo;
        this.exaStCodigo = exaStCodigo;
        this.depStCodigo = depStCodigo;
    }

    public String getDepStCodigo() {
        return depStCodigo;
    }

    public void setDepStCodigo(String depStCodigo) {
        this.depStCodigo = depStCodigo;
    }

    public String getExaStCodigo() {
        return exaStCodigo;
    }

    public void setExaStCodigo(String exaStCodigo) {
        this.exaStCodigo = exaStCodigo;
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
        final LabExameDependentePK other = (LabExameDependentePK) obj;
        if ((this.uniStCodigo == null) ? (other.uniStCodigo != null) : !this.uniStCodigo.equals(other.uniStCodigo)) {
            return false;
        }
        if ((this.exaStCodigo == null) ? (other.exaStCodigo != null) : !this.exaStCodigo.equals(other.exaStCodigo)) {
            return false;
        }
        if ((this.depStCodigo == null) ? (other.depStCodigo != null) : !this.depStCodigo.equals(other.depStCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (this.uniStCodigo != null ? this.uniStCodigo.hashCode() : 0);
        hash = 13 * hash + (this.exaStCodigo != null ? this.exaStCodigo.hashCode() : 0);
        hash = 13 * hash + (this.depStCodigo != null ? this.depStCodigo.hashCode() : 0);
        return hash;
    }




    

}
