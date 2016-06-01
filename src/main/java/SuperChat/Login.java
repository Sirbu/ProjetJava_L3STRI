package SuperChat;

import Database.Mysql;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pumba
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    private static String username;

    private Appclient messagerie;
    private Appadmin admin;
    private ErrorDialog erreur;
    
    private Mysql connector;

    public Login() throws ClassNotFoundException
    {
        erreur = new ErrorDialog();
        
        this.connector = new Mysql();
        initComponents();
        // on centre la fenetre
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        errorDialog = new javax.swing.JDialog();
        okButton = new javax.swing.JButton();
        label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        errorDetails = new javax.swing.JTextArea();
        ConnectButton = new javax.swing.JButton();
        loginField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();

        errorDialog.setTitle("Error");
        errorDialog.setAlwaysOnTop(true);
        errorDialog.setResizable(false);
        errorDialog.setType(java.awt.Window.Type.UTILITY);

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        label.setText("Erreur :");

        errorDetails.setColumns(20);
        errorDetails.setRows(5);
        errorDetails.setEnabled(false);
        jScrollPane1.setViewportView(errorDetails);

        javax.swing.GroupLayout errorDialogLayout = new javax.swing.GroupLayout(errorDialog.getContentPane());
        errorDialog.getContentPane().setLayout(errorDialogLayout);
        errorDialogLayout.setHorizontalGroup(
            errorDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(errorDialogLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(errorDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(errorDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        errorDialogLayout.setVerticalGroup(
            errorDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, errorDialogLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(label)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(okButton)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        errorDialog.getAccessibleContext().setAccessibleDescription("");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SuperChat : Login");

        ConnectButton.setText("Connexion");
        ConnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConnectButtonActionPerformed(evt);
            }
        });

        loginField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Login :");

        jLabel2.setText("Password :");

        jLabel3.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("SuperChat");
        jLabel3.setToolTipText("");

        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(loginField)))
                    .addComponent(ConnectButton))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(ConnectButton)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginFieldActionPerformed
        ConnectButtonActionPerformed(evt);
    }//GEN-LAST:event_loginFieldActionPerformed

    private void ConnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConnectButtonActionPerformed

        // variables de connection à la base de donnée
        char[] passArray = passwordField.getPassword();
        String password = new String(passArray);

        try
        {
            if(connector.checkAuth(loginField.getText(), password))
            {
                // Connexion réussie !
                // on instancie la messagerie !
                Login.username = loginField.getText();
                String requete = "SELECT isAdmin FROM User WHERE login=\""+loginField.getText()+"\";";
                ResultSet result = connector.sendQuery(requete);
                result.first();
                
                if(result.getString("isAdmin").contentEquals("1")){
                    admin = new Appadmin();
                    admin.setVisible(true);
                } else if(result.getString("isAdmin").contentEquals("0")){
                   messagerie = new Appclient();
                   messagerie.setVisible(true);  
                }
                connector.close();
                this.setVisible(false);
                this.dispose(); 
            }
            else
            {
                erreur.showError("Login ou mot de passe invalide !");
            }
            
        } catch (SQLException ex)
        {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            erreur.showError(ex.getMessage());
            
        } catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            erreur.showError(ex.getMessage());
        }
        catch(Exception e)
        {
            erreur.showError("La connexion à la base de donnée"
                    + " n'a probablement pas été effectuée :\n" + e.getMessage());
        }
        
    }//GEN-LAST:event_ConnectButtonActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed

        ConnectButtonActionPerformed(evt);
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
        errorDialog.setVisible(false);
    }//GEN-LAST:event_okButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try 
                {
                    new Login().setVisible(true);
                    
                }catch (ClassNotFoundException ex)
                {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public static String getUsername() {
        return username;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConnectButton;
    private javax.swing.JTextArea errorDetails;
    private javax.swing.JDialog errorDialog;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JTextField loginField;
    private javax.swing.JButton okButton;
    private javax.swing.JPasswordField passwordField;
    // End of variables declaration//GEN-END:variables
}
