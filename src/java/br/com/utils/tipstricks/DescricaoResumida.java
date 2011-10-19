/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utils.tipstricks;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author eros
 */
@ManagedBean(name = "descresumida")
@ApplicationScoped
public class DescricaoResumida {
    
    
    public static String descResuminda(String strFrase,int  qtMaxChars){
        
        if(strFrase != null && strFrase.length()>qtMaxChars){
            if(strFrase.length()>=2){
                
                if(qtMaxChars >= 5){
                    return  strFrase.substring(0, qtMaxChars-3)+"...";
                }else if(qtMaxChars >= 4){
//                    System.out.println("insite 4");
                    return  strFrase.substring(0, qtMaxChars-1)+".";
                }else if(qtMaxChars >= 3){
//                    System.out.println("insite 3");
                    return  strFrase.substring(0, qtMaxChars)+".";
                }else if(qtMaxChars >= 2){
//                    System.out.println("insite 2");
                    return  strFrase.substring(0, qtMaxChars);
                }else{
                    return  strFrase.substring(0, qtMaxChars);
                }
                
            }else{
                return  strFrase.substring(0, qtMaxChars-3)+"...";
            }
            
        }else{
            return  strFrase;
        }
        
    }
    
}
