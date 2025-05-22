/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authentication;

import admin.adminDashboard;
import config.PasswordHasher;
import config.Session;
import config.connectDB;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import users.usersDashboard;

/**
 *
 * @author ADMIN
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public login() {
        initComponents();
    }

   static String status;
    
public static boolean loginnAcc(String username, String password) throws NoSuchAlgorithmException {
    connectDB connector = new connectDB();
    try {
        String query = "SELECT u_id, firstname, lastname, username, email, usertype, status, password FROM users WHERE username = ?";
        PreparedStatement pstmt = connector.getConnection().prepareStatement(query);
        pstmt.setString(1, username); // Only set username
        ResultSet resultSet = pstmt.executeQuery();

        if (resultSet.next()) {
            String hashedPass = resultSet.getString("password"); // Get stored hashed password
            String rehashedPass = PasswordHasher.hashPassword(password); // Hash the entered password

            if (hashedPass.equals(rehashedPass)) {
                status = resultSet.getString("status");

                Session sess = Session.getInstance();
                sess.setId(resultSet.getString("u_id"));
                sess.setFirstname(resultSet.getString("firstname"));
                sess.setLastname(resultSet.getString("lastname"));
                sess.setUsername(resultSet.getString("username"));
                sess.setEmail(resultSet.getString("email"));
                sess.setUsertype(resultSet.getString("usertype"));
                sess.setStatus(status);

                return true; // Login successful
            } else {
                JOptionPane.showMessageDialog(null, "Invalid password. Please try again.");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username. Please try again.");
            return false;
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        return false;
    } finally {
        connector.closeConnection(); 
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        login = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 255));
        jLabel1.setText("Register");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 410, -1, -1));

        username.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel2.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 250, 40));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 255));
        jLabel2.setText("BITE");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 80, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("______________ or _____________");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 390, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/download__2_-removebg-preview (1).png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 170, 310, 190));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("forgot password");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 300, -1, -1));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("User Name:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, -1, -1));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Password:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, -1, -1));

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Dont' have an account? Click");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, -1, -1));

        login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login_fft-removebg-preview_2.png"))); // NOI18N
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginMouseClicked(evt);
            }
        });
        jPanel2.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, 190, 40));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Welcome back");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, -1, -1));

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("QUICK");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 100, -1));
        jPanel2.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 250, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 490));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
      new register().setVisible(true); this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseClicked
         String user = username.getText();
        String pass = new String(password.getPassword());

    if (user.isEmpty() || pass.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please fill in both username and password fields.");
    } else {
    try {
        if (loginnAcc(user, pass)) {
            Session sess = Session.getInstance();
            String status = sess.getStatus();
            
            if (!"Active".equalsIgnoreCase(status)) {
                JOptionPane.showMessageDialog(null, "IN-ACTIVE ACCOUNT, CONTACT THE ADMIN");
            } else {
                String userType = sess.getUsertype().trim(); // Trim to remove spaces
                JOptionPane.showMessageDialog(null, "LOG IN SUCCESSFULLY");

                if (userType.equalsIgnoreCase("Admin")) {
                    adminDashboard ad = new adminDashboard();
                    ad.setVisible(true);
                    this.dispose();
                } else if (userType.equalsIgnoreCase("User")) {
                    usersDashboard rc = new usersDashboard();
                    rc.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Unknown user type: " + userType + ". Contact the admin.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "INVALID ACCOUNT");
        }
    } catch (NoSuchAlgorithmException ex) {
        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
    }
}
       
    }//GEN-LAST:event_loginMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
      new forgotpassword().setVisible(true); this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel login;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
