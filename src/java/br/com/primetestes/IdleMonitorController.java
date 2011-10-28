/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.primetestes;

/**
 *
 * @author eros
 */
import javax.faces.application.FacesMessage;  
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;  
  
import org.primefaces.event.IdleEvent;  
  


@SessionScoped
@ManagedBean(name="idleMonitorControllerBean")
public class IdleMonitorController {  
      
    private Integer x = 0;

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }
    
    
    
    public void idleListener(IdleEvent event) {  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,   
                                        "Your session is closed", "You have been idle for at least 5 seconds"));  
        x ++;
          activeListener();
        //invalidate session  
    }  
    
    
    
    public void idleListener() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, 
										"Your session is closed", "You have been idle for at least 5 seconds"));

    }

    public void activeListener() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
										"Welcome Back", "That's a long coffee break!"));
    }
    
    
}  
