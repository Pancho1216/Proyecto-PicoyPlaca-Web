/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pyp.back.Placa;

/**
 *
 * @author dari1
 */
@WebServlet(name = "ControladorPlaca", urlPatterns = {"/ControladorPlaca"})
public class ControladorPlaca extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorPlaca</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorPlaca at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Placa placa=new Placa();
        response.setContentType("text/plain;charset=UTF-8");
        String ac=request.getParameter("verificar");
        //String verProductos=request.getParameter("repProductos");
        
        if(ac.equals("Verificar Placa"))
        {
            placa.setFecha(request.getParameter("fecha"));
            placa.setHora(request.getParameter("hora"));
            placa.setMinutos(request.getParameter("minutos"));
            placa.setPlacaparte1(request.getParameter("placap1"));
            placa.setPlacaparte2(request.getParameter("placap2"));
            PrintWriter out = response.getWriter();
            
            if(placa.validarFecha()){
                if(placa.validarplacaletras()){
                    try {
                        String resultado=placa.validarSiPuedeSalir();
                        out.print(resultado);
                    } catch (ParseException ex) {
                        Logger.getLogger(ControladorPlaca.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    out.print("Por favor ingresar solo letras");
                }
            }else{
                out.print("Por favor ingresar la fecha de forma correcta");
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
