/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utils.pdfmaker;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

/**
 *
 * @author eros
 */
public class HeaderFooterPageEvent extends PdfPageEventHelper {
  private String headerStr, footerStr;
  private Rectangle hBox, fBox;
  
  public HeaderFooterPageEvent(String hStr, Rectangle _hBox, String fString, Rectangle _fBox) {
    headerStr = hStr;
    hBox = _hBox;
    footerStr = fString;
    fBox = _fBox;
  }
  
    @Override
  public void onEndPage(PdfWriter writer, Document doc) {
    // draw the header text.
    ColumnText.showTextAligned(
            writer.getDirectContent(),Element.ALIGN_RIGHT, new Phrase(headerStr), hBox.getRight(), hBox.getTop(), 0);
        
    // draw the footer text.
   ColumnText.showTextAligned(
           writer.getDirectContent(),Element.ALIGN_RIGHT,  new Phrase(footerStr), fBox.getRight(), fBox.getTop(), 0);
  }
  
}