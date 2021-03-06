/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws5;
import java.net.*;
import javax.swing.*;
import java.io.*;

/**
 *
 * @author Stagit
 */
public class ClientChatter extends javax.swing.JFrame {
    Socket mngSocket = null;
    String mngIP = "";
    int mngPort = 0;
    String staffName = "";
    BufferedReader br = null;
    DataOutputStream os = null;
    /**
     * Creates new form ClientChatter
     */
    public ClientChatter() {
        initComponents();
        this.setSize(600, 450);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbStaff = new javax.swing.JLabel();
        txtStaff = new javax.swing.JTextField();
        lbIP = new javax.swing.JLabel();
        txtIP = new javax.swing.JTextField();
        lbPort = new javax.swing.JLabel();
        txtPort = new javax.swing.JTextField();
        btnConnect = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Staff and Server Info"));
        jPanel1.setPreferredSize(new java.awt.Dimension(533, 75));

        lbStaff.setText("Staff:");

        txtStaff.setText("Ly Tan Loi");

        lbIP.setText("Mang IP:");

        txtIP.setText("127.0.10.5");
        txtIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIPActionPerformed(evt);
            }
        });

        lbPort.setText("Port:");

        txtPort.setText("12340");

        btnConnect.setText("Connect");
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbStaff)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(lbIP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(lbPort)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(btnConnect)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbIP)
                        .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbPort)
                        .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnConnect))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbStaff)
                        .addComponent(txtStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 29, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
        // TODO add your handling code here:
        mngIP = txtIP.getText();
        mngPort = Integer.parseInt(txtPort.getText());
        staffName = this.txtStaff.getText();
        try {
            mngSocket = new Socket(mngIP, mngPort);
            if(mngSocket != null) {
                ChatPanel p = new ChatPanel(mngSocket, staffName, "Manager");
                this.add(p);
                p.getTxtMessages().append("Manager is running");
                p.updateUI();

                br = new BufferedReader(new InputStreamReader(mngSocket.getInputStream()));
                os = new DataOutputStream(mngSocket.getOutputStream());

                os.writeBytes("Staff: "+staffName);
                os.write(13); os.write(10);
                os.flush();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Manager is not running");
            System.exit(0);
        }
    }//GEN-LAST:event_btnConnectActionPerformed

    private void txtIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIPActionPerformed

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
            java.util.logging.Logger.getLogger(ClientChatter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientChatter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientChatter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientChatter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientChatter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnect;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbIP;
    private javax.swing.JLabel lbPort;
    private javax.swing.JLabel lbStaff;
    private javax.swing.JTextField txtIP;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextField txtStaff;
    // End of variables declaration//GEN-END:variables
}
