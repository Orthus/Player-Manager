package player_manager;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.TransformerConfigurationException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Orthus
 */
public class ManagerUI extends javax.swing.JFrame {

    /**
     * Creates new form ManagerUI
     */
   
    List<String> playerinfo;
    String Player_Data;
    public ManagerUI() {
        
        initComponents();
        Configuration_Handler config = new Configuration_Handler();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        First_Name = new javax.swing.JTextField();
        Last_Name = new javax.swing.JTextField();
        Player_ID = new javax.swing.JTextField();
        Gamertag = new javax.swing.JTextField();
        Retro_Points = new javax.swing.JTextField();
        adjust_points = new javax.swing.JTextField();
        search_button = new javax.swing.JButton();
        add_button = new javax.swing.JButton();
        subtract_button = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Retro Point Manager");
        setPreferredSize(new java.awt.Dimension(333, 259));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("First Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(5, 15, 100, 20);

        jLabel2.setText("Last Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(155, 20, 70, 14);

        jLabel3.setText("Player ID");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(165, 47, 70, 14);

        First_Name.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        First_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                First_NameActionPerformed(evt);
            }
        });
        getContentPane().add(First_Name);
        First_Name.setBounds(65, 10, 90, 30);

        Last_Name.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        Last_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Last_NameActionPerformed(evt);
            }
        });
        getContentPane().add(Last_Name);
        Last_Name.setBounds(215, 10, 110, 30);

        Player_ID.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        getContentPane().add(Player_ID);
        Player_ID.setBounds(215, 45, 110, 30);

        Gamertag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GamertagActionPerformed(evt);
            }
        });
        getContentPane().add(Gamertag);
        Gamertag.setBounds(65, 45, 90, 30);
        getContentPane().add(Retro_Points);
        Retro_Points.setBounds(80, 120, 84, 30);
        getContentPane().add(adjust_points);
        adjust_points.setBounds(80, 160, 84, 30);

        search_button.setText("Search");
        search_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(search_button);
        search_button.setBounds(130, 80, 80, 23);

        add_button.setText("+");
        add_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(add_button);
        add_button.setBounds(80, 200, 41, 23);

        subtract_button.setText("-");
        subtract_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subtract_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(subtract_button);
        subtract_button.setBounds(130, 200, 37, 23);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Retro Points");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 130, 100, 14);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Add/Remove");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 170, 140, 14);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("GamerTag");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(5, 50, 70, 14);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/player_manager/retro.png"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(200, 120, 110, 100);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/player_manager/download.jpg"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, 0, 330, 260);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void search_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_buttonActionPerformed
         String Input_ID = Player_ID.getText(), Input_FirstName = First_Name.getText(), Input_LastName = Last_Name.getText(), Input_GamerTag= Gamertag.getText();           
         XML_Handler reader = new XML_Handler();
         Player_Data = "0,1";
        try {
            Player_Data = reader.XML_Reader(Input_ID, Input_FirstName, Input_LastName, Input_GamerTag);
            playerinfo = Arrays.asList(Player_Data.split(","));
            String PlayerID = playerinfo.get(1);
            String PlayerPoints = playerinfo.get(0);
            System.out.println(PlayerID + " " + PlayerPoints);
            Retro_Points.setText(PlayerPoints);
            Player_ID.setText(PlayerID);

        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(ManagerUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        
         
    }//GEN-LAST:event_search_buttonActionPerformed

    private void First_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_First_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_First_NameActionPerformed

    private void subtract_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subtract_buttonActionPerformed
        XML_Handler subtract = new XML_Handler();
        String Sub_Points = "-"+adjust_points.getText();
        Player_Data = subtract.XML_Writer(Player_ID.getText(), Sub_Points);
    }//GEN-LAST:event_subtract_buttonActionPerformed

    private void GamertagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GamertagActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GamertagActionPerformed

    private void add_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_buttonActionPerformed
        XML_Handler add = new XML_Handler();
        String add_points = adjust_points.getText();
        Player_Data = add.XML_Writer(Player_ID.getText(), add_points);    }//GEN-LAST:event_add_buttonActionPerformed

    private void Last_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Last_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Last_NameActionPerformed

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
            java.util.logging.Logger.getLogger(ManagerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        Configuration_Handler config = new Configuration_Handler();
        String Results_path = config.Results_path;
        String Players_path = config.Players_path;
        System.out.println(Results_path + " and " + Players_path);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField First_Name;
    private javax.swing.JTextField Gamertag;
    private javax.swing.JTextField Last_Name;
    private javax.swing.JTextField Player_ID;
    private javax.swing.JTextField Retro_Points;
    private javax.swing.JButton add_button;
    private javax.swing.JTextField adjust_points;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton search_button;
    private javax.swing.JButton subtract_button;
    // End of variables declaration//GEN-END:variables

}
