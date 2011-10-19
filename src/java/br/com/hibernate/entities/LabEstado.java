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
@Table(name="LAB_ESTADO")
public class LabEstado implements Serializable{


    @Id
    @Column(name="EST_IN_CODIGO")
    private Long estInCodigo;
    @Column(name="EST_ST_UF")
    private String estStUF;
    @Column(name="EST_ST_DESCRICAO")
    private String estStDescricao;

    public Long getEstInCodigo() {
        return estInCodigo;
    }

    public void setEstInCodigo(Long estInCodigo) {
        this.estInCodigo = estInCodigo;
    }

    public String getEstStDescricao() {
        return estStDescricao;
    }

    public void setEstStDescricao(String estStDescricao) {
        this.estStDescricao = estStDescricao;
    }

    public String getEstStUF() {
        return estStUF;
    }

    public void setEstStUF(String estStUF) {
        this.estStUF = estStUF;
    }


    

}
