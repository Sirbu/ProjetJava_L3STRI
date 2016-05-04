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
        
        String query;
        Statement st;
        ResultSet result;
        
        String MyDriver = "com.mysql.jdbc.Driver";
        String MyURL = "jdbc:mysql://localhost:3306/toto";
        
        Class.forName(MyDriver);
        
        Connection connect = DriverManager.getConnection(MyURL, "root", "mysql");  
        
        query = "SELECT * from test;";

        st = connect.createStatement();
        result = st.executeQuery(query);
        
        while(result.next())
        {
            System.out.println("truc -> " + result.getInt("truc"));
            System.out.println("bidule -> " + result.getString("bidule"));
        }
    }
    
}
