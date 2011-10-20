/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.entities;

import br.com.facesbeans.ExameFormatado;
import br.com.hibernate.utils.OracleHelper;

//import br.com.tmlab.hibernatebeans.oracle.LabDetalheRequisicaoPK;

//import br.com.tmlab.oracleconnector.OracleConnector;
import br.com.oracleconnector.OracleConnector;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import org.hibernate.annotations.Columns;

/**
 *
 * @author eros
 */


@Entity
@Table(name="LAB_DETALHEREQUISICAO")
@IdClass(LabDetalheRequisicaoPK.class)
public class LabDetalheRequisicao  implements Serializable {





    @Id
//    @ManyToOne
//    @JoinColumn(name = "REQ_ST_CODIGO")
    @Column(name = "REQ_ST_CODIGO")
     private String reqStCodigo;
    @Id
//    @ManyToOne
//    @JoinColumn(name = "EXA_ST_CODIGO")
    @JoinColumn(name = "EXA_ST_CODIGO")
    private String exaStCodigo;
    @Id
    @Column(name = "SEQ_ST_CODIGO")
     private String seqStCodigo;


    @Column(name = "UNI_ST_CODIGO")
    private String uniStCodigo;
    
    @Column(name = "DER_ST_UNIDADEEX")
    private String derStUnidadeEx;
    @Column(name = "MOR_ST_CODIGO")
    private String morStCodigo;
    @Column(name = "SET_ST_CODIGO")
    private String setStCodigo;
    @Column(name = "EQU_ST_CODIGO")
    private String equStCodigo;
    @Column(name = "OBS_ST_CODIGO")
    private String obsStCodigo;
    @Column(name = "PEX_ST_CODIGO")
    private String pexStCodigo;
    @Column(name = "AMO_ST_CODIGO")
    private String amoStCodigo;
    @Column(name = "LEG_ST_CODIGO")
    private String legStCodigo;
    @Transient
    private String legStSigla;
    @Column(name = "LEG_ST_CODIGOFAT")
    private String legStCodigoFat;
    @Column(name = "TAP_ST_CODIGO")
    private String tapStCodigo;
    @Column(name = "TAB_ST_CODIGO")
    private String tabStCodigo;
    @Column(name = "DER_CH_URGENTE")
    private Character derChUrgente = 'N';
    @Column(name = "DER_CH_LIBERACAOAUTOMATICA")
    private Character derChLiberacaoAutomatica;
    @Column(name = "DER_CH_AUTOMATICO")
    private Character derChAutomatico;
    @Column(name = "DER_IN_REPETICAO")
    private Integer derInRepeticao;
    @Column(name = "DER_ST_DILUICAO")
    private String derStDiluicao;
    @Column(name = "DER_CH_NAONECESSARIO")
    private Character derChNaoNecessario;
    @Column(name = "DER_IN_FLAG")
    private Integer derInFlag;
    @Column(name = "DER_IN_ENVIOLIS")
    private Integer derInEnvioLis;
    @Column(name = "DER_CH_PARCIAL")
    private Character derChParcial;
    @Column(name = "DER_CH_REPETIR")
    private Character derChRepetir;
    @Column(name = "DER_ST_AUTORIZACAO")
    private String derStAutorizacao;
    @Column(name = "DER_DT_ENTRADAMAT")
    @Temporal(value = javax.persistence.TemporalType.TIMESTAMP)
    private Date derDtEntradaMat;  //Date derDtEntradaMat;
    //Date derDtEntradaMat;
    @Column(name = "DER_HR_ENTRADAMAT")
    @Temporal(value = javax.persistence.TemporalType.TIME)
    private Date derHREntradaMat;
    @Column(name = "DER_CH_TROUXEMAT")
    private Character derChTrouxeMat;
    @Column(name = "DER_FL_VALORCH", precision = 6)
    private Float derFlValorCh;
    @Column(name = "DER_FL_QTDECH")
    private Float derFlQtDeCh;
    @Column(name = "DER_DT_DATAFATURA")
    @Temporal(value = javax.persistence.TemporalType.DATE)
    private Date derDtDataFatura;
    @Column(name = "DER_HR_HORAFATURA")
    @Temporal(value = javax.persistence.TemporalType.TIMESTAMP)
    private Date derHrHoraFatura;
    @Column(name = "DER_DT_DATAPREVISTAENTREGA")
    @Temporal(value = javax.persistence.TemporalType.TIMESTAMP)
    private Date derDtDataPrevistaEntrega;
    @Column(name = "DER_HR_HORAPREVISTAENTREGA")
    @Temporal(value = javax.persistence.TemporalType.DATE)
    private Date derHrHoraPrevistaEntrega;
    @Column(name = "LOT_ST_CODIGO")
    private String lotStCodigo;
    @Column(name = "USU_ST_CODIGO")
    private String usuStCodigo;
    @Column(name = "DER_CH_INTERFACE")
    private Character derChInterface;
    @Column(name = "MET_ST_CODIGO")
    private String metStCodigo;
    @Transient
    private String metStCodigoGrp;
    @Column(name = "EMV_DT_VALIDADE")
    private java.sql.Timestamp emvDtValidade;
    @Column(name = "RES_DT_VALIDADE")
    @Temporal(value = javax.persistence.TemporalType.DATE)
    private Date resDtValidade;
    @Column(name = "DER_IN_MAPASEQ")
    private Integer derInMapaSeq;
    @Column(name = "GRP_ST_CODIGO")
    private String grpStCodigo;
    @Column(name = "APO_ST_CODIGO")
    private String apoStCodigo;
    @Column(name = "FRL_CODIGO")
    private String frlCodigo;
    @Column(name = "DER_IN_LAUDOSEQ")
    private Integer derInLaudoSeq;
    @Column(name = "DER_FL_CONVENIO")
    private Float derFlConvenio;
    @Column(name = "DER_FL_DESCONTO")
    private Float derFlDesconto;
    @Column(name = "DER_FL_ACRESCIMO")
    private Float derFlAcrescimo;
    @Column(name = "DER_CH_VLDIFERENCIADO")
    private Character derChVlDiferenciado;
    @Column(name = "USU_ST_CODIGOASS")
    private String usuStCodigoAss;
    @Column(name = "DER_CH_FATURA")
    private Character derChFatura;
    @Column(name = "DER_CH_IMPRESSO")
    private Character derChImpresso;
    @Column(name = "DER_CH_INCLUIDOAPOSCONF")
    private Character derChIncluidoAposConf;
    @Column(name = "DER_ST_OBSREPETICAO")
    private String derStObsRepeticao;
    @Column(name = "DER_CH_ETIQUETA")
    private Character derChEtiqueta;
    @Column(name = "DER_IN_CODIGO")
    private Long derInCodigo;
    @Column(name = "DER_IN_VALIDADERES")
    private Integer derInValidadeRes;
    @Column(name = "REC_ST_CODIGO")
    private String recStCodigo;
    @Column(name = "SOR_IN_CODIGO")
    private Long sorInCodigo;
    @Column(name = "DER_IN_VERTICAL")
    private Integer derInVertical;
    @Column(name = "DER_IN_HORIZONTAL")
    private Integer derInHorizontal;
    @Column(name = "PFE_ST_CODIGO")
    private String pfeStCodigo;
    @Column(name = "DER_IN_VIASIMPRESSAS")
    private Integer derInViasImpressas;
//    @Column(name="DER_CH_AGENDAD0")
//    private Character derChAgendado;
//    @Column(name="DER_CH_AGENDAD0")
//    private Character derChAgendado;
    @Column(name = "DER_CH_NOVACOLETA")
    private Character derChNovaColeta;
    @Column(name = "DER_ST_VOLUME")
    private String derStVolume;
    @Column(name = "DER_ST_ORDEMINTEGRACAO")
    private String derStOrdemItegracao;
    @Column(name = "DER_CH_OMITECAD")
    private Character derChOmiteCad;
    @Column(name = "REQ_DT_CADASTRO")
    @Temporal(value = javax.persistence.TemporalType.DATE)
    private Date reqDtCadastro;
    @Column(name = "MAT_ST_CODIGO")
    private String matStCodigo;
    @Transient
    private String matStCodigoDescricao;
    @Transient
    private String matStDescricao;
    @Column(name = "DER_ST_GUIA")
    private String derStGuia;
    @Column(name = "DER_ST_MATERIAL")
    private String derStMaterial;
    @Column(name = "DER_DT_ASSINATURA")
    @Temporal(value = javax.persistence.TemporalType.DATE)
    private Date derDtAssinatura;
    @Column(name = "DER_DT_FATURA")
    @Temporal(value = javax.persistence.TemporalType.DATE)
    private Date derDtFatura;
    @Column(name = "DER_CH_ENVIOOLA")
    private Character derChEnvioOla;
    @Column(name = "DER_DT_IMPRESSAO")
    @Temporal(value = javax.persistence.TemporalType.DATE)
    private Date derDtImpressao;
    @Column(name = "DER_CH_ESPECIAL")
    private Character derChEspecial;
    @Column(name = "DER_CH_ENVIADOHIS")
    private Character derChEnviadoHis;
    @Column(name = "SIS_ST_CODIGO")
    private String sisStCodigo;
    @Column(name = "DER_ST_UNIDADEASS")
    private String  derStUnidadeAss;
    @Column(name = "CNT_ST_CODIGO")
    private String cntStCodigo;
    @Column(name = "REQ_ST_CODIGOLIS")
    private String reqStCodigoLis;
    @Column(name = "DER_DT_DATATRANSPORTE")
    @Temporal(value = javax.persistence.TemporalType.DATE)
    private Date derDtDataTransporte;
    @Column(name = "REQ_IN_CODIGO")
    private Long reqInCodigo;
    @Column(name = "ORI_ST_CODIGO")
    private String oriStCodigo;
    @Column(name = "CON_ST_CODIGO")
    private String conStCodigo;
    @Column(name = "DER_DT_PRAZOCADASTRO")
    @Temporal(value = javax.persistence.TemporalType.DATE)
    private Date derDtPrazoCadastro;
    @Column(name = "EQU_IN_CODIGO")
    private Long equInCodigo;
    @Column(name = "DER_DT_COLETA")
    @Temporal(value = javax.persistence.TemporalType.DATE)
    private Date derDtColeta;
    @Column(name = "DER_HR_COLETA")
    @Temporal(value = javax.persistence.TemporalType.DATE)
    private Date derHrColeta;
    @Column(name = "DER_CH_RESTRICAO")
    private Character derChRestricao;
    @Column(name = "DEP_ST_CODIGO")
    private String depStCodigo;
    @Column(name = "SUB_ST_SEQUENCIA")
    private String subStSequencia;
    @Column(name = "DER_CH_FATURAEXTERNO")
    private Character derChFaturaExterno;
    @Column(name = "DER_IN_TEMPO")
    private Integer derInTempo;
    @Column(name = "DER_CH_COLETADO")
    private Character derChColetado;
    @Column(name = "DER_DT_LASTUPDATE")
    @Temporal(value = javax.persistence.TemporalType.TIMESTAMP)
    private Date derDtLastUpdate;
    @Column(name = "DER_ST_SEQINTEGRACAO")
    private String derStSeqIntegracao;
    @Column(name = "DER_CH_ENVIADOREGLAB")
    private Character derChEnviadoRegLab;
    @Column(name = "DER_CH_TIPO")
    private Character derChTipo;
    @Column(name = "DER_ST_PROCEDIMENTOALT")
    private String derStProcedimentoAlt;
    @Column(name = "REG_ST_CODIGO")
    private String regStCodigo;
    @Column(name = "DER_FL_VALORCHEXTERNO")
    private Float derFlValorChExterno;
    @Column(name = "DER_FL_CONVENIOEXTERNO")
    private Float derFlConvenioExterno;
    @Column(name = "DER_FL_DESCONTOEXTERNO")
    private Float derFlDescontoExterno;




    @Transient
    private List<LabResultados> listLabResultados;
    @Transient
    private String derStDescricao;
    @Transient
    private boolean blGroupControl = false;
     @Transient
    private boolean salvoNoDb= false;
    @Transient
     private String urlIcoSave = "images/saved.png";
    @Transient
    private boolean blOutOfDate;
    @Transient
    private String legStDescricao;


    @Transient
     private String urlImgConf = "images/unsaved.png";
    @Transient
     private String urlImgConfFat = "images/unsaved.png";
    @Transient
    private Character  exuChObrigaMaterial;

    public    LabDetalheRequisicao() {
    }

    

   

    

    public LabDetalheRequisicao(String reqStCodigo, String exaStCodigo, String seqStCodigo, String uniStCodigo, String derStUnidadeEx, String morStCodigo, String setStCodigo, String equStCodigo, String obsStCodigo, String pexStCodigo, String amoStCodigo, String legStCodigo, String legStCodigoFat, String tapStCodigo, String tabStCodigo, Character derChUrgente, Character derChLiberacaoAutomatica, Character derChAutomatico, Integer derInRepeticao, String derStDiluicao, Character derChNaoNecessario, Integer derInFlag, Integer derInEnvioLis, Character derChParcial, Character derChRepetir, String derStAutorizacao, Date derDtEntradaMat, Date derHREntradaMat, Character derChTrouxeMat, Float derFlValorCh, Float derFlQtDeCh, Date derDtDataFatura, Date derHrHoraFatura, Date derDtDataPrevistaEntrega, Date derHrHoraPrevistaEntrega, String lotStCodigo, String usuStCodigo, Character derChInterface, String metStCodigo,Timestamp  emvDtValidade, Date resDtValidade, Integer derInMapaSeq, String grpStCodigo, String apoStCodigo, String frlCodigo, Integer derInLaudoSeq, Float derFlConvenio, Float derFlDesconto, Float derFlAcrescimo, Character derChVlDiferenciado, String usuStCodigoAss, Character derChFatura, Character derChImpresso, Character derChIncluidoAposConf, String derStObsRepeticao, Character derChEtiqueta, Long derInCodigo, Integer derInValidadeRes, String recStCodigo, Long sorInCodigo, Integer derInVertical, Integer derInHorizontal, String pfeStCodigo, Integer derInViasImpressas, Character derChNovaColeta, String derStVolume, String derStOrdemItegracao, Character derChOmiteCad, Date reqDtCadastro, String matStCodigo, String derStGuia, String derStMaterial, Date derDtAssinatura, Date derDtFatura, Character derChEnvioOla, Date derDtImpressao, Character derChEspecial, Character derChEnviadoHis, String sisStCodigo, String derStUnidadeAss, String cntStCodigo, String reqStCodigoLis, Date derDtDataTransporte, Long reqInCodigo, String oriStCodigo, String conStCodigo, Long equInCodigo, Date derDtColeta, Date derHrColeta, Character derChRestricao, String depStCodigo, String subStSequencia, Character derChFaturaExterno, Integer derInTempo, Character derChColetado, Date derDtLastUpdate, String derStSeqIntegracao, Character derChEnviadoRegLab, Character derChTipo, String derStProcedimentoAlt, String regStCodigo) {
        this.reqStCodigo = reqStCodigo;
        this.exaStCodigo = exaStCodigo;
        this.seqStCodigo = seqStCodigo;
        this.uniStCodigo = uniStCodigo;
        this.derStUnidadeEx = derStUnidadeEx;
        this.morStCodigo = morStCodigo;
        this.setStCodigo = setStCodigo;
        this.equStCodigo = equStCodigo;
        this.obsStCodigo = obsStCodigo;
        this.pexStCodigo = pexStCodigo;
        this.amoStCodigo = amoStCodigo;
        this.legStCodigo = legStCodigo;
        this.legStCodigoFat = legStCodigoFat;
        this.tapStCodigo = tapStCodigo;
        this.tabStCodigo = tabStCodigo;
        this.derChUrgente = derChUrgente;
        this.derChLiberacaoAutomatica = derChLiberacaoAutomatica;
        this.derChAutomatico = derChAutomatico;
        this.derInRepeticao = derInRepeticao;
        this.derStDiluicao = derStDiluicao;
        this.derChNaoNecessario = derChNaoNecessario;
        this.derInFlag = derInFlag;
        this.derInEnvioLis = derInEnvioLis;
        this.derChParcial = derChParcial;
        this.derChRepetir = derChRepetir;
        this.derStAutorizacao = derStAutorizacao;
        this.derDtEntradaMat = derDtEntradaMat;
        this.derHREntradaMat = derHREntradaMat;
        this.derChTrouxeMat = derChTrouxeMat;
        this.derFlValorCh = derFlValorCh;
        this.derFlQtDeCh = derFlQtDeCh;
        this.derDtDataFatura = derDtDataFatura;
        this.derHrHoraFatura = derHrHoraFatura;
        this.derDtDataPrevistaEntrega = derDtDataPrevistaEntrega;
        this.derHrHoraPrevistaEntrega = derHrHoraPrevistaEntrega;
        this.lotStCodigo = lotStCodigo;
        this.usuStCodigo = usuStCodigo;
        this.derChInterface = derChInterface;
        this.metStCodigo = metStCodigo;
        this.emvDtValidade = emvDtValidade;
        this.resDtValidade = resDtValidade;
        this.derInMapaSeq = derInMapaSeq;
        this.grpStCodigo = grpStCodigo;
        this.apoStCodigo = apoStCodigo;
        this.frlCodigo = frlCodigo;
        this.derInLaudoSeq = derInLaudoSeq;
        this.derFlConvenio = derFlConvenio;
        this.derFlDesconto = derFlDesconto;
        this.derFlAcrescimo = derFlAcrescimo;
        this.derChVlDiferenciado = derChVlDiferenciado;
        this.usuStCodigoAss = usuStCodigoAss;
        this.derChFatura = derChFatura;
        this.derChImpresso = derChImpresso;
        this.derChIncluidoAposConf = derChIncluidoAposConf;
        this.derStObsRepeticao = derStObsRepeticao;
        this.derChEtiqueta = derChEtiqueta;
        this.derInCodigo = derInCodigo;
        this.derInValidadeRes = derInValidadeRes;
        this.recStCodigo = recStCodigo;
        this.sorInCodigo = sorInCodigo;
        this.derInVertical = derInVertical;
        this.derInHorizontal = derInHorizontal;
        this.pfeStCodigo = pfeStCodigo;
        this.derInViasImpressas = derInViasImpressas;
        this.derChNovaColeta = derChNovaColeta;
        this.derStVolume = derStVolume;
        this.derStOrdemItegracao = derStOrdemItegracao;
        this.derChOmiteCad = derChOmiteCad;
        this.reqDtCadastro = reqDtCadastro;
        this.matStCodigo = matStCodigo;
        this.derStGuia = derStGuia;
        this.derStMaterial = derStMaterial;
        this.derDtAssinatura = derDtAssinatura;
        this.derDtFatura = derDtFatura;
        this.derChEnvioOla = derChEnvioOla;
        this.derDtImpressao = derDtImpressao;
        this.derChEspecial = derChEspecial;
        this.derChEnviadoHis = derChEnviadoHis;
        this.sisStCodigo = sisStCodigo;
        this.derStUnidadeAss = derStUnidadeAss;
        this.cntStCodigo = cntStCodigo;
        this.reqStCodigoLis = reqStCodigoLis;
        this.derDtDataTransporte = derDtDataTransporte;
        this.reqInCodigo = reqInCodigo;
        this.oriStCodigo = oriStCodigo;
        this.conStCodigo = conStCodigo;
        this.equInCodigo = equInCodigo;
        this.derDtColeta = derDtColeta;
        this.derHrColeta = derHrColeta;
        this.derChRestricao = derChRestricao;
        this.depStCodigo = depStCodigo;
        this.subStSequencia = subStSequencia;
        this.derChFaturaExterno = derChFaturaExterno;
        this.derInTempo = derInTempo;
        this.derChColetado = derChColetado;
        this.derDtLastUpdate = derDtLastUpdate;
        this.derStSeqIntegracao = derStSeqIntegracao;
        this.derChEnviadoRegLab = derChEnviadoRegLab;
        this.derChTipo = derChTipo;
        this.derStProcedimentoAlt = derStProcedimentoAlt;
        this.regStCodigo = regStCodigo;
    }

    public String getExaStCodigo() {
        return exaStCodigo;
    }

    public void setExaStCodigo(String exaStCodigo) {
        this.exaStCodigo = exaStCodigo;
    }

    public String getReqStCodigo() {
        return reqStCodigo;
    }

    public void setReqStCodigo(String reqStCodigo) {
        this.reqStCodigo = reqStCodigo;
    }

    

    public Timestamp getEmvDtValidade() {
        return emvDtValidade;
    }

    public void setEmvDtValidade(Timestamp emvDtValidade) {
        this.emvDtValidade = emvDtValidade;
    }

    
    public String getLegStSigla() {
        if(legStCodigo != null){
            LabLegenda ll = (LabLegenda) OracleHelper.getObject(LabLegenda.class, legStCodigo);
            if(ll != null){
                return ll.getLegStSigla();
            }
        }
        return "NI";
    }

    public void setLegStSigla(String legStSigla) {
        this.legStSigla = legStSigla;
    }




    public String getSeqStCodigo() {
        return seqStCodigo;
    }

    public void setSeqStCodigo(String seqStCodigo) {
        this.seqStCodigo = seqStCodigo;
    }

    public Float getDerFlConvenioExterno() {
        return derFlConvenioExterno;
    }

    public void setDerFlConvenioExterno(Float derFlConvenioExterno) {
        this.derFlConvenioExterno = derFlConvenioExterno;
    }

    public Float getDerFlDescontoExterno() {
        return derFlDescontoExterno;
    }

    public void setDerFlDescontoExterno(Float derFlDescontoExterno) {
        this.derFlDescontoExterno = derFlDescontoExterno;
    }
    @Transient
    public boolean isSalvoNoDb() {
        return salvoNoDb;
    }

    public void setSalvoNoDb(boolean salvoNoDb) {
        this.salvoNoDb = salvoNoDb;
    }

    public String getAmoStCodigo() {
        return amoStCodigo;
    }

    public void setAmoStCodigo(String amoStCodigo) {
        this.amoStCodigo = amoStCodigo;
    }

    public String getApoStCodigo() {
        return apoStCodigo;
    }

    public void setApoStCodigo(String apoStCodigo) {
        this.apoStCodigo = apoStCodigo;
    }

    public String getCntStCodigo() {
        return cntStCodigo;
    }

    public void setCntStCodigo(String cntStCodigo) {
        this.cntStCodigo = cntStCodigo;
    }

    public String getConStCodigo() {
        return conStCodigo;
    }

    public void setConStCodigo(String conStCodigo) {
        this.conStCodigo = conStCodigo;
    }


    public String getUrlIcoSave() {
        return urlIcoSave;
    }

    public void setUrlIcoSave(String urlIcoSave) {
        this.urlIcoSave = urlIcoSave;
    }

    public String getDepStCodigo() {
        return depStCodigo;
    }

    public void setDepStCodigo(String depStCodigo) {
        this.depStCodigo = depStCodigo;
    }

    public Character getDerChAutomatico() {
        return derChAutomatico;
    }

    public void setDerChAutomatico(Character derChAutomatico) {
        this.derChAutomatico = derChAutomatico;
    }

    public Character getDerChEnviadoHis() {
        return derChEnviadoHis;
    }

    public void setDerChEnviadoHis(Character derChEnviadoHis) {
        this.derChEnviadoHis = derChEnviadoHis;
    }

    public Float getDerFlValorChExterno() {
        return derFlValorChExterno;
    }

    public void setDerFlValorChExterno(Float derFlValorChExterno) {
        this.derFlValorChExterno = derFlValorChExterno;
    }

   

    public Character getDerChEnvioOla() {
        return derChEnvioOla;
    }

    public void setDerChEnvioOla(Character derChEnvioOla) {
        this.derChEnvioOla = derChEnvioOla;
    }

    public Character getDerChEspecial() {
        return derChEspecial;
    }

    public void setDerChEspecial(Character derChEspecial) {
        this.derChEspecial = derChEspecial;
    }

    public Character getDerChEtiqueta() {
        return derChEtiqueta;
    }

    public void setDerChEtiqueta(Character derChEtiqueta) {
        this.derChEtiqueta = derChEtiqueta;
    }
  
    public String getMetStCodigoGrp() {
        return metStCodigoGrp;
    }
 
    public void setMetStCodigoGrp(String metStCodigoGrp) {
        this.metStCodigoGrp = metStCodigoGrp;
    }

    public Character getDerChFatura() {
        return derChFatura;
    }

    public void setDerChFatura(Character derChFatura) {
        this.derChFatura = derChFatura;
    }

    public Character getDerChFaturaExterno() {
        return derChFaturaExterno;
    }

    public void setDerChFaturaExterno(Character derChFaturaExterno) {
        this.derChFaturaExterno = derChFaturaExterno;
    }

    public Character getDerChImpresso() {
        return derChImpresso;
    }

    public void setDerChImpresso(Character derChImpresso) {
        this.derChImpresso = derChImpresso;
    }

    public Character getDerChIncluidoAposConf() {
        return derChIncluidoAposConf;
    }

    public void setDerChIncluidoAposConf(Character derChIncluidoAposConf) {
        this.derChIncluidoAposConf = derChIncluidoAposConf;
    }

    public Character getDerChInterface() {
        return derChInterface;
    }

    public void setDerChInterface(Character derChInterface) {
        this.derChInterface = derChInterface;
    }

    public Character getDerChLiberacaoAutomatica() {
        return derChLiberacaoAutomatica;
    }

    public void setDerChLiberacaoAutomatica(Character derChLiberacaoAutomatica) {
        this.derChLiberacaoAutomatica = derChLiberacaoAutomatica;
    }

   
    public Character getDerChNaoNecessario() {
        return derChNaoNecessario;
    }

    public void setDerChNaoNecessario(Character derChNaoNecessario) {
        this.derChNaoNecessario = derChNaoNecessario;
    }

//    @Column(name="DER_CH_AGENDAD0")
//    private Character derChAgendado;
    public Character getDerChNovaColeta() {
        return derChNovaColeta;
    }

    public void setDerChNovaColeta(Character derChNovaColeta) {
        this.derChNovaColeta = derChNovaColeta;
    }

    public Character getDerChOmiteCad() {
        return derChOmiteCad;
    }

    public void setDerChOmiteCad(Character derChOmiteCad) {
        this.derChOmiteCad = derChOmiteCad;
    }

    public Character getDerChParcial() {
        return derChParcial;
    }

    public void setDerChParcial(Character derChParcial) {
        this.derChParcial = derChParcial;
    }

    public Character getDerChRepetir() {
        return derChRepetir;
    }

    public void setDerChRepetir(Character derChRepetir) {
        this.derChRepetir = derChRepetir;
    }

    public Character getDerChRestricao() {
        return derChRestricao;
    }

    public void setDerChRestricao(Character derChRestricao) {
        this.derChRestricao = derChRestricao;
    }

    public Character getDerChTrouxeMat() {
        return derChTrouxeMat;
    }

    public void setDerChTrouxeMat(Character derChTrouxeMat) {
        this.derChTrouxeMat = derChTrouxeMat;
    }

    public Character getDerChUrgente() {
        return derChUrgente;
    }

    public void setDerChUrgente(Character derChUrgente) {
        this.derChUrgente = derChUrgente;
    }

    public Character getDerChVlDiferenciado() {
        return derChVlDiferenciado;
    }

    public void setDerChVlDiferenciado(Character derChVlDiferenciado) {
        this.derChVlDiferenciado = derChVlDiferenciado;
    }

    public Date getDerDtAssinatura() {
        return derDtAssinatura;
    }

    public void setDerDtAssinatura(Date derDtAssinatura) {
        this.derDtAssinatura = derDtAssinatura;
    }

    public Date getDerDtColeta() {
        return derDtColeta;
    }

    public void setDerDtColeta(Date derDtColeta) {
        this.derDtColeta = derDtColeta;
    }

    public Date getDerDtDataFatura() {
        return derDtDataFatura;
    }

    public void setDerDtDataFatura(Date derDtDataFatura) {
        this.derDtDataFatura = derDtDataFatura;
    }

    public Date getDerDtDataPrevistaEntrega() {
        return derDtDataPrevistaEntrega;
    }

    public Date getDerDtPrazoCadastro() {
        return derDtPrazoCadastro;
    }

    public void setDerDtPrazoCadastro(Date derDtPrazoCadastro) {
        this.derDtPrazoCadastro = derDtPrazoCadastro;
    }

    public void setDerDtDataPrevistaEntrega(Date derDtDataPrevistaEntrega) {
        this.derDtDataPrevistaEntrega = derDtDataPrevistaEntrega;
    }

    public Date getDerDtDataTransporte() {
        return derDtDataTransporte;
    }

    public void setDerDtDataTransporte(Date derDtDataTransporte) {
        this.derDtDataTransporte = derDtDataTransporte;
    }

    public Date getDerDtEntradaMat() {
        return derDtEntradaMat;
    }

    public void setDerDtEntradaMat(Date derDtEntradaMat) {
        this.derDtEntradaMat = derDtEntradaMat;
    }

    public Date getDerDtFatura() {
        return derDtFatura;
    }

    public void setDerDtFatura(Date derDtFatura) {
        this.derDtFatura = derDtFatura;
    }

    public Date getDerDtImpressao() {
        return derDtImpressao;
    }

    public void setDerDtImpressao(Date derDtImpressao) {
        this.derDtImpressao = derDtImpressao;
    }

    public Float getDerFlAcrescimo() {
        return derFlAcrescimo;
    }

    public void setDerFlAcrescimo(Float derFlAcrescimo) {
        this.derFlAcrescimo = derFlAcrescimo;
    }

    public Float getDerFlConvenio() {
        return derFlConvenio;
    }

    public void setDerFlConvenio(Float derFlConvenio) {
        this.derFlConvenio = derFlConvenio;
    }

    public Float getDerFlDesconto() {
        return derFlDesconto;
    }

    public void setDerFlDesconto(Float derFlDesconto) {
        this.derFlDesconto = derFlDesconto;
    }

    public Float getDerFlQtDeCh() {
        return derFlQtDeCh;
    }

    public void setDerFlQtDeCh(Float derFlQtDeCh) {
        this.derFlQtDeCh = derFlQtDeCh;
    }

    public Float getDerFlValorCh() {
        return derFlValorCh;
    }

    public void setDerFlValorCh(Float derFlValorCh) {
        this.derFlValorCh = derFlValorCh;
    }

    //Date derDtEntradaMat;
    public Date getDerHREntradaMat() {
        return derHREntradaMat;
    }

    public void setDerHREntradaMat(Date derHREntradaMat) {
        this.derHREntradaMat = derHREntradaMat;
    }

   
    public Date getDerHrColeta() {
        return derHrColeta;
    }

    public void setDerHrColeta(Date derHrColeta) {
        this.derHrColeta = derHrColeta;
    }

    public Date getDerHrHoraFatura() {
        return derHrHoraFatura;
    }

    public void setDerHrHoraFatura(Date derHrHoraFatura) {
        this.derHrHoraFatura = derHrHoraFatura;
    }

    public Date getDerHrHoraPrevistaEntrega() {
        return derHrHoraPrevistaEntrega;
    }

    public void setDerHrHoraPrevistaEntrega(Date derHrHoraPrevistaEntrega) {
        this.derHrHoraPrevistaEntrega = derHrHoraPrevistaEntrega;
    }

    public Long getDerInCodigo() {
        return derInCodigo;
    }

    public void setDerInCodigo(Long derInCodigo) {
        this.derInCodigo = derInCodigo;
    }

    public Integer getDerInEnvioLis() {
        return derInEnvioLis;
    }

    public void setDerInEnvioLis(Integer derInEnvioLis) {
        this.derInEnvioLis = derInEnvioLis;
    }

    public Integer getDerInFlag() {
        return derInFlag;
    }

    public void setDerInFlag(Integer derInFlag) {
        this.derInFlag = derInFlag;
    }

    public Integer getDerInHorizontal() {
        return derInHorizontal;
    }

    public void setDerInHorizontal(Integer derInHorizontal) {
        this.derInHorizontal = derInHorizontal;
    }

    public Integer getDerInLaudoSeq() {
        return derInLaudoSeq;
    }

    public void setDerInLaudoSeq(Integer derInLaudoSeq) {
        this.derInLaudoSeq = derInLaudoSeq;
    }

    public Integer getDerInMapaSeq() {
        return derInMapaSeq;
    }

    public void setDerInMapaSeq(Integer derInMapaSeq) {
        this.derInMapaSeq = derInMapaSeq;
    }

    public Integer getDerInRepeticao() {
        return derInRepeticao;
    }

    public void setDerInRepeticao(Integer derInRepeticao) {
        this.derInRepeticao = derInRepeticao;
    }

    public Integer getDerInValidadeRes() {
        return derInValidadeRes;
    }

    public void setDerInValidadeRes(Integer derInValidadeRes) {
        this.derInValidadeRes = derInValidadeRes;
    }

    public Integer getDerInVertical() {
        return derInVertical;
    }

    public void setDerInVertical(Integer derInVertical) {
        this.derInVertical = derInVertical;
    }

    public Integer getDerInViasImpressas() {
        return derInViasImpressas;
    }

    public void setDerInViasImpressas(Integer derInViasImpressas) {
        this.derInViasImpressas = derInViasImpressas;
    }

    public String getDerStAutorizacao() {
        return derStAutorizacao;
    }

    public void setDerStAutorizacao(String derStAutorizacao) {
        this.derStAutorizacao = derStAutorizacao;
    }

    public String getDerStDiluicao() {
        return derStDiluicao;
    }

    public void setDerStDiluicao(String derStDiluicao) {
        this.derStDiluicao = derStDiluicao;
    }

    public String getDerStGuia() {
        return derStGuia;
    }

    public void setDerStGuia(String derStGuia) {
        this.derStGuia = derStGuia;
    }

    public String getDerStMaterial() {
        return derStMaterial;
    }

    public void setDerStMaterial(String derStMaterial) {
        this.derStMaterial = derStMaterial;
    }

    public String getDerStObsRepeticao() {
        return derStObsRepeticao;
    }

    public void setDerStObsRepeticao(String derStObsRepeticao) {
        this.derStObsRepeticao = derStObsRepeticao;
    }

    public String getDerStOrdemItegracao() {
        return derStOrdemItegracao;
    }

    public void setDerStOrdemItegracao(String derStOrdemItegracao) {
        this.derStOrdemItegracao = derStOrdemItegracao;
    }

    public String getDerStUnidadeAss() {
        return derStUnidadeAss;
    }

    public void setDerStUnidadeAss(String derStUnidadeAss) {
        this.derStUnidadeAss = derStUnidadeAss;
    }

    public String getDerStUnidadeEx() {
        return derStUnidadeEx;
    }

    public void setDerStUnidadeEx(String derStUnidadeEx) {
        this.derStUnidadeEx = derStUnidadeEx;
    }

    public String getDerStVolume() {
        return derStVolume;
    }

    public void setDerStVolume(String derStVolume) {
        this.derStVolume = derStVolume;
    }

  
    public Long getEquInCodigo() {
        return equInCodigo;
    }

    public void setEquInCodigo(Long equInCodigo) {
        this.equInCodigo = equInCodigo;
    }

    public String getEquStCodigo() {
        return equStCodigo;
    }

    public void setEquStCodigo(String equStCodigo) {
        this.equStCodigo = equStCodigo;
    }

    public String getFrlCodigo() {
        return frlCodigo;
    }

    public void setFrlCodigo(String frlCodigo) {
        this.frlCodigo = frlCodigo;
    }

    public String getGrpStCodigo() {
        return grpStCodigo;
    }

    public void setGrpStCodigo(String grpStCodigo) {
        this.grpStCodigo = grpStCodigo;
    }

    public String getLegStCodigo() {
        return legStCodigo;
    }

    public void setLegStCodigo(String legStCodigo) {
        this.legStCodigo = legStCodigo;
    }

    public String getLegStCodigoFat() {
        return legStCodigoFat;
    }

    public void setLegStCodigoFat(String legStCodigoFat) {
        this.legStCodigoFat = legStCodigoFat;
    }

    public String getLotStCodigo() {
        return lotStCodigo;
    }

    public void setLotStCodigo(String lotStCodigo) {
        this.lotStCodigo = lotStCodigo;
    }

    public String getMatStCodigo() {
        return matStCodigo;
    }

    public void setMatStCodigo(String matStCodigo) {
        this.matStCodigo = matStCodigo;
    }

    public String getMetStCodigo() {
        return metStCodigo;
    }

    public void setMetStCodigo(String metStCodigo) {
        this.metStCodigo = metStCodigo;
    }

    public String getMorStCodigo() {
        return morStCodigo;
    }

    public void setMorStCodigo(String morStCodigo) {
        this.morStCodigo = morStCodigo;
    }

    public String getObsStCodigo() {
        return obsStCodigo;
    }

    public void setObsStCodigo(String obsStCodigo) {
        this.obsStCodigo = obsStCodigo;
    }

    public String getOriStCodigo() {
        return oriStCodigo;
    }

    public void setOriStCodigo(String oriStCodigo) {
        this.oriStCodigo = oriStCodigo;
    }

    public String getPexStCodigo() {
        return pexStCodigo;
    }

    public void setPexStCodigo(String pexStCodigo) {
        this.pexStCodigo = pexStCodigo;
    }

    public String getPfeStCodigo() {
        return pfeStCodigo;
    }

    public void setPfeStCodigo(String pfeStCodigo) {
        this.pfeStCodigo = pfeStCodigo;
    }

    public String getRecStCodigo() {
        return recStCodigo;
    }

    public void setRecStCodigo(String recStCodigo) {
        this.recStCodigo = recStCodigo;
    }

    public Date getReqDtCadastro() {
        return reqDtCadastro;
    }

    public void setReqDtCadastro(Date reqDtCadastro) {
        this.reqDtCadastro = reqDtCadastro;
    }

    public Long getReqInCodigo() {
        return reqInCodigo;
    }

    public void setReqInCodigo(Long reqInCodigo) {
        this.reqInCodigo = reqInCodigo;
    }

    public String getReqStCodigoLis() {
        return reqStCodigoLis;
    }

    public void setReqStCodigoLis(String reqStCodigoLis) {
        this.reqStCodigoLis = reqStCodigoLis;
    }

    public Date getResDtValidade() {
        return resDtValidade;
    }

    public void setResDtValidade(Date resDtValidade) {
        this.resDtValidade = resDtValidade;
    }

    public String getSetStCodigo() {
        return setStCodigo;
    }

    public void setSetStCodigo(String setStCodigo) {
        this.setStCodigo = setStCodigo;
    }

    public String getSisStCodigo() {
        return sisStCodigo;
    }

    public void setSisStCodigo(String sisStCodigo) {
        this.sisStCodigo = sisStCodigo;
    }

    public Long getSorInCodigo() {
        return sorInCodigo;
    }

    public void setSorInCodigo(Long sorInCodigo) {
        this.sorInCodigo = sorInCodigo;
    }

    public String getSubStSequencia() {
        return subStSequencia;
    }

    public void setSubStSequencia(String subStSequencia) {
        this.subStSequencia = subStSequencia;
    }

    public String getTabStCodigo() {
        return tabStCodigo;
    }

    public void setTabStCodigo(String tabStCodigo) {
        this.tabStCodigo = tabStCodigo;
    }

    public String getTapStCodigo() {
        return tapStCodigo;
    }

    public void setTapStCodigo(String tapStCodigo) {
        this.tapStCodigo = tapStCodigo;
    }

    public String getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(String uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }

    public String getUsuStCodigo() {
        return usuStCodigo;
    }

    public void setUsuStCodigo(String usuStCodigo) {
        this.usuStCodigo = usuStCodigo;
    }

    public String getUsuStCodigoAss() {
        return usuStCodigoAss;
    }

    public void setUsuStCodigoAss(String usuStCodigoAss) {
        this.usuStCodigoAss = usuStCodigoAss;
    }

    public Character getDerChColetado() {
        return derChColetado;
    }

    public void setDerChColetado(Character derChColetado) {
        this.derChColetado = derChColetado;
    }

    public Character getDerChEnviadoRegLab() {
        return derChEnviadoRegLab;
    }

    public void setDerChEnviadoRegLab(Character derChEnviadoRegLab) {
        this.derChEnviadoRegLab = derChEnviadoRegLab;
    }

    public Character getDerChTipo() {
        return derChTipo;
    }

    public void setDerChTipo(Character derChTipo) {
        this.derChTipo = derChTipo;
    }

    public Date getDerDtLastUpdate() {
        return derDtLastUpdate;
    }

    public void setDerDtLastUpdate(Date derDtLastUpdate) {
        this.derDtLastUpdate = derDtLastUpdate;
    }

    public Integer getDerInTempo() {
        return derInTempo;
    }

    public void setDerInTempo(Integer derInTempo) {
        this.derInTempo = derInTempo;
    }

    public String getDerStProcedimentoAlt() {
        return derStProcedimentoAlt;
    }

    public void setDerStProcedimentoAlt(String derStProcedimentoAlt) {
        this.derStProcedimentoAlt = derStProcedimentoAlt;
    }

    public String getDerStSeqIntegracao() {
        return derStSeqIntegracao;
    }

    public void setDerStSeqIntegracao(String derStSeqIntegracao) {
        this.derStSeqIntegracao = derStSeqIntegracao;
    }

    public String getRegStCodigo() {
        return regStCodigo;
    }

    public void setRegStCodigo(String regStCodigo) {
        this.regStCodigo = regStCodigo;
    }

    
    public String getDerStDescricao() {
        return derStDescricao;
    }

    public void setDerStDescricao(String derStDescricao) {
        this.derStDescricao = derStDescricao;
    }
    
    public String getMatStCodigoDescricao() {
        return matStCodigoDescricao;
    }

    public void setMatStCodigoDescricao(String matStCodigoDescricao) {
        this.matStCodigoDescricao = matStCodigoDescricao;
    }

    public String getMatStDescricao() {
        if(matStDescricao == null){
            if(matStCodigo != null){
                LabMaterial lm = (LabMaterial) OracleHelper.getObject(LabMaterial.class, this.matStCodigo);
                if(lm != null){
                    matStDescricao = lm.getMatStDescricao();
                }
            }
        }else{
            return matStDescricao;
        }
        return matStDescricao;
    }

    @Transient
    public boolean isBlGroupControl() {
        return blGroupControl;
    }

    public void setBlGroupControl(boolean blGroupControl) {
        this.blGroupControl = blGroupControl;
    }

    public boolean isBlOutOfDate() {
        return blOutOfDate;
    }

    public void setBlOutOfDate(boolean blOutOfDate) {
        this.blOutOfDate = blOutOfDate;
    }
    
    public String getLegStDescricao() {
        if(legStDescricao == null){
            if(legStCodigo != null){
                 LabLegenda lg =(LabLegenda) OracleHelper.getObject(LabLegenda.class , legStCodigo);
                 if(lg != null){
                     legStDescricao = lg.getLegStDescricao();
                 }
            }
        }else{
            return legStDescricao;
        }
        return legStDescricao;
    }

    
    public String getUrlImgConf() {
        return urlImgConf;
    }

    public void setUrlImgConf(String urlImgConf) {
        this.urlImgConf = urlImgConf;
    }
    
    public String getUrlImgConfFat() {
        return urlImgConfFat;
    }

    public void setUrlImgConfFat(String urlImgConfFat) {
        this.urlImgConfFat = urlImgConfFat;
    }

    @Transient
    public Character getExuChObrigaMaterial() {
        return exuChObrigaMaterial;
    }

    public void setExuChObrigaMaterial(Character exuChObrigaMaterial) {
        this.exuChObrigaMaterial = exuChObrigaMaterial;
    }

    public List<LabResultados> getListLabResultados() {
        if(listLabResultados == null && derInCodigo != null){
            listLabResultados = OracleHelper.getListLabResultados(derInCodigo);
        }
        return listLabResultados;
    }

    public void setListLabResultados(List<LabResultados> listLabResultados) {
        this.listLabResultados = listLabResultados;
    }






//    @Transient
//    public static LabDetalheRequisicao  makeCustomLabDetRequisicao(
//             Character derChUrgente,
//             ExameFormatado ef,LabSolicitante ls,
//             LabUsuario lus,LabUnidade lu,
//             LabConvenio lc,LabRegras lrg,
//             LabRequisicao lrq,LabExame le,
//             LabLocal ll,
//             Character trouxeMat,String myGrpStCodigo,
//             LabOrigem lo,
//             String matStCodigo){
//
//         Calendar cal =   Calendar.getInstance();
//         Date today = cal.getTime();
//         Timestamp ttoday = new Timestamp(today.getTime());
//
//          String myUnidadeEx = "nada";
//         Character myderChLiberacaoAutomatica =  'S';
//         String myLegStCodigo = "";
//         String myLegStCodigoFat = "";
//
//        LabExameUnidadePK leupk = new LabExameUnidadePK();
//        leupk.setExaStCodigo(le.getExaStCodigo());
//        leupk.setUniStCodigo(lu.getUniStCodigo());
//
//        LabExameUnidade leu =  (LabExameUnidade) OracleHelper.getObject(LabExameUnidade.class, leupk);
//
//                if(derChUrgente.toString().equalsIgnoreCase("S")){
//
//                }else{
//
//                }
//
//
//         if(derChUrgente.toString().equalsIgnoreCase("S")){
//             myUnidadeEx = leu.getExuStUnidadeExUrgente();
//         }else{
//             myUnidadeEx = leu.getExuStUnidadeEx();
//         }
//         if(leu.getExuChLiberaIngressoManual().toString().equalsIgnoreCase("S")){
//           myderChLiberacaoAutomatica = 'N';
//         }
//        if(leu.getExuChConfereAutomaticoFat().toString().equalsIgnoreCase("S")){
//            myLegStCodigo = "002";
//            myLegStCodigoFat = "FAT";
//        }else{
//            myLegStCodigo = "001";
//            myLegStCodigoFat = "";
//        }
//
//
//
//
//
//
//
//         return new LabDetalheRequisicao(lrq.getReqStCodigo() ,
//                 le,
//                 "01",
//                 lu.getUniStCodigo(),
//                  myUnidadeEx,  // derStCodigoEx
//                 null,//String morStCodigo
//                 ef.getSetStCodigo(),
//                 null ,//String equStCodigo
//                 null, // String obsStCodigo
//                 null ,//String pexStCodigo
//                 null , //String amoStCodigo
//                 myLegStCodigo,//String legStCodigo
//                 myLegStCodigoFat ,//String legStCodigoFat
//                 ef.getTapStCodigo() ,
//                 ef.getTabStCodigo() ,
//                 derChUrgente ,//Character derChUrgente
//                  myderChLiberacaoAutomatica,//Character derChLiberacaoAutomatica
//                 myderChLiberacaoAutomatica ,//Character derChAutomatico
//                 null ,// Integer derInRepeticao
//                 null,//String derStDiluicao
//                 'N' ,//Character derChNaoNecessario
//                 0 ,//Integer derInFlag
//                 null ,//Integer derInEnvioLis
//                 'N' ,//Character derChParcial
//                 'N' ,//Character derChRepetir
//                 null ,//String derStAutorizacao
//                 null,//Date derDtEntradaMat
//                 null,//Date derHREntradaMat
//                 trouxeMat,//Character derChTrouxeMat
//                 ef.getRtpFlValorCh(),//Float derFlValorCh
//                ef.getTabFlQtDeCh() ,// Float derFlQtDeCh
//                 null,//Date derDtDataFatura
//                 null,//Date derHrHoraFatura
//                 null,//Date derDtDataPrevistaEntrega
//                 null,//Date derHrHoraPrevistaEntrega
//                 null, //String lotStCodigo
//                 lus.getUniStCodigo(),//String usuStCodigo
//                 'N',//Character derChInterface
//                 ef.getMetStCodigo(),//String metStCodigo
//                 ttoday,//Date emvDtValidade  ??????????????????????????????????????????????
//                 null, //Date resDtValidade
//                 null,//Integer derInMapaSeq
//                 myGrpStCodigo, //String grpStCodigo
//                 null,//String apoStCodigo
//                 null,//String frlCodigo ???????????????????????????????????????????
//                 null,//Integer derInLaudoSeq  ???????????????????????????????????????????????????
//                 null,//Float derFlConvenio  valor liquido
//                 null,//Float derFlDesconto  rtpFlDesconto
//                 null,//Float derFlAcrescimo null
//                 null,//Character derChVlDiferenciado sim ou nao deacordo c a conta
//                 null,//String usuStCodigoAss
//                 null,//Character derChFatura  exuChFatura or exaChaFatura grupo
//                 'N',//Character derChImpresso  ????????????????????????????
//                 'N',//Character derChIncluidoAposConf ?????????????????????????
//                 null,//String derStObsRepeticao
//                 null,//Character derChEtiqueta ????????????????????????
//                 OracleConnector.getDerInCodigo(),//Long derInCodigo
//                 null,//Integer derInValidadeRes  ???????????????
//                 null,//String recStCodigo  ????????????????
//                 null,//Long sorInCodigo  ????????????
//                 null,//Integer derInVertical   ?????????
//                 null,//Integer derInHorizontal ??????????
//                 null,//String pfeStCodigo  ?????
//                 null,//Integer derInViasImpressas ????????
//                 null,//Character derChNovaColeta  ???????
//                 null,//String derStVolume  ?????
//                 null,//String derStOrdemItegracao
//                 'N',//Character derChOmiteCad  ??????????????????????
//                 lrq.getReqDtCadastro(),//Date reqDtCadastro
//                 matStCodigo,//String matStCodigo
//                 null,//String derStGuia
//                 null,//String derStMaterial
//                 null,//Date derDtAssinatura
//                 null,//Date derDtFatura
//                 null,//Character derChEnvioOla
//                 null,//Date derDtImpressao
//                 null,//Character derChEspecial
//                 null,//Character derChEnviadoHis
//                 null,//String sisStCodigo
//                 lu.getUniStCodigo(),//String derStUnidadeAss  ???????
//                 null,//String cntStCodigo
//                 null,//String reqStCodigoLis
//                 null,//Date derDtDataTransporte
//                 null,//Long reqInCodigo
//                 lo.getLocStCodigo(),//String oriStCodigo
//                 lc.getConStCodigo(),//String conStCodigo
//                 null,//Long equInCodigo
//                 null,//Date derDtColeta
//                 null,//Date derHrColeta
//                 null,//Character derChRestricao
//                 null,//String depStCodigo
//                 null,//String subStSequencia
//                 null,//Character derChFaturaExterno
//                 null,//Integer derInTempo
//                 null,//Character derChColetado
//                 null,//Date derDtLastUpdate
//                 null,//String derStSeqIntegracao
//                 null,//Character derChEnviadoRegLab
//                  '1',//Character derChTipo
//                 null,//String derStProcedimentoAlt
//                 lrg.getRegStCodigo()//String regStCodigo
//                 );
//     }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LabDetalheRequisicao other = (LabDetalheRequisicao) obj;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (this.reqStCodigo != null ? this.reqStCodigo.hashCode() : 0);
        hash = 83 * hash + (this.exaStCodigo != null ? this.exaStCodigo.hashCode() : 0);
        hash = 83 * hash + (this.seqStCodigo != null ? this.seqStCodigo.hashCode() : 0);
        return hash;
    }

    

   
}
