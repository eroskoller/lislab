/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.primetestes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.DateSelectEvent;


/**
 *
 * @author eros
 */

@SessionScoped
@ManagedBean(name="primeSamplesBean")
public class PrimeSamples {
    
    private Date date1 = new Date();
    private Date date2 = new Date();
    private Date date3 = new Date();
    private Date date4 = new Date();
    
    private Date    date5;
    
    static public String[] colors = null;
    static public String[] manufacturers = null;
    
    
    static {  
        colors = new String[10];  
        colors[0] = "Black";  
        colors[1] = "White";  
        colors[2] = "Green";  
        colors[3] = "Red";  
        colors[4] = "Blue";  
        colors[5] = "Orange";  
        colors[6] = "Silver";  
        colors[7] = "Yellow";  
        colors[8] = "Brown";  
        colors[9] = "Maroon";  
          
        manufacturers = new String[10];  
        manufacturers[0] = "Mercedes";  
        manufacturers[1] = "BMW";  
        manufacturers[2] = "Volvo";  
        manufacturers[3] = "Audi";  
        manufacturers[4] = "Renault";  
        manufacturers[5] = "Opel";  
        manufacturers[6] = "Volkswagen";  
        manufacturers[7] = "Chrysler";  
        manufacturers[8] = "Ferrari";  
        manufacturers[9] = "Ford";  
    }  
      
    
    
     private List<Sale> sales;  
  
    
  
    public List<Sale> getSales() {  
        return sales;  
    }  
    
    
    private List<Car> carsSmall;

    public PrimeSamples() {
        
        carsSmall = new ArrayList<Car>();  
          
        populateRandomCars(carsSmall, 9);  
        
         sales = new ArrayList<Sale>();  
        sales.add(new Sale("Brand 1", 540));  
        sales.add(new Sale("Brand 2", 325));  
        sales.add(new Sale("Brand 3", 702));  
        sales.add(new Sale("Brand 4", 421));  
        
    }
      
    
      
    private void populateRandomCars(List<Car> list, int size) {  
        for(int i = 0 ; i < size ; i++)  
            list.add(new Car(getRandomModel(), getRandomYear(), getRandomManufacturer(), getRandomColor()));  
    }  
      
    public List<Car> getCarsSmall() {  
        return carsSmall;  
    }  
  
    private int getRandomYear() {  
        return (int) (Math.random() * 50 + 1960);  
    }  
      
    private String getRandomColor() {  
        return colors[(int) (Math.random() * 10)];  
    }  
      
    private String getRandomManufacturer() {  
        return manufacturers[(int) (Math.random() * 10)];  
    }  
      
    private String getRandomModel() {  
        return UUID.randomUUID().toString().substring(0, 8);  
    }  
    

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public Date getDate3() {
        return date3;
    }

    public void setDate3(Date date3) {
        this.date3 = date3;
    }

    public Date getDate4() {
        return date4;
    }

    public void setDate4(Date date4) {
        this.date4 = date4;
    }

    public Date getDate5() {
        return date5;
    }

    public void setDate5(Date date5) {
        this.date5 = date5;
    }
    public void handleDateSelect(DateSelectEvent event) {  
        
        System.out.println("handleDateSelect");
        
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");  
        FacesContext facesContext = FacesContext.getCurrentInstance();  
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getDate())));  
    }  
    
    
    
    
    public void submitCapcha(ActionEvent event) {  
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correct", "Correct");  
          
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
    
    
}
