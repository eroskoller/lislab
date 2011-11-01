/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.telas.relatorio;

import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author eros
 */
public class ServicoDocumento implements Serializable{
    
    private String strNome;
    private String strUrl;
    private Date dtInicio;
    private Date dtFim;
    private Integer intProgresso = 0;
    private boolean blStatus = false;

    public ServicoDocumento() {
    }

    public ServicoDocumento(String strNome, String strUrl, Date dtInicio, Date dtFim) {
        this.strNome = strNome;
        this.strUrl = strUrl;
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
    }

    public boolean isBlStatus() {
        return blStatus;
    }

    public void setBlStatus(boolean blStatus) {
        this.blStatus = blStatus;
    }

    public Date getDtFim() {
        return dtFim;
    }

    public void setDtFim(Date dtFim) {
        this.dtFim = dtFim;
    }

    public Date getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    public Integer getIntProgresso() {
        return intProgresso;
    }

    public void setIntProgresso(Integer intProgresso) {
        this.intProgresso = intProgresso;
    }

    

    public String getStrNome() {
        return strNome;
    }

    public void setStrNome(String strNome) {
        this.strNome = strNome;
    }

    public String getStrUrl() {
        return strUrl;
    }

    public void setStrUrl(String strUrl) {
        this.strUrl = strUrl;
    }
    
    
    
     public Integer getProgress() {  
        if(intProgresso == null)  
            intProgresso = 0;  
        else {  
            intProgresso = intProgresso + (int)(Math.random() * 35);  
              
            if(intProgresso > 100)  
                intProgresso = 100;  
        }  
          
        return intProgresso;  
    }  
  
    
      
    public void onComplete() {  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Progress Completed", "Progress Completed"));  
    }  
      
    public void onCancel() {  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Progress Cancelled", "Progress Cancelled"));  
    }  
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ServicoDocumento other = (ServicoDocumento) obj;
        if ((this.strNome == null) ? (other.strNome != null) : !this.strNome.equals(other.strNome)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.strNome != null ? this.strNome.hashCode() : 0);
        return hash;
    }
   
    
    
}
