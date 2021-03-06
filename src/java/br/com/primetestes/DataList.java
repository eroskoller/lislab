/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.primetestes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author eros
 */
@SessionScoped
@ManagedBean(name="dataListBean")
public class DataList {
    
    private final static Logger logger = Logger.getLogger(DataList.class.getName());  
    private final static String[] colors;  
    private final static String[] manufacturers;  
    private Date date;
    
    
    
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
    
    
     private List<Car> cars;  
      
    private Car selectedCar;  
  
    public DataList() {  
        cars = new ArrayList<Car>();  
          
        populateRandomCars(cars, 50);  
    }  
      
    public Car getSelectedCar() {  
        return selectedCar;  
    }  
  
    public void setSelectedCar(Car selectedCar) {  
        this.selectedCar = selectedCar;  
    }  
  
    public Date getDate() {  
        return date;  
    }  
    public void setDate(Date date) {  
        this.date = date;  
    }  
  
    private void populateRandomCars(List<Car> list, int size) {  
        for(int i = 0 ; i < size ; i++)  
            list.add(new Car(getRandomModel(), getRandomYear(), getRandomManufacturer(), getRandomColor()));  
    }  
  
    public List<Car> getCars() {  
        return cars;  
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
    
    
    
}
