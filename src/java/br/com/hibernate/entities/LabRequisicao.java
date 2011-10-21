/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.entities;


import br.com.hibernate.utils.OracleHelper;
import br.com.utils.shared.ArrayItens;
import java.io.Serializable;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author eros
 */

@Entity
@Table(name="LAB_REQUISICAO")
public class LabRequisicao implements Serializable{


    @Id
    @Column(name="REQ_IN_CODIGO")
    private Long reqInCodigo;

    
    @Column(name="REQ_ST_CODIGO")
    private String reqStCodigo;


//    @ManyToOne
//    @JoinColumns({
//        @JoinColumn(name="ORI_ST_CODIGO"),
//        @JoinColumn(name="UNI_ST_CODIGO")
//    })
    @Column(name="ORI_ST_CODIGO")
    private String oriStCodigo;
//    @Column(name="ORI_ST_CODIGO")
//    private String oriStCodigo;

    
//    @ManyToOne
//    @JoinColumn(name="UNI_ST_CODIGO",nullable=false, updatable=false, insertable=false)//mappeded
    @Column(name="UNI_ST_CODIGO",nullable=false, updatable=false, insertable=false)//mappeded
    private String uniStCodigo;

//    @ManyToOne
//    @JoinColumn(name="CON_ST_CODIGO")//mappeded
    @Column(name="CON_ST_CODIGO")//mappeded
    private String conStCodigo;


   //    @ManyToOne
//    @JoinColumns({
//        @JoinColumn(name="UNI_ST_CODIGO"),
//        @JoinColumn(name="LOC_ST_CODIGO")
//    })\
    @Column(name="LOC_ST_CODIGO")
    private String locStCodigo;






//    @ManyToOne
//    @JoinColumns({
//        @JoinColumn(name="UNI_ST_CODIGO",nullable=false, updatable=false, insertable=false),
//        @JoinColumn(name="CON_ST_CODIGO",nullable=false, updatable=false, insertable=false),
//        @JoinColumn(name="REG_ST_CODIGO",nullable=false, updatable=false, insertable=false)
//    })
    @Column(name="REG_ST_CODIGO")
    private String regStCodigo;

    @ManyToOne
    @JoinColumn(name="PAC_IN_CODIGO")
    private LabPaciente pacInCodigo;


    @Column(name="CID_ST_CODIGO")
    private String cidStCodigo;


//    @ManyToOne
//    @JoinColumns({
//        @JoinColumn(name="SOL_ST_ESTADO"),
//        @JoinColumn(name="PRO_ST_CODIGO"),
//        @JoinColumn(name="SOL_ST_CODIGO")
//
//    })
    @Column(name="SOL_ST_CODIGO")
    private String solStCodigo;
//    @ManyToOne
//    @JoinColumn(name="LEG_ST_CODIGO")//mappeded
    @Column(name="LEG_ST_CODIGO")//mappeded
    private String legStCodigo;
//    @ManyToOne
//    @JoinColumns({
//        @JoinColumn(name="ALO_IN_CODIGO",nullable=false, updatable=false, insertable=false),
//        @JoinColumn(name="UNI_ST_CODIGO",nullable=false, updatable=false, insertable=false)
//    })
    @Column(name="ALO_IN_CODIGO")
    private Long aloInCodigo;

    @Column(name="SOL_ST_ESTADO")
    private String solStEstado;
    
    @Column(name="REQ_DT_CADASTRO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date reqDtCadastro;
    @Column(name="REQ_HR_CADASTRO")
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date reqHrCadastro;
    @Column(name="REQ_ST_GUIA")
    private String reqStGuia;
    @Column(name="REQ_ST_MATRICULA")
    private String reqStMatricula;
    @Column(name="REQ_DT_VALIDADECART")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date reqDtValidadeCart;
    @Column(name="REQ_ST_QUARTO")
    private String reqStQuarto;
    @Column(name="REQ_ST_LEITO")
    private String reqStLeito;
    @Column(name="REQ_CH_PRECADASTRO")
    private Character reqChPrecadastro;
    @Column(name="REQ_ST_DUM")
    private String reqStDUM;
//    @ManyToOne
//    @JoinColumn(name="PRO_ST_CODIGO")//mappeded
    @Column(name="PRO_ST_CODIGO")//mappeded
    private String proStCodigo;
    
//    @ManyToOne
//    @JoinColumns({
//        @JoinColumn(name="COL_ST_CODIGO"),
//        @JoinColumn(name="UNI_ST_CODIGO")
//    })
//    private LabColetor colStCodigo;


    @Column(name="COL_ST_CODIGO")
    private String colStCodigo;
    @Column(name="REQ_IN_FLAG")
    private Integer regInFlag;
    @Column(name="REQ_CH_ETIQUETA")
    private Character reqChEtiqueta;
    @Column(name="REQ_ST_PESO")
    private String reqStPeso;
    @Column(name="REQ_ST_ALTURA")
    private String reqStAltura;
    @Column(name="REQ_DT_FATURA")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date reqDtFatura;
    @Column(name="REQ_DT_ETIQUETA")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date reqDtEtiqueta;
    @Column(name="REQ_HR_ETIQUETA")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date reqHrEtiqueta;
    @Column(name="USU_ST_CODIGOETIQUETA")
    private String usuStCodigoEtiqueta;
    @Lob
    @Column(name="REQ_BL_OBSMEDICAMENTO")
    private String reqBlObsMedicamento;
    @Lob
    @Column(name="REQ_BL_OBSHD")
    private String reqBlObsHD;
    @Lob
    @Column(name="REQ_BL_OBSERVACAO")
    private String reqBlObservacao;
    @Column(name="REQ_ST_CODIGOALT")
    private String reqStCodigoAlt;
    @Column(name="REQ_CH_ENVIADO")
    private Character reqChEnviado;
    @Column(name="LEG_ST_CODIGOFAT")
    private String legStCodigoFat;
    @Column(name="REQ_CH_URGENTE")
    private Character reqChUrgente;
    @Column(name="REQ_CH_NOVO")
    private Character reqChNovo;
    @Column(name="REQ_DT_ASSINATURA")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date reqDtAssinatura;
    @Column(name="REQ_DT_TRIAGEM")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date reqDtTriagem;
    @Column(name="REQ_CH_RN")
    private Character reqChRN;
    @Column(name="REQ_IN_VIASIMPRESSAS")
    private Integer reqInViasImpressas;
    @Column(name="REQ_CH_AGENDADO")
    private Character reqChAgendado;
    @Column(name="REQ_ST_CODIGOTESTE")
    private String reqStCodigoTeste;
    @Column(name="REQ_DT_COLETA")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date reqDtColeta;
    @Column(name="REQ_HR_COLETA")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date reqHrColeta;
    @Column(name="REQ_DT_IMPRESSAO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date reqDtImpressao;
    @Column(name="REQ_CH_OCORRENCIA")
    private Character reqChOcorrencia;
    @Column(name="REQ_CH_GESTANTE")
    private Character reqChGestante;
    @Column(name="REQ_CH_ESPECIAL")
    private Character reqChEspecial;
    @Column(name="REQ_ST_CODIGOLIS")
    private String reqStCodigoLis;
    @Column(name="REQ_IN_ENVIOLIS")
    private Integer reqInEnvioLis;
    
    @Column(name="REQ_CH_ATENDIDO")
    private Character reqChAtendido;
    @Column(name="REQ_CH_CHAMADO")
    private Character reqChChamado;
    @Column(name="REQ_HR_CHAMADO")
    private Timestamp reqHrChamado;
    @Column(name="REQ_HR_ATENDIDO")
    private Timestamp regHrAtendido;
//    @ManyToOne
//    @JoinColumn(name="AGP_IN_CODIGO")//mappeded
//    private LabAgendaPaciente agpInCodigo;
    @Column(name="REQ_ST_CODBENEF")
    private String reqStCodBenef;



    @OneToMany(mappedBy="reqStCodigo")
    private List<LabDetalheRequisicao> listLabDetalheRequisicao;
    
    @Transient
    private List<LabDetalheRequisicao> listLabDetalheRequisicaoFiltrado;




    @Transient
    private LabSolicitante buscaLabSolicitante;
    @Transient
    private LabRegras buscaLabRegra;
    @Transient
    private LabColetor buscaLabColetor;

    public LabRequisicao() {
    }

    public LabRequisicao(Long reqInCodigo, String reqStCodigo) {
        this.reqInCodigo = reqInCodigo;
        this.reqStCodigo = reqStCodigo;
    }

    
    
  

    public String getColStCodigo() {
        return colStCodigo;
    }

    public void setColStCodigo(String colStCodigo) {
        this.colStCodigo = colStCodigo;
    }



    public String getCidStCodigo() {
        return cidStCodigo;
    }

    public void setCidStCodigo(String cidStCodigo) {
        this.cidStCodigo = cidStCodigo;
    }

    public String getOriStCodigo() {
        return oriStCodigo;
    }

    public void setOriStCodigo(String oriStCodigo) {
        this.oriStCodigo = oriStCodigo;
    }

    public String getConStCodigo() {
        return conStCodigo;
    }

    public void setConStCodigo(String conStCodigo) {
        this.conStCodigo = conStCodigo;
    }
    public String getLocStCodigo() {
        return locStCodigo;
    }

    public void setLocStCodigo(String locStCodigo) {
        this.locStCodigo = locStCodigo;
    }

    public String getProStCodigo() {
        return proStCodigo;
    }

    public void setProStCodigo(String proStCodigo) {
        this.proStCodigo = proStCodigo;
    }


    public List<LabDetalheRequisicao> getListLabDetalheRequisicao() {
        return listLabDetalheRequisicao;
    }

    public void setListLabDetalheRequisicao(List<LabDetalheRequisicao> listLabDetalheRequisicao) {
        this.listLabDetalheRequisicao = listLabDetalheRequisicao;
    }

    @Transient
    public List<LabDetalheRequisicao> getListLabDetalheRequisicaoFiltrado() {
//        if(this.reqInCodigo != null){
//            listLabDetalheRequisicaoFiltrado = OracleHelper.getListOfObjectByKeyEq(LabDetalheRequisicao.class, "reqStCodigo", this.reqStCodigo, "reqStCodigo", true);
//        }
        return listLabDetalheRequisicaoFiltrado;
    }

    public void setListLabDetalheRequisicaoFiltrado(List<LabDetalheRequisicao> listLabDetalheRequisicaoFiltrado) {
        this.listLabDetalheRequisicaoFiltrado = listLabDetalheRequisicaoFiltrado;
    }
    
    
    
    @Transient
    public String getListTextExames(){
        StringBuilder sb = new StringBuilder();
        if(listLabDetalheRequisicaoFiltrado != null && listLabDetalheRequisicaoFiltrado.size()>0){
            boolean bltIghterText = false;
            for(int i = 0 ; i < listLabDetalheRequisicaoFiltrado.size(); i ++){
                LabDetalheRequisicao ldr = listLabDetalheRequisicaoFiltrado.get(i);
                bltIghterText = listLabDetalheRequisicaoFiltrado.size() > 17 ?  true : false; 
                sb.append(ldr.getExaStCodigo())
                        .append(ArrayItens.getMapLegResumido().get(ldr.getLegStCodigo()));
                
                if(bltIghterText){
                    if(i < listLabDetalheRequisicaoFiltrado.size()-1){sb.append(", ");}
                }else{
                    if(i < listLabDetalheRequisicaoFiltrado.size()-1){sb.append(" , ");}
                }
                
                
            }
        }
        return sb.toString();
    }
    
    public Long getAloInCodigo() {
        return aloInCodigo;
    }

    public void setAloInCodigo(Long aloInCodigo) {
        this.aloInCodigo = aloInCodigo;
    }

    public String getLegStCodigo() {
        return legStCodigo;
    }

    public void setLegStCodigo(String legStCodigo) {
        this.legStCodigo = legStCodigo;
    }

    public String getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(String uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }

    

    public String getLegStCodigoFat() {
        return legStCodigoFat;
    }

    public void setLegStCodigoFat(String legStCodigoFat) {
        this.legStCodigoFat = legStCodigoFat;
    }

    public LabPaciente getPacInCodigo() {
        return pacInCodigo;
    }

    public void setPacInCodigo(LabPaciente pacInCodigo) {
        this.pacInCodigo = pacInCodigo;
    }

    public Timestamp getRegHrAtendido() {
        return regHrAtendido;
    }

    public void setRegHrAtendido(Timestamp regHrAtendido) {
        this.regHrAtendido = regHrAtendido;
    }

    public Integer getRegInFlag() {
        return regInFlag;
    }

    public void setRegInFlag(Integer regInFlag) {
        this.regInFlag = regInFlag;
    }

    public String getReqBlObsHD() {
        return reqBlObsHD;
    }

    public void setReqBlObsHD(String reqBlObsHD) {
        this.reqBlObsHD = reqBlObsHD;
    }

    public String getReqBlObsMedicamento() {
        return reqBlObsMedicamento;
    }

    public void setReqBlObsMedicamento(String reqBlObsMedicamento) {
        this.reqBlObsMedicamento = reqBlObsMedicamento;
    }

    public String getReqBlObservacao() {
        return reqBlObservacao;
    }

    public void setReqBlObservacao(String reqBlObservacao) {
        this.reqBlObservacao = reqBlObservacao;
    }

    public Character getReqChAgendado() {
        return reqChAgendado;
    }

    public void setReqChAgendado(Character reqChAgendado) {
        this.reqChAgendado = reqChAgendado;
    }

    public Character getReqChAtendido() {
        return reqChAtendido;
    }

    public void setReqChAtendido(Character reqChAtendido) {
        this.reqChAtendido = reqChAtendido;
    }

    public Character getReqChChamado() {
        return reqChChamado;
    }

    public void setReqChChamado(Character reqChChamado) {
        this.reqChChamado = reqChChamado;
    }

    public Character getReqChEnviado() {
        return reqChEnviado;
    }

    public void setReqChEnviado(Character reqChEnviado) {
        this.reqChEnviado = reqChEnviado;
    }

    public Character getReqChEspecial() {
        return reqChEspecial;
    }

    public void setReqChEspecial(Character reqChEspecial) {
        this.reqChEspecial = reqChEspecial;
    }

    public Character getReqChEtiqueta() {
        return reqChEtiqueta;
    }

    public void setReqChEtiqueta(Character reqChEtiqueta) {
        this.reqChEtiqueta = reqChEtiqueta;
    }

    public Character getReqChGestante() {
        return reqChGestante;
    }

    public void setReqChGestante(Character reqChGestante) {
        this.reqChGestante = reqChGestante;
    }

    public Character getReqChNovo() {
        return reqChNovo;
    }

    public void setReqChNovo(Character reqChNovo) {
        this.reqChNovo = reqChNovo;
    }

    public Character getReqChOcorrencia() {
        return reqChOcorrencia;
    }

    public void setReqChOcorrencia(Character reqChOcorrencia) {
        this.reqChOcorrencia = reqChOcorrencia;
    }

    public Character getReqChPrecadastro() {
        return reqChPrecadastro;
    }

    public void setReqChPrecadastro(Character reqChPrecadastro) {
        this.reqChPrecadastro = reqChPrecadastro;
    }

    public Character getReqChRN() {
        return reqChRN;
    }

    public void setReqChRN(Character reqChRN) {
        this.reqChRN = reqChRN;
    }

    public Character getReqChUrgente() {
        return reqChUrgente;
    }

    public void setReqChUrgente(Character reqChUrgente) {
        this.reqChUrgente = reqChUrgente;
    }

    public String getRegStCodigo() {
        return regStCodigo;
    }

    public void setRegStCodigo(String regStCodigo) {
        this.regStCodigo = regStCodigo;
    }

 

    public Date getReqDtAssinatura() {
        return reqDtAssinatura;
    }

    public void setReqDtAssinatura(Date reqDtAssinatura) {
        this.reqDtAssinatura = reqDtAssinatura;
    }

    public Date getReqDtCadastro() {
        return reqDtCadastro;
    }

    public void setReqDtCadastro(Date reqDtCadastro) {
        this.reqDtCadastro = reqDtCadastro;
    }

    public Date getReqDtColeta() {
        return reqDtColeta;
    }

    public void setReqDtColeta(Date reqDtColeta) {
        this.reqDtColeta = reqDtColeta;
    }

    public Date getReqDtEtiqueta() {
        return reqDtEtiqueta;
    }

    public void setReqDtEtiqueta(Date reqDtEtiqueta) {
        this.reqDtEtiqueta = reqDtEtiqueta;
    }

    public Date getReqDtFatura() {
        return reqDtFatura;
    }

    public void setReqDtFatura(Date reqDtFatura) {
        this.reqDtFatura = reqDtFatura;
    }

    public Date getReqDtImpressao() {
        return reqDtImpressao;
    }

    public void setReqDtImpressao(Date reqDtImpressao) {
        this.reqDtImpressao = reqDtImpressao;
    }

    public Date getReqDtTriagem() {
        return reqDtTriagem;
    }

    public void setReqDtTriagem(Date reqDtTriagem) {
        this.reqDtTriagem = reqDtTriagem;
    }

    public Date getReqDtValidadeCart() {
        return reqDtValidadeCart;
    }

    public void setReqDtValidadeCart(Date reqDtValidadeCart) {
        this.reqDtValidadeCart = reqDtValidadeCart;
    }

    public Date getReqHrCadastro() {
        return reqHrCadastro;
    }

    public void setReqHrCadastro(Date reqHrCadastro) {
        this.reqHrCadastro = reqHrCadastro;
    }

 

    public Timestamp getReqHrChamado() {
        return reqHrChamado;
    }

    public void setReqHrChamado(Timestamp reqHrChamado) {
        this.reqHrChamado = reqHrChamado;
    }

    public Date getReqHrColeta() {
        return reqHrColeta;
    }

    public void setReqHrColeta(Date reqHrColeta) {
        this.reqHrColeta = reqHrColeta;
    }

    public Date getReqHrEtiqueta() {
        return reqHrEtiqueta;
    }

    public void setReqHrEtiqueta(Date reqHrEtiqueta) {
        this.reqHrEtiqueta = reqHrEtiqueta;
    }

    public Long getReqInCodigo() {
        return reqInCodigo;
    }

    public void setReqInCodigo(Long reqInCodigo) {
        this.reqInCodigo = reqInCodigo;
    }

    public Integer getReqInEnvioLis() {
        return reqInEnvioLis;
    }

    public void setReqInEnvioLis(Integer reqInEnvioLis) {
        this.reqInEnvioLis = reqInEnvioLis;
    }

    public Integer getReqInViasImpressas() {
        return reqInViasImpressas;
    }

    public void setReqInViasImpressas(Integer reqInViasImpressas) {
        this.reqInViasImpressas = reqInViasImpressas;
    }

    public String getReqStAltura() {
        return reqStAltura;
    }

    public void setReqStAltura(String reqStAltura) {
        this.reqStAltura = reqStAltura;
    }

    public String getReqStCodBenef() {
        return reqStCodBenef;
    }

    public void setReqStCodBenef(String reqStCodBenef) {
        this.reqStCodBenef = reqStCodBenef;
    }

    public String getReqStCodigo() {
        return reqStCodigo;
    }

    public void setReqStCodigo(String reqStCodigo) {
        this.reqStCodigo = reqStCodigo;
    }

    public String getReqStCodigoAlt() {
        return reqStCodigoAlt;
    }

    public void setReqStCodigoAlt(String reqStCodigoAlt) {
        this.reqStCodigoAlt = reqStCodigoAlt;
    }

    public String getReqStCodigoLis() {
        return reqStCodigoLis;
    }

    public void setReqStCodigoLis(String reqStCodigoLis) {
        this.reqStCodigoLis = reqStCodigoLis;
    }

    public String getReqStCodigoTeste() {
        return reqStCodigoTeste;
    }

    public void setReqStCodigoTeste(String reqStCodigoTeste) {
        this.reqStCodigoTeste = reqStCodigoTeste;
    }

    public String getReqStDUM() {
        return reqStDUM;
    }

    public void setReqStDUM(String reqStDUM) {
        this.reqStDUM = reqStDUM;
    }

    public String getReqStGuia() {
        return reqStGuia;
    }

    public void setReqStGuia(String reqStGuia) {
        this.reqStGuia = reqStGuia;
    }

    public String getReqStLeito() {
        return reqStLeito;
    }

    public void setReqStLeito(String reqStLeito) {
        this.reqStLeito = reqStLeito;
    }

    public String getReqStMatricula() {
        return reqStMatricula;
    }

    public void setReqStMatricula(String reqStMatricula) {
        this.reqStMatricula = reqStMatricula;
    }

    public String getReqStPeso() {
        return reqStPeso;
    }

    public void setReqStPeso(String reqStPeso) {
        this.reqStPeso = reqStPeso;
    }

    public String getReqStQuarto() {
        return reqStQuarto;
    }

    public void setReqStQuarto(String reqStQuarto) {
        this.reqStQuarto = reqStQuarto;
    }

    public String getSolStCodigo() {
        return solStCodigo;
    }

    public void setSolStCodigo(String solStCodigo) {
        this.solStCodigo = solStCodigo;
    }

    public String getUsuStCodigoEtiqueta() {
        return usuStCodigoEtiqueta;
    }

    public void setUsuStCodigoEtiqueta(String usuStCodigoEtiqueta) {
        this.usuStCodigoEtiqueta = usuStCodigoEtiqueta;
    }

    public String getSolStEstado() {
        return solStEstado;
    }

    public void setSolStEstado(String solStEstado) {
        this.solStEstado = solStEstado;
    }
    
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LabRequisicao other = (LabRequisicao) obj;
        if (this.reqInCodigo != other.reqInCodigo && (this.reqInCodigo == null || !this.reqInCodigo.equals(other.reqInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.reqInCodigo != null ? this.reqInCodigo.hashCode() : 0);
        return hash;
    }

    @Transient
    public LabSolicitante getBuscaLabSolicitante(){
        if(this.solStCodigo != null){
            if(buscaLabSolicitante == null){
                 buscaLabSolicitante =  (LabSolicitante) OracleHelper.getObjectByKey(LabSolicitante.class, "solStCodigo",solStCodigo);
                 return buscaLabSolicitante;
            }else{
                 return buscaLabSolicitante;
            }
            
        }
        return null;
    }
    @Transient
    public LabRegras getBuscaLabRegra(){
        if(uniStCodigo != null && conStCodigo != null && regStCodigo != null ){
            if(buscaLabRegra == null){
                buscaLabRegra =  OracleHelper.getLabRegrasByUniStCodigoAndConStCodigoAndRegStCodigo(uniStCodigo, this.conStCodigo
                    , this.getRegStCodigo());
                return buscaLabRegra;
            }else{
                return buscaLabRegra;
            }
          
        }
        return null;
    }
@Transient
public LabColetor getBuscaLabColetor(){
    if(colStCodigo != null && uniStCodigo != null){
        if(buscaLabColetor == null){
              buscaLabColetor = OracleHelper.getLabColetorByColStCodigo_UniStCodigo(this.colStCodigo, uniStCodigo);
              return buscaLabColetor;
        }else{
            return buscaLabColetor;
        }
    }
    
    return null;
}


//    public LabAgendaPaciente getAgpInCodigo() {
//        return agpInCodigo;
//    }
//
//    public void setAgpInCodigo(LabAgendaPaciente agpInCodigo) {
//        this.agpInCodigo = agpInCodigo;
//    }


//    @OneToOne(mappedBy="reqStCodigo")
//    private LabAgendaPaciente labAgendaPaciente;
    
    
    

   

   
}
