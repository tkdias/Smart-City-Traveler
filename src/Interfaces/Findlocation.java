/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DB.DB;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Jithmal
 */
public class Findlocation extends javax.swing.JFrame {

    /**
     * Creates new form Add
     */
    public Findlocation() {
        initComponents();
        time();
        cmbLoad();
        //tblLoad();
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
//===================================================================cmbLoad()== 
    private void cmbLoad() {

        try {
            Connection c = DB.mycon();
            Statement s = c.createStatement();
            ResultSet rs1 = s.executeQuery("SELECT * FROM province");

            Vector v1 = new Vector();
            v1.add("Select Province");
            while (rs1.next()) {
                v1.add(rs1.getString("Province_Name"));
            }
            cmbProvince.setModel(new DefaultComboBoxModel(v1));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//==============================================================================  
//===================================================================cmbLoad()== 
    private void cmb2Load() {

        try {
            Connection c = DB.mycon();
            Statement s = c.createStatement();
            ResultSet rs1 = s.executeQuery("SELECT * FROM district where Province_Name = '" + cmbProvince.getSelectedItem() + "'");

            Vector v1 = new Vector();
            v1.add("Select District");
            while (rs1.next()) {
                v1.add(rs1.getString("District_Name"));
            }
            cmbDistrict.setModel(new DefaultComboBoxModel(v1));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//==============================================================================  
//==================================================================Clearall()==
    public void Clearall() {
        cmbProvince.setSelectedIndex(0);
        cmbDistrict.setSelectedIndex(0);
        txtURL.setText("");
    }
//==============================================================================
//===================================================================tblLoad()==

    private void tblLoad() {

        try {
            Connection c = DB.mycon();
            Statement s = c.createStatement();

            ResultSet rs1 = s.executeQuery("SELECT * FROM location WHERE District_Name = '" + cmbDistrict.getSelectedItem() + "'");
            jTable.setModel(DbUtils.resultSetToTableModel(rs1));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//==============================================================================
    public void RowClick() {
        try {

            int row = jTable.getSelectedRow();
            String table_click = (jTable.getModel().getValueAt(row, 0).toString());

            Connection c = DB.mycon();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM location WHERE Location_ID ='" + table_click + "'");

            while (rs.next()) {
                txtURL.setText(rs.getString("Location_URL"));
            }

        } catch (Exception e) {
            e.printStackTrace();
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel2 = new javax.swing.JPanel();
        btnDelete1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtURL = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cmbDistrict = new javax.swing.JComboBox<>();
        cmbProvince = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtBox = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Home");
        setBackground(new java.awt.Color(255, 204, 51));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 204, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDelete1.setBackground(new java.awt.Color(102, 102, 102));
        btnDelete1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete1.setText("Reset");
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnDelete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 180, 39));

        jLabel9.setBackground(new java.awt.Color(204, 204, 204));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Location URL:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 120, -1));

        txtURL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtURL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtURLMouseClicked(evt);
            }
        });
        txtURL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtURLKeyTyped(evt);
            }
        });
        jPanel2.add(txtURL, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 420, 39));

        btnSearch.setBackground(new java.awt.Color(102, 102, 102));
        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel2.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 180, 39));

        jTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable.setInheritsPopupMenu(true);
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 590, 150));

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("District Name:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 120, -1));

        jLabel12.setBackground(new java.awt.Color(204, 204, 204));
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Province Name:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 130, -1));

        cmbDistrict.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        jPanel2.add(cmbDistrict, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 210, 40));

        cmbProvince.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        cmbProvince.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProvinceActionPerformed(evt);
            }
        });
        jPanel2.add(cmbProvince, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 210, 40));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        txtBox.setBackground(new java.awt.Color(255, 255, 255));
        txtBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtBox.setForeground(new java.awt.Color(255, 255, 255));
        txtBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(txtBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 120, 30));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Locations");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 280, 30));

        jButton1.setText("Home");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 120, 30));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Find Tourist Attract");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 280, 30));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 90));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 550));

        setSize(new java.awt.Dimension(634, 493));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        tblLoad();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtURLKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtURLKeyTyped

        try {

            char c = evt.getKeyChar();
            if (Character.isDigit(c)) {
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_txtURLKeyTyped

    private void txtURLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtURLMouseClicked

    }//GEN-LAST:event_txtURLMouseClicked

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        Clearall();
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        RowClick();
    }//GEN-LAST:event_jTableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Main MainMgm = new Main();
        String xx = txtBox.getText();
        Main.txtBox.setText(xx);
        MainMgm.setVisible(true);
        MainMgm.pack();
        MainMgm.setLocationRelativeTo(null);
        MainMgm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbProvinceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProvinceActionPerformed
        cmb2Load();
    }//GEN-LAST:event_cmbProvinceActionPerformed

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
            java.util.logging.Logger.getLogger(Findlocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Findlocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Findlocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Findlocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Findlocation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cmbDistrict;
    private javax.swing.JComboBox<String> cmbProvince;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    public static javax.swing.JLabel txtBox;
    private javax.swing.JTextField txtURL;
    // End of variables declaration//GEN-END:variables
}
