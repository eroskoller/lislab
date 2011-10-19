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
import br.com.hibernate.entities.LabRequisicao;
import br.com.hibernate.utils.OracleHelper;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.util.Calendar;
import java.util.Date;
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
                
                    float flA4MaxHeigh = 1000f;
                    float flPdfHeigh = flA4MaxHeigh;
                    
                    Document document=new Document(PageSize.A4,0,0,2,2);
                    PdfWriter.getInstance(document, new FileOutputStream(pdfName));
                    document.open();
                    
                    PdfBodyContent.addMetaData(document);
                    PdfBodyContent.addTitlePage(document,new Date(),new Date(),"Unidade Tamboré","1/2");
                    PdfBodyContent.makeTablesHeader(document);
                    
                    for(LabRequisicao lr : listRequisicao){
                        if(document.getPageSize().getHeight()<= flPdfHeigh){
                            PdfBodyContent.makePdfContentOneByOne(lr, document);
                        }else{
                            document.newPage();
                            PdfBodyContent.addMetaData(document);
                            PdfBodyContent.addTitlePage(document,new Date(),new Date(),"Unidade Tamboré","1/2");
                            PdfBodyContent.makeTablesHeader(document);
                            flPdfHeigh = flPdfHeigh + flA4MaxHeigh;
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
                    return  null;
                    
        }
        
        
        public static void main(String[] args) {
            
            
		try {
                                        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



    
}
