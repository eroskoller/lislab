/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.entities;

import br.com.utils.tipstricks.*;
import java.io.Serializable;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author eros
 */

@Entity
@Table(name="LAB_REGRAS")
@IdClass(LabRegrasPK.class)
public class LabRegras implements Serializable{


    @Id
    @ManyToOne
    @JoinColumn(name="UNI_ST_CODIGO")//mappeded
     private LabUnidade uniStCodigo;
    @Id
    @Column(name="CON_ST_CODIGO",nullable=false, updatable=false, insertable=false)
    private String conStCodigo;
    @Id
    @Column(name="REG_ST_CODIGO",nullable=false, updatable=false, insertable=false)
    private String regStCodigo;




    
    @Column(name="REG_ST_DESCRICAO")
    private String regStDescricao;
    @Column(name="REG_IN_PROC_GUIA")
    private Integer regInProcGuia;
    @Column(name="REG_IN_QTD_VIAS")
    private Integer regInQtdVias;
    @Column(name="REG_IN_AUTORIZACH")
    private Integer regInAutorizaCH;
    @Column(name="REG_IN_GUIAVENCEEM")
    private Integer regInGuiVenceEm;
    @Column(name="REG_CH_FATURA_AMB")
    private char regChFaturaAMB;
    @Column(name="REG_CH_AUTORIZA_REGRA")
    private char regChAutorizaRegra;
    @Column(name="REG_CH_STATUSNOVACOLETA")
    private char regChStatusNovaColeta;
    @Column(name="REG_CH_STATUSDEVEMATERIAL")
    private char regChStatusDeveMaterial;
    @Column(name="REG_CH_STATUSEXAMELIBERADO")
    private char regChStatusExameLiberado;
    @Column(name="REG_CH_STATUSEXAMEIMPRESSO")
    private char regChStatusExameImpresso;
    @Column(name="REG_CH_OBRIGATORIONUMMATRICULA")
    private char regChObrigatorioNumMatricula;
    @Column(name="REG_CH_OBRIGATORIONUMGUIA")
    private char regChObrigatorioNumGuia;
    @Column(name="REG_CH_OBRIGATORIONUMCID")
    private char regChObrigatorioNumCid;
    @Column(name="REG_CH_OBRIGATORIONUMQUARTO")
    private char regChObrigarorioNumQuarto;
    @Column(name="REG_CH_OBRIGATORIONUMLEITO")
    private char regChObrigarorioNumLeito;
    @Column(name="REG_CH_STATUSRESULTADOPACIAL")
    private char regChStatusResultadoPacial;
    @Lob
    @Column(name="REG_BL_CONTRATO")
    private String regBlContrato;
    @Column(name="REG_CH_FATURARPOR")
    private char regChFaturarPor;
    @Column(name="REG_CH_STATUSEXAMEASSINADO")
    private char regChStatusExameAssinado;
    @Column(name="REG_CH_STATUSEXAMEOUTROS")
    private char regChStatusExameOutros;
    @Column(name="REG_CH_MANTER_REQPENDENTEFAT")
    private char regChManterReqPendenteFat;
    @Column(name="REG_CH_TIPOGERACAOLOTE")
    private char regChTipoGeracaoLote;
    @Column(name="REG_IN_QUOTAEXAMES")
    private Integer regInQuotaExames;
    @Column(name="REG_FL_VALORFATURA")
    private Float regFlValorFatura;
    @Column(name="REG_CH_ATIVO")
    private char regChAtivo;



//    @OneToMany(mappedBy="regStCodigo")
//    private List<LabOrigem> listLabOrigem;

//    @OneToMany(mappedBy="regStCodigo")
//    private List<LabRequisicao> listLabRequisicao;

   

   
   
    
    public String getRegBlContrato() {
        return regBlContrato;
    }

    public void setRegBlContrato(String regBlContrato) {
        this.regBlContrato = regBlContrato;
    }

    public char getRegChAtivo() {
        return regChAtivo;
    }

    public void setRegChAtivo(char regChAtivo) {
        this.regChAtivo = regChAtivo;
    }

    public char getRegChAutorizaRegra() {
        return regChAutorizaRegra;
    }

    public void setRegChAutorizaRegra(char regChAutorizaRegra) {
        this.regChAutorizaRegra = regChAutorizaRegra;
    }

    public char getRegChFaturaAMB() {
        return regChFaturaAMB;
    }

    public void setRegChFaturaAMB(char regChFaturaAMB) {
        this.regChFaturaAMB = regChFaturaAMB;
    }

    public char getRegChFaturarPor() {
        return regChFaturarPor;
    }

    public void setRegChFaturarPor(char regChFaturarPor) {
        this.regChFaturarPor = regChFaturarPor;
    }

   

    public char getRegChManterReqPendenteFat() {
        return regChManterReqPendenteFat;
    }

    public void setRegChManterReqPendenteFat(char regChManterReqPendenteFat) {
        this.regChManterReqPendenteFat = regChManterReqPendenteFat;
    }

    public char getRegChObrigarorioNumLeito() {
        return regChObrigarorioNumLeito;
    }

    public void setRegChObrigarorioNumLeito(char regChObrigarorioNumLeito) {
        this.regChObrigarorioNumLeito = regChObrigarorioNumLeito;
    }

    public char getRegChObrigarorioNumQuarto() {
        return regChObrigarorioNumQuarto;
    }

    public void setRegChObrigarorioNumQuarto(char regChObrigarorioNumQuarto) {
        this.regChObrigarorioNumQuarto = regChObrigarorioNumQuarto;
    }

    public char getRegChObrigatorioNumCid() {
        return regChObrigatorioNumCid;
    }

    public void setRegChObrigatorioNumCid(char regChObrigatorioNumCid) {
        this.regChObrigatorioNumCid = regChObrigatorioNumCid;
    }

    public char getRegChObrigatorioNumGuia() {
        return regChObrigatorioNumGuia;
    }

    public void setRegChObrigatorioNumGuia(char regChObrigatorioNumGuia) {
        this.regChObrigatorioNumGuia = regChObrigatorioNumGuia;
    }

    public char getRegChObrigatorioNumMatricula() {
        return regChObrigatorioNumMatricula;
    }

    public void setRegChObrigatorioNumMatricula(char regChObrigatorioNumMatricula) {
        this.regChObrigatorioNumMatricula = regChObrigatorioNumMatricula;
    }

    public char getRegChStatusDeveMaterial() {
        return regChStatusDeveMaterial;
    }

    public void setRegChStatusDeveMaterial(char regChStatusDeveMaterial) {
        this.regChStatusDeveMaterial = regChStatusDeveMaterial;
    }

    public char getRegChStatusExameAssinado() {
        return regChStatusExameAssinado;
    }

    public void setRegChStatusExameAssinado(char regChStatusExameAssinado) {
        this.regChStatusExameAssinado = regChStatusExameAssinado;
    }

    public char getRegChStatusExameImpresso() {
        return regChStatusExameImpresso;
    }

    public void setRegChStatusExameImpresso(char regChStatusExameImpresso) {
        this.regChStatusExameImpresso = regChStatusExameImpresso;
    }

    public char getRegChStatusExameLiberado() {
        return regChStatusExameLiberado;
    }

    public void setRegChStatusExameLiberado(char regChStatusExameLiberado) {
        this.regChStatusExameLiberado = regChStatusExameLiberado;
    }

    public char getRegChStatusExameOutros() {
        return regChStatusExameOutros;
    }

    public void setRegChStatusExameOutros(char regChStatusExameOutros) {
        this.regChStatusExameOutros = regChStatusExameOutros;
    }

    public char getRegChStatusNovaColeta() {
        return regChStatusNovaColeta;
    }

    public void setRegChStatusNovaColeta(char regChStatusNovaColeta) {
        this.regChStatusNovaColeta = regChStatusNovaColeta;
    }

    public char getRegChStatusResultadoPacial() {
        return regChStatusResultadoPacial;
    }

    public void setRegChStatusResultadoPacial(char regChStatusResultadoPacial) {
        this.regChStatusResultadoPacial = regChStatusResultadoPacial;
    }

    public char getRegChTipoGeracaoLote() {
        return regChTipoGeracaoLote;
    }

    public void setRegChTipoGeracaoLote(char regChTipoGeracaoLote) {
        this.regChTipoGeracaoLote = regChTipoGeracaoLote;
    }

    public Float getRegFlValorFatura() {
        return regFlValorFatura;
    }

    public void setRegFlValorFatura(Float regFlValorFatura) {
        this.regFlValorFatura = regFlValorFatura;
    }

    public Integer getRegInAutorizaCH() {
        return regInAutorizaCH;
    }

    public void setRegInAutorizaCH(Integer regInAutorizaCH) {
        this.regInAutorizaCH = regInAutorizaCH;
    }

    public Integer getRegInGuiVenceEm() {
        return regInGuiVenceEm;
    }

    public void setRegInGuiVenceEm(Integer regInGuiVenceEm) {
        this.regInGuiVenceEm = regInGuiVenceEm;
    }

    public Integer getRegInProcGuia() {
        return regInProcGuia;
    }

    public void setRegInProcGuia(Integer regInProcGuia) {
        this.regInProcGuia = regInProcGuia;
    }

    public Integer getRegInQtdVias() {
        return regInQtdVias;
    }

    public void setRegInQtdVias(Integer regInQtdVias) {
        this.regInQtdVias = regInQtdVias;
    }

    public Integer getRegInQuotaExames() {
        return regInQuotaExames;
    }

    public void setRegInQuotaExames(Integer regInQuotaExames) {
        this.regInQuotaExames = regInQuotaExames;
    }

    public String getRegStDescricao() {
        return regStDescricao;
    }
    @Transient
    public String getRegStDescricaoResumida() {
        return DescricaoResumida.descResuminda(this.regStDescricao, 10);
    }

    public void setRegStDescricao(String regStDescricao) {
        this.regStDescricao = regStDescricao;
    }

    public String getConStCodigo() {
        return conStCodigo;
    }

    public void setConStCodigo(String conStCodigo) {
        this.conStCodigo = conStCodigo;
    }

    public String getRegStCodigo() {
        return regStCodigo;
    }

    public void setRegStCodigo(String regStCodigo) {
        this.regStCodigo = regStCodigo;
    }

    public LabUnidade getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(LabUnidade uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }

 
    


}
