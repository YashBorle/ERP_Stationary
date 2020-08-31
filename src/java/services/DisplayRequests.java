/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.google.gson.Gson;
import controller.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.FacultyRequest;

/**
 *
 * @author LoveYou3000
 */
public class DisplayRequests extends HttpServlet {

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
            String s = request.getParameter("last");
            if(s.isEmpty()){
                s="5";
            }
            String dbquery="select * from erpdb.requests " +
                            "order by reqDate desc " +
                            "limit "+s;
            try{
                Connection con = DBConnection.dbInitialize();
                Statement stmt = con.createStatement();
                ResultSet rs =stmt.executeQuery(dbquery);
                ArrayList<FacultyRequest> arr = new ArrayList<>();
                while(rs.next()){
                    FacultyRequest fac = new FacultyRequest(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6));
                    arr.add(fac);
                }
                rs.close();
                stmt.close();
                
                Gson gson = new Gson();
                String json = gson.toJson(arr);
                
                request.setAttribute("json", json);
                request.setAttribute("flag", "true");
                request.getRequestDispatcher("disRequests.jsp").forward(request, response);
            }
            catch(Exception e){
                request.setAttribute("flag", "false");
                request.setAttribute("json", e.toString());
                request.getRequestDispatcher("disRequests.jsp").forward(request, response);
                System.out.println(e);
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

}
