/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erpServs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LoveYou3000
 */
public class DataInput extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    
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
                try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
//            String s = request.getParameter("item0");            
            Enumeration paramNames = request.getParameterNames();
            out.println("Hahaha");
            String[] items = request.getParameterValues("items");
            out.println(Arrays.toString(items)); 
            
            
            
//            String n = request.getParameter("itemQuan");
//            out.println(n);
//            int n =Integer.parseInt(request.getParameter("itemQuan"));
//            String[] items = new String[n]; 
//            int[] quantity = new int[n]; 
//            String str1,str2;
//            for(int i=0;i<n;i++){
//                
//                items[i]=request.getParameter("item"+i);
//                quantity[i]=Integer.parseInt(request.getParameter("quantity"+i));
//                 
//            }
//            str1 = Arrays.toString(items);
//            str2 = Arrays.toString(quantity);
//            
//            System.out.println(str1);
//            System.out.println(str2);
        
    }
    }
}
