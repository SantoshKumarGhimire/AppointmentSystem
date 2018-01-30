/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointment.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Santosh
 */

//this class provides database connection 
// It has connected to mysql database
public class DbConnection {
    
     public static Connection getDBConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/appointment_db", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;

    }
    
}
