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
@Table(name="LAB_UNIDADEMEDIDA")
public class LabUnidadeMedida implements Serializable {

    @Id
    @Column(name="UNM_ST_CODIGO")
    private String unmStCodigo;
    @Column(name="UNM_ST_DESCRICAO")
    private String unmStDescricao;

    public String getUnmStCodigo() {
        return unmStCodigo;
    }

    public void setUnmStCodigo(String unmStCodigo) {
        this.unmStCodigo = unmStCodigo;
    }

    public String getUnmStDescricao() {
        return unmStDescricao;
    }

    public void setUnmStDescricao(String unmStDescricao) {
        this.unmStDescricao = unmStDescricao;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LabUnidadeMedida other = (LabUnidadeMedida) obj;
        if ((this.unmStCodigo == null) ? (other.unmStCodigo != null) : !this.unmStCodigo.equals(other.unmStCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.unmStCodigo != null ? this.unmStCodigo.hashCode() : 0);
        return hash;
    }


}
