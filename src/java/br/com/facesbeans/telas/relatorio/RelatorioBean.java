/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.telas.relatorio;

import br.com.hibernate.entities.LabExame;
import br.com.hibernate.entities.LabLocal;
import br.com.hibernate.entities.LabOrigem;
import br.com.hibernate.entities.LabSetor;
import br.com.hibernate.entities.LabUnidade;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author eros
 */
@SessionScoped
@ManagedBean(name="relatorioBean")
public class RelatorioBean implements Serializable{
    
    
    private String strOptionQuery;
    private Date dtInicioQuery;
    private Date dtFinalQuery;
    
    private String strUniStCodigoCadastro;
    private LabUnidade labUnidadeCadastro;
    private List<LabUnidade> listLabUnidade;
    
    private String strUniStCodigoExcucao;
    private LabUnidade labUnidadeExcucao;
        
    private String strOriStCodigo;
    private LabOrigem labOrigem;
    private List<LabOrigem> listLabOrigem;
    private List<LabOrigem> listLabOrigemSelected;
    
    private String strLocStCodigo;
    private LabLocal labLocal;
    private List<LabLocal> listLabLocal;
    private List<LabLocal> listLabLocalSelected;
    
    
    private String strSetStCodigo;
    private LabSetor labSetor;
    private List<LabSetor> listLabSetor;
    private List<LabSetor> listLabSetorSelected;
    
    private String strExaStCodigo;
    private LabExame labExame;
    private List<LabExame> listLabExame;
    private List<LabExame> listLabExameSelected;
    
    
   
    private boolean blConfCad;
    private boolean blPreTriado;
    private boolean blTriagem;
    private boolean blTradoAP;
    private boolean blRecSetor;
    private boolean blPendente;
    private boolean blCompleto;
    private boolean blIngresso;
    private boolean blLibTec;
    private boolean blAssinado;
    private boolean blConfirma;
    private boolean blCancelado;
    private boolean blArmazenado;
    private boolean blDescartado;
    private boolean blImpresso;
    private boolean bl2Amostra;
    private boolean blLaudado;
    private boolean blNaoColetado;
    private boolean blDeletado;
   private boolean blDevMat;
   private boolean blRemarcado;
   private boolean blPreConf;
   
   
   
    private boolean blOmitidos;
    private boolean blParcial;
    
   private boolean blnNaoConfFat;
   private boolean blFaturados;
   private boolean blNaoConficad;   

    public RelatorioBean() {
        dtInicioQuery = new Date();
        dtFinalQuery = new Date();
    }
   
   
   
   
   

    public boolean isBl2Amostra() {
        return bl2Amostra;
    }

    public void setBl2Amostra(boolean bl2Amostra) {
        this.bl2Amostra = bl2Amostra;
    }

    public boolean isBlArmazenado() {
        return blArmazenado;
    }

    public void setBlArmazenado(boolean blArmazenado) {
        this.blArmazenado = blArmazenado;
    }

    public boolean isBlAssinado() {
        return blAssinado;
    }

    public void setBlAssinado(boolean blAssinado) {
        this.blAssinado = blAssinado;
    }

    public boolean isBlCancelado() {
        return blCancelado;
    }

    public void setBlCancelado(boolean blCancelado) {
        this.blCancelado = blCancelado;
    }

    public boolean isBlCompleto() {
        return blCompleto;
    }

    public void setBlCompleto(boolean blCompleto) {
        this.blCompleto = blCompleto;
    }

    public boolean isBlConfCad() {
        return blConfCad;
    }

    public void setBlConfCad(boolean blConfCad) {
        this.blConfCad = blConfCad;
    }

    public boolean isBlConfirma() {
        return blConfirma;
    }

    public void setBlConfirma(boolean blConfirma) {
        this.blConfirma = blConfirma;
    }

    public boolean isBlDeletado() {
        return blDeletado;
    }

    public void setBlDeletado(boolean blDeletado) {
        this.blDeletado = blDeletado;
    }

    public boolean isBlDescartado() {
        return blDescartado;
    }

    public void setBlDescartado(boolean blDescartado) {
        this.blDescartado = blDescartado;
    }

    public boolean isBlDevMat() {
        return blDevMat;
    }

    public void setBlDevMat(boolean blDevMat) {
        this.blDevMat = blDevMat;
    }

    public boolean isBlFaturados() {
        return blFaturados;
    }

    public void setBlFaturados(boolean blFaturados) {
        this.blFaturados = blFaturados;
    }

    public boolean isBlImpresso() {
        return blImpresso;
    }

    public void setBlImpresso(boolean blImpresso) {
        this.blImpresso = blImpresso;
    }

    public boolean isBlIngresso() {
        return blIngresso;
    }

    public void setBlIngresso(boolean blIngresso) {
        this.blIngresso = blIngresso;
    }

    public boolean isBlLaudado() {
        return blLaudado;
    }

    public void setBlLaudado(boolean blLaudado) {
        this.blLaudado = blLaudado;
    }

    public boolean isBlLibTec() {
        return blLibTec;
    }

    public void setBlLibTec(boolean blLibTec) {
        this.blLibTec = blLibTec;
    }

    public boolean isBlNaoColetado() {
        return blNaoColetado;
    }

    public void setBlNaoColetado(boolean blNaoColetado) {
        this.blNaoColetado = blNaoColetado;
    }

    public boolean isBlNaoConficad() {
        return blNaoConficad;
    }

    public void setBlNaoConficad(boolean blNaoConficad) {
        this.blNaoConficad = blNaoConficad;
    }

    public boolean isBlOmitidos() {
        return blOmitidos;
    }

    public void setBlOmitidos(boolean blOmitidos) {
        this.blOmitidos = blOmitidos;
    }

    public boolean isBlParcial() {
        return blParcial;
    }

    public void setBlParcial(boolean blParcial) {
        this.blParcial = blParcial;
    }

    public boolean isBlPendente() {
        return blPendente;
    }

    public void setBlPendente(boolean blPendente) {
        this.blPendente = blPendente;
    }

    public boolean isBlPreConf() {
        return blPreConf;
    }

    public void setBlPreConf(boolean blPreConf) {
        this.blPreConf = blPreConf;
    }

    public boolean isBlPreTriado() {
        return blPreTriado;
    }

    public void setBlPreTriado(boolean blPreTriado) {
        this.blPreTriado = blPreTriado;
    }

    public boolean isBlRecSetor() {
        return blRecSetor;
    }

    public void setBlRecSetor(boolean blRecSetor) {
        this.blRecSetor = blRecSetor;
    }

    public boolean isBlRemarcado() {
        return blRemarcado;
    }

    public void setBlRemarcado(boolean blRemarcado) {
        this.blRemarcado = blRemarcado;
    }

    public boolean isBlTradoAP() {
        return blTradoAP;
    }

    public void setBlTradoAP(boolean blTradoAP) {
        this.blTradoAP = blTradoAP;
    }

    public boolean isBlTriagem() {
        return blTriagem;
    }

    public void setBlTriagem(boolean blTriagem) {
        this.blTriagem = blTriagem;
    }

    public boolean isBlnNaoConfFat() {
        return blnNaoConfFat;
    }

    public void setBlnNaoConfFat(boolean blnNaoConfFat) {
        this.blnNaoConfFat = blnNaoConfFat;
    }

    public Date getDtInicioQuery() {
        return dtInicioQuery;
    }

    public void setDtInicioQuery(Date dtInicioQuery) {
        this.dtInicioQuery = dtInicioQuery;
    }

    public LabExame getLabExame() {
        return labExame;
    }

    public void setLabExame(LabExame labExame) {
        this.labExame = labExame;
    }

    public LabLocal getLabLocal() {
        return labLocal;
    }

    public void setLabLocal(LabLocal labLocal) {
        this.labLocal = labLocal;
    }

    public LabOrigem getLabOrigem() {
        return labOrigem;
    }

    public void setLabOrigem(LabOrigem labOrigem) {
        this.labOrigem = labOrigem;
    }

    public LabSetor getLabSetor() {
        return labSetor;
    }

    public void setLabSetor(LabSetor labSetor) {
        this.labSetor = labSetor;
    }

    public LabUnidade getLabUnidadeCadastro() {
        return labUnidadeCadastro;
    }

    public void setLabUnidadeCadastro(LabUnidade labUnidadeCadastro) {
        this.labUnidadeCadastro = labUnidadeCadastro;
    }

    public LabUnidade getLabUnidadeExcucao() {
        return labUnidadeExcucao;
    }

    public void setLabUnidadeExcucao(LabUnidade labUnidadeExcucao) {
        this.labUnidadeExcucao = labUnidadeExcucao;
    }

    public List<LabExame> getListLabExame() {
        return listLabExame;
    }

    public void setListLabExame(List<LabExame> listLabExame) {
        this.listLabExame = listLabExame;
    }

    public List<LabExame> getListLabExameSelected() {
        return listLabExameSelected;
    }

    public void setListLabExameSelected(List<LabExame> listLabExameSelected) {
        this.listLabExameSelected = listLabExameSelected;
    }

    public List<LabLocal> getListLabLocal() {
        return listLabLocal;
    }

    public void setListLabLocal(List<LabLocal> listLabLocal) {
        this.listLabLocal = listLabLocal;
    }

    public List<LabLocal> getListLabLocalSelected() {
        return listLabLocalSelected;
    }

    public void setListLabLocalSelected(List<LabLocal> listLabLocalSelected) {
        this.listLabLocalSelected = listLabLocalSelected;
    }

    public List<LabOrigem> getListLabOrigem() {
        return listLabOrigem;
    }

    public void setListLabOrigem(List<LabOrigem> listLabOrigem) {
        this.listLabOrigem = listLabOrigem;
    }

    public List<LabOrigem> getListLabOrigemSelected() {
        return listLabOrigemSelected;
    }

    public void setListLabOrigemSelected(List<LabOrigem> listLabOrigemSelected) {
        this.listLabOrigemSelected = listLabOrigemSelected;
    }

    public List<LabSetor> getListLabSetor() {
        return listLabSetor;
    }

    public void setListLabSetor(List<LabSetor> listLabSetor) {
        this.listLabSetor = listLabSetor;
    }

    public List<LabSetor> getListLabSetorSelected() {
        return listLabSetorSelected;
    }

    public void setListLabSetorSelected(List<LabSetor> listLabSetorSelected) {
        this.listLabSetorSelected = listLabSetorSelected;
    }

    public List<LabUnidade> getListLabUnidade() {
        return listLabUnidade;
    }

    public void setListLabUnidade(List<LabUnidade> listLabUnidade) {
        this.listLabUnidade = listLabUnidade;
    }

    public String getStrExaStCodigo() {
        return strExaStCodigo;
    }

    public void setStrExaStCodigo(String strExaStCodigo) {
        this.strExaStCodigo = strExaStCodigo;
    }

    public String getStrLocStCodigo() {
        return strLocStCodigo;
    }

    public void setStrLocStCodigo(String strLocStCodigo) {
        this.strLocStCodigo = strLocStCodigo;
    }

    public String getStrOptionQuery() {
        return strOptionQuery;
    }

    public void setStrOptionQuery(String strOptionQuery) {
        this.strOptionQuery = strOptionQuery;
    }

    public String getStrOriStCodigo() {
        return strOriStCodigo;
    }

    public void setStrOriStCodigo(String strOriStCodigo) {
        this.strOriStCodigo = strOriStCodigo;
    }

    public String getStrSetStCodigo() {
        return strSetStCodigo;
    }

    public void setStrSetStCodigo(String strSetStCodigo) {
        this.strSetStCodigo = strSetStCodigo;
    }

    public String getStrUniStCodigoCadastro() {
        return strUniStCodigoCadastro;
    }

    public void setStrUniStCodigoCadastro(String strUniStCodigoCadastro) {
        this.strUniStCodigoCadastro = strUniStCodigoCadastro;
    }

    public String getStrUniStCodigoExcucao() {
        return strUniStCodigoExcucao;
    }

    public void setStrUniStCodigoExcucao(String strUniStCodigoExcucao) {
        this.strUniStCodigoExcucao = strUniStCodigoExcucao;
    }
   
   
    
    
            
    
    
    

    public Date getDtFinalQuery() {
        return dtFinalQuery;
    }

    public void setDtFinalQuery(Date dtFinalQuery) {
        this.dtFinalQuery = dtFinalQuery;
    }


    
    
    
    
    
    
    
    
    
    public SelectItem[] getOpcoestens() {

                SelectItem[] d = {new SelectItem("-", "-"),new SelectItem("P", "Pendentes")};
        return d;
    }
    
}
