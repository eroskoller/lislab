/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.utils.tipstricks;

/**
 *
 * @author eros
 */
public class ZerosFabrica {
    public static String makeZeros(String strSomeThing){


         if(strSomeThing != null    &&  strSomeThing.replaceAll("\\D", "").trim().length() > 0
                && !strSomeThing.trim().equalsIgnoreCase("") ){

            int intLength = strSomeThing.replaceAll("\\D", "").length();
            int restante = 6  - intLength;
            String strZeros = "";
            for(int i = 0 ; i < restante; i ++){
                strZeros  = strZeros +"0";
            }

             return  strSomeThing = strZeros+strSomeThing.trim();
        }else{
             return strSomeThing.toUpperCase();
        }
    }
     public static String makeZeros(String strSomeThing,int base){


         if(strSomeThing != null    &&  strSomeThing.replaceAll("\\D", "").trim().length() > 0
                && !strSomeThing.trim().equalsIgnoreCase("") ){

            int intLength = strSomeThing.replaceAll("\\D", "").length();
            int restante = base  - intLength;
            String strZeros = "";
            for(int i = 0 ; i < restante; i ++){
                strZeros  = strZeros +"0";
            }

             return  strSomeThing = strZeros+strSomeThing.trim();
        }else{
             return strSomeThing.toUpperCase();
        }
    }
}
