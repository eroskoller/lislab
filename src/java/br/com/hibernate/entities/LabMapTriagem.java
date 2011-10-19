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
@Table(name="LAB_MAPTRIAGEM")
@IdClass(LabMapaTriagemPK.class)
public class LabMapTriagem implements Serializable{

    @Id
    @Column(name="UNI_ST_CODIGO")
    private String uniStCodigo;
    @Id
    @Column(name="GTR_ST_CODIGO")
    private String gtrStCodigo;
    @Id
    @Column(name="REC_ST_CODIGO")
    private String recStCodigo;
    @Id
    @Column(name="EXA_ST_CODIGO")
    private String exaStCodigo;

    @Column(name="MTR_ST_ETIQUETA")
    private Character mtrChEtiqueta;
    @Column(name="MTR_ST_TRIAGEM")
    private Character mtrChTriagem;
    @Column(name="MTR_ST_PADRAO")
    private Character mtrChPadrao;

    public String getExaStCodigo() {
        return exaStCodigo;
    }

    public void setExaStCodigo(String exaStCodigo) {
        this.exaStCodigo = exaStCodigo;
    }

    public String getGtrStCodigo() {
        return gtrStCodigo;
    }

    public void setGtrStCodigo(String gtrStCodigo) {
        this.gtrStCodigo = gtrStCodigo;
    }

    public Character getMtrChEtiqueta() {
        return mtrChEtiqueta;
    }

    public void setMtrChEtiqueta(Character mtrChEtiqueta) {
        this.mtrChEtiqueta = mtrChEtiqueta;
    }

    public Character getMtrChPadrao() {
        return mtrChPadrao;
    }

    public void setMtrChPadrao(Character mtrChPadrao) {
        this.mtrChPadrao = mtrChPadrao;
    }

    public Character getMtrChTriagem() {
        return mtrChTriagem;
    }

    public void setMtrChTriagem(Character mtrChTriagem) {
        this.mtrChTriagem = mtrChTriagem;
    }

    public String getRecStCodigo() {
        return recStCodigo;
    }

    public void setRecStCodigo(String recStCodigo) {
        this.recStCodigo = recStCodigo;
    }

    public String getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(String uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }


    

}
