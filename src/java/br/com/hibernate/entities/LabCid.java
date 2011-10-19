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
@Table(name="LAB_CID")
public class LabCid implements Serializable{

    @Id
    @Column(name="CID_ST_CODIGO")
    private String cidStCodigo;
    @Column(name="CID_ST_DESCRICAO")
    private String cidStDescricao;



    @OneToMany(mappedBy="cidStCodigo")
    private List<LabAgendaPaciente> listLabAgendaPaciente;

    public String getCidStCodigo() {
        return cidStCodigo;
    }

    public void setCidStCodigo(String cidStCodigo) {
        this.cidStCodigo = cidStCodigo;
    }

    public String getCidStDescricao() {
        return cidStDescricao;
    }

    public void setCidStDescricao(String cidStDescricao) {
        this.cidStDescricao = cidStDescricao;
    }

    public List<LabAgendaPaciente> getListLabAgendaPaciente() {
        return listLabAgendaPaciente;
    }

    public void setListLabAgendaPaciente(List<LabAgendaPaciente> listLabAgendaPaciente) {
        this.listLabAgendaPaciente = listLabAgendaPaciente;
    }

    
    

}
