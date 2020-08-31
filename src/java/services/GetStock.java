
package services;

import controller.DBConnection;
import models.Item;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author LoveYou3000
 */
public class GetStock extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
             {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            try{
               String dbQuery = "Select * from erpdb.stock";
               String dbQueryF = "Select facultyName from erpdb.faculty";
               
               String dec = request.getParameter("e");
               
               Connection con = DBConnection.dbInitialize();
               Statement stmt = con.createStatement();
               ResultSet rs = stmt.executeQuery(dbQuery);

                ArrayList<Item> items = new ArrayList<>();
                ArrayList<String> faculty = new ArrayList<>();
                

                while(rs.next()){
                    Item obj = new Item(rs.getInt("itemId"),rs.getString("itemName"),rs.getInt("itemQuantity"));
                    items.add(obj);
                }
                rs.close();
                
                Gson gson = new Gson();
                
                String jsonobj = gson.toJson(items);
                out.println(jsonobj);
               if(dec.contains("request")){
                    rs = stmt.executeQuery(dbQueryF);
                    while(rs.next()){
                    faculty.add(rs.getString(1));
                    }
                    String fac = gson.toJson(faculty);
                    request.setAttribute("fjson",fac);
                    request.setAttribute("gjson",jsonobj);
                    request.getRequestDispatcher("facultyReq.jsp").forward(request,response);
               }
               else if(dec.contains("requisition")){
                    request.setAttribute("gjson",jsonobj);
                    request.getRequestDispatcher("requisition.jsp").forward(request,response);
               }
            }
            catch(SQLException e){
                System.out.println(e);
            }
        }
        catch(Exception e){
            System.out.println(e);
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

}
