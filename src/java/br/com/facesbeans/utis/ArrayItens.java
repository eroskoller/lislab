/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.facesbeans.utis;


import br.com.hibernate.entities.*;
import br.com.hibernate.utils.OracleHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ApplicationScoped;
import javax.faces.model.SelectItem;
import java.sql.Timestamp;

/**
 *
 * @author eros
 */

import javax.faces.bean.ManagedBean;




@ManagedBean(name = "arrayitens")
@ApplicationScoped
public class ArrayItens implements Serializable{


    public static List<LabUnidade>  listLabUnidade = new ArrayList<LabUnidade>(10);
    public static List<LabCid> listLabCid = new ArrayList<LabCid>(10);
    
    public static Map<LabConfigIngresso,LabConfigIngresso> mapLabConfigIngresso = new HashMap<LabConfigIngresso, LabConfigIngresso>(100);
    public static Map<LabUnidadeMedida,LabUnidadeMedida> mapLabUnidadeMedida = new HashMap<LabUnidadeMedida, LabUnidadeMedida>();
    public static Map<LabLegenda,LabLegenda> mapLabLegenda = new HashMap<LabLegenda,LabLegenda>();
    public static Map<String,String> mapReqStCodigByUserLogin = new HashMap<String, String>();
    public static Map<LabExameMetodoVersao,LabExameMetodoVersao> mapLabExameMetodoVersao = new HashMap<LabExameMetodoVersao,LabExameMetodoVersao>();
    public static String zorakCss = ".byZoraK {position:absolute;background:#000000;filter: alpha(opacity=80);text-align:center;width:100%;height:100%;z-index:666;overflow:hidden;visibility:hidden;border: #990000 2px solid;}a {color:#000000;font-size:10px;font-weight:bold;font-family:'Verdana', 'Arial';text-decoration:none;}a:hover{color:#990000;text-decoration:none;}.fonte10 {color:#000000;font-size:10px;font-weight:bold;font-family:'Verdana', 'Arial';text-decoration:none;cursor:hand;}.fonte_10 {color:#990000;font-size:10px;font-weight:bold;font-family:'Verdana', 'Arial';text-decoration:underline;cursor:hand;}.fonte10_C {color:#666666;font-size:9px;font-weight:bold;font-family:'Verdana', 'Arial';text-decoration:none;cursor:hand;}.fonte12 {color:#000000;font-size:12px;font-weight:bold;font-family:'Verdana', 'Arial';text-decoration:none;}.fonte14 {color:#000099;font-size:14px;font-weight:bold;font-family:'Verdana', 'Arial';text-decoration:none;}.bots {background-color:#FFFFFF;color: #000000;font-size: 10px;font-family: Verdana, Arial;font-weight: bold;text-decoration: none;border: #666666 1px solid;}.resultado{position:relative;background:transparent;width:100%;height:100%;z-index:1;overflow-y:scroll;border: #000000 0px solid;}.titulos{position:relative;background:transparent;width:100%;z-index:1;overflow-y:scroll;border: #000000 0px solid;}.TelaPrincipal {position:absolute;background:transparent;margin:0% 0% 0% 0%;height:100%;width:100%;z-index:0;overflow:hidden;border: #000000 0px solid;}body {scrollbar-arrow-color: #006699;scrollbar-base-color: #000000;scrollbar-dark-shadow-color: #FFFFFF;scrollbar-track-color: #FFFFFF;scrollbar-face-color: #FFFFFF;scrollbar-shadow-color: #FFFFFF;scrollbar-highlight-color: #FFFFFF;scrollbar-3d-light-color: #FFFFFF;}.fundover{background:#C4C4C4;color: #800000;font-size: 10px;font-family: Verdana, Arial;font-weight: bold;text-decoration: none;}.fundout{background:transparent;color: #000000;font-size: 10px;font-family: Verdana, Arial;font-weight: bold;text-decoration: none;}";

    public SelectItem[] getSexoItens() {

                SelectItem[] d = {new SelectItem("-", "-"),new SelectItem("M", "M"),new SelectItem("F", "F")};
        return d;
    }

    public SelectItem[] getCorItens() {

                SelectItem[] d = {new SelectItem("-", "-"),new SelectItem("B", "BRANCO"),new SelectItem("N", "NEGRO"),new SelectItem("P", "PARDO"),new SelectItem("A", "AMARELO")};
        return d;
    }

    public SelectItem[] getEstadoItens() {

                SelectItem[] d = {new SelectItem("-", "-"),new SelectItem("RJ", "RJ"),new SelectItem("SP", "SP")};
        return d;
    }

    public SelectItem[] getSangueItens() {

                SelectItem[] d = {new SelectItem("-", "-"),new SelectItem("+A", "+A"),new SelectItem("-A", "-A"),new SelectItem("+B", "+B"),new SelectItem("-B", "-B")
                ,new SelectItem("+AB", "+AB"),new SelectItem("-AB", "-AB"),new SelectItem("+O", "+O"),new SelectItem("-O", "-O")};
        return d;
    }


    public SelectItem[] getDoencaBasicaItens() {

                SelectItem[] d = {new SelectItem("-", "-"),new SelectItem("H.A.S", "H.A.S"),new SelectItem("CHAGAS", "CHAGAS"),new SelectItem("CANCER", "CANCER")};
        return d;
    }

    public SelectItem[] getStatusItens() {

                SelectItem[] d = {new SelectItem("-", "-"),new SelectItem("Apto", "Apto"),new SelectItem("Afastamento Provisório", "Afastamento Provisório"),new SelectItem("Afastamento Definitivo", "Afastamento Definitivo"),new SelectItem("Transplantado", "Transplantado")
                ,new SelectItem("Óbto", "Óbto")};
        return d;
    }

    public SelectItem[] getYearItens() {

                SelectItem[] d = {new SelectItem("2011", "2011"),new SelectItem("2010", "2010"),new SelectItem("2009", "2009"),new SelectItem("2008", "2008"),new SelectItem("2007", "2007"),new SelectItem("2006", "2006"),new SelectItem("2005", "2005")
                };
        return d;
    }

    public SelectItem[] getEstadoCivilItens() {

                SelectItem[] d = {new SelectItem("-", "--"),new SelectItem("S", "SOLTEIRO"),new SelectItem("C", "CASADO"),new SelectItem("D", "DISQUITADO"),new SelectItem("N", "NI")};
        return d;
    }

    public SelectItem[] getGestasItens() {

                SelectItem[] d = {new SelectItem("-", "--"),new SelectItem("S", "Sim"),new SelectItem("N", "Não"),new SelectItem("NI", "NI")};
        return d;
    }

    public SelectItem[] getRnItens() {

                SelectItem[] d = {new SelectItem("--", "--"),new SelectItem("S", "Sim"),new SelectItem("N", "Não"),new SelectItem("NI", "NI")};
        return d;
    }

    public SelectItem[] getJobsItens() {

                SelectItem[] d = {new SelectItem("1", "MÉDICO (A)"),new SelectItem("3", "ENFERMEIRO(A)"),new SelectItem("4", "NUTRICIONISTA"),new SelectItem("9", "DENTISTA")};
        return d;
    }

    public SelectItem[] getMaterialItens() {

                SelectItem[] d = {new SelectItem("--", "--"),new SelectItem("Solteiro", "Solteiro"),new SelectItem("Casado", "Casado"),new SelectItem("Disquitado", "Disquitado"),new SelectItem("Emancipado", "Emancipado"),new SelectItem("Outros", "Outros")};
        return d;
    }

    public SelectItem[] getUnidExecItens() {

                SelectItem[] d = {new SelectItem("--", "--"),new SelectItem("Solteiro", "Solteiro"),new SelectItem("Casado", "Casado"),new SelectItem("Disquitado", "Disquitado"),new SelectItem("Emancipado", "Emancipado"),new SelectItem("Outros", "Outros")};
        return d;
    }
    public static  List<LabUnidade> getListLabUnidadeItems(){

        if(listLabUnidade != null){
            return listLabUnidade;
        }else{
            listLabUnidade = OracleHelper.getListLabUnidadeOrderByUniStCodigo(); // (List<LabUnidade>)  OracleHelper.getListObject(LabUnidade.class);
            return listLabUnidade;
        }

       
    }

     public static  List<LabCid> getListLabCidItems(){

        if(listLabCid != null){
            return listLabCid;
        }else{
            listLabCid = OracleHelper.getListObject(LabCid.class); // (List<LabUnidade>)  OracleHelper.getListObject(LabUnidade.class);
            return listLabCid;
        }


    }


     public static LabConfigIngresso getLabConfigIngressoByLabConfigIngresso(String cinStCodigo,Timestamp emvDtValidade,String exaStCodigo,String metStCodigo){
         if(mapLabConfigIngresso != null){
              LabConfigIngresso lci = new LabConfigIngresso();
                                             lci.setCinStCodigo(cinStCodigo);
                                             lci.setEmvDtValidade(emvDtValidade);
                                             lci.setExaStCodigo(exaStCodigo);
                                             lci.setMetStCodigo(metStCodigo);

             
             LabConfigIngresso retornoLc = mapLabConfigIngresso.get(lci);
             if(retornoLc != null){
                 return  retornoLc;
             }else{
                retornoLc = OracleHelper.getLabConfigIngresso(cinStCodigo, emvDtValidade, exaStCodigo, metStCodigo);
                if(retornoLc != null){
                    mapLabConfigIngresso.put(retornoLc, retornoLc);
                }
                return retornoLc;
             }
         }else{
             return null;
         }

     }

    public static Map<LabConfigIngresso, LabConfigIngresso> getMapLabConfigIngresso() {

        return mapLabConfigIngresso;
    }

    public static Map<LabUnidadeMedida, LabUnidadeMedida> getMapLabUnidadeMedida() {
//        if(mapLabUnidadeMedida.isEmpty()){
//            List<LabUnidadeMedida> l = (List<LabUnidadeMedida>) OracleHelper.getListObject(LabUnidadeMedida.class);
//            for(LabUnidadeMedida lum : l){
//                mapLabUnidadeMedida.put(lum, lum);
//            }
//        }
        return mapLabUnidadeMedida;
    }
    
    public  static LabUnidadeMedida getLabUnidadeMedida(String lum){
        LabUnidadeMedida lumRetorno = new LabUnidadeMedida();
        lumRetorno.setUnmStCodigo(lum);
            LabUnidadeMedida    lumRetorno2 = mapLabUnidadeMedida.get(lumRetorno);
        if(lumRetorno2 != null && lumRetorno2.getUnmStDescricao() != null){
            return lumRetorno2;
        }else{
            LabUnidadeMedida  lumRetorno3 = (LabUnidadeMedida) OracleHelper.getObject(LabUnidadeMedida.class, lum);
            if(lumRetorno3 != null){
                mapLabUnidadeMedida.put(lumRetorno, lumRetorno);
                return  lumRetorno3;
            }
        }
        return null;
    }




    public static Map<LabLegenda, LabLegenda> getMapLabLegenda() {
        if(mapLabLegenda.size()==0){
            List<LabLegenda> l =(List<LabLegenda>) OracleHelper.getListObject(LabLegenda.class);
            for(LabLegenda ll : l){
                mapLabLegenda.put(ll, ll);
            }
        }
        return mapLabLegenda;
    }

    public static Map<LabExameMetodoVersao, LabExameMetodoVersao> getMapLabExameMetodoVersao() {
        return mapLabExameMetodoVersao;
    }

    public String getZorakCss() {
        return zorakCss;
    }

    public static Map<String, String> getMapReqStCodigByUserLogin() {
        return mapReqStCodigByUserLogin;
    }

    public static void setMapReqStCodigByUserLogin(Map<String, String> mapReqStCodigByUserLogin) {
        ArrayItens.mapReqStCodigByUserLogin = mapReqStCodigByUserLogin;
    }


    public SelectItem[] getSituacaoResultadosItens() {

                SelectItem[] d = {new SelectItem("T", "TODOS"),new SelectItem("N", "NORMAIS"),new SelectItem("F", "FLAG"),new SelectItem("B", "BLOQUEADOS"),new SelectItem("I", "INCONPATIVEL")};
        return d;
    }

  public   SelectItem[] getSituacaoColetaItens() {

                SelectItem[] d = {new SelectItem("T", "TODOS"),new SelectItem("C", "COLETADOS"),new SelectItem("N", "NÃO COLETADOS")};
        return d;
    }

     public   SelectItem[] getSituacaoReqItens() {

                SelectItem[] d = {new SelectItem("T", "TODOS"),new SelectItem("R", "ROTINA"),new SelectItem("U", "URGENTES"),new SelectItem("A", "AGENDADOS"),new SelectItem("RE", "RESTRIÇÃO")};
        return d;
    }

     public SelectItem[] getSearchTypeItens() {
         SelectItem[] d = {new SelectItem("RG", "RG"),new SelectItem("CPF", "CPF"),new SelectItem("SUS", "SUS"),new SelectItem("R.C.", "R.C.")
                 ,new SelectItem("Req", "Req"),new SelectItem("Nome", "Nome"),new SelectItem("Pront.", "Pront.")};
        return d;
    }


}
