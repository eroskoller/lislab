/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utils.shared;

import java.util.*;

/**
 *
 * @author eros
 */
public class ArrayItens {
    
    private static Map<String,String> mapLegResumido = new HashMap<String,String>();

    public static Map<String, String> getMapLegResumido() {
        if(mapLegResumido.isEmpty()){
            mapLegResumido.put("001", "(CA)");
            mapLegResumido.put("002", "(CO)");
            mapLegResumido.put("004", "(TR)");
            mapLegResumido.put("006", "(EA)");
            mapLegResumido.put("007", "(PE)");
            mapLegResumido.put("008", "(CO)");
            mapLegResumido.put("009", "(IN)");
            mapLegResumido.put("010", "(LT)");
            mapLegResumido.put("011", "(AS)");
            mapLegResumido.put("012", "(BL)");
            mapLegResumido.put("013", "(CN)");
            mapLegResumido.put("014", "(AR)");
            mapLegResumido.put("015", "(DE)");
            mapLegResumido.put("016", "(EA)");
            mapLegResumido.put("020", "(IM)");
            mapLegResumido.put("040", "(NC)");
            mapLegResumido.put("040", "(DL)");
//            mapLegResumido.put("040", "(EA)");
//            mapLegResumido.put("041", "(EA)");
//            mapLegResumido.put("040", "(EA)");
            
        }
        return mapLegResumido;
    }
    
    
}
