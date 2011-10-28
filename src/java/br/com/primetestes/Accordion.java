/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.primetestes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.TabChangeEvent;

/**
 *
 * @author eros
 */
@SessionScoped
@ManagedBean(name="accordionBean")
public class Accordion {
    
    private String strMsgs = "Some Messege";
    
    private List<String> listList = new ArrayList<String>();

    public Accordion() {
        listList.add("daftpunk");
        listList.add("namnambulu");
        listList.add("Icon Of Coin");
    }
    
    

    public List<String> getListList() {
        return listList;
    }

    public void setListList(List<String> listList) {
        this.listList = listList;
    }
    
    

    public String getStrMsgs() {
        return strMsgs;
    }

    public void setStrMsgs(String strMsgs) {
        this.strMsgs = strMsgs;
    }
    
    
    
    public void onChange(TabChangeEvent event){
        strMsgs = "Changing the msg....";
        FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab:" + event.getTab().getId());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        System.out.println("Changing the msg....");
    }
    
    
}
