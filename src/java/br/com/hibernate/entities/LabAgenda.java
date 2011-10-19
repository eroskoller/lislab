/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.entities;

import java.io.Serializable;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 *
 * @author eros
 */


@Entity
@Table(name="LAB_AGENDA")
@IdClass(LabAgendaPK.class)
public class LabAgenda implements Serializable{



//    @Id
//    @ManyToOne
//    @JoinColumn(name="UNI_ST_CODIGO",nullable=false, updatable=false, insertable=false)
//    private LabUnidade uniStCodigo;//mappeded
    @Id
     @JoinColumns ({
        @JoinColumn(name="ALO_IN_CODIGO",referencedColumnName = "ALO_IN_CODIGO"),
        @JoinColumn(name="UNI_ST_CODIGO", referencedColumnName = "UNI_ST_CODIGO")
    })
    private LabAgendaLocal aloInCodigo;
    @Id
    @Column(name="AGE_IN_CODIGO",nullable=false, updatable=false, insertable=false)
    private Long ageInCodigo;

    public Long getAgeInCodigo() {
        return ageInCodigo;
    }

    public void setAgeInCodigo(Long ageInCodigo) {
        this.ageInCodigo = ageInCodigo;
    }

   

    


//    @EmbeddedId
//    private LabAgendaPK id;

//    @Id
//    @OneToOne
//    private LabUnidade uniStCodigo;//mappeded
//    @Id
//    @ManyToOne
//    @JoinColumn(name="ALO_IN_CODIGO")//mappeded
//    private LabAgendaLocal aloInCodigo;
//    @Id
//    @Column(name="AGE_IN_CODIGO")
//    private Long ageInCodigo;


  



    @Column(name="AGE_ST_DESCRICAO")
    private String ageStDescricao;//
//    @ManyToOne
//    @JoinColumns({
//        @JoinColumn(name="ORI_ST_CODIGO",nullable=false, updatable=false, insertable=false),
//        @JoinColumn(name="UNI_ST_CODIGO",nullable=false, updatable=false, insertable=false)
//    })
    @Column(name="ORI_ST_CODIGO")
    private String oriStCodigo;


    
    @Column(name="AGE_HR_INICIAL")
    private char ageHrInicial;//
    @Column(name="AGE_HR_FINAL")
    private char ageHrFinal;//
    @Column(name="AGE_IN_HORARIOS")
    private Integer ageInHorarios;//
    
    //private LabRequisicao reqInCodigo;//TODO mapping
    @Column(name="AGE_CH_SEGUNDA")
    private char ageChSegunda;//
    @Column(name="AGE_CH_TERCA")
    private char ageChTerca;//
    @Column(name="AGE_CH_QUARTA")
    private char ageChQuarta;//
    @Column(name="AGE_CH_QUINTA")
    private char ageChQuinta;//
    @Column(name="AGE_CH_SEXTA")
    private char ageChSexta;//
    @Column(name="AGE_CH_SABADO")
    private char ageChSabado;//
    @Column(name="AGE_CH_DOMINGO")
    private char ageChDomingo;//
    @Column(name="AGE_CH_FERIADO")
    private char ageChFeriado;//




    @OneToMany(mappedBy="ageInCodigo")
    private List<LabAgendaPaciente> listLabAgendaPaciente;

    public char getAgeChDomingo() {
        return ageChDomingo;
    }

    public void setAgeChDomingo(char ageChDomingo) {
        this.ageChDomingo = ageChDomingo;
    }

    public char getAgeChFeriado() {
        return ageChFeriado;
    }

    public void setAgeChFeriado(char ageChFeriado) {
        this.ageChFeriado = ageChFeriado;
    }

    public char getAgeChQuarta() {
        return ageChQuarta;
    }

    public void setAgeChQuarta(char ageChQuarta) {
        this.ageChQuarta = ageChQuarta;
    }

    public char getAgeChQuinta() {
        return ageChQuinta;
    }

    public void setAgeChQuinta(char ageChQuinta) {
        this.ageChQuinta = ageChQuinta;
    }

    public char getAgeChSabado() {
        return ageChSabado;
    }

    public void setAgeChSabado(char ageChSabado) {
        this.ageChSabado = ageChSabado;
    }

    public char getAgeChSegunda() {
        return ageChSegunda;
    }

    public void setAgeChSegunda(char ageChSegunda) {
        this.ageChSegunda = ageChSegunda;
    }

    public char getAgeChSexta() {
        return ageChSexta;
    }

    public void setAgeChSexta(char ageChSexta) {
        this.ageChSexta = ageChSexta;
    }

    public char getAgeChTerca() {
        return ageChTerca;
    }

    public void setAgeChTerca(char ageChTerca) {
        this.ageChTerca = ageChTerca;
    }

    public char getAgeHrFinal() {
        return ageHrFinal;
    }

    public void setAgeHrFinal(char ageHrFinal) {
        this.ageHrFinal = ageHrFinal;
    }

    public char getAgeHrInicial() {
        return ageHrInicial;
    }

    public void setAgeHrInicial(char ageHrInicial) {
        this.ageHrInicial = ageHrInicial;
    }

   

    public Integer getAgeInHorarios() {
        return ageInHorarios;
    }

    public void setAgeInHorarios(Integer ageInHorarios) {
        this.ageInHorarios = ageInHorarios;
    }

    public String getAgeStDescricao() {
        return ageStDescricao;
    }

    public void setAgeStDescricao(String ageStDescricao) {
        this.ageStDescricao = ageStDescricao;
    }

   

    
    public List<LabAgendaPaciente> getListLabAgendaPaciente() {
        return listLabAgendaPaciente;
    }

    public void setListLabAgendaPaciente(List<LabAgendaPaciente> listLabAgendaPaciente) {
        this.listLabAgendaPaciente = listLabAgendaPaciente;
    }

    public String getOriStCodigo() {
        return oriStCodigo;
    }

    public void setOriStCodigo(String oriStCodigo) {
        this.oriStCodigo = oriStCodigo;
    }

    public LabAgendaLocal getAloInCodigo() {
        return aloInCodigo;
    }

    public void setAloInCodigo(LabAgendaLocal aloInCodigo) {
        this.aloInCodigo = aloInCodigo;
    }

   
    
   


}
