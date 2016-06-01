package SuperChat;

import Database.Mysql;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pumba
 */
public class Appadmin extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form appadmin
     */
    private Mysql connector;
    private ErrorDialog erreur;
    private PageGere gere;
    private Creer cree;
    private Timer timer;
    private Appclient Messagerie;
    
    public Appadmin() {
        initComponents();
        
        this.timer = new Timer(200,this);
        this.timer.setInitialDelay(200);
        this.timer.start();
        
        erreur = new ErrorDialog();
        try 
        {            
            connector = new Mysql();
            
            String query = "SELECT nomSalon FROM Salon;";
            
            ResultSet result = connector.sendQuery(query);
            
            while(result.next())
            {
                ListSalon.addItem(result.getString("nomSalon"));
            }
            
            
        }  catch (SQLException ex) 
        {
            Logger.getLogger(Appclient.class.getName()).log(Level.SEVERE, null, ex);
            erreur.showError("Erreur SQL :\n" + ex.getMessage());
        }   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        creer = new javax.swing.JButton();
        supprimer = new javax.swing.JButton();
        gerer = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        deconnexion = new javax.swing.JButton();
        ListSalon = new javax.swing.JComboBox<>();
        AccesTchat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        creer.setText("Creer");
        creer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creerActionPerformed(evt);
            }
        });

        supprimer.setText("Supprimer");
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerActionPerformed(evt);
            }
        });

        gerer.setText("Gerer");
        gerer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gererActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("SuperChat");
        jLabel3.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Century Schoolbook L", 1, 15)); // NOI18N
        jLabel1.setText("Administrateur");

        deconnexion.setText("Deconnexion");
        deconnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deconnexionActionPerformed(evt);
            }
        });

        ListSalon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListSalonActionPerformed(evt);
            }
        });

        AccesTchat.setText("Accès au Tchat");
        AccesTchat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccesTchatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(372, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ListSalon, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(creer, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(gerer, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AccesTchat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deconnexion, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel1))
                    .addComponent(AccesTchat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(supprimer)
                    .addComponent(creer)
                    .addComponent(gerer)
                    .addComponent(deconnexion))
                .addGap(28, 28, 28)
                .addComponent(ListSalon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gererActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gererActionPerformed
        // TODO add your handling code here:
            gere = new PageGere();
            gere.setVisible(true);
    }//GEN-LAST:event_gererActionPerformed

    private void deconnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deconnexionActionPerformed
        // TODO add your handling code here:
        connector.close();
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_deconnexionActionPerformed

    private void creerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creerActionPerformed
        // TODO add your handling code here
        cree = new Creer();
        cree.setVisible(true);
//        String requete ="INSERT INTO";
    }//GEN-LAST:event_creerActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        
        ListSalon.removeAllItems();
        
        try 
        {            
            connector = new Mysql();
            
            String query = "SELECT nomSalon FROM Salon;";
            
            ResultSet result = connector.sendQuery(query);
            
            while(result.next())
            {
                ListSalon.addItem(result.getString("nomSalon"));
            }
            
            
        }  catch (SQLException ex) 
        {
            Logger.getLogger(Appclient.class.getName()).log(Level.SEVERE, null, ex);
            erreur.showError("Erreur SQL :\n" + ex.getMessage());
        }
    }//GEN-LAST:event_formWindowActivated

    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed
        // TODO add your handling code here:
                 
        erreur = new ErrorDialog();
        try 
        {    
            String query = "DELETE MessageSalon FROM MessageSalon, Salon WHERE nomSalon=\""+ListSalon.getSelectedItem()+"\" AND MessageSalon.idSalon=Salon.idSalon;";
            System.out.println(query);
            connector.sendUpdate(query);
            
            query = "DELETE Accede FROM Accede, Salon WHERE nomSalon=\""+ListSalon.getSelectedItem()+"\" AND Accede.idSalon=Salon.idSalon;";
            System.out.println(query);
            connector.sendUpdate(query); 
            
            query = "DELETE FROM Salon WHERE nomSalon=\""+ListSalon.getSelectedItem()+"\";";
            System.out.println(query);
            connector.sendUpdate(query);     
            
            //Actualisation de la liste des salons
            
            ListSalon.removeAllItems();
            
            query = "SELECT nomSalon FROM Salon;";
            
            ResultSet result = connector.sendQuery(query);
            
            while(result.next())
            {
                ListSalon.addItem(result.getString("nomSalon"));
            }
            
        }  catch (SQLException ex) 
        {
            Logger.getLogger(Appclient.class.getName()).log(Level.SEVERE, null, ex);
            erreur.showError("Erreur SQL :\n" + ex.getMessage());
        }
    }//GEN-LAST:event_supprimerActionPerformed

    private void ListSalonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListSalonActionPerformed
        // TODO add your handling code here:              
    }//GEN-LAST:event_ListSalonActionPerformed

    private void AccesTchatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccesTchatActionPerformed
        // TODO add your handling code here:
        Messagerie = new Appclient();
        Messagerie.setVisible(true);
    }//GEN-LAST:event_AccesTchatActionPerformed

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
            java.util.logging.Logger.getLogger(Appadmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Appadmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Appadmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Appadmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Appadmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AccesTchat;
    private javax.swing.JComboBox<String> ListSalon;
    private javax.swing.JButton creer;
    private javax.swing.JButton deconnexion;
    private javax.swing.JButton gerer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton supprimer;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        Vector salons = new Vector();
            erreur = new ErrorDialog();
             try 
        {            
           
            
            String query = "SELECT * FROM Salon;";
            
            ResultSet result = connector.sendQuery(query);
            
            while(result.next())
            {
                salons.add(result.getString("nomSalon"));
            }
            
            //ListSalon.setListData(salons);
            
            
        }  catch (SQLException ex) 
        {
            Logger.getLogger(Appclient.class.getName()).log(Level.SEVERE, null, ex);
            erreur.showError("Erreur SQL :\n" + ex.getMessage());
        }
    }
}

