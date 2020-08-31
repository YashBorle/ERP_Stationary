/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import controller.DBConnection;
import com.google.gson.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
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
            String items =request.getParameter("items");
            String quan = request.getParameter("quantity");
            int i= Integer.parseInt(request.getParameter("itl"));
            int q= Integer.parseInt(request.getParameter("qtl"));
            request.setCharacterEncoding("utf8");
            response.setContentType("application/json");
            JsonObject obj = new JsonObject();
            if(i==q){
            String dbQuery= "INSERT INTO erpdb.r_object(items,quantity,printDate)values('"+items+"','"+quan+"',CURRENT_TIMESTAMP())";
            
            try{
                Connection con = DBConnection.dbInitialize();
                Statement stmt = con.createStatement();
                stmt.executeUpdate(dbQuery);
                stmt.close();
                obj.addProperty("message", "Success");
                out.print(obj);
            }
            catch(ClassNotFoundException | SQLException e){
                System.out.println(e);
                obj.addProperty("message", e.toString());
                out.print(obj);
            }
            }
            else{
                obj.addProperty("message", "Submit Proper Values!");
                out.println(obj);
            }

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
