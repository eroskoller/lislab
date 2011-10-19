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
@Table(name="LAB_MATERIAL")
public class LabMaterial implements Serializable{

    @Id
    @Column(name="MAT_ST_CODIGO")

    
    private String matStCodigo;
    @Column(name="MAT_ST_DESCRICAO")
    private String matStDescricao;

    public String getMatStCodigo() {
        return matStCodigo;
    }

    public void setMatStCodigo(String matStCodigo) {
        this.matStCodigo = matStCodigo;
    }

    public String getMatStDescricao() {
        return matStDescricao;
    }

    public void setMatStDescricao(String matStDescricao) {
        this.matStDescricao = matStDescricao;
    }

    

}
