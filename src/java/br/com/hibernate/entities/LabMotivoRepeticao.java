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
@Table(name="LAB_MOTIVOREPETICAO")
public class LabMotivoRepeticao implements Serializable{


    @Id
    @Column(name="MOR_ST_CODIGO")
    private String morStCodigo;
    @Column(name="MOR_ST_DESCRICAO")
    private String morStDescricao;

    public String getMorStCodigo() {
        return morStCodigo;
    }

    public void setMorStCodigo(String morStCodigo) {
        this.morStCodigo = morStCodigo;
    }

    public String getMorStDescricao() {
        return morStDescricao;
    }

    public void setMorStDescricao(String morStDescricao) {
        this.morStDescricao = morStDescricao;
    }


    


}
