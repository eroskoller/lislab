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
   
   
    
    
            
    
    
    

    public Date getDtFinalQuery() {
        return dtFinalQuery;
    }

    public void setDtFinalQuery(Date dtFinalQuery) {
        this.dtFinalQuery = dtFinalQuery;
    }

    public RelatorioBean() {
        
        dtFinalQuery = new Date();
    }
    
    
    
    
    
    
    
    
    
    public SelectItem[] getOpcoestens() {

                SelectItem[] d = {new SelectItem("-", "-"),new SelectItem("P", "Pendentes")};
        return d;
    }
    
}
