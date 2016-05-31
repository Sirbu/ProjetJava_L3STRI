package SuperChat;

import Database.Mysql;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import sun.swing.SwingUtilities2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pumba
 */
public class Appclient extends javax.swing.JFrame implements ActionListener{

    private Mysql connector;
    private ErrorDialog erreur;
    private Timer timer;
    
    /**
     * Creates new form appclient
     */
    public Appclient() {
        initComponents();
        
        this.timer = new Timer(200, this);
        this.timer.setInitialDelay(200);
        this.timer.start();
        
        jTabbedPane1.setTitleAt(1, "Users");
        
        Vector salons = new Vector();
        Vector users = new Vector();
        erreur = new ErrorDialog();
        
        try 
        {            
            connector = new Mysql();
            
            String query = "SELECT * FROM Salon;";
            
            ResultSet result = connector.sendQuery(query);
            
            while(result.next())
            {
                salons.add(result.getString("nomSalon"));
            }
            
            ListSalon.setListData(salons);
            
            query = "SELECT login FROM User WHERE login <>\""+ Login.getUsername() +"\";";
            result = connector.sendQuery(query);
            
            while(result.next())
            {
                String user = result.getString("login");
                users.add(capitalize(user));
            }
            
            ListUsers.setListData(users);
          
            String login = Login.getUsername();
            String co = "update User SET statut=\"Connecté\" where login=\""+login+"\";";  
            connector.sendUpdate(co);
            
            WelcomeUser.setText("Bienvenue "+capitalize(login)+" !");            
            
        }  catch (SQLException ex) 
        {
            Logger.getLogger(Appclient.class.getName()).log(Level.SEVERE, null, ex);
            erreur.showError("Erreur SQL :\n" + ex.getMessage());
        }
    }
    
    public static String capitalize(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return str;
        }
        return new StringBuffer(strLen)
            .append(Character.toTitleCase(str.charAt(0)))
            .append(str.substring(1))
            .toString();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DeconnectButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ReponseField = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        SendButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        MessagesArea = new javax.swing.JTextArea();
        ComboStatut = new javax.swing.JComboBox<>();
        salonLabel = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListSalon = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListUsers = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        ListUsersSalon = new javax.swing.JTextArea();
        InfoSalon = new javax.swing.JLabel();
        WelcomeUser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SuperChat : Messagerie");

        DeconnectButton.setText("Deconnexion");
        DeconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeconnectButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("SuperChat");
        jLabel3.setToolTipText("");

        ReponseField.setColumns(20);
        ReponseField.setRows(5);
        jScrollPane3.setViewportView(ReponseField);

        jLabel4.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel4.setText("Repondre :");

        SendButton.setText("Envoyer");
        SendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendButtonActionPerformed(evt);
            }
        });

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        MessagesArea.setEditable(false);
        MessagesArea.setColumns(20);
        MessagesArea.setLineWrap(true);
        MessagesArea.setRows(5);
        MessagesArea.setWrapStyleWord(true);
        MessagesArea.setAutoscrolls(false);
        MessagesArea.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MessagesArea.setRequestFocusEnabled(false);
        jScrollPane4.setViewportView(MessagesArea);

        ComboStatut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Connecté", "Occupé", "Absent", "Hors ligne" }));
        ComboStatut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboStatutActionPerformed(evt);
            }
        });

        salonLabel.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        salonLabel.setText("Salon :");

        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setToolTipText("");

        ListSalon.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListSalonValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(ListSalon);

        jTabbedPane1.addTab("Salons", jScrollPane2);
        jScrollPane2.getAccessibleContext().setAccessibleParent(jTabbedPane1);

        ListUsers.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ListUsers.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListUsersValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(ListUsers);

        jTabbedPane1.addTab("tab2", jScrollPane1);

        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        ListUsersSalon.setEditable(false);
        ListUsersSalon.setColumns(20);
        ListUsersSalon.setRows(5);
        ListUsersSalon.setRequestFocusEnabled(false);
        jScrollPane5.setViewportView(ListUsersSalon);

        WelcomeUser.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        WelcomeUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        WelcomeUser.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboStatut, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SendButton))
                            .addComponent(ComboStatut, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(salonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(InfoSalon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(DeconnectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(247, 247, 247)
                        .addComponent(WelcomeUser)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(WelcomeUser)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DeconnectButton)
                            .addComponent(InfoSalon)
                            .addComponent(salonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4)
                            .addComponent(jScrollPane5))
                        .addGap(19, 19, 19)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ComboStatut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(SendButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboStatutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboStatutActionPerformed
        // TODO add your handling code here:
        int item;
        String statut;
        
        item = this.ComboStatut.getSelectedIndex();
        String login = Login.getUsername();
        
        switch (item) {
            case 0:
                statut="Connecté";
                break;
            case 1:
                statut="Occupé";
                break;
            case 2:
                statut="Absent";
                break;
            case 3:
                statut="Hors ligne";
                break;
            default:
                statut="Hors ligne";
                break;
        }
               
        try {
            String query = "update User SET statut=\""+statut+"\" where login=\""+login+"\";";  
            connector.sendUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Appclient.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_ComboStatutActionPerformed

    // détermine si l'utilisateur 'user' à accès en 
    // 'accesType' (string qui est soit 'lecture' soit 'ecriture'
    // au salon 'salon' (donner le nom du salon)
    // peut retourner false si il y a un soucis
    public boolean hasAccess(String user, String salon, String accessType) throws SQLException
    {
        if(!(accessType.contentEquals("lecture")) && !(accessType.contentEquals("ecriture")))
        {
            return false; // you idiot...
        }
        
        String query = "SELECT "+ accessType + " from Accede as A, User as U, Salon as S"
                + " WHERE S.nomSalon = '" + salon + "'"
                + " AND S.idSalon = A.idSalon"
                + " AND U.login = '" + user + "'"
                + " AND U.iduser = A.idUser;";
                
        ResultSet result = connector.sendQuery(query);
        if(result.next())
        {
            return result.getString(accessType).contentEquals("1");
        }
        else
        {   // il n'y a aucune correspondance dans la
            // bdd donc aucun accès
            return false;
        }
    }
    
    // Cette méthode s'exécute à chaque fois que l'on sélectionne
    // un élément de la liste. C'est ici que les messages seront chargés    
    private void ListSalonValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListSalonValueChanged
        
        String salon = this.ListSalon.getSelectedValue();
        
        try
        {
            // on vide la zone de messages en prévision
            // de ceux qui arrivent
            MessagesArea.setText("");              
            ListUsersSalon.setText("");
            InfoSalon.setText("");
            salonLabel.setText("Salon :");

            if(!hasAccess(Login.getUsername(), salon, "lecture"))
            {
                System.out.println(Login.getUsername() + " READ " + salon + " : NOPE");
                this.MessagesArea.setEnabled(false);
                this.ListUsersSalon.setEnabled(false);
                this.InfoSalon.setEnabled(false);
            }
            else
            {
                System.out.println(Login.getUsername() + " READ " + salon + " : YES");
                this.MessagesArea.setEnabled(true);
                ResultSet result;

                String requete = "SELECT login, contenu"
                        + " FROM MessageSalon as M, Salon as S, User as U"
                        + " WHERE S.nomSalon = \"" + salon +"\""
                        + " AND S.idSalon = M.idSalon"
                        + " AND M.idUser = U.idUser;";

                result = connector.sendQuery(requete);

                // maintenant dans result on a toutes les infos
                // des messages du salon selectionné
                while(result.next())
                {
                    String login = result.getString("login");
                    if(login.contentEquals(Login.getUsername())){
                        login = "--Moi--";
                    }
                    this.MessagesArea.setText(MessagesArea.getText() + 
                            "["+ capitalize(login) +"]\n"
                            + result.getString("contenu")+"\n\n");
                }
               
                
                this.ListUsersSalon.setEnabled(true);
                
                requete = "SELECT DISTINCT U.login, U.statut "
                        + "FROM User AS U, Accede AS A, Salon AS S "
                        + "WHERE (S.idSalon = A.idSalon) "
                        + "AND (U.idUser = A.idUser) "
                        + "AND S.nomSalon=\""+ salon +"\";";
                
                result = connector.sendQuery(requete);
                
                while(result.next())
                {
                    String login = result.getString("login");
                    if(login.contentEquals(Login.getUsername())){
                        login = "Moi";
                    }
                    this.ListUsersSalon.setText(ListUsersSalon.getText() 
                            + capitalize(login) +" : "
                            + result.getString("statut")+"\n");
                }
                
                this.InfoSalon.setEnabled(true);
                
                requete = "SELECT description "
                        + "FROM Salon "
                        + "WHERE nomSalon=\""+ salon +"\";";
                                
                result = connector.sendQuery(requete);
                
                while (result.next())
                {
                    String description = result.getString("description");
                    this.InfoSalon.setText(capitalize(description)); 
                }
            }
            
            if(!hasAccess(Login.getUsername(), salon, "ecriture"))
            {
                System.out.println(Login.getUsername() + " WRITE " + salon + " : NOPE");
                this.SendButton.setEnabled(false);
            }
            else
            {
                System.out.println(Login.getUsername() + " WRITE " + salon + " : YES");
                this.SendButton.setEnabled(true);
            }
            
            System.out.println("Affichage des users du salon : " + salon + ".");
            
        } catch (SQLException ex) {
            Logger.getLogger(Appclient.class.getName()).log(Level.SEVERE, null, ex);
            erreur.showError(ex.getMessage());
        }
                
    }//GEN-LAST:event_ListSalonValueChanged
    
    private void DeconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeconnectButtonActionPerformed
        // TODO add your handling code here:
        String login = Login.getUsername();
                    
        try {
            String deco = "update User SET statut=\"Hors ligne\" where login=\""+login+"\";";  
            connector.sendUpdate(deco);
        } catch (SQLException ex) {
            Logger.getLogger(Appclient.class.getName()).log(Level.SEVERE, null, ex);
        }
        connector.close();
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_DeconnectButtonActionPerformed

    private void SendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendButtonActionPerformed
        
        if(!MessagesArea.getText().isEmpty())
        {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
            Date date = new Date();
            
            System.out.println("Selected tab : " + jTabbedPane1.getSelectedIndex());
            
            // on cherche l'id de l'expéditeur
            String userQuery = "SELECT idUser FROM User WHERE login = \"" + Login.getUsername() + "\";";
            
            try 
            {                
                ResultSet userResult = connector.sendQuery(userQuery);
                userResult.first();              
                
                String insert = "INSERT INTO ";
                
                // maintenant il faut savoir si on envoie
                // le message à un utilisateur ou un salon
                if(this.jTabbedPane1.getSelectedIndex() == 0)
                {
                    System.out.println("Message Salon");
                    
                    // et l'id du salon
                    String salonQuery = "SELECT idSalon FROM Salon "
                    + " WHERE nomsalon = '" + ListSalon.getSelectedValue() + "';";
                    
                    ResultSet salonResult = connector.sendQuery(salonQuery);
                    salonResult.first();
                    
                    insert += "MessageSalon (contenu,dateEnvoi,idUser,idSalon) "
                    + "VALUES (?, '" + dateFormat.format(date) + "', " 
                    + "'" + userResult.getString("idUser") + "', "
                    + "'" + salonResult.getString("idSalon") + "');";
                }
                else if(this.jTabbedPane1.getSelectedIndex() == 1)
                {
                    System.out.println("Message Privé");
                    
                    // il faut l'id du récepteur
                    String recptQuery = "SELECT idUser FROM User "
                            + "WHERE login = '" + ListUsers.getSelectedValue() + "';";
                    
                    ResultSet recptResult = connector.sendQuery(recptQuery);
                    recptResult.first();
                    
                    insert += "MessageUser (contenu,dateEnvoi,idExpediteur,idRecepteur) "
                    + "VALUES (?, '" + dateFormat.format(date) + "', " 
                    + "'" + userResult.getString("idUser") + "', "
                    + "'" + recptResult.getString("idUser") + "');";                    
                }
                
                connector.setPrep_st(insert);
                
                // on rajoute le contenu dans la requête préparée
                connector.getPrep_st().setString(1, this.ReponseField.getText());
                System.out.println(connector.getPrep_st());
                connector.sendPreparedUpdate();
            
            } catch (SQLException ex) {
                Logger.getLogger(Appclient.class.getName()).log(Level.SEVERE, null, ex);
                erreur.showError("Erreur SQL :\n" + ex.getMessage());
            }
        }
            
        ReponseField.setText("");
    }//GEN-LAST:event_SendButtonActionPerformed

    private void ListUsersValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListUsersValueChanged
        // TODO add your handling code here:
        
        String destinataire = this.ListUsers.getSelectedValue();
        
        try
        {
            MessagesArea.setText("");              
            ListUsersSalon.setText("");
            InfoSalon.setText("");
            ListUsersSalon.setEnabled(false);
            InfoSalon.setEnabled(false);
            MessagesArea.setEnabled(true);
            salonLabel.setText("Conversation privée avec "+ ListUsers.getSelectedValue() +" :");
            salonLabel.setSize(300, 37);
            ResultSet result;
            
            String requete = "SELECT U.idUser FROM User AS U WHERE U.login= \"" + Login.getUsername() +"\";";
            result = connector.sendQuery(requete);
            result.first();
            String idUserConnected = result.getString("idUser");
            //System.out.println("Notre ID : "+ idUserConnected);
            
            requete = "SELECT U.idUser FROM User AS U WHERE U.login= \"" + destinataire +"\";";
            result = connector.sendQuery(requete);
            result.first();
            String idDestinataire = result.getString("idUser");
            //System.out.println("ID Destinataire : "+ idDestinataire);
            
            requete = "SELECT DISTINCT login, contenu"
                    + " FROM User as U, MessageUser as M"
                    + " WHERE (M.idExpediteur = \"" + idUserConnected +"\" OR M.idExpediteur = \"" + idDestinataire +"\")"
                    + " AND (M.idRecepteur = \"" + idUserConnected +"\" OR M.idRecepteur = \"" + idDestinataire +"\")"
                    + " AND (U.idUser = M.idExpediteur);";

            result = connector.sendQuery(requete);
            
            while(result.next())
            {
                String login = result.getString("login");
                if(login.contentEquals(Login.getUsername())){
                    login = "--Moi--";
                }
                this.MessagesArea.setText(MessagesArea.getText() + 
                        "["+capitalize(login)+"]\n"
                        + result.getString("contenu")+"\n\n");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Appclient.class.getName()).log(Level.SEVERE, null, ex);
            erreur.showError(ex.getMessage());
        }
    }//GEN-LAST:event_ListUsersValueChanged

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
            java.util.logging.Logger.getLogger(Appclient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Appclient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Appclient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Appclient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Appclient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboStatut;
    private javax.swing.JButton DeconnectButton;
    private javax.swing.JLabel InfoSalon;
    private javax.swing.JList<String> ListSalon;
    private javax.swing.JList<String> ListUsers;
    private javax.swing.JTextArea ListUsersSalon;
    private javax.swing.JTextArea MessagesArea;
    private javax.swing.JTextArea ReponseField;
    private javax.swing.JButton SendButton;
    private javax.swing.JLabel WelcomeUser;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel salonLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(jTabbedPane1.getSelectedIndex() == 0)
        {
            this.ListSalonValueChanged(null);
        }
        else if(jTabbedPane1.getSelectedIndex() == 1)
        {
            this.ListUsersValueChanged(null);   
        }
    }
}
