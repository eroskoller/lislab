/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.utils.tipstricks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eros
 */
public class IOUtils {


     public static String getStringFromFile(String filename){

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        try{
            br = new BufferedReader(new FileReader(filename),256*1024);
            try{
                String s;
                while((s = br.readLine()) != null){
                    //System.out.println(s);
                    sb.append(s).append("\n");
                    
                    //sb.append("\n");
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

  public static boolean saveStringToFile(String filename,String stringStream){
        boolean save = false;
        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter(new FileWriter(filename),256*1024);
            try{
                bw.write(stringStream);
                save = true;
            }catch(IOException xcp){
                System.err.println(xcp);
            }finally{
                bw.close();
            }
        }catch(IOException xcp){
            System.err.println(xcp);
        }

        return save;
    }
  
  
  
  
  public static String getExternalPageSourceCode(String strUrl){
        try {
            URL url = new URL(strUrl);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder builder = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null){
                builder.append(line);
//                builder.append("\\n");
            }
            reader.close();
            return  builder.toString();
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(IOUtils.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException xcp){
            
        }
      
    return null;
  }
  

}




