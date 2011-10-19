/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.entities;

import java.io.Serializable;
import java.sql.Timestamp;
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
@Table(name="LAB_EXAMEMETODOVERSAO")
@IdClass(LabExameMetodoVersaoPK.class)
public class LabExameMetodoVersao implements Serializable {

    @Id
    @Column(name="EXA_ST_CODIGO")
    private String exaStCodigo;
    @Id
    @Column(name="MET_ST_CODIGO")
    private String metStCodigo;
    @Id
    @Column(name="EMV_DT_VALIDADE")
    private java.sql.Timestamp emvDtValidade;


    @Column(name="EMV_BL_LAUDO")
    private String emvBlLaudo;
    @Column(name="EMV_FL_TAMANHOLAUDO")
    private Float emvFlTamanhoLaudo;
    @Column(name="EMV_CH_IMPRIMESOZINHO")
    private Character emvChImprimesozinho;
    @Column(name="EMV_CH_ATIVO")
    private Character emvChAtivo;
    @Column(name="EMV_IN_FOLHASEQ")
    private Integer emvInFolhaSeq;
    @Column(name="EMV_IN_FOLHA")
    private Integer emvInFolha;
    @Column(name="TEMP")
    private Integer temp;
    @Column(name="TEMPSEQ")
    private Integer tempSeq;
    @Column(name="EMV_BL_CHECKFORMULA")
    private String emvBlCheckFormula;
    @Column(name="EMV_BL_LAUDO1")
    private String emvBlLaudo1;
    @Column(name="EMV_CL_LAUDO")
    private String emvClLaudo;
    @Column(name="EMV_CL_CHECKFORMULA")
    private String emvClCheckFormula;

    public String getEmvBlCheckFormula() {
        return emvBlCheckFormula;
    }

    public void setEmvBlCheckFormula(String emvBlCheckFormula) {
        this.emvBlCheckFormula = emvBlCheckFormula;
    }

    public String getEmvBlLaudo() {
        return emvBlLaudo;
    }

    public void setEmvBlLaudo(String emvBlLaudo) {
        this.emvBlLaudo = emvBlLaudo;
    }

    public String getEmvBlLaudo1() {
        return emvBlLaudo1;
    }

    public void setEmvBlLaudo1(String emvBlLaudo1) {
        this.emvBlLaudo1 = emvBlLaudo1;
    }

    public Character getEmvChAtivo() {
        return emvChAtivo;
    }

    public void setEmvChAtivo(Character emvChAtivo) {
        this.emvChAtivo = emvChAtivo;
    }

    public Character getEmvChImprimesozinho() {
        return emvChImprimesozinho;
    }

    public void setEmvChImprimesozinho(Character emvChImprimesozinho) {
        this.emvChImprimesozinho = emvChImprimesozinho;
    }

    public String getEmvClCheckFormula() {
        return emvClCheckFormula;
    }

    public void setEmvClCheckFormula(String emvClCheckFormula) {
        this.emvClCheckFormula = emvClCheckFormula;
    }

    public String getEmvClLaudo() {
        return emvClLaudo;
    }

    public void setEmvClLaudo(String emvClLaudo) {
        this.emvClLaudo = emvClLaudo;
    }

    public Timestamp getEmvDtValidade() {
        return emvDtValidade;
    }

    public void setEmvDtValidade(Timestamp emvDtValidade) {
        this.emvDtValidade = emvDtValidade;
    }

    public Float getEmvFlTamanhoLaudo() {
        return emvFlTamanhoLaudo;
    }

    public void setEmvFlTamanhoLaudo(Float emvFlTamanhoLaudo) {
        this.emvFlTamanhoLaudo = emvFlTamanhoLaudo;
    }

    public Integer getEmvInFolha() {
        return emvInFolha;
    }

    public void setEmvInFolha(Integer emvInFolha) {
        this.emvInFolha = emvInFolha;
    }

    public Integer getEmvInFolhaSeq() {
        return emvInFolhaSeq;
    }

    public void setEmvInFolhaSeq(Integer emvInFolhaSeq) {
        this.emvInFolhaSeq = emvInFolhaSeq;
    }

    public String getExaStCodigo() {
        return exaStCodigo;
    }

    public void setExaStCodigo(String exaStCodigo) {
        this.exaStCodigo = exaStCodigo;
    }

    public String getMetStCodigo() {
        return metStCodigo;
    }

    public void setMetStCodigo(String metStCodigo) {
        this.metStCodigo = metStCodigo;
    }

    public Integer getTemp() {
        return temp;
    }

    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    public Integer getTempSeq() {
        return tempSeq;
    }

    public void setTempSeq(Integer tempSeq) {
        this.tempSeq = tempSeq;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LabExameMetodoVersao other = (LabExameMetodoVersao) obj;
        if ((this.exaStCodigo == null) ? (other.exaStCodigo != null) : !this.exaStCodigo.equals(other.exaStCodigo)) {
            return false;
        }
        if ((this.metStCodigo == null) ? (other.metStCodigo != null) : !this.metStCodigo.equals(other.metStCodigo)) {
            return false;
        }
        if (this.emvDtValidade != other.emvDtValidade && (this.emvDtValidade == null || !this.emvDtValidade.equals(other.emvDtValidade))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + (this.exaStCodigo != null ? this.exaStCodigo.hashCode() : 0);
        hash = 23 * hash + (this.metStCodigo != null ? this.metStCodigo.hashCode() : 0);
        hash = 23 * hash + (this.emvDtValidade != null ? this.emvDtValidade.hashCode() : 0);
        return hash;
    }
    

}
