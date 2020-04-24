/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erpServs;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LoveYou3000
 */
public class FetchData extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws javax.servlet.ServletException
     */
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
                response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           try{
            
                Connection con = DBConnection.dbInitialize();

                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from r_object where isFilled='0'");
                rs.next();
                int i = rs.getInt(1);
                String[] items = rs.getString(2).split(",");
                String[] quantity = rs.getString(3).split(",");
                String[] remark = rs.getString(4).split(",");
                String[] supplied = rs.getString(5).split(",");
                boolean isPrinted = bool(rs.getInt(6));
                boolean isFilled = bool(rs.getInt(7)); 

                RequisitionForm re = new RequisitionForm(i,items,quantity,remark,supplied,isPrinted,isFilled);

                Gson gson = new Gson();
                String jsonObj = gson.toJson(re);

                out.println(jsonObj);

        //            response.sendRedirect("stockFill.jsp");

                request.setAttribute("gjson",jsonObj);
                request.getRequestDispatcher("stockFill.jsp").forward(request, response);

            
            
        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        
        }
    }

    private boolean bool(int aInt) {
        if(aInt==0) return false;
        else return true;
        
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
