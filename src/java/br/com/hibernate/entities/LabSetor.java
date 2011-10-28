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
import javax.persistence.Table;

/**
 *
 * @author eros
 */
@Entity
@Table(name="LAB_SETOR")
@IdClass(LabSetorPK.class)
public class LabSetor implements Serializable{

    @Id
//    @ManyToOne
//    @JoinColumn(name="UNI_ST_CODIGO")
    @Column(name="UNI_ST_CODIGO")
    private String uniStCodigo;
    @Id
    @Column(name="SET_ST_CODIGO")
    private String setStCodigo;

    @Column(name="SET_ST_DESCRICAO")
    private String setStDescricao;
    @Column(name="SET_IN_SEQUENCIA")
    private Long setInSequencia;
    @Column(name="SET_IN_DESCARTE")
    private Long setInDescarte;
    @Column(name="SET_IN_COR")
    private Long setInCor;

    public Long getSetInCor() {
        return setInCor;
    }

    public void setSetInCor(Long setInCor) {
        this.setInCor = setInCor;
    }

    public Long getSetInDescarte() {
        return setInDescarte;
    }

    public void setSetInDescarte(Long setInDescarte) {
        this.setInDescarte = setInDescarte;
    }

    public Long getSetInSequencia() {
        return setInSequencia;
    }

    public void setSetInSequencia(Long setInSequencia) {
        this.setInSequencia = setInSequencia;
    }

    public String getSetStCodigo() {
        return setStCodigo;
    }

    public void setSetStCodigo(String setStCodigo) {
        this.setStCodigo = setStCodigo;
    }

    public String getSetStDescricao() {
        return setStDescricao;
    }

    public void setSetStDescricao(String setStDescricao) {
        this.setStDescricao = setStDescricao;
    }

    public String getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(String uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }

    




}
