/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utils.pdfmaker;

import br.com.hibernate.entities.LabPaciente;
import br.com.hibernate.entities.LabRequisicao;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author eros
 */
public class PdfBodyContent {
    
//                public static String FILE = "RelatorioDePendencias.pdf";
                static Font catFont8 = new Font(Font.FontFamily.TIMES_ROMAN, 8,Font.BOLD);
                static Font catFont10 = new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.BOLD);
	static Font catFont12 = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.BOLD);
        
	static Font redFont8 = new Font(Font.FontFamily.TIMES_ROMAN, 8,Font.NORMAL, BaseColor.RED);
                static Font redFont10 = new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.NORMAL, BaseColor.RED);
                static Font redFont12 = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.NORMAL, BaseColor.RED);
                
                static Font redFont8Bold = new Font(Font.FontFamily.TIMES_ROMAN, 8,Font.BOLD, BaseColor.RED);
                static Font redFont10Bold = new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.BOLD, BaseColor.RED);
                static Font redFont12Bold = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.BOLD, BaseColor.RED);
                
                static Font blueFont8Bold = new Font(Font.FontFamily.TIMES_ROMAN, 8,Font.BOLD, BaseColor.BLUE);
                static Font blueFont10Bold = new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.BOLD, BaseColor.BLUE);
                static Font blueFont12Bold = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.BOLD, BaseColor.BLUE);
        
	static Font subFont8 = new Font(Font.FontFamily.TIMES_ROMAN, 8,Font.BOLD);
                static Font subFont10 = new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.BOLD);
                static Font subFont12 = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.BOLD);
        
                static Font subFontText8 = new Font(Font.FontFamily.TIMES_ROMAN, 8,Font.NORMAL);
                static Font subFontText10 = new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.NORMAL);
                static Font subFontText12 = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.NORMAL);
                
                static Font smallBold7 = new Font(Font.FontFamily.TIMES_ROMAN, 7,Font.BOLD);
	static Font smallBold8 = new Font(Font.FontFamily.TIMES_ROMAN, 8,Font.BOLD);
                static Font smallBold9 = new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD);
        
                 
                static Font smallNormal7 = new Font(Font.FontFamily.TIMES_ROMAN, 7,Font.NORMAL);
                static Font smallNormal8 = new Font(Font.FontFamily.TIMES_ROMAN, 8,Font.NORMAL);
                
                static SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
                static SimpleDateFormat formater2 = new SimpleDateFormat("dd/MM/yyyy  HH:mm ss");
                
                static int[] arrayTitlePageWithsBotton = {20,25,55};
                static int[] arrayContetTableWidths = {13,10,44,5,5,12,11};
                static  Paragraph paragraph;
                
                
                
                
                 private static PdfPTable contentTable;
                 private static PdfPCell cell1;
    
        static  void addMetaData(Document document) {
		document.addTitle("Relatório de Pendências");
		document.addSubject("Pendencias");
		document.addKeywords("Pendencias,Exames,Relatorio,Resultados");
		document.addAuthor("Eros Koller");
		document.addCreator("Eros Koller");
        }
                
        
        
        
        static void addTitlePage(Document document,Date dtInicio,Date dtFinal,String unidadeDesc,String pagina)
			throws DocumentException,Exception {
            
                               
                        
		PdfPTable tableHeaderPage = new PdfPTable(3);
                                tableHeaderPage.setWidthPercentage(100);
                                
                                
                                int[] intWiths = {40,20,40};
                                tableHeaderPage.setWidths(intWiths);
                                PdfPTable tableHeaderLeft = new PdfPTable(1);
                                
                                PdfPCell cellLeft = new PdfPCell();
//                                cellLeft.setRotation(90);
                                cellLeft.setVerticalAlignment(Element.ALIGN_TOP);
                                cellLeft.setBorder(Rectangle.NO_BORDER);
                                
                                cellLeft.addElement(new Phrase("Pendência", catFont12));
                                cellLeft.addElement(new Phrase(unidadeDesc, smallBold9));
                                cellLeft.addElement(new Phrase("Data de Cadastro", smallBold8));
                                cellLeft.addElement(new Phrase("Período: "+formater.format(dtInicio)+" - "+formater.format(dtFinal),smallBold8));
//                                tableHeaderLeft.addCell(cellLeft);
                                
                                PdfPCell cellOutLeft = new PdfPCell(cellLeft);
                                cellOutLeft.setBorderColorRight(BaseColor.WHITE);
                                cellOutLeft.addElement(tableHeaderLeft);
                                tableHeaderPage.addCell(cellOutLeft);
                                
                                PdfPCell cellCenter = new PdfPCell();
                                cellCenter.setBorder(Rectangle.NO_BORDER);
                                cellCenter.addElement(new Phrase("                                                             "));
                                tableHeaderPage.addCell(cellCenter);
                                
                                PdfPCell cellRight = new PdfPCell();
                                cellRight.setBorder(Rectangle.NO_BORDER);
                                cellRight.addElement(new Paragraph("                                  Laboratório", catFont12));
                                tableHeaderPage.addCell(cellRight);


                                document.add(tableHeaderPage);
                                
                                PdfPTable tableHeaderBotton = new PdfPTable(3);
                                tableHeaderBotton.setWidthPercentage(100);
                                PdfPCell cell1 = new PdfPCell();
                                cell1.addElement(new Phrase("                                            "));
                                cell1.setBorder(Rectangle.NO_BORDER);
                                cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
                                
                                tableHeaderBotton.addCell(cell1);
                                
                                
                                cell1 = new PdfPCell();
                                cell1.addElement(new Phrase("                                            "));
                                cell1.setBorder(Rectangle.NO_BORDER);
                                cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
                                tableHeaderBotton.addCell(cell1);
                                
                                cell1 = new PdfPCell();
                                cell1.addElement(new Phrase(new Paragraph("                                         Data/Hora: "+formater2.format(new Date())+" Página: "+pagina,smallBold8)));
                                cell1.setBorder(Rectangle.NO_BORDER);
                                cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
                                tableHeaderBotton.addCell(cell1);
                                
                                
                                tableHeaderBotton.setWidths(arrayTitlePageWithsBotton);
                                document.add(tableHeaderBotton);
                                
                                
                                
                                
	}
                
    
        static  void makeTablesHeader(Document doc) throws DocumentException{
            
            PdfPTable pdfTableContent = new PdfPTable(7);
            pdfTableContent.setWidths(arrayContetTableWidths);
            pdfTableContent.setWidthPercentage(100);
            Phrase parDataCadastro = new Phrase(" Data Cadastro",smallBold9);
            Phrase parRequisicao = new Phrase(" Requisição",smallBold9);
            Phrase parNome = new Phrase(" Nome",smallBold9);
            Phrase parIdade = new Phrase("Idade",smallBold9);
            Phrase parSexo = new Phrase("Sexo",smallBold9);
            Phrase parUnidade = new Phrase("Unidade",smallBold9);
            Phrase parDataEntrega = new Phrase("Data Entrega",smallBold9);
      
            pdfTableContent.addCell(parDataCadastro);
            pdfTableContent.addCell(parRequisicao);
            pdfTableContent.addCell(parNome);
            pdfTableContent.addCell(parIdade);
            pdfTableContent.addCell(parSexo);
            pdfTableContent.addCell(parUnidade);
            pdfTableContent.addCell(parDataEntrega);
            
                    try {
                        doc.add(pdfTableContent);
                    } catch (DocumentException ex) {
                        Logger.getLogger(PdfRelMakerPendencias.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        
        }
        
    

      static  float makePdfContentOneByOne(LabRequisicao  labReq,Document document) throws DocumentException{
          
                                   
          
                                    LabPaciente pac = labReq.getPacInCodigo();
                                    contentTable = new PdfPTable(7);
                                    contentTable.setWidthPercentage(100);
                                    contentTable.setWidths(arrayContetTableWidths);
                                    cell1 = new PdfPCell();
                                    cell1.setBorder(Rectangle.NO_BORDER);
                                    cell1.addElement(new Phrase(formater2.format(labReq.getReqDtCadastro()) ,smallNormal8));
                                    cell1.setPadding(0);
                                    cell1.setPaddingLeft(5f);
                                    contentTable.addCell(cell1);

                                    cell1 = new PdfPCell();
                                    cell1.setBorder(Rectangle.NO_BORDER);
                                    cell1.addElement(new Phrase(labReq.getReqStCodigo(),redFont8Bold));
                                    cell1.setPadding(0);
                                    cell1.setPaddingLeft(5f);
                                    contentTable.addCell(cell1);

                                    cell1 = new PdfPCell();
                                    cell1.setBorder(Rectangle.NO_BORDER);
                                    cell1.addElement(new Phrase(pac.getPacStNome(),blueFont8Bold));
                                    cell1.setPadding(0);
                                    cell1.setPaddingLeft(5f);
                                    contentTable.addCell(cell1);

                                    cell1 = new PdfPCell();
                                    cell1.setBorder(Rectangle.NO_BORDER);
                                    cell1.addElement(new Phrase(pac.getPacInIdade().toString(),smallNormal8));
                                    cell1.setPadding(0);
                                    cell1.setPaddingLeft(5f);
                                    contentTable.addCell(cell1);

                                    cell1 = new PdfPCell();
                                    cell1.setBorder(Rectangle.NO_BORDER);
                                    cell1.addElement(new Phrase(pac.getPacStSexo().toString(),smallNormal8));
                                    cell1.setPadding(0);
                                    cell1.setPaddingLeft(5f);
                                    contentTable.addCell(cell1);

                                    cell1 = new PdfPCell();
                                    cell1.setBorder(Rectangle.NO_BORDER);
                                    cell1.addElement(new Phrase(labReq.getUniStCodigo().getUniStDescricaoResumida(),smallNormal8));
                                    cell1.setPadding(0);
                                    cell1.setPaddingLeft(5f);
                                    contentTable.addCell(cell1);

                                    cell1 = new PdfPCell();
                                    cell1.setBorder(Rectangle.NO_BORDER);
                                    cell1.addElement(new Phrase(formater.format(labReq.getReqDtFatura()),smallNormal8));//TODO redo it dude data entrega e nao data fatura
                                    cell1.setPadding(0);
                                    cell1.setPaddingLeft(5f);
                                    contentTable.addCell(cell1);

                                    document.add(contentTable);    


                                    contentTable = new PdfPTable(1);
                                    contentTable.setWidthPercentage(100);
                                    cell1 = new PdfPCell();
                                    cell1.setBorder(Rectangle.NO_BORDER);
                                    cell1.addElement(new Phrase(labReq.getListTextExames(),smallBold7));
                                    cell1.setPadding(0);
                                    cell1.setPaddingLeft(5f);
                                    contentTable.addCell(cell1);

                                    cell1 = new PdfPCell();
                                    cell1.setBorder(Rectangle.BOTTOM );
                                    contentTable.addCell(cell1);
                                    document.add(contentTable);
          
          
          return document.getPageSize().getHeight();
      }
      
      
      static  void addEmptyLine(Document doc, int number) throws DocumentException {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
                                doc.add(paragraph);
        }
      
      static void addGrayEmptyLine(Document doc, int number) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(" ");
		for (int i = 0; i < number; i++) {
			sb.append("_");
		}
                            try {
                                doc.add(new Paragraph(sb.toString()));
                            } catch (DocumentException ex) {
                                Logger.getLogger(PdfRelMakerPendencias.class.getName()).log(Level.SEVERE, null, ex);
                            }
        }
      
      
//      @Deprecated
//      public void makePageContent(List<LabRequisicao>  listRequisicoes,Document document) throws DocumentException,Exception {
//                        
//                        PdfPTable contentTable;
//                        PdfPCell cell1;
//                        
//                           if(listRequisicoes != null  && listRequisicoes.size()>0){
//                               
//                               
//                                 for(LabRequisicao lr : listRequisicoes){
//                                     
//                                    LabPaciente pac = lr.getPacInCodigo();
//                                    contentTable = new PdfPTable(7);
//                                    contentTable.setWidthPercentage(100);
//                                    contentTable.setWidths(arrayContetTableWidths);
//                                    cell1 = new PdfPCell();
//                                    cell1.setBorder(Rectangle.NO_BORDER);
//                                    cell1.addElement(new Phrase(formater2.format(lr.getReqDtCadastro()) ,smallNormal8));
//                                    cell1.setPadding(0);
//                                    cell1.setPaddingLeft(5f);
//                                    contentTable.addCell(cell1);
//
//                                    cell1 = new PdfPCell();
//                                    cell1.setBorder(Rectangle.NO_BORDER);
//                                    cell1.addElement(new Phrase(lr.getReqStCodigo(),redFont8Bold));
//                                    cell1.setPadding(0);
//                                    cell1.setPaddingLeft(5f);
//                                    contentTable.addCell(cell1);
//
//                                    cell1 = new PdfPCell();
//                                    cell1.setBorder(Rectangle.NO_BORDER);
//                                    cell1.addElement(new Phrase(pac.getPacStNome(),blueFont8Bold));
//                                    cell1.setPadding(0);
//                                    cell1.setPaddingLeft(5f);
//                                    contentTable.addCell(cell1);
//
//                                    cell1 = new PdfPCell();
//                                    cell1.setBorder(Rectangle.NO_BORDER);
//                                    cell1.addElement(new Phrase(pac.getPacInIdade().toString(),smallNormal8));
//                                    cell1.setPadding(0);
//                                    cell1.setPaddingLeft(5f);
//                                    contentTable.addCell(cell1);
//
//                                    cell1 = new PdfPCell();
//                                    cell1.setBorder(Rectangle.NO_BORDER);
//                                    cell1.addElement(new Phrase(pac.getPacStSexo().toString(),smallNormal8));
//                                    cell1.setPadding(0);
//                                    cell1.setPaddingLeft(5f);
//                                    contentTable.addCell(cell1);
//
//                                    cell1 = new PdfPCell();
//                                    cell1.setBorder(Rectangle.NO_BORDER);
//                                    cell1.addElement(new Phrase(lr.getUniStCodigo().getUniStDescricaoResumida(),smallNormal8));
//                                    cell1.setPadding(0);
//                                    cell1.setPaddingLeft(5f);
//                                    contentTable.addCell(cell1);
//
//                                    cell1 = new PdfPCell();
//                                    cell1.setBorder(Rectangle.NO_BORDER);
//                                    cell1.addElement(new Phrase(formater.format(lr.getReqDtFatura()),smallNormal8));//TODO redo it dude data entrega e nao data fatura
//                                    cell1.setPadding(0);
//                                    cell1.setPaddingLeft(5f);
//                                    contentTable.addCell(cell1);
//
//                                    document.add(contentTable);    
//
//
//                                    contentTable = new PdfPTable(1);
//                                    contentTable.setWidthPercentage(100);
//                                    cell1 = new PdfPCell();
//                                    cell1.setBorder(Rectangle.NO_BORDER);
//                                    cell1.addElement(new Phrase(lr.getListTextExames(),smallBold7));
//                                    cell1.setPadding(0);
//                                    cell1.setPaddingLeft(5f);
//                                    contentTable.addCell(cell1);
//
//                                    cell1 = new PdfPCell();
//                                    cell1.setBorder(Rectangle.BOTTOM );
//                                    contentTable.addCell(cell1);
//                                    document.add(contentTable);
//                                    
//                                }
//
//                           }
//                        
//                        
//                      
//
//                        
//	}
      
      
}
