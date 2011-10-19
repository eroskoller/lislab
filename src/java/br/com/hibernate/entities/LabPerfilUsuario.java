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
@Table(name="LAB_PERFILUSUARIO")
public class LabPerfilUsuario implements Serializable{

    @Id
    @Column(name="PUS_ST_CODIGO")
    private String pusStCodigo;
     @Column(name="PUS_ST_DESCRICAO")
    private String pusStDescricao;

    public String getPusStCodigo() {
        return pusStCodigo;
    }

    public void setPusStCodigo(String pusStCodigo) {
        this.pusStCodigo = pusStCodigo;
    }

    public String getPusStDescricao() {
        return pusStDescricao;
    }

    public void setPusStDescricao(String pusStDescricao) {
        this.pusStDescricao = pusStDescricao;
    }


     

}
