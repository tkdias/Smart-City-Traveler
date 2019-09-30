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
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Jithmal
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Add
     */
    public Home() {
        initComponents();
        time();
        tblLoad();
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
            ResultSet rs = s.executeQuery("SELECT * FROM hometable");

            Vector v = new Vector();
            while (rs.next()) {
                v.add(rs.getString("Gender"));
            }
            cmbGender.setModel(new DefaultComboBoxModel(v));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//==============================================================================    
//==================================================================Clearall()==
    public void Clearall() {

        txtId.setText("");
        txtName.setText("");
        jDateChooser.setCalendar(null);
        jCheckBox1.setSelected(false);
        cmbGender.setSelectedIndex(0);

    }
//==============================================================================
//====================================================================Insert()==

    public void Insert() {

        Boolean CheckBoxx = jCheckBox1.isSelected();

        try {
            //show confirm msg box
            int x = JOptionPane.showConfirmDialog(rootPane, "Do you want to save this Record ? ");

            if (x == 0) {

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                String jDate = sdf.format(jDateChooser.getDate());

                Connection c = DB.mycon();
                Statement s = c.createStatement();
                s.executeUpdate("INSERT INTO hometable (ID,Name,Date,Checkbox,Gender) values('" + txtId.getText() + "','" + txtName.getText() + "','" + jDate + "','" + CheckBoxx + "','" + cmbGender.getSelectedItem() + "')");
                JOptionPane.showMessageDialog(rootPane, "record has been saved successfully");

                Clearall();

            } else if (x == 1) {
                Clearall();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//==============================================================================
//====================================================================Update()==
    public void Update() {

        try {

            Boolean CheckBoxx = jCheckBox1.isSelected();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            String jDate = sdf.format(jDateChooser.getDate());

            //show confirm msg box
            int x = JOptionPane.showConfirmDialog(rootPane, "Do you want to Update this Record ? ");

            if (x == 0) {

                Connection c = DB.mycon();
                Statement s = c.createStatement();
                s.executeUpdate("UPDATE hometable SET Name = '" + txtName.getText() + "',Date = '" + jDate + "',Checkbox = '" + CheckBoxx + "',Gender = '" + cmbGender.getSelectedItem() + "' where ID = '" + txtId.getText() + "' ");
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
//====================================================================Search()==
    public void Search() {
        try {

            Connection c = DB.mycon();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM hometable WHERE ID ='" + txtId.getText() + "'");

            SimpleDateFormat DDate = new SimpleDateFormat("yyyy-MM-dd");

            while (rs.next()) {
                txtName.setText(rs.getString("Name"));
                jDateChooser.setDate(DDate.parse(rs.getString("Date")));
                jCheckBox1.setSelected(rs.getBoolean("Checkbox"));
                cmbGender.setSelectedItem(rs.getString("Gender"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//==============================================================================
//====================================================================Delete()==

    public void Delete() {

        try {

            Connection c = DB.mycon();
            Statement s = c.createStatement();
            s.executeUpdate("DELETE FROM hometable WHERE ID ='" + txtId.getText() + "'");
            JOptionPane.showMessageDialog(rootPane, "record has been not Deleted successfully ");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
//==============================================================================
//===================================================================tblLoad()==

    private void tblLoad() {

        try {
            Connection c = DB.mycon();
            Statement s = c.createStatement();

            ResultSet rs1 = s.executeQuery("SELECT * FROM hometable");
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
            ResultSet rs = s.executeQuery("SELECT * FROM hometable WHERE ID ='" + table_click + "'");

            SimpleDateFormat DDate = new SimpleDateFormat("yyyy-MM-dd");

            while (rs.next()) {
                txtId.setText(rs.getString("ID"));
                txtName.setText(rs.getString("Name"));
                jDateChooser.setDate(DDate.parse(rs.getString("Date")));
                jCheckBox1.setSelected(rs.getBoolean("Checkbox"));
                cmbGender.setSelectedItem(rs.getString("Gender"));
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
        txtId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtBox = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        cmbGender = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        btnDatapass = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnEmail = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Home");
        setBackground(new java.awt.Color(255, 204, 51));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtId.setText("Enter ID");
        txtId.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIdMouseClicked(evt);
            }
        });
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 115, 248, 37));

        txtName.setText("Enter Name");
        txtName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNameMouseClicked(evt);
            }
        });
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameKeyTyped(evt);
            }
        });
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 248, 39));

        jDateChooser.setBackground(new java.awt.Color(255, 204, 51));
        getContentPane().add(jDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 248, 34));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jLabel1.setText("ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 115, 80, 37));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jLabel2.setText("Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 80, -1));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jLabel3.setText("True / False");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 80, 20));

        btnSearch.setBackground(new java.awt.Color(102, 102, 102));
        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 120, 39));

        btnDelete.setBackground(new java.awt.Color(102, 102, 102));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 120, 39));

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

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Sample Codes");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 260, 40));

        txtBox.setBackground(new java.awt.Color(255, 255, 255));
        txtBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtBox.setForeground(new java.awt.Color(255, 255, 255));
        txtBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(txtBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 120, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 600, 90));

        jCheckBox1.setText("CheckBox");
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 90, -1));

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jLabel7.setText("Gender");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 80, 30));

        cmbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Male", "Female" }));
        getContentPane().add(cmbGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 250, 30));

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jLabel8.setText("Date");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 80, 30));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 600, 160));

        btnDatapass.setBackground(new java.awt.Color(102, 102, 102));
        btnDatapass.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDatapass.setText("Data\nPass");
        btnDatapass.setPreferredSize(new java.awt.Dimension(89, 25));
        btnDatapass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatapassActionPerformed(evt);
            }
        });
        getContentPane().add(btnDatapass, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 90, 40));

        jPanel2.setBackground(new java.awt.Color(255, 204, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEmail.setBackground(new java.awt.Color(102, 102, 102));
        btnEmail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEmail.setText("Email");
        btnEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmailActionPerformed(evt);
            }
        });
        jPanel2.add(btnEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 90, 40));

        btnAdd.setBackground(new java.awt.Color(102, 102, 102));
        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel2.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 120, 39));

        btnUpdate.setBackground(new java.awt.Color(102, 102, 102));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel2.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 120, 39));

        btnDelete1.setBackground(new java.awt.Color(102, 102, 102));
        btnDelete1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete1.setText("Reset");
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnDelete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 120, 39));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 550));

        setSize(new java.awt.Dimension(634, 564));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Insert();
        tblLoad();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        Search();
        tblLoad();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        Update();
        tblLoad();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        Delete();
        tblLoad();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped

        try {

            char c = evt.getKeyChar();
            if (!Character.isDigit(c)) {
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_txtIdKeyTyped

    private void txtNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyTyped

        try {

            char c = evt.getKeyChar();
            if (Character.isDigit(c)) {
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_txtNameKeyTyped

    private void txtIdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIdMouseClicked
        txtId.setText("");
    }//GEN-LAST:event_txtIdMouseClicked

    private void txtNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNameMouseClicked
        txtName.setText("");
    }//GEN-LAST:event_txtNameMouseClicked

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        Clearall();
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void txtIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyReleased
        Search();
    }//GEN-LAST:event_txtIdKeyReleased

    private void btnDatapassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatapassActionPerformed
        DataPass ps = new DataPass();

        String xx = txtBox.getText();
        ps.jTextField1.setText(xx);

        ps.setVisible(true);
    }//GEN-LAST:event_btnDatapassActionPerformed

    private void btnEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmailActionPerformed

        SendEmail s = new SendEmail();
        s.send2();
    }//GEN-LAST:event_btnEmailActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        RowClick();
    }//GEN-LAST:event_jTableMouseClicked

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDatapass;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnEmail;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbGender;
    private javax.swing.JCheckBox jCheckBox1;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    public javax.swing.JLabel txtBox;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
