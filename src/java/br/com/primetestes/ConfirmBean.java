/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.primetestes;

import javax.faces.application.FacesMessage;  
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;  
import javax.faces.event.ActionEvent;  

/**
 *
 * @author eros
 */
@SessionScoped
@ManagedBean(name="confirmBean")
public class ConfirmBean {
    
    public void destroyWorld(ActionEvent actionEvent){  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "System Error",  "Please try again later.");  
          
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }  
    
}
