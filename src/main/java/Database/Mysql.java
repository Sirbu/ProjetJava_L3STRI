/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import SuperChat.ErrorDialog;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author alex
 */
public class Mysql {

    private String MyDriver;
    private String MyUrl;

    private Connection connect;
    
    private Statement st;
    private PreparedStatement prep_st;
    
    private ResultSet result;
    
    private String query;
    
    // peut être pas nécessaire
    private ErrorDialog erreur;
    
    public Mysql()
    {
        // peut être pas nécessaire
        erreur = new ErrorDialog();
        
        this.MyDriver = "com.mysql.jdbc.Driver";
        this.MyUrl = "jdbc:mysql://sirbu.freeboxos.fr:55555/java_project";
        

        try 
        {
            // Connection à la base de donnée
            Class.forName(this.MyDriver);
            
            // user et mot de passes et base de donnée
            // sont temporaires. Tout est en local jusqu'à trouver mieux (raspi)
            connect = DriverManager.getConnection(this.MyUrl, "root", "mysql");
            
        } catch (SQLException ex) 
        {
            Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
            erreur.showError("Erreur SQL :\n" + ex.getMessage());
        } catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
            erreur.showError("Erreur fatale :\n" + ex.getMessage());
        }
    }

    public PreparedStatement getPrep_st() {
        return prep_st;
    }

    public void setPrep_st(String prep_st) throws SQLException {
        this.prep_st = (PreparedStatement) connect.prepareStatement(prep_st);
    }

    public ResultSet sendPrepQuery() throws SQLException
    {
        return this.prep_st.executeQuery();
    }
    
    public void sendPreparedUpdate() throws SQLException
    {
        this.prep_st.executeUpdate();
    }
    
    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
    
    
    
    // réfléchir a une possibilité de traiter les résultats
    // à l'intérieur de la classe.
    public ResultSet sendQuery(String query) throws SQLException
    {
        this.st = connect.createStatement();
        
        return (st.executeQuery(query));
    }
    
    public void sendUpdate(String query) throws SQLException
    {
        this.st = connect.createStatement();
        st.executeUpdate(query);
    }
    
    public boolean checkAuth(String login, String password) throws SQLException, ClassNotFoundException
    {

        // TODO : pener à une méthode pour hasher les mots de passe
        // Requête permettant d'extraire les infos de connexion
        // dans la base de donnée
        query = "SELECT login, password from User"
                + " WHERE login = \'" + login + "\';";

        // on envoie la requête
        result = sendQuery(query);

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
    
    public void close()
    {
        try 
        {
            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
            erreur.showError("Problème lors de la fermeture de connexion :\n"+
                    ex.getMessage());
        }
    }
}
