/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.entities;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import br.com.utils.tipstricks.*;

/**
 *
 * @author eros
 */

@Entity
@Table(name="LAB_LOCAL")
@IdClass(LabLocalPK.class)
public class LabLocal implements Serializable{



    @Id
    @ManyToOne
    @JoinColumn(name="UNI_ST_CODIGO")
    private LabUnidade uniStCodigo;
    @Id
    @Column(name="LOC_ST_CODIGO",nullable=false, updatable=false, insertable=false)
    private String locStCodigo;

    @Column(name="LOC_ST_DESCRICAO")
    private String locStDescricao;



//    @OneToMany(mappedBy="locStCodigo")
//    private List<LabAgendaPaciente> listLabAgendaPaciente;


//    @OneToMany(mappedBy="regStCodigo")
//    private List<LabOrigem> listLabOrigem;

//    @OneToMany(mappedBy="locStCodigo")
//    private List<LabRequisicao> listLabRequisicao

    public String getLocStDescricao() {
        return locStDescricao;
    }
    
    public String getLocStDescricaoResumida() {
        return DescricaoResumida.descResuminda(locStDescricao, 10);
    }

    public void setLocStDescricao(String locStDescricao) {
        this.locStDescricao = locStDescricao;
    }

    public String getLocStCodigo() {
        return locStCodigo;
    }

    public void setLocStCodigo(String locStCodigo) {
        this.locStCodigo = locStCodigo;
    }

    public LabUnidade getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(LabUnidade uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }

    

  

   
    

    
    

}
