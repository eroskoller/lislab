/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.primetestes;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author eros
 */

@SessionScoped
@ManagedBean(name="buttonBean")
public class ButtonBean implements Serializable{
    
    
    private String text;

    private boolean toggled;
    
    private Integer number;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
    
	public String submitButtonAction(){
		text = "Command clicked";

		return null;
	}
	
	public void destroyWorld(ActionEvent actionEvent){
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "System Error",  "Please try again later.");
		
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public void displayMessage(ActionEvent actionEvent) {
		addMessage("You said:'" + text + "'");
	}
	
	public void save(ActionEvent actionEvent) {
            
                    System.out.println("public void save(ActionEvent actionEvent)");
            
		addMessage("Data saved");
	}
	
	public void update(ActionEvent actionEvent) {
		addMessage("Data updated");
	}
	
	public void delete(ActionEvent actionEvent) {
		addMessage("Data deleted");
	}
	
	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

    public boolean isToggled() {
        return toggled;
    }

    public void setToggled(boolean toggled) {
        this.toggled = toggled;
    }
    
}
