
package erpServs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    protected static Connection dbInitialize() throws SQLException,ClassNotFoundException{
               String dbUserName="root";
               String dbPass ="root";
               String dbUrl = "jdbc:mysql://localhost:3306/erpdb";
               Class.forName("com.mysql.jdbc.Driver");
               Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPass);
               return con; 
    }
}
