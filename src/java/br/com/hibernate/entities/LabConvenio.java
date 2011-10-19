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
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author eros
 */
@Entity
@Table(name="LAB_CONVENIO")
public class LabConvenio implements Serializable{



    @Id
    @Column(name="CON_ST_CODIGO")
    private String conStCodigo;
    @Column(name="CON_ST_DESCRICAO")
    private String conStDescricao;
    @Column(name="CON_ST_RAZAOSOCIAL")
    private String conStRazaoSocial;
    @Column(name="CON_ST_CNPJ")
    private String conStCNPJ;
    @Column(name="CON_ST_INSCESTADUAL")
    private String conStInscEstadual;
    @Column(name="CON_ST_NUMERO")
    private String conStNumero;
    @Column(name="CON_ST_CEP")
    private String conStCEP;
    @Column(name="CON_ST_ENDERECO")
    private String conStEndereco;
    @Column(name="CON_ST_COMPLEMENTO")
    private String conStComplemento;
    @Column(name="CON_ST_CIDADE")
    private String conStCidade;
    @Column(name="CON_ST_UF")
    private String conStUf;
    @Column(name="CON_ST_FONE")
    private String conStFone;
    @Column(name="CON_ST_FAX")
    private String conStFax;
    @Column(name="CON_ST_CONTATO")
    private String conStContato;
    @Column(name="CON_ST_EMAIL")
    private String conStEmail;
    @Column(name="CON_ST_SITE")
    private String conStSite;
    @Column(name="CON_ST_USUARIO_RESP")
    private String conStUsuarioResp;
    @Column(name="CON_ST_BAIRRO")
    private String conStBairro;
    @Column(name="CON_IN_DIA_FECHAMENTO")
    private Integer conInDiaFechamento;
    @Column(name="CON_IN_DIA_PAGAMENTO")
    private Integer conInDiaPagamento;
    @Lob
    @Column(name="CON_BL_OBS")
    private String conBlObs;
    @Column(name="CON_CH_ATIVO")
    private Character conChAtivo;
    @Column(name="CON_ST_ANS")
    private String conStAns;
    @Column(name="CON_IN_SEQUENCIAANS")
    private Integer conInSequenciaAns;





    @OneToMany(mappedBy="conStCodigo")
    private List<LabAgendaPaciente> listLabAgendaPaciente;


    @OneToMany(mappedBy="conStCodigo")
    private List<LabOrigem> listLabOrigem;


    @OneToMany(mappedBy="conStCodigo")
    private List<LabPaciente> listLabPaciente;

//    @OneToMany(mappedBy="uniStCodigo")
//    private List<LabRegras> listLabRegras;


//    @OneToMany(mappedBy="conStCodigo")
//    private List<LabRequisicao> listLabRequisicao;

    
    public List<LabPaciente> getListLabPaciente() {
        return listLabPaciente;
    }

    public void setListLabPaciente(List<LabPaciente> listLabPaciente) {
        this.listLabPaciente = listLabPaciente;
    }



    
    public List<LabOrigem> getListLabOrigem() {
        return listLabOrigem;
    }

    public void setListLabOrigem(List<LabOrigem> listLabOrigem) {
        this.listLabOrigem = listLabOrigem;
    }

    public List<LabAgendaPaciente> getListLabAgendaPaciente() {
        return listLabAgendaPaciente;
    }

    public void setListLabAgendaPaciente(List<LabAgendaPaciente> listLabAgendaPaciente) {
        this.listLabAgendaPaciente = listLabAgendaPaciente;
    }


    
    public String getConBlObs() {
        return conBlObs;
    }

    public void setConBlObs(String conBlObs) {
        this.conBlObs = conBlObs;
    }

    public Character getConChAtivo() {
        return conChAtivo;
    }

    public void setConChAtivo(Character conChAtivo) {
        this.conChAtivo = conChAtivo;
    }

   

    public Integer getConInDiaFechamento() {
        return conInDiaFechamento;
    }

    public void setConInDiaFechamento(Integer conInDiaFechamento) {
        this.conInDiaFechamento = conInDiaFechamento;
    }

    public Integer getConInDiaPagamento() {
        return conInDiaPagamento;
    }

    public void setConInDiaPagamento(Integer conInDiaPagamento) {
        this.conInDiaPagamento = conInDiaPagamento;
    }

    public Integer getConInSequenciaAns() {
        return conInSequenciaAns;
    }

    public void setConInSequenciaAns(Integer conInSequenciaAns) {
        this.conInSequenciaAns = conInSequenciaAns;
    }

    public String getConStAns() {
        return conStAns;
    }

    public void setConStAns(String conStAns) {
        this.conStAns = conStAns;
    }

    public String getConStBairro() {
        return conStBairro;
    }

    public void setConStBairro(String conStBairro) {
        this.conStBairro = conStBairro;
    }

    public String getConStCEP() {
        return conStCEP;
    }

    public void setConStCEP(String conStCEP) {
        this.conStCEP = conStCEP;
    }

    public String getConStCNPJ() {
        return conStCNPJ;
    }

    public void setConStCNPJ(String conStCNPJ) {
        this.conStCNPJ = conStCNPJ;
    }

    public String getConStCidade() {
        return conStCidade;
    }

    public void setConStCidade(String conStCidade) {
        this.conStCidade = conStCidade;
    }

    public String getConStCodigo() {
        return conStCodigo;
    }

    public void setConStCodigo(String conStCodigo) {
        this.conStCodigo = conStCodigo;
    }

    public String getConStComplemento() {
        return conStComplemento;
    }

    public void setConStComplemento(String conStComplemento) {
        this.conStComplemento = conStComplemento;
    }

    public String getConStContato() {
        return conStContato;
    }

    public void setConStContato(String conStContato) {
        this.conStContato = conStContato;
    }

    public String getConStDescricao() {
        return conStDescricao;
    }
    @Transient
    public String getConStDescricaoResumida() {
        if(this.conStDescricao != null && conStDescricao.length()>13){
            return  conStDescricao.substring(0, 10)+"...";
        }else{
            return  conStDescricao;
        }
    }

    public void setConStDescricao(String conStDescricao) {
        this.conStDescricao = conStDescricao;
    }

    public String getConStEmail() {
        return conStEmail;
    }

    public void setConStEmail(String conStEmail) {
        this.conStEmail = conStEmail;
    }

    public String getConStEndereco() {
        return conStEndereco;
    }

    public void setConStEndereco(String conStEndereco) {
        this.conStEndereco = conStEndereco;
    }

    public String getConStFax() {
        return conStFax;
    }

    public void setConStFax(String conStFax) {
        this.conStFax = conStFax;
    }

    public String getConStFone() {
        return conStFone;
    }

    public void setConStFone(String conStFone) {
        this.conStFone = conStFone;
    }

    public String getConStInscEstadual() {
        return conStInscEstadual;
    }

    public void setConStInscEstadual(String conStInscEstadual) {
        this.conStInscEstadual = conStInscEstadual;
    }

    public String getConStNumero() {
        return conStNumero;
    }

    public void setConStNumero(String conStNumero) {
        this.conStNumero = conStNumero;
    }

    public String getConStRazaoSocial() {
        return conStRazaoSocial;
    }

    public void setConStRazaoSocial(String conStRazaoSocial) {
        this.conStRazaoSocial = conStRazaoSocial;
    }

    public String getConStSite() {
        return conStSite;
    }

    public void setConStSite(String conStSite) {
        this.conStSite = conStSite;
    }

    public String getConStUf() {
        return conStUf;
    }

    public void setConStUf(String conStUf) {
        this.conStUf = conStUf;
    }

    public String getConStUsuarioResp() {
        return conStUsuarioResp;
    }

    public void setConStUsuarioResp(String conStUsuarioResp) {
        this.conStUsuarioResp = conStUsuarioResp;
    }

    

}
