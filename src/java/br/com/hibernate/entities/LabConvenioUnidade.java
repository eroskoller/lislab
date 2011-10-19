/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author eros
 */
@Entity
@Table(name="LAB_CONVENIOUNIDADE")
@IdClass(LabConvenioUnidadePK.class)
public class LabConvenioUnidade  implements Serializable {

    //there is no ID define for thie entity hierarchy
    @Id
    @Column(name="UNI_ST_CODIGO")
    private String uniStCodigo;
    @Id
    @ManyToOne
    @JoinColumn(name="CON_ST_CODIGO")
    private LabConvenio conStCodigo;

    @Column(name="CUN_CH_ATIVO")
    private Character cunChAtivo;

    public LabConvenio getConStCodigo() {
        return conStCodigo;
    }

    public void setConStCodigo(LabConvenio conStCodigo) {
        this.conStCodigo = conStCodigo;
    }

    public Character getCunChAtivo() {
        return cunChAtivo;
    }

    public void setCunChAtivo(Character cunChAtivo) {
        this.cunChAtivo = cunChAtivo;
    }

   
    public String getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(String uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }

   
            


}
