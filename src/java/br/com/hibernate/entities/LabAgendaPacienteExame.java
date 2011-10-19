/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author eros
 */
@Entity
@Table(name="LAB_AGENDAPACIENTEEXAME")
@IdClass(LabAgendaPacienteExamePK.class)
public class LabAgendaPacienteExame implements Serializable{


       @Id
       @ManyToOne
       @JoinColumn(name="AGP_IN_CODIGO")
       private LabAgendaPaciente agpInCodigo;

       @Id
       @Column(name="AGX_IN_CODIGO",nullable=false, updatable=false, insertable=false)
       private Long agxInCodigo;



        @ManyToOne
        @JoinColumn(name="EXA_ST_CODIGO")//mappeded
        private LabExame exaStCodigo;
        @Column(name="AGX_IN_STATUS")
        private Integer agxInStatus;

   

    public Integer getAgxInStatus() {
        return agxInStatus;
    }

    public void setAgxInStatus(Integer agxInStatus) {
        this.agxInStatus = agxInStatus;
    }

    public LabExame getExaStCodigo() {
        return exaStCodigo;
    }

    public void setExaStCodigo(LabExame exaStCodigo) {
        this.exaStCodigo = exaStCodigo;
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

   

    

    
}
