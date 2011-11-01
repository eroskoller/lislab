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
import javax.persistence.Transient;

/**
 *
 * @author eros
 */


@Entity
@Table(name="LAB_ORIGEM")
@IdClass(LabOrigemPK.class)
public class LabOrigem implements Serializable{



    @Id
    @Column(name="ORI_ST_CODIGO")
    private String oriStCodigo;
    @Id
//    @ManyToOne
    @Column(name="UNI_ST_CODIGO")
    private String uniStCodigo;



    @Column(name="ORI_ST_DESCRICAO")
    private String oriStDescricao;
    @Column(name="ORI_CH_IMPRIMECOLETA")
    private Character oriChImprimeColeta;
    @Column(name="ORI_ST_ESTADO")
    private String oriStEstado;
    @Column(name="ORI_IN_CIDADE")
    private Integer oriInCidade;
    @Column(name="ORI_IN_BAIRRO")
    private Integer oriInBairro;
    @Column(name="ORI_ST_CEP")
    private String oriStCep;
    @Column(name="ORI_IN_NUMERO")
    private Integer oriInNumero;
    @Column(name="ORI_ST_CIDADE")
    private String oriStCidade;
    @Column(name="ORI_ST_BAIRRO")
    private String oriStBairro;
    @Column(name="ORI_ST_ENDERECO")
    private String oriStEndereco;
    @Column(name="ORI_CH_URGENCIA")
    private Character oriChUrgencia;
    @Column(name="ORI_ST_COMPLEMENTO")
    private String oriStComplemento;
    @Column(name="ORI_ST_EMAIL")
    private String oriStEmail;
    @Column(name="ORI_ST_CONTATO")
    private String oriStContato;
    @Column(name="ORI_ST_TELEFONE")
    private String oriStTelefone;
    @Column(name="ORI_ST_CELULAR")
    private String oriStCelular;
    @Column(name="ORI_ST_FAX")
    private String oriStFax;
    @ManyToOne
    @JoinColumn(name="CON_ST_CODIGO")//mappeded
    private LabConvenio conStCodigo;

    @Column(name="REG_ST_CODIGO")
    private String regStCodigo;
    @Column(name="LOC_ST_CODIGO")
    private String locStCodigo;
    @Column(name="ORI_CH_LOC_ST_CODIGO")
    private char oriChLocStCodigo;
    @Column(name="ORI_CH_COL_ST_CODIGO")
    private char oriChColStCodigo;
    @Column(name="ORI_CH_ETIQUETACOMPROVA")
    private char oriChEtiquetaComprova;
    @Column(name="ORI_ST_ITEM_EMS")
    private String oriStItemEMS;
    @Column(name="ORI_ST_EMSCODCLI")
    private String oriStEmsCodCli;
    @Column(name="LEG_ST_CODIGOINICIAL")
    private String legStCodigoInicial;
    @Column(name="LEG_ST_CODIGOFINAL")
    private String legStCodigoFinal;


 


//    @OneToMany(mappedBy="oriStCodigo")
//    private List<LabAgenda> listLabAgenda;

//    @OneToMany(mappedBy="oriStCodigo")
//    private List<LabAgendaPaciente> listLabAgendaPaciente;

//    @OneToMany(mappedBy="oriStCodigo")
//    private List<LabRequisicao> listLabRequisicao;

    public LabOrigem() {
    }

    public LabOrigem(String oriStCodigo, String uniStCodigo) {
        this.oriStCodigo = oriStCodigo;
        this.uniStCodigo = uniStCodigo;
    }

   



    
    public LabConvenio getConStCodigo() {
        return conStCodigo;
    }

    public void setConStCodigo(LabConvenio conStCodigo) {
        this.conStCodigo = conStCodigo;
    }

    public String getLocStCodigo() {
        return locStCodigo;
    }

    public void setLocStCodigo(String locStCodigo) {
        this.locStCodigo = locStCodigo;
    }

   

    public char getOriChColStCodigo() {
        return oriChColStCodigo;
    }

    public void setOriChColStCodigo(char oriChColStCodigo) {
        this.oriChColStCodigo = oriChColStCodigo;
    }

    
    public char getOriChEtiquetaComprova() {
        return oriChEtiquetaComprova;
    }

    public void setOriChEtiquetaComprova(char oriChEtiquetaComprova) {
        this.oriChEtiquetaComprova = oriChEtiquetaComprova;
    }

    public Character getOriChImprimeColeta() {
        return oriChImprimeColeta;
    }

    public void setOriChImprimeColeta(Character oriChImprimeColeta) {
        this.oriChImprimeColeta = oriChImprimeColeta;
    }


  

    public char getOriChLocStCodigo() {
        return oriChLocStCodigo;
    }

    public void setOriChLocStCodigo(char oriChLocStCodigo) {
        this.oriChLocStCodigo = oriChLocStCodigo;
    }

    public Character getOriChUrgencia() {
        return oriChUrgencia;
    }

    public void setOriChUrgencia(Character oriChUrgencia) {
        this.oriChUrgencia = oriChUrgencia;
    }

 

    public Integer getOriInBairro() {
        return oriInBairro;
    }

    public void setOriInBairro(Integer oriInBairro) {
        this.oriInBairro = oriInBairro;
    }

    public Integer getOriInCidade() {
        return oriInCidade;
    }

    public void setOriInCidade(Integer oriInCidade) {
        this.oriInCidade = oriInCidade;
    }

    public Integer getOriInNumero() {
        return oriInNumero;
    }

    public void setOriInNumero(Integer oriInNumero) {
        this.oriInNumero = oriInNumero;
    }

    public String getOriStBairro() {
        return oriStBairro;
    }

    public void setOriStBairro(String oriStBairro) {
        this.oriStBairro = oriStBairro;
    }

    public String getOriStCelular() {
        return oriStCelular;
    }

    public void setOriStCelular(String oriStCelular) {
        this.oriStCelular = oriStCelular;
    }

    public String getOriStCep() {
        return oriStCep;
    }

    public void setOriStCep(String oriStCep) {
        this.oriStCep = oriStCep;
    }

    public String getOriStCidade() {
        return oriStCidade;
    }

    public void setOriStCidade(String oriStCidade) {
        this.oriStCidade = oriStCidade;
    }

    public String getRegStCodigo() {
        return regStCodigo;
    }

    public void setRegStCodigo(String regStCodigo) {
        this.regStCodigo = regStCodigo;
    }

    public String getOriStComplemento() {
        return oriStComplemento;
    }

    public void setOriStComplemento(String oriStComplemento) {
        this.oriStComplemento = oriStComplemento;
    }

    public String getOriStContato() {
        return oriStContato;
    }

    public void setOriStContato(String oriStContato) {
        this.oriStContato = oriStContato;
    }

    public String getOriStDescricao() {
        return oriStDescricao;
    }
    @Transient
    public String getOriStDescricaoResumida() {
        if(this.oriStDescricao != null && oriStDescricao.length()>13){
            return  oriStDescricao.substring(0, 10)+"...";
        }else{
            return  oriStDescricao;
        }
        
    }

    public void setOriStDescricao(String oriStDescricao) {
        this.oriStDescricao = oriStDescricao;
    }

    public String getOriStEmail() {
        return oriStEmail;
    }

    public void setOriStEmail(String oriStEmail) {
        this.oriStEmail = oriStEmail;
    }

    public String getOriStEmsCodCli() {
        return oriStEmsCodCli;
    }

    public void setOriStEmsCodCli(String oriStEmsCodCli) {
        this.oriStEmsCodCli = oriStEmsCodCli;
    }

    public String getOriStEndereco() {
        return oriStEndereco;
    }

    public void setOriStEndereco(String oriStEndereco) {
        this.oriStEndereco = oriStEndereco;
    }

    public String getOriStEstado() {
        return oriStEstado;
    }

    public void setOriStEstado(String oriStEstado) {
        this.oriStEstado = oriStEstado;
    }

    public String getOriStFax() {
        return oriStFax;
    }

    public void setOriStFax(String oriStFax) {
        this.oriStFax = oriStFax;
    }

    public String getOriStItemEMS() {
        return oriStItemEMS;
    }

    public void setOriStItemEMS(String oriStItemEMS) {
        this.oriStItemEMS = oriStItemEMS;
    }

    public String getOriStTelefone() {
        return oriStTelefone;
    }

    public void setOriStTelefone(String oriStTelefone) {
        this.oriStTelefone = oriStTelefone;
    }

    public String getOriStCodigo() {
        return oriStCodigo;
    }

    public void setOriStCodigo(String oriStCodigo) {
        this.oriStCodigo = oriStCodigo;
    }

    public String getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(String uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }

    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LabOrigem other = (LabOrigem) obj;
        if ((this.oriStCodigo == null) ? (other.oriStCodigo != null) : !this.oriStCodigo.equals(other.oriStCodigo)) {
            return false;
        }
        if (this.uniStCodigo != other.uniStCodigo && (this.uniStCodigo == null || !this.uniStCodigo.equals(other.uniStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.oriStCodigo != null ? this.oriStCodigo.hashCode() : 0);
        hash = 83 * hash + (this.uniStCodigo != null ? this.uniStCodigo.hashCode() : 0);
        return hash;
    }

   

   



}
