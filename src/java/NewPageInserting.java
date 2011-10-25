
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eros
 */

public class NewPageInserting {
    
 public static void main(String[] args)throws Exception {
     
     
     
 System.out.println("Example of a PDF File  to blank pages and new page"); 
 
  Rectangle pageSize = new Rectangle(288, 720);
  Document document = new Document(pageSize, 36, 18, 72, 72);
  PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream("NewPagePDF.pdf"));
  document.open();
  
  PdfPTable table1 = new PdfPTable(1);
  table1.addCell("Inside Table Page 1");
  document.add(table1);
  
//  document.newPage();  
//  writer.setPageEmpty(false);
//  document.add(new Paragraph("Pagina 2-->>"));  
//  
//  
//  document.newPage();
//  writer.setPageEmpty(false);
//  document.add(new Paragraph("Pagina 3-->>"));  
//  document.close();
  int x = 1;
  for(int i = 0 ; i < 100; i ++){
      document.newPage();
      writer.setPageEmpty(false);
      document.add(new Paragraph("Pagina : "+(i+x)+"->>"));  
  }
  document.close();
  
  }
}