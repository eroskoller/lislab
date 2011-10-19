/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author eros
 */

@Entity
@Table(name="LAB_SISTEMA")
@IdClass(LabSistemaPK.class)
public class LabSistema implements Serializable{

    @Id
    @Column(name="SIS_ST_CODIGO",nullable=false, updatable=false, insertable=false)
    private String sisStCodigo;
    @Id
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="UNI_ST_CODIGO")//mappeded
    private LabUnidade uniStCodigo;


    @Column(name="SIS_ST_SISTEMA")
    private String sisStSistema;
    @Column(name="SIS_ST_EMPRESA")
    private String sisStEmpresa;

  
    
    

    public String getSisStEmpresa() {
        return sisStEmpresa;
    }

    public void setSisStEmpresa(String sisStEmpresa) {
        this.sisStEmpresa = sisStEmpresa;
    }

    public String getSisStSistema() {
        return sisStSistema;
    }

    public void setSisStSistema(String sisStSistema) {
        this.sisStSistema = sisStSistema;
    }

    public String getSisStCodigo() {
        return sisStCodigo;
    }

    public void setSisStCodigo(String sisStCodigo) {
        this.sisStCodigo = sisStCodigo;
    }

    public LabUnidade getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(LabUnidade uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }

    




}
