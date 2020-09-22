
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LoveYou3000
 */
public class DBConnection {
    public static Connection dbInitialize() throws SQLException,ClassNotFoundException{
               String dbUserName="root";
               String dbPass ="root";
               String dbUrl = "jdbc:mysql://localhost:3306/erpdb";
               Class.forName("com.mysql.jdbc.Driver");
               Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPass);
               return con; 
    }
}
