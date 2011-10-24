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


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
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
   
	
        
        
        
        
        
        private  static Document makePdfPendencia(String pdfName,String unidadeDesc,Date dtIncio , Date dtFinal,List<LabRequisicao> listRequisicao) 
                throws FileNotFoundException, DocumentException, Exception{
            
//            int intNo_BORDER = Rectangle.NO_BORDER;
            
            if(dtIncio != null && dtFinal != null &&
                    (dtIncio.before(dtFinal)) || dtIncio.equals(dtFinal)  && 
                                listRequisicao != null && !listRequisicao.isEmpty()){
                
                    float flA4MaxHeigh = 800f;//PageSize.A4.getHeight();
                    float flPdfHeigh = flA4MaxHeigh;
                    
                    Document document=new Document(PageSize.A4,0,0,2,2);
                    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfName));
                   document.open();
                    
                   
                   
                    
                            Double dMaxPages = 27d;
                        
                           document = PdfBodyContent.addMetaData(document);
                           double dPages = listRequisicao.size()/dMaxPages;
                           Double dPagesCeil = Math.ceil(dPages);
                           String sPages = dPagesCeil.toString().substring(0, dPagesCeil.toString().length()-2);
                           Integer iPages = 1;
                           
                           
                           document.add(PdfBodyContent.addTitlePage(dtIncio,dtFinal,unidadeDesc,iPages.toString()+"/"+sPages ));
                           document.add(PdfBodyContent.makeTablesHeader());
                            
                        
                        int reqs4Pages = dMaxPages.intValue();
                            
                            for(int i = 1 ; i < listRequisicao.size(); i ++){
                                
                                    LabRequisicao lr = listRequisicao.get(i);
                                  
                                    
                                        if(lr.getListLabDetalheRequisicaoFiltrado() != null && !lr.getListLabDetalheRequisicaoFiltrado().isEmpty()){

                                                    document.add(PdfBodyContent.makePdfContentOneByOne(lr));
                                                    document.add(PdfBodyContent.makePdfPTable4ListaExames(lr));
                                                    
                                                    
                                                    if(i >= reqs4Pages){
                                                        document.newPage();
                                                        writer.setPageEmpty(false);
                                                        document = PdfBodyContent.addMetaData(document);
                                                        ++iPages;
                                                        document.add(PdfBodyContent.addTitlePage(dtIncio,dtFinal,unidadeDesc,iPages.toString()+"/"+sPages ));
                                                        document.add(PdfBodyContent.makeTablesHeader());
                                                        flPdfHeigh = flPdfHeigh+flA4MaxHeigh;
                                                        reqs4Pages = reqs4Pages+dMaxPages.intValue();
                                                    }
                                                    
                                                    
                                        }
                                        
                                                
                                        
                        
                    }
                    
//                Phrase footer = new Phrase(new Chunk("Fim da pagina", PdfBodyContent.catFont8));
//                Rectangle rect = new Rectangle(200, 500);
//                rect.setBackgroundColor(BaseColor.RED);
//                footer.setLeading(12);
////                footer.add(new Chunk("There is no obligation to comply with these prices. Date Printed: "));
////                 ColumnText c = new ColumnText(new PdfContentByte(writer)) ; // 
//                 ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_BOTTOM, footer, 700,300, 0);
////                    c.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("Fim da pagina"), 700,300, 0);
//                    document.add(footer);
                            
                            
                    document.close();
                    return document;
                    
            }
            return null;
        }
      
        private static List<LabRequisicao> grabListLabRequisicaosWithReqFilterAndLabDetFilter(Date dtInicio,Date dtFinal,Map<String,Object> mapAnds4Req,String field4OrsReq,List<Object> listOrs4Req,
                Map<String,Object> mapAnds4Det,String field4OrsDet,List<Object> listOrs4Det){
            
            long comeco = new Date().getTime();
            
            List<LabRequisicao> listReq = 
                    OracleHelper.getListObjectsByAnds_Ors_Dates(LabRequisicao.class, mapAnds4Req, field4OrsReq, listOrs4Req, "reqDtCadastro", dtInicio, dtFinal);
            long fim = new Date().getTime();
            System.out.println("Tempo gasto p lista de LabRequisicoes: "+(new Long((fim-comeco)/1000)));
            List<LabRequisicao>  listReqRetorno;
            if(listReq != null ){
                comeco = new Date().getTime();
                for(LabRequisicao lr : listReq){
                    mapAnds4Det.put("reqStCodigo", lr.getReqStCodigo());
                    mapAnds4Det.put("uniStCodigo", lr.getUniStCodigo());
                    mapAnds4Det.put("reqInCodigo", lr.getReqInCodigo());
                    mapAnds4Det.put("conStCodigo", lr.getConStCodigo());
                    List<LabDetalheRequisicao> listDr = OracleHelper.getListObjectsByAnds_Ors_Dates(LabDetalheRequisicao.class, mapAnds4Det, field4OrsDet, listOrs4Det,"reqDtCadastro", dtInicio, dtFinal); 
                    if(listDr != null && ! listDr.isEmpty()){
                        lr.setListLabDetalheRequisicaoFiltrado(listDr);
                    }
                }
                fim = new Date().getTime();
                System.out.println("Tempo gasto p lista de LabDetalheRequisicoes: "+(new Long((fim-comeco)/1000)));
                if(listReq != null){
                    listReqRetorno = new ArrayList<LabRequisicao>(listReq.size());
                    
                    for(LabRequisicao lr : listReq){
                        if(lr.getListLabDetalheRequisicaoFiltrado() != null &&
                               lr.getListLabDetalheRequisicaoFiltrado().size()>0 ){
                            listReqRetorno.add(lr);
                        }
                    }
                    return listReqRetorno;
                }
                 
                
            }
            return null;
        }
        
        
        public static synchronized  Document geraPdfPendencias(String pdfName,Date dtInicio,Date dtFinal,Map<String,Object> mapAnds4Req,String field4OrsReq,List<Object> listOrs4Req,
                Map<String,Object> mapAnds4Det,String field4OrsDet,List<Object> listOrs4Det){
            
                    if(pdfName != null && dtInicio  != null && dtFinal  != null && mapAnds4Req != null && !mapAnds4Req.isEmpty() && listOrs4Req != null 
                           && mapAnds4Det != null && ! mapAnds4Det.isEmpty() && field4OrsDet  != null && listOrs4Det != null){

                        try {
                            LabUnidade labUnidade;
                            String unidadeDesc = "NI";
                            List<LabRequisicao> listReq = grabListLabRequisicaosWithReqFilterAndLabDetFilter(dtInicio, dtFinal, mapAnds4Req, field4OrsReq, listOrs4Req, mapAnds4Det, field4OrsDet, listOrs4Det);
                            
                            if(mapAnds4Req.get("uniStCodigo") != null){
                                labUnidade = (LabUnidade)OracleHelper.getObject(LabUnidade.class, mapAnds4Req.get("uniStCodigo"));
                                if(labUnidade != null){
                                    unidadeDesc = labUnidade.getUniStCodigo()+" "+labUnidade.getUniStDescricao();
                                }
                            }
                            
                            
                            if(listReq != null && !listReq.isEmpty()){
                               return  makePdfPendencia(pdfName, unidadeDesc,dtInicio, dtFinal, listReq);
                            }else{
                                return  null;
                            }
                            

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
                                    dtInicio.add(Calendar.DAY_OF_YEAR, -30);
//                                    dtInicio.add(Calendar.HOUR_OF_DAY, -30);
                                    Calendar dtFinal = Calendar.getInstance();
                                    String uniStCodigo = "HAS";
                                    String oriStCodigo = "000001";
//                                    dtFinal.add(Calendar.HOUR, -8);
                                    Map<String,Object> mapAnds4Req = new HashMap<String, Object>();
//                                    mapAnds4Req.put("reqStCodigo", "1139365702");
//                                    mapAnds4Req.put("legStCodigo", "007");
                                    mapAnds4Req.put("uniStCodigo",uniStCodigo);
                                    mapAnds4Req.put("oriStCodigo",oriStCodigo);
//                                    mapAnds4Req.put("locStCodigo",uniStCodigo);
//                                    mapAnds4Req.put("uniStCodigo",uniStCodigo);
//                                    mapAnds4Req.put("solStEstado", "RJ");
//                                    mapAnds4Req.put("reqChPrecadastro", new Character('S'));
//                                    mapAnds4Req.put("reqChEtiqueta", new Character('S'));
                                    
                                    
                                    List listOrs4Req = new ArrayList ();
//                                    listOrs4Req.add("001");
//                                    listOrs4Req.add("002");
//                                    listOrs4Req.add("003");
//                                    listOrs4Req.add("004");
//                                    listOrs4Req.add("005");
//                                    listOrs4Req.add("006");
//                                    listOrs4Req.add("007");
//                                    listOrs4Req.add("008");
//                                    listOrs4Req.add("016");
                                    
                                    Map<String,Object> mapAnds4Det = new HashMap<String, Object>();
                                    mapAnds4Det.put("uniStCodigo", uniStCodigo);
                                       mapAnds4Det.put("oriStCodigo", oriStCodigo);
//                                       mapAnds4Det.put("derChFatura", 'N');
//                                    mapAnds4Det.put("exaStCodigo", new LabExame("URI"));
//                                    mapAnds4Det.put("legStCodigo", "007");
                                    
                                    List listOrs4Det = new ArrayList ();
//                                    listOrs4Det.add("001");
//                                    listOrs4Det.add("002");
////                                    listOrs4Det.add("003");
//                                    listOrs4Det.add("004");
////                                    listOrs4Det.add("005");
////                                    listOrs4Det.add("006");
//                                    listOrs4Det.add("007");
//                                    listOrs4Det.add("008");
//                                    listOrs4Det.add("016");
                                    
                                    Document doc = geraPdfPendencias("firstPdftest.pdf",
                                            dtInicio.getTime(), dtFinal.getTime(),
                                           mapAnds4Req , 
                                           "legStCodigo", listOrs4Req, 
                                           mapAnds4Det,
                                           "legStCodigo", listOrs4Det);
                    
                                    if(doc != null && doc.isOpen()){
                                        doc.close();
                                    }
                    
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



    
}
