/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
/**
 *
 * @author alex
 */
public class TestBDD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connect;
        
        Class.forName("com.mysql.jdbc.Driver");
        
        connect = DriverManager
          .getConnection("jdbc:mysql://localhost:3306/toto?"
              + "user=root&password=mysql");
        
        
    }
    
}
