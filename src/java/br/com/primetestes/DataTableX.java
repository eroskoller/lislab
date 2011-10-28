/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.primetestes;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import java.io.Serializable;  
import java.util.ArrayList;  
import java.util.Date;  
import java.util.List;  
import java.util.UUID;  


/**
 *
 * @author eros
 */
@SessionScoped
@ManagedBean(name="dataTableX")
public class DataTableX {
    
    
    private final static String[] colors;  
    private final static String[] manufacturers;  
    private final static String[] model;  
    private List<Car> cars;  
    private Car selectedCar;  
    private List<Car> carsSmall;
     private CarDataModel smallCarsModel;
      private CarDataModel mediumCarsModel;
        private LazyDataModel<Car> lazyModel;
    
    
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
        
        model = new String[10];  
        model[0] = "SLS";  
        model[1] = "M3";  
        model[2] = "340";  
        model[3] = "A4";  
        model[4] = "Logan";  
        model[5] = "Omega";  
        model[6] = "Fusca";  
        model[7] = "C300";  
        model[8] = "F40";  
        model[9] = "Focus";  
        
    }  

        public DataTableX() {  
        cars = new ArrayList<Car>();
		carsSmall = new ArrayList<Car>();
//        carsLarge = new ArrayList<Car>();
//        droppedCars = new ArrayList<Car>();
		
		populateRandomCars(cars, 50);
		populateRandomCars(carsSmall, 9);
//        populateRandomCars(carsLarge, 200);
//        populateRandomSales();

//        createDynamicColumns();
//        populateDynamicCars();
//        manufacturerOptions = createFilterOptions(manufacturers);
//        
//        populatePlayers();
//        
        smallCarsModel = new CarDataModel(carsSmall);
        mediumCarsModel = new CarDataModel(cars);
//        	
		lazyModel = new LazyCarDataModel(cars);
        }
        
        
     private void populateRandomCars(List<Car> list, int size) {  
        for(int i = 0 ; i < size ; i++)  
            list.add(new Car(getRandomModel(), getRandomYear(), getRandomManufacturer(), getRandomColor()));  
    }  
  
    public Car getSelectedCar() {  
        return selectedCar;  
    }  
    public void setSelectedCar(Car selectedCar) {  
        this.selectedCar = selectedCar;  
    }  
  
    public List<Car> getCars() {  
        return cars;  
    }  
    
   private String getRandomModel() {
		return model[(int) (Math.random() * 10)];
   }
    
    private int getRandomYear() {
		return (int) (Math.random() * 50 + 1960);
   }
    
    private String getRandomManufacturer() {
		return manufacturers[(int) (Math.random() * 10)];
    }
    private String getRandomColor() {
		return colors[(int) (Math.random() * 10)];
    }
    
}
