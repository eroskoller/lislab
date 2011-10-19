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
@Table(name="LAB_SEQUENCIAAMOSTRA")
public class LabSequenciaAmostra implements Serializable{


    @Id
    @Column(name="SEQ_ST_CODIGO")
    private String seqStCodigo;
    @Column(name="SEQ_ST_DESCRICAO")
    private String seqStDescricao;

    public String getSeqStCodigo() {
        return seqStCodigo;
    }

    public void setSeqStCodigo(String seqStCodigo) {
        this.seqStCodigo = seqStCodigo;
    }

    public String getSeqStDescricao() {
        return seqStDescricao;
    }

    public void setSeqStDescricao(String seqStDescricao) {
        this.seqStDescricao = seqStDescricao;
    }


    


}
