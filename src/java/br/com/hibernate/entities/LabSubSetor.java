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
@Table(name="LAB_SUBSETOR")
@IdClass(LabSubSetorPK.class)
public class LabSubSetor implements Serializable{

    @Id
    @Column(name="UNI_ST_CODIGO")
    private String uniStCodigo;
    @Id
    @Column(name="SET_ST_CODIGO")
    private String setStCodigo;
    @Id
    @Column(name="SUB_ST_CODIGO")
    private String subStCodigo;

    @Column(name="SUB_ST_DESCRICAO")
    private String subStDescricao;


    @Column(name="SUB_IN_SEQUENCIA")
    private Integer subInSequencia;

    public String getSetStCodigo() {
        return setStCodigo;
    }

    public void setSetStCodigo(String setStCodigo) {
        this.setStCodigo = setStCodigo;
    }

    public Integer getSubInSequencia() {
        return subInSequencia;
    }

    public void setSubInSequencia(Integer subInSequencia) {
        this.subInSequencia = subInSequencia;
    }

    public String getSubStCodigo() {
        return subStCodigo;
    }

    public void setSubStCodigo(String subStCodigo) {
        this.subStCodigo = subStCodigo;
    }

    public String getSubStDescricao() {
        return subStDescricao;
    }

    public void setSubStDescricao(String subStDescricao) {
        this.subStDescricao = subStDescricao;
    }

    public String getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(String uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }


    
}
