/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utils.pdfmaker;

/**
 *
 * @author eros
 */





import br.com.hibernate.entities.LabDetalheRequisicao;
import br.com.hibernate.entities.LabExame;
import br.com.hibernate.entities.LabRequisicao;
import br.com.hibernate.entities.LabUnidade;
import br.com.hibernate.utils.OracleHelper;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;



public class PdfRelMakerPendencias {
   
	
        
        
        
        
        
        private  static Document makePdfPendencia(String pdfName,Date dtIncio , Date dtFinal,List<LabRequisicao> listRequisicao) 
                throws FileNotFoundException, DocumentException, Exception{
            
            if(dtIncio != null && dtFinal != null &&
                    (dtIncio.before(dtFinal)) || dtIncio.equals(dtFinal)  && 
                                listRequisicao != null && !listRequisicao.isEmpty()){
                
                    float flA4MaxHeigh = 300f;//PageSize.A4.getHeight();
                    float flPdfHeigh = flA4MaxHeigh;
                    
                    Document document=new Document(PageSize.A4,0,0,2,2);
                    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfName));
                    document.open();
                    
                    PdfBodyContent.addMetaData(document);
                    PdfBodyContent.addTitlePage(document,dtIncio,dtFinal,"Unidade Tamboré","NI/NI");
                    PdfBodyContent.makeTablesHeader(document);
                    
                    for(LabRequisicao lr : listRequisicao){
                        
                        if(lr.getListLabDetalheRequisicaoFiltrado() != null && !lr.getListLabDetalheRequisicaoFiltrado().isEmpty()){
                            
                                if(document.getPageSize().getHeight()<= flPdfHeigh){

                                    PdfBodyContent.makePdfContentOneByOne(lr, document);

                                }else{
//                                    document.newPage();
//                                    document.newPage();
//                                    writer.setPageEmpty(false);
                                    PdfBodyContent.addMetaData(document);
                                    PdfBodyContent.addTitlePage(document,dtIncio,dtFinal,"Criando Nova Pagina"," new Page/new Page");
                                    PdfBodyContent.makeTablesHeader(document);
                                    flPdfHeigh = flPdfHeigh + flA4MaxHeigh;
                                }

                        }
                        
                        
                    }
                    
                    
                    
                    return document;
                    
            }
            return null;
        }
      
        private static List<LabRequisicao> grabListLabRequisicaosWithReqFilterAndLabDetFilter(Date dtInicio,Date dtFinal,Map<String,Object> mapAnds4Req,String field4OrsReq,List<Object> listOrs4Req,
                Map<String,Object> mapAnds4Det,String field4OrsDet,List<Object> listOrs4Det){
            
            List<LabRequisicao> listReq = 
                    OracleHelper.getListObjectsByAnds_Ors_Dates(LabRequisicao.class, mapAnds4Req, field4OrsReq, listOrs4Req, "reqDtCadastro", dtInicio, dtFinal);
            
            if(listReq != null &&
                    ! listOrs4Req.isEmpty()){
                
                for(LabRequisicao lr : listReq){
                    mapAnds4Det.put("reqStCodigo", lr.getReqStCodigo());
                    List<LabDetalheRequisicao> listDr = OracleHelper.getListObjectsByAnds_Ors(LabDetalheRequisicao.class, mapAnds4Det, field4OrsDet, listOrs4Det); 
                    if(listDr != null && ! listDr.isEmpty()){
                        lr.setListLabDetalheRequisicaoFiltrado(listDr);
                    }
                }
                
            }
            return listReq;
        }
        
        
        public static synchronized  Document geraPdfPendencias(String pdfName,Date dtInicio,Date dtFinal,Map<String,Object> mapAnds4Req,String field4OrsReq,List<Object> listOrs4Req,
                Map<String,Object> mapAnds4Det,String field4OrsDet,List<Object> listOrs4Det){
            
                    if(pdfName != null && dtInicio  != null && dtFinal  != null && mapAnds4Req != null && !mapAnds4Req.isEmpty() && listOrs4Req != null && ! listOrs4Req.isEmpty() 
                           && mapAnds4Det != null && ! mapAnds4Det.isEmpty() && field4OrsDet  != null && listOrs4Det != null && !listOrs4Det.isEmpty()){

                        try {
                            
                            List<LabRequisicao> listReq = grabListLabRequisicaosWithReqFilterAndLabDetFilter(dtInicio, dtFinal, mapAnds4Req, field4OrsReq, listOrs4Req, mapAnds4Det, field4OrsDet, listOrs4Det);

                            return makePdfPendencia(pdfName, dtInicio, dtFinal, listReq);

                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(PdfRelMakerPendencias.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (DocumentException ex) {
                            Logger.getLogger(PdfRelMakerPendencias.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (Exception ex) {
                            Logger.getLogger(PdfRelMakerPendencias.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        
                    }else{
                        System.out.println("that method is pick all values must be != null and got some real value...   Oooh, isn't that cool or not. ");
                    }
            
                    
                    return  null;
                    
        }
        
        
        public static void main(String[] args) {
            
            
		try {
                                       
//                                System.out.println(PageSize.A4.getHeight()); 
                    
                                    Calendar dtInicio = Calendar.getInstance();
                                    dtInicio.add(Calendar.HOUR_OF_DAY, -9);
                                    Calendar dtFinal = Calendar.getInstance();
//                                    dtFinal.add(Calendar.HOUR, -8);
                                    Map<String,Object> mapAnds4Req = new HashMap<String, Object>();
//                                    mapAnds4Req.put("reqStCodigo", "1139365702");
                                    mapAnds4Req.put("uniStCodigo", new LabUnidade("UJA"));
                                    mapAnds4Req.put("solStEstado", "RJ");
                                    mapAnds4Req.put("reqChPrecadastro", new Character('S'));
                                    
                                    List listOrs4Req = new ArrayList ();
                                    listOrs4Req.add(new LabUnidade("UJA"));
                                    
                                    Map<String,Object> mapAnds4Det = new HashMap<String, Object>();
//                                    mapAnds4Det.put("exaStCodigo", new LabExame("URI"));
                                    mapAnds4Det.put("legStCodigoFat", "CON");
                                    
                                    List listOrs4Det = new ArrayList ();
                                    listOrs4Det.add("UJA");
                                    
                                    Document doc = geraPdfPendencias("firstPdftest.pdf",
                                            dtInicio.getTime(), dtFinal.getTime(),
                                           mapAnds4Req , 
                                           "uniStCodigo", listOrs4Req, 
                                           mapAnds4Det,
                                           "uniStCodigo", listOrs4Det);
                    
                                    if(doc != null && doc.isOpen()){
                                        doc.close();
                                    }
                    
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



    
}
