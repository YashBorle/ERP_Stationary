/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.google.gson.*;
import controller.DBConnection;
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
public class submitRequest extends HttpServlet {

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
            Gson gson = new Gson();
            String data = request.getParameter("pos");
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(data);
            JsonObject obj2 = element.getAsJsonObject();
            JsonObject message = new JsonObject();
            
            request.setCharacterEncoding("utf8");
            response.setContentType("application/json");
            
            
            String dbQ = getStockRequestQuery(obj2);
           
            
            
            String dbS = getStockUpdateQuery(obj2);
            try{
                Connection con = DBConnection.dbInitialize(); 
                Statement s = con.createStatement();
                s.executeUpdate(dbQ);
                s.executeUpdate(dbS);
                message.addProperty("message", "Success");
                out.print(message);
            }
            catch(ClassNotFoundException | SQLException e){
                System.out.println(e);
                message.addProperty("message", e.toString());
                out.print(message);
            
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

    private String getVal(String string, JsonObject obj2) {
        return obj2.get(string).getAsString();
        
    }

    private String getStockRequestQuery(JsonObject obj2) {
        return "insert into erpdb.requests(facultyName,reqDate,item,quantity,remarks)"
                    + " values('"+getVal("faculty",obj2)+"',CURRENT_TIMESTAMP(),'"+getVal("item",obj2)+"'"
                    + ",'"+getVal("quantity",obj2)+"','"+getVal("remarks",obj2)+"')" ;
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String getStockUpdateQuery(JsonObject obj2) {
        return "update erpdb.stock"
                    + " set itemQuantity=itemQuantity-"+ getVal("quantity",obj2)
                    +" where itemName='"+getVal("item",obj2)+"'";
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
