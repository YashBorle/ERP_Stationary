/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import controller.DBConnection;
import com.google.gson.JsonObject;
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
public class SubmitSupplied extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String id = request.getParameter("id");
            String remarks = request.getParameter("remarks");
            String supplied = request.getParameter("supplied");
            String items = request.getParameter("items");
            String DBquery ="update erpdb.r_object "
                    + "set remark='"+remarks+"',supplied='"+supplied+"',isFilled="+1+",stockFillDate= CURRENT_TIMESTAMP() "
                    + "where idr_object="+id;

            JsonObject obj = new JsonObject();
            
            request.setCharacterEncoding("utf8");
            response.setContentType("application/json");
            
            try{
                Connection con = DBConnection.dbInitialize();
                Statement s = con.createStatement();
                s.execute(DBquery);
                updateStock(s,items.split(","),supplied.split(","));
                s.close();
                obj.addProperty("message", "Success");
                out.print(obj);
            }
            catch(ClassNotFoundException | SQLException e){
                System.out.print(e);
                obj.addProperty("message", e.toString());
                out.print(obj); 
            }
           
            
            
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
        processRequest(request, response);
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

    private void updateStock(Statement s, String[] item, String[] supplied) throws SQLException {
        String stockQuery;
        for(int i = 0 ; i<item.length;i++){
             stockQuery ="update erpdb.stock " +
                    "set itemQuantity = itemQuantity +"+supplied[i]+
                    " where itemName='" +item[i]+"'"
                    ;
            s.execute(stockQuery);
        }
    }

}
