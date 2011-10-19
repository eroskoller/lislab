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

import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author eros
 */
@Entity
@Table(name="LAB_AGENDALOCAL")
@IdClass(LabAgendaLocalPK.class)
public class LabAgendaLocal implements Serializable{

//    @Id
//    private Long aloInCodigo;


    @Id
    @Column(name="ALO_IN_CODIGO")
    private Long aloInCodigo;
    @Id
    @ManyToOne
    @JoinColumn(name="UNI_ST_CODIGO")
    private LabUnidade uniStCodigo;

    public Long getAloInCodigo() {
        return aloInCodigo;
    }

    public void setAloInCodigo(Long aloInCodigo) {
        this.aloInCodigo = aloInCodigo;
    }

    public LabUnidade getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(LabUnidade uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }

   


    @Column(name="ALO_ST_DESCRICAO")
    private String aloStDescricao;
    

//    @ManyToOne
//     @JoinColumns({
//        @JoinColumn(name="ORI_ST_CODIGO"),
//        @JoinColumn(name="UNI_ST_CODIGO")
//    })//mappeded
    @Column(name="ORI_ST_CODIGO")
    private String oriStCodigo; //mappeded
    @Column(name="ALO_CH_TIPO")
    private char aloChTipo;



//    @OneToMany(mappedBy="aloInCodigo")
//    private List<LabRequisicao> listLabRequisicao;

//    @OneToMany(mappedBy="aloInCodigo")
//    private List<LabAgenda> listLabAgenda;



   
    


    public char getAloChTipo() {
        return aloChTipo;
    }

    public void setAloChTipo(char aloChTipo) {
        this.aloChTipo = aloChTipo;
    }


    public String getAloStDescricao() {
        return aloStDescricao;
    }

    public void setAloStDescricao(String aloStDescricao) {
        this.aloStDescricao = aloStDescricao;
    }

    public String getOriStCodigo() {
        return oriStCodigo;
    }

    public void setOriStCodigo(String oriStCodigo) {
        this.oriStCodigo = oriStCodigo;
    }

   
   
    
}
