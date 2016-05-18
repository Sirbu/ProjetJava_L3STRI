/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import SuperChat.ErrorDialog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author alex
 */
public class Mysql {

    private String MyDriver;
    private String MyUrl;

    private Connection connect;
    private Statement st;
    private ResultSet result;
    
    private String query;
    
    // peut être pas nécessaire
    private ErrorDialog erreur;
    
    public Mysql() throws ClassNotFoundException, SQLException
    {
        // peut être pas nécessaire
        erreur = new ErrorDialog();
        
        this.MyDriver = "com.mysql.jdbc.Driver";
        this.MyUrl = "jdbc:mysql://localhost:3306/java_project";
        
        // Connection à la base de donnée
        Class.forName(this.MyDriver);
        // user et mot de passes et base de donnée
        // sont temporaires. Tout est en local jusqu'à trouver mieux (raspi)
        connect = DriverManager.getConnection(this.MyUrl, "root", "mysql");
    }
    
    public boolean connectDB(String login, String password) throws SQLException, ClassNotFoundException
    {

        // TODO : pener à une méthode pour hasher les mots de passe
        // Requête permettant d'extraire les infos de connexion
        // dans la base de donnée
        query = "SELECT login, password from User"
                + " WHERE login = \'" + login + "\';";

        // on envoie la requête
        st = connect.createStatement();
        result = st.executeQuery(query);

        // si il existe un tel login...
        if (result.first())
        {
            // ... et si le mot de passe correspond...
            if (password.contentEquals(result.getString("password")))
            {
                // ... Connecté !
                System.out.println("Connexion réussie !");
                
                return true;
            }
            else
            {
                System.err.println("[ERROR] Bad login/Password combination");
            }
        }    
        else
        {
            System.err.println("[ERROR] Bad Login/password combination");
        }
        
        return false;
    }
    
    public ResultSet sendQuery(String query) throws SQLException
    {
        this.st = connect.createStatement();
                
        return (st.executeQuery(query));
    }
}
