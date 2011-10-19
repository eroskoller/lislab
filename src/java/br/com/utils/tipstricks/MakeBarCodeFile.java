package br.com.utils.tipstricks;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */




import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author eros
 */
public class MakeBarCodeFile {


    public static String[] makeString4EPL(String tipoEtiqueta,int qdEtiquetas,Date derDtEntradaMat,Character pacStSexo,String reqStQuarto,String locStDescricao,
            String uniStCodigo,String uniStDescricao,String oriStCodigo,String oriStDescricao,Long pacInCodigo,String pacStNome,String reqStCodigo,Date derDtDataPrevistaEntrega){

 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:MM:ss");
 String strDerDtEntradaMat = formatter.format(derDtEntradaMat);
 String  strPacStSexo= ";";if(pacStSexo != null){if(pacStSexo.toString().equalsIgnoreCase("M")){strPacStSexo = "Masc";}else{strPacStSexo = "Fem";}}
 String strLocStDescricao = "";if(locStDescricao != null && locStDescricao.length()>=10){strLocStDescricao = locStDescricao.substring(1, 10);}else{strLocStDescricao = locStDescricao;}
 String strUniStDescricao = ""; if(uniStDescricao != null && uniStDescricao.length()>=27){strUniStDescricao = uniStDescricao.substring(1, 27);}else{strUniStDescricao = uniStDescricao;}
 String strOriStDescricao = ""; if(oriStDescricao != null && oriStDescricao.length()>=27){strOriStDescricao = oriStDescricao.substring(1, 27);}else{strOriStDescricao = oriStDescricao;}
 String strPacStNome = ""; if(pacStNome != null ){ if(pacStNome.length()>=35){strPacStNome = pacStNome.substring(1, 35);}else{strPacStNome = pacStNome;}}
 Long vPrazo = new Long(0); if(derDtDataPrevistaEntrega != null && derDtDataPrevistaEntrega.getTime()>0){
 
 }


 StringBuilder sb ;


//System.out.println("A data formatada é: "+ formatter.format(today));
        for(int i = 0 ; i < qdEtiquetas; i ++){
           sb = new StringBuilder();
           sb.append("FK\n");
           sb.append("FN\n");
           sb.append("N\n");
           sb.append("I8,A,003\n");
           sb.append("q824\n");
           sb.append("R5,5\n");
           sb.append("S4\n");
           sb.append("D24\n");
           sb.append("ZT\n");
           sb.append("N\n");
           sb.append("A300,370,4,1,1,1,N,'"+strDerDtEntradaMat +"  TM'\n");
           sb.append("A300,350,4,1,1,1,N,'"+strPacStSexo+" '"+reqStQuarto+"'\n");
           sb.append("A390,338,4,1,1,1,N,'"+strLocStDescricao+"'\n");
           sb.append("A520,20,5,2,1,1,N,'"+uniStCodigo+"-"+strUniStDescricao+"'\n");
           sb.append("A500,20,5,2,1,1,N,'"+oriStCodigo+"-"+strOriStDescricao+"'\n");
           sb.append("A330,05,4,4,1,1,N,'"+pacInCodigo.toString()+"'\n");
           sb.append("A478,50,5,1,1,1,N,'"+strPacStNome+"'\n");
           sb.append("A458,70,5,4,1,1,N,'"+reqStCodigo+"'\n");
           sb.append("A428,50,5,1,1,1,N,'Exames: '\n");
           sb.append("\n");
           sb.append("\n");
           sb.append("\n");
           sb.append("");
           sb.append("");
           sb.append("");
           sb.append("");
           sb.append("");
           sb.append("");

        }


        return null;
    }

     public static File saveStringToBarCodeFile(String filename,String stringStream){
         File f = new File(filename);
        boolean save = false;
        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter(new FileWriter(f));//(new FileWriter(filename));
            try{
                bw.write(stringStream);
                save = true;
                return f;
            }catch(IOException xcp){
                System.err.println(xcp);
            }finally{
                bw.close();
            }
        }catch(IOException xcp){
            System.err.println(xcp);
        }

        return f;
    }

    public static String getStringFromBarCodeFile(String filename){

        BufferedReader br = null;
        StringBuilder sb = null;
        try{
            br = new BufferedReader(new FileReader(filename));
            try{
                String s;
                while((s = br.readLine()) != null){
                    sb.append(s);
                    sb.append("\n");
                }
            }catch(IOException xcp){
                System.err.println(xcp);
            }finally{
                br.close();
            }
        }catch(IOException xcp){
            xcp.printStackTrace();
        }

        return sb.toString();
    }

    

}
