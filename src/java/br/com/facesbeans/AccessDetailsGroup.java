/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.facesbeans;


import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author eros
 */
public class AccessDetailsGroup implements Serializable{

    private Map<String,AccessDetails> mapAccessDetail;

    public  Map<String, AccessDetails> getMapAccessDetail() {
        return mapAccessDetail;
    }

    public  void setMapAccessDetail(Map<String, AccessDetails> mapAccessDetail) {
        this.mapAccessDetail = mapAccessDetail;
    }

   
    

}
