/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.telas.relatorio;

import br.com.hibernate.entities.LabExame;
import br.com.hibernate.entities.LabLocal;
import br.com.hibernate.entities.LabLocalPK;
import br.com.hibernate.entities.LabOrigem;
import br.com.hibernate.entities.LabOrigemPK;
import br.com.hibernate.entities.LabSetor;
import br.com.hibernate.entities.LabUnidade;
import br.com.hibernate.utils.OracleHelper;
import br.com.utils.tipstricks.ZerosFabrica;
import com.sun.faces.facelets.tag.jstl.core.IndexedValueExpression;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.el.ELContext;
import javax.el.ELException;
import javax.el.PropertyNotFoundException;
import javax.el.PropertyNotWritableException;
import javax.el.ValueExpression;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.primefaces.component.breadcrumb.BreadCrumb;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.toolbar.ToolbarGroup;
import org.primefaces.model.MenuModel;
//import org.primefaces.model.breadcrumb.BreadCrumb;

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
//    private Set<LabUnidade> listLabUnidade;
    
    private String strUniStCodigoExcucao;
    private LabUnidade labUnidadeExcucao;
        
    private String strOriStCodigo;
    private LabOrigem labOrigem;
    private Set<LabOrigem> listLabOrigem;
    private Set<LabOrigem> listLabOrigemSelected;
    
    private String strLocStCodigo;
    private LabLocal labLocal;
    private Set<LabLocal> listLabLocal;
    private Set<LabLocal> listLabLocalSelected;
    
    
    private String strSetStCodigo;
    private LabSetor labSetor;
    private Set<LabSetor> listLabSetor;
    private Set<LabSetor> listLabSetorSelected;
    
    private String strExaStCodigo;
    private LabExame labExame;
    private Set<LabExame> listLabExame;
    private Set<LabExame> listLabExameSelected;
    
    private Set<ServicoDocumento>  listServicoDocs;
    
    
   private boolean blCadastro;
    private boolean blConfCad;
    private boolean blPreTriado;
    private boolean blTriagem;
    private boolean blTrIadoAP;
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
//        breadCrumbModelUnidades = new BreadCrumb();
//        

//        breadCrumbModelUnidades.setItems(this);
        
    }

    
    
    public void grabUnidadeExcucao(ActionEvent event){
        System.out.println("Indide grabUnidadeExcucao");
        if(strUniStCodigoExcucao != null){
            labUnidadeExcucao = (LabUnidade)OracleHelper.getObjectByKey(LabUnidade.class, "uniStCodigo", strUniStCodigoExcucao);
        }
    }
    
    public void grabUnidadeCadastro(ActionEvent event){
        System.out.println("Indide grabUnidadeCadastro");
        if(strUniStCodigoCadastro != null){
            labUnidadeCadastro = null;
            labUnidadeCadastro = (LabUnidade)OracleHelper.getObjectByKey(LabUnidade.class, "uniStCodigo", strUniStCodigoCadastro);
        }
    }
    
    
    public void grabOrigemCadastro(ActionEvent event){
        System.out.println("Indide grabOrigemCadastro");
        if(strOriStCodigo != null 
                && labUnidadeCadastro != null){
            
            labOrigem = null;
            LabOrigemPK pk = new LabOrigemPK(strOriStCodigo, labUnidadeCadastro.getUniStCodigo());
            labOrigem = (LabOrigem)OracleHelper.getObject(LabOrigem.class, pk);
            if(labOrigem != null){
                if(listLabOrigem == null){listLabOrigem = new HashSet<LabOrigem>();}
                listLabOrigem.add(labOrigem);
            }
        }
    }
    
    public void grabLocalCadastro(ActionEvent event){
        System.out.println("Indide grabLocalCadastro");
        if(strLocStCodigo != null
                && labUnidadeCadastro != null){
            labLocal = null;
            LabLocalPK pk = new LabLocalPK(labUnidadeCadastro.getUniStCodigo(), strLocStCodigo);
            labLocal = (LabLocal)OracleHelper.getObject(LabLocal.class, pk);
            if(labLocal != null){
                if(listLabLocal == null){listLabLocal = new HashSet<LabLocal>();}
                listLabLocal.add(labLocal);
            }
        }
    }
    
    
    public void grabSetorCadastro(ActionEvent event){
        System.out.println("Indide grabLocalCadastro");
        if(strLocStCodigo != null
                && labUnidadeCadastro != null){
            labLocal = null;
            LabLocalPK pk = new LabLocalPK(labUnidadeCadastro.getUniStCodigo(), strLocStCodigo);
            labLocal = (LabLocal)OracleHelper.getObject(LabLocal.class, pk);
            if(labLocal != null){
                if(listLabLocal == null){listLabLocal = new HashSet<LabLocal>();}
                listLabLocal.add(labLocal);
            }
        }
    }
    
    
    public void grabExameCadastro(ActionEvent event){
        System.out.println("Indide grabExameCadastro");
        if(strExaStCodigo != null
                && labUnidadeCadastro != null){
            labExame = null;
            labExame = (LabExame)OracleHelper.getObject(LabExame.class, strExaStCodigo);
            if(labExame != null){
                if(listLabExame == null){listLabExame = new HashSet<LabExame>();}
                listLabExame.add(labExame);
            }
        }
    }
   
    
    
    public Set<String > getListaTeste(){
        System.out.println("Inside getListaTeste");
        Set<String> list = new HashSet<String>();
        list.add("ummmm");
        list.add("doissssssss");
        list.add("tresssssssss");
        return  list;
    }
    
    public boolean isBlCadastro() {
        return blCadastro;
    }

    public void setBlCadastro(boolean blCadastro) {
        this.blCadastro = blCadastro;
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

    public boolean isBlTrIadoAP() {
        return blTrIadoAP;
    }

    public void setBlTrIadoAP(boolean blTrIadoAP) {
        this.blTrIadoAP = blTrIadoAP;
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

    public String getStrExaStCodigo() {
        return strExaStCodigo;
    }

    public void setStrExaStCodigo(String strExaStCodigo) {
        this.strExaStCodigo = strExaStCodigo.toUpperCase().trim();
    }

    public String getStrLocStCodigo() {
        return strLocStCodigo;
    }

    public void setStrLocStCodigo(String strLocStCodigo) {
        this.strLocStCodigo = ZerosFabrica.makeZeros(strLocStCodigo, 5);
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
        this.strOriStCodigo = ZerosFabrica.makeZeros(strOriStCodigo, 5);
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
        this.strUniStCodigoCadastro = strUniStCodigoCadastro.toUpperCase();
    }

    public String getStrUniStCodigoExcucao() {
        return strUniStCodigoExcucao;
    }

    public void setStrUniStCodigoExcucao(String strUniStCodigoExcucao) {
        this.strUniStCodigoExcucao = strUniStCodigoExcucao.toUpperCase();
    }
   
   
    
    
            
    
    
    

    public Date getDtFinalQuery() {
        return dtFinalQuery;
    }

    public void setDtFinalQuery(Date dtFinalQuery) {
        this.dtFinalQuery = dtFinalQuery;
    }

    public SelectItem[] getOpcoestens() {

                SelectItem[] d = {new SelectItem("P", "Pendentes"),new SelectItem("P", "Pendentes")};
        return d;
    }

    public Set<LabExame> getListLabExame() {
        return listLabExame;
    }

    public void setListLabExame(Set<LabExame> listLabExame) {
        this.listLabExame = listLabExame;
    }

    public Set<LabExame> getListLabExameSelected() {
        return listLabExameSelected;
    }

    public void setListLabExameSelected(Set<LabExame> listLabExameSelected) {
        this.listLabExameSelected = listLabExameSelected;
    }

    public Set<LabLocal> getListLabLocal() {
        return listLabLocal;
    }

    public void setListLabLocal(Set<LabLocal> listLabLocal) {
        this.listLabLocal = listLabLocal;
    }

    public Set<LabLocal> getListLabLocalSelected() {
        return listLabLocalSelected;
    }

    public void setListLabLocalSelected(Set<LabLocal> listLabLocalSelected) {
        this.listLabLocalSelected = listLabLocalSelected;
    }

    public Set<LabOrigem> getListLabOrigem() {
        return listLabOrigem;
    }

    public void setListLabOrigem(Set<LabOrigem> listLabOrigem) {
        this.listLabOrigem = listLabOrigem;
    }

    public Set<LabOrigem> getListLabOrigemSelected() {
        return listLabOrigemSelected;
    }

    public void setListLabOrigemSelected(Set<LabOrigem> listLabOrigemSelected) {
        this.listLabOrigemSelected = listLabOrigemSelected;
    }

    public Set<LabSetor> getListLabSetor() {
        return listLabSetor;
    }

    public void setListLabSetor(Set<LabSetor> listLabSetor) {
        this.listLabSetor = listLabSetor;
    }

    public Set<LabSetor> getListLabSetorSelected() {
        return listLabSetorSelected;
    }

    public void setListLabSetorSelected(Set<LabSetor> listLabSetorSelected) {
        this.listLabSetorSelected = listLabSetorSelected;
    }

    public Set<ServicoDocumento> getListServicoDocs() {
        return listServicoDocs;
    }

    public void setListServicoDocs(Set<ServicoDocumento> listServicoDocs) {
        this.listServicoDocs = listServicoDocs;
    }

    
    

    
}


