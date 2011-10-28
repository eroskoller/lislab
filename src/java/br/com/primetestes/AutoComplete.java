/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.primetestes;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author eros
 */

@SessionScoped
@ManagedBean(name="autoCompleteBean")
public class AutoComplete {
    
    
    
    private String text1;  
    private String text2;  
    private String text3;  
    private String text4;  
    private String text5;
    private String text6;

    public String getText6() {
        return text6;
    }

    public void setText6(String text6) {
        this.text6 = text6;
    }

    
    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public String getText4() {
        return text4;
    }

    public void setText4(String text4) {
        this.text4 = text4;
    }

    public String getText5() {
        return text5;
    }

    public void setText5(String text5) {
        this.text5 = text5;
    }
      
    
      
    public List<String> complete(String query) {  
        List<String> results = new ArrayList<String>();  
          
        for (int i = 0; i < 10; i++) {  
            results.add(query + i);  
        }  
          
        return results;  
    }     
    
}
