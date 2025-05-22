/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.connectDB;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ADMIN
 */
public class sales extends javax.swing.JFrame {

    /**
     * Creates new form user
     */
    public sales() {
        initComponents();
         displayData();
    }

    public void displayData(){
       connectDB dbc = new connectDB();
    ResultSet rs = null;

    try {
        rs = dbc.getData("SELECT * FROM sales");

        // Ensure the ResultSet is not null
        if (rs != null) {
            salesTable.setModel(DbUtils.resultSetToTableModel(rs));
        } else {
            System.out.println("No data returned from the database.");
        }
    } catch (SQLException ex) {
        System.err.println("Error while fetching user data: " + ex.getMessage());
        ex.printStackTrace();
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (dbc.getConnection() != null) {
                dbc.getConnection().close();
            }
        } catch (SQLException ex) {
            System.err.println("Error closing database resources: " + ex.getMessage());
        }
    }
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        salesTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        sales = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        user = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        food = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        profile = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 255));
        jLabel2.setText("Dashboard");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 120, -1));

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Sales");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 40));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        salesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(salesTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 480, 460));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sales.setBackground(new java.awt.Color(51, 51, 51));
        sales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                salesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                salesMouseExited(evt);
            }
        });
        sales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Delete");
        sales.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-delete-user-male-50.png"))); // NOI18N
        sales.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 50));

        jPanel2.add(sales, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 210, 50));

        user.setBackground(new java.awt.Color(51, 51, 51));
        user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userMouseExited(evt);
            }
        });
        user.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-add-administrator-50.png"))); // NOI18N
        user.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 60));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Add");
        user.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, 30));

        jPanel2.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 210, 60));

        food.setBackground(new java.awt.Color(51, 51, 51));
        food.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                foodMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                foodMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                foodMouseExited(evt);
            }
        });
        food.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Edit ");
        food.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-edit-profile-32.png"))); // NOI18N
        food.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 60, 50));

        jPanel2.add(food, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 210, 50));

        profile.setBackground(new java.awt.Color(51, 51, 51));
        profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profileMouseExited(evt);
            }
        });
        profile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Back");
        profile.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-back-button-50.png"))); // NOI18N
        profile.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jPanel2.add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 210, 50));

        id.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setText("ID");
        jPanel2.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 20, -1));

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Current ID:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 90, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, 460));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void salesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesMouseEntered
        sales.setBackground(new Color(153,153,255));
    }//GEN-LAST:event_salesMouseEntered

    private void salesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesMouseExited
        sales.setBackground(new Color (51,51,51));
    }//GEN-LAST:event_salesMouseExited

    private void userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseClicked
        new addSale().setVisible(true); this.dispose();
    }//GEN-LAST:event_userMouseClicked

    private void userMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseEntered
        user.setBackground(new Color (153,153,255));
    }//GEN-LAST:event_userMouseEntered

    private void userMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseExited
        user.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_userMouseExited

    private void foodMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_foodMouseEntered
        food.setBackground(new Color (153, 153, 255));
    }//GEN-LAST:event_foodMouseEntered

    private void foodMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_foodMouseExited
        food.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_foodMouseExited

    private void profileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileMouseEntered
        profile.setBackground(new Color (153,153,255));
    }//GEN-LAST:event_profileMouseEntered

    private void profileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileMouseExited
        profile.setBackground(new Color (51, 51 ,51));
    }//GEN-LAST:event_profileMouseExited

    private void profileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileMouseClicked
     new adminDashboard().setVisible(true); this.dispose();
    }//GEN-LAST:event_profileMouseClicked

    private void foodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_foodMouseClicked
         int rowIndex = salesTable.getSelectedRow();

    if (rowIndex < 0) {
        JOptionPane.showMessageDialog(null, "Please Select An Item!");
    } else {
        addUser a = new addUser();
        try {
      connectDB cdb = new connectDB();
        TableModel tbl = salesTable.getModel();
        
        String userId = tbl.getValueAt(rowIndex, 0).toString();
        
        ResultSet rs = cdb.getData("SELECT * FROM sales WHERE s_id = '" + userId + "'");
        
        if (rs.next()) {
            a.uid.setText(rs.getString("u_id")); 
            a.firstname.setText(rs.getString("firstname"));
            a.lastname.setText(rs.getString("lastname"));
            a.username.setText(rs.getString("username"));
            a.email.setText(rs.getString("email"));
            a.password.setText(rs.getString("password"));
            
            String userStatus = rs.getString("status");
            String userType = rs.getString("usertype");
            
            a.status.setSelectedItem(userStatus != null ? userStatus : ""); 
            a.usertype.setSelectedItem(userType != null ? userType : "");

            a.add.setEnabled(false);
            a.update.setEnabled(true);
            a.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "User data not found!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
    }//GEN-LAST:event_foodMouseClicked

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
            java.util.logging.Logger.getLogger(sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel food;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel profile;
    private javax.swing.JPanel sales;
    private javax.swing.JTable salesTable;
    private javax.swing.JPanel user;
    // End of variables declaration//GEN-END:variables
}
