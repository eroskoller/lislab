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
@Table(name="LAB_MATERIALCOLETA")
public class LabMaterialColeta implements Serializable{


    @Id
    @Column(name="MTC_IN_CODIGO")
    private Long mtcInCodigo;
    @Column(name="MTC_ST_CODIGO")
    private String mtcStCodigo;
    @Column(name="MTC_ST_DESCRICAO")
    private String mtcStDescricao;

    public Long getMtcInCodigo() {
        return mtcInCodigo;
    }

    public void setMtcInCodigo(Long mtcInCodigo) {
        this.mtcInCodigo = mtcInCodigo;
    }

    public String getMtcStCodigo() {
        return mtcStCodigo;
    }

    public void setMtcStCodigo(String mtcStCodigo) {
        this.mtcStCodigo = mtcStCodigo;
    }

    public String getMtcStDescricao() {
        return mtcStDescricao;
    }

    public void setMtcStDescricao(String mtcStDescricao) {
        this.mtcStDescricao = mtcStDescricao;
    }
    



}
