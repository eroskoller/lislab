/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utils.pdfmaker;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eros
 */
@WebServlet(name = "pdfstremer", urlPatterns = {"/PdfStreamer"})
public class PdfStreamer extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
           pdfGiver(request, response);
        } finally {            
            
        }
    }
    
    
    private void pdfGiver(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
                        

        String pdfFileName = (String) request.getAttribute("pdffielname");
        
                            if(pdfFileName != null){
                                
                                String contextPath = getServletContext().getRealPath(File.separator);
		File pdfFile = new File(contextPath +pdfFileName);

                                    if(pdfFile.exists()){
                                                response.setContentType("application/pdf");
                                                response.addHeader("Content-Disposition", "attachment; filename=" + pdfFileName);
                                                
                                                response.setContentLength((int) pdfFile.length());
                                                FileInputStream fileInputStream = new FileInputStream(pdfFile);
                                                OutputStream responseOutputStream = response.getOutputStream();
                                                
                                                int bytes;
                                                
                                                while ((bytes = fileInputStream.read()) != -1) {
                                                        responseOutputStream.write(bytes);
                                                }

                                    }
                
		                                        
                            }
		

	}
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
