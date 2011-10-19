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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author eros
 */
@Entity
@Table(name="LAB_USUARIOUNIDADE")
@IdClass(LabUsuarioUnidadePK.class)
public class LabUsuarioUnidade implements Serializable  {

    @Id
    @Column(name="UNI_ST_CODIGO")
    private String uniStCodigo;
    @Id
    @ManyToOne(targetEntity=LabUsuario.class)
    @JoinColumn(name="USU_ST_CODIGO")
    private LabUsuario usuStCodigo;



    public String getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(String uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }

    public LabUsuario getUsuStCodigo() {
        return usuStCodigo;
    }

    public void setUsuStCodigo(LabUsuario usuStCodigo) {
        this.usuStCodigo = usuStCodigo;
    }

  

   
  
 


}
