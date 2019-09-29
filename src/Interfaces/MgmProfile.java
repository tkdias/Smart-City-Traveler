/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DB.DB;
import Email.SendEmail;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author T.K.Dias
 */
public class MgmProfile extends javax.swing.JFrame {

    /**
     * Creates new form Add
     */
    public MgmProfile() {
        initComponents();
        Search();
        time();
    }

//===============================================================(Time & Date)==
    public void time() {

        try {

            new Thread(new Runnable() {
                @Override
                public void run() {

                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    while (true) {

                        Date d = new Date();
                        String date = d.toString();
                        String arr[] = date.split(" ");
                        String newdate = arr[5] + "-" + arr[1] + "-" + arr[2];
                        jLabel4.setText(newdate);
                        jLabel5.setText(arr[3]);
                    }

                }
            }).start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//==============================================================================
    
//==================================================================Clearall()==
    public void Clearall() {

        txt_FN.setText("");
        txt_LN.setText("");
        txt_UN.setText("");
        txt_Email.setText("");
        jPasswordField_PASS.setText("");
        jPasswordField_REPASS.setText("");
        txt_FN.setText("");
        txt_Phn.setText("");
        jDateChooser_BDATE.setCalendar(null);
        txt_ADDRESS.setText("");

    }
//==============================================================================
//====================================================================Search()==
    public void Search() {
        try {
            
            System.out.println(txtBox.getText());

            Connection c = DB.mycon();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM users WHERE username ='" + txtBox.getText() + "'");

            SimpleDateFormat DDate = new SimpleDateFormat("yyyy-MM-dd");

            while (rs.next()) {
                
                txt_FN.setText(rs.getString("first_name"));
                txt_LN.setText(rs.getString("last_name"));
                txt_UN.setText(rs.getString("username"));
                txt_Email.setText(rs.getString("email"));
                jPasswordField_PASS.setText(rs.getString("password"));
                jPasswordField_REPASS.setText(rs.getString("password"));
                txt_Phn.setText(rs.getString("phone"));
                jDateChooser_BDATE.setDate(DDate.parse(rs.getString("dob")));
                txt_ADDRESS.setText(rs.getString("address"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//==============================================================================
//====================================================================Update()==
    public void Update() {

        try {


            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            String jDate = sdf.format(jDateChooser_BDATE.getDate());

            //show confirm msg box
            int x = JOptionPane.showConfirmDialog(rootPane, "Do you want to Update this Record ? ");

            if (x == 0) {

                Connection c = DB.mycon();
                Statement s = c.createStatement();
                s.executeUpdate("UPDATE users SET first_name = '" + txt_FN.getText() + "',last_name = '" + txt_LN.getText() + "',email = '" + txt_Email.getText() + "',password = '" + jPasswordField_PASS.getText() + "', phone = '" + txt_Phn.getText() + "', dob = '" + jDate + "', address = '" + txt_ADDRESS.getText() + "' where username = '" + txt_UN.getText() + "' ");
                JOptionPane.showMessageDialog(rootPane, "record has been Updated successfully ");

                Clearall();

            } else if (x == 1) {
                Clearall();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//==============================================================================

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtBox = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txt_FN = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_LN = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_UN = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_Email = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPasswordField_PASS = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        jPasswordField_REPASS = new javax.swing.JPasswordField();
        jLabel14 = new javax.swing.JLabel();
        txt_Phn = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jDateChooser_BDATE = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        btnUpdate1 = new javax.swing.JButton();
        txt_ADDRESS = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Home");
        setBackground(new java.awt.Color(255, 204, 51));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Profile Management");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 290, 30));

        txtBox.setBackground(new java.awt.Color(255, 255, 255));
        txtBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtBox.setForeground(new java.awt.Color(255, 255, 255));
        txtBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(txtBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 100, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 140, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 140, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 600, 90));

        jPanel2.setBackground(new java.awt.Color(255, 204, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnUpdate.setBackground(new java.awt.Color(153, 153, 153));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdate.setText("Update Profile");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel2.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 450, 38));

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("First Name:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 92, -1));

        txt_FN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(txt_FN, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 160, -1));

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Last Name:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 92, -1));

        txt_LN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(txt_LN, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 160, -1));

        jLabel9.setBackground(new java.awt.Color(204, 204, 204));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Username:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 90, -1));

        txt_UN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(txt_UN, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 160, -1));

        jLabel13.setBackground(new java.awt.Color(204, 204, 204));
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Email:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, -1, -1));

        txt_Email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(txt_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 160, -1));

        jLabel10.setBackground(new java.awt.Color(204, 204, 204));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Password:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jPasswordField_PASS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(jPasswordField_PASS, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 160, -1));

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Re-Password:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, -1, -1));

        jPasswordField_REPASS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(jPasswordField_REPASS, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 160, -1));

        jLabel14.setBackground(new java.awt.Color(204, 204, 204));
        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Phone:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 60, -1));

        txt_Phn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(txt_Phn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 160, -1));

        jLabel12.setBackground(new java.awt.Color(204, 204, 204));
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("BirthDate:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, -1, -1));

        jDateChooser_BDATE.setBackground(new java.awt.Color(255, 204, 51));
        jPanel2.add(jDateChooser_BDATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 180, 30));

        jLabel15.setBackground(new java.awt.Color(204, 204, 204));
        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Address:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        btnUpdate1.setBackground(new java.awt.Color(153, 153, 153));
        btnUpdate1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdate1.setText("Load Profile Details");
        btnUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnUpdate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 450, 38));

        txt_ADDRESS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(txt_ADDRESS, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 160, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 450));

        setSize(new java.awt.Dimension(633, 476));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate1ActionPerformed
        Search();
    }//GEN-LAST:event_btnUpdate1ActionPerformed

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
            java.util.logging.Logger.getLogger(MgmProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MgmProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MgmProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MgmProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MgmProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdate1;
    private com.toedter.calendar.JDateChooser jDateChooser_BDATE;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField_PASS;
    private javax.swing.JPasswordField jPasswordField_REPASS;
    private javax.swing.JPopupMenu jPopupMenu1;
    public static javax.swing.JLabel txtBox;
    private javax.swing.JTextField txt_ADDRESS;
    private javax.swing.JTextField txt_Email;
    private javax.swing.JTextField txt_FN;
    private javax.swing.JTextField txt_LN;
    private javax.swing.JTextField txt_Phn;
    private javax.swing.JTextField txt_UN;
    // End of variables declaration//GEN-END:variables
}
