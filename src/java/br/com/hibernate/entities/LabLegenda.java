/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author eros
 */
@Entity
@Table(name="LAB_LEGENDA")
public class LabLegenda implements Serializable{


    @Id
    @Column(name="LEG_ST_CODIGO")
    private String legStCodigo;

    
    @Column(name="LEG_ST_DESCRICAO")
    private String legStDescricao;
    @Column(name="LEG_ST_SIGLA")
    private String legStSigla;
    @Column(name="LEG_IN_FONTE")
    private Integer legInFonte;
    @Column(name="LEG_IN_COR")
    private Integer legInCor;


    @OneToMany(mappedBy="legStCodigo")
    private List<LabRequisicao> listLabRequisicao;

    public List<LabRequisicao> getListLabRequisicao() {
        return listLabRequisicao;
    }

    public void setListLabRequisicao(List<LabRequisicao> listLabRequisicao) {
        this.listLabRequisicao = listLabRequisicao;
    }

    
    public Integer getLegInCor() {
        return legInCor;
    }

    public void setLegInCor(Integer legInCor) {
        this.legInCor = legInCor;
    }

    public Integer getLegInFonte() {
        return legInFonte;
    }

    public void setLegInFonte(Integer legInFonte) {
        this.legInFonte = legInFonte;
    }

    public String getLegStCodigo() {
        return legStCodigo;
    }

    public void setLegStCodigo(String legStCodigo) {
        this.legStCodigo = legStCodigo;
    }

    public String getLegStDescricao() {
        return legStDescricao;
    }

    public void setLegStDescricao(String legStDescricao) {
        this.legStDescricao = legStDescricao;
    }

    public String getLegStSigla() {
        return legStSigla;
    }

    public void setLegStSigla(String legStSigla) {
        this.legStSigla = legStSigla;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LabLegenda other = (LabLegenda) obj;
        if ((this.legStCodigo == null) ? (other.legStCodigo != null) : !this.legStCodigo.equals(other.legStCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.legStCodigo != null ? this.legStCodigo.hashCode() : 0);
        return hash;
    }



}
