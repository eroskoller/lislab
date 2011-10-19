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
import javax.persistence.Table;

/**
 *
 * @author eros
 */
@Entity
@Table(name="LAB_EXAMEDEPENDENTE")
@IdClass(LabExameDependentePK.class)
public class LabExameDependente  implements Serializable{

     @Id
    @Column(name="UNI_ST_CODIGO")
    private String uniStCodigo;
    @Id
    @Column(name="EXA_ST_CODIGO")
    private String exaStCodigo;
    @Id
    @Column(name="DEP_ST_CODIGO")
    private String depStCodigo;

    @Column(name="DEP_CH_FATURA")
    private Character depChFatura;
    @Column(name="DEP_CH_OMITE")
    private Character depChOmite;

    public Character getDepChFatura() {
        return depChFatura;
    }

    public void setDepChFatura(Character depChFatura) {
        this.depChFatura = depChFatura;
    }

    public Character getDepChOmite() {
        return depChOmite;
    }

    public void setDepChOmite(Character depChOmite) {
        this.depChOmite = depChOmite;
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

   



}
