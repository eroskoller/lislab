/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author eros
 */
@Entity
@Table(name="LAB_GRUPOTRIAGEM")
public class LabGrupoTriagem implements Serializable{

    
    @Id
    @Column(name="GRR_ST_CODIGO")
    private String gtrStCodigo;
    
    @Column(name="GRR_ST_DESCRICAO")
    private String gtrStDescricao;
    @Column(name="GRR_CH_TRIAGEM")
    private Character gtrChTriagem;
    @Column(name="GRR_IN_FONTE")
    private Integer gtrInCorFonte;
    @Column(name="GRR_IN_FUNDO")
    private Integer gtrInCorFundo;

    
    public LabGrupoTriagem() {
    }

    


    public Character getGtrChTriagem() {
        return gtrChTriagem;
    }

    public void setGtrChTriagem(Character gtrChTriagem) {
        this.gtrChTriagem = gtrChTriagem;
    }

    public Integer getGtrInCorFonte() {
        return this.gtrInCorFonte;
    }

    public void setGtrInCorFonte(Integer gtrInCorFonte) {
        this.gtrInCorFonte = gtrInCorFonte;
    }

    public Integer getGtrInCorFundo() {
        return gtrInCorFundo;
    }

    public void setGtrInCorFundo(Integer gtrInCorFundo) {
        this.gtrInCorFundo = gtrInCorFundo;
    }

    public String getGtrStCodigo() {
        return gtrStCodigo;
    }

    public void setGtrStCodigo(String gtrStCodigo) {
        this.gtrStCodigo = gtrStCodigo;
    }

    public String getGtrStDescricao() {
        return gtrStDescricao;
    }

    public void setGtrStDescricao(String gtrStDescricao) {
        this.gtrStDescricao = gtrStDescricao;
    }

    

}
