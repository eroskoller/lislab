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
public class LabAgendaPacienteExamePK implements Serializable{

   @ManyToOne
   @JoinColumn(name="AGP_IN_CODIGO",nullable=false, updatable=false, insertable=false)
   private LabAgendaPaciente agpInCodigo;
   
   @Column(name="AGX_IN_CODIGO",nullable=false, updatable=false, insertable=false)
   private Long agxInCodigo;

    public LabAgendaPacienteExamePK() {
    }

    public LabAgendaPaciente getAgpInCodigo() {
        return agpInCodigo;
    }

    public void setAgpInCodigo(LabAgendaPaciente agpInCodigo) {
        this.agpInCodigo = agpInCodigo;
    }

    public Long getAgxInCodigo() {
        return agxInCodigo;
    }

    public void setAgxInCodigo(Long agxInCodigo) {
        this.agxInCodigo = agxInCodigo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LabAgendaPacienteExamePK other = (LabAgendaPacienteExamePK) obj;
        if (this.agpInCodigo != other.agpInCodigo && (this.agpInCodigo == null || !this.agpInCodigo.equals(other.agpInCodigo))) {
            return false;
        }
        if (this.agxInCodigo != other.agxInCodigo && (this.agxInCodigo == null || !this.agxInCodigo.equals(other.agxInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.agpInCodigo != null ? this.agpInCodigo.hashCode() : 0);
        hash = 97 * hash + (this.agxInCodigo != null ? this.agxInCodigo.hashCode() : 0);
        return hash;
    }


   

//    public LabAgendaPaciente getAgpInCodigo() {
//        return agpInCodigo;
//    }
//
//    public void setAgpInCodigo(LabAgendaPaciente agpInCodigo) {
//        this.agpInCodigo = agpInCodigo;
//    }
//
//    public Long getAgxInCodigo() {
//        return agxInCodigo;
//    }
//
//    public void setAgxInCodigo(Long agxInCodigo) {
//        this.agxInCodigo = agxInCodigo;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final LabAgendaPacienteExamePK other = (LabAgendaPacienteExamePK) obj;
//        if (this.agpInCodigo != other.agpInCodigo && (this.agpInCodigo == null || !this.agpInCodigo.equals(other.agpInCodigo))) {
//            return false;
//        }
//        if (this.agxInCodigo != other.agxInCodigo && (this.agxInCodigo == null || !this.agxInCodigo.equals(other.agxInCodigo))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 79 * hash + (this.agpInCodigo != null ? this.agpInCodigo.hashCode() : 0);
//        hash = 79 * hash + (this.agxInCodigo != null ? this.agxInCodigo.hashCode() : 0);
//        return hash;
//    }







}
