/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.primetestes;

import br.com.primetestes.Sale;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.CartesianChartModel;

/**
 *
 * @author eros
 */



@SessionScoped
@ManagedBean(name="chartBean")
public class ChartBean implements Serializable{
    
     private List<Vote> votes;  
     private List<Sale> sales;  
     private List<Birth> births; 
     private List<ServerLoad> servers; 
     
     private CartesianChartModel categoryModel;
     
  
    private String message;

    public CartesianChartModel getCategoryModel() {
        return categoryModel;
    }

    public List<ServerLoad> getServers() {
        return servers;
    }

    public void setServers(List<ServerLoad> servers) {
        this.servers = servers;
    }
  
    
    
    public ChartBean() {  
        votes = new ArrayList<Vote>();  
        votes.add(new Vote("Candidate 1", 100));  
        votes.add(new Vote("Candidate 2", 100));  
        
        sales = new ArrayList<Sale>();  
        sales.add(new Sale("Brand 1", 540));  
        sales.add(new Sale("Brand 2", 325));  
        sales.add(new Sale("Brand 3", 702));  
        sales.add(new Sale("Brand 4", 421));  
        this.createCategoryModel();
        
        
        births = new ArrayList<Birth>();  
        births.add(new Birth(2004, 120, 52));  
        births.add(new Birth(2005, 100, 60));  
        births.add(new Birth(2006, 44, 110));  
        births.add(new Birth(2007, 150, 135));  
        births.add(new Birth(2008, 125, 120));  
       
        
    }
    
    
    private void createCategoryModel() {
        categoryModel = new CartesianChartModel();

        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");

        boys.set("2004", 120);
        boys.set("2005", 100);
        boys.set("2006", 44);
        boys.set("2007", 150);
        boys.set("2008", 25);

        ChartSeries girls = new ChartSeries();
        girls.setLabel("Girls");

        girls.set("2004", 52);
        girls.set("2005", 60);
        girls.set("2006", 110);
        girls.set("2007", 135);
        girls.set("2008", 120);

//        categoryModel.addSeries(boys);
//        categoryModel.addSeries(girls);
    }
    
    
    
    

    public List<Birth> getBirths() {
        return births;
    }

   

    public String getMessage() {
        return message;
    }
  
    
    
    public List<Sale> getSales() {  
        return sales;  
    }  
    
    
    public void itemSelect(ItemSelectEvent event) {  
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",  
                        "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
    
    public List<Vote> getVotes() {  
        int random1 = (int)((Math.random() *1000)*2);  
        int random2 = (int)((Math.random() *1000)*2);
  
        votes.get(0).add(random1);  
        votes.get(1).add(random2);  
  
        return votes;  
    }
    
    
    public void itemSelect2(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                        "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());
        
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
    
    
}
