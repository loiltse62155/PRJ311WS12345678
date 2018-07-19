/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import org.jvnet.substance.skin.SubstanceChallengerDeepLookAndFeel;

import se1069.BasicValidator;

/**
 *
 * @author Ly Tan loi
 */
public class DepartmentManagement extends javax.swing.JFrame {
    
    String filename = "employee.txt";
    DefaultMutableTreeNode root = null;
    DefaultMutableTreeNode curDepNode = null;
    DefaultMutableTreeNode curEmpNode = null;
    boolean addNewDep = false;
    boolean addNewEmp = false;

    /**
     * Creates new form Department
     */
    public DepartmentManagement() {
        initComponents();
        root = (DefaultMutableTreeNode) (this.tree.getModel().getRoot());
        loadData();
        
        TreePath path = new TreePath(root);
        tree.expandPath(path);
    }
    
    public void loadData() {
        String s = "";
        StringTokenizer stk;
        try {
            FileReader f = new FileReader(filename);
            BufferedReader bf = new BufferedReader(f);
            while ((s = bf.readLine()) != null) {
                s = s.trim();
                boolean isDept = (s.charAt(s.length() - 1) == ':');
                stk = new StringTokenizer(s, "-:,");
                String code = stk.nextToken().trim();
                String name = stk.nextToken().trim();
                if (isDept) {
                    curDepNode = new DefaultMutableTreeNode(new Department(code, name));
                    root.add(curDepNode);
                } else {
                    int salary = Integer.parseInt(stk.nextToken().trim());
                    curEmpNode = new DefaultMutableTreeNode(new Employee(code, name, salary));
                    curDepNode.add(curEmpNode);
                }
            }
            bf.close();
            f.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void viewDeptAndEmp() {
        Department curDep = null;
        Employee curEmp = null;
        if (curDepNode != null) {
            curDep = (Department) (curDepNode.getUserObject());
        }
        if (curEmpNode != null) {
            curEmp = (Employee) (curEmpNode.getUserObject());
        }
        this.txtDepCode.setText(curDep != null ? curDep.getDepCode() : "");
        this.txtDepName.setText(curDep != null ? curDep.getDepName() : "");
        this.txtEmpCode.setText(curEmp != null ? curEmp.getEmpCode() : "");
        this.txtEmpName.setText(curEmp != null ? curEmp.getEmpName() : "");
        this.txtSalary.setText("" + (curEmp != null ? curEmp.getSalary() : ""));
        this.txtDepCode.setEditable(false);
        this.txtEmpCode.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tree = new javax.swing.JTree();
        pDep = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnDepNew = new javax.swing.JButton();
        btnDepRemove = new javax.swing.JButton();
        btnDepSave = new javax.swing.JButton();
        txtDepCode = new javax.swing.JTextField();
        txtDepName = new javax.swing.JTextField();
        pEmp = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnEmpNew = new javax.swing.JButton();
        btnEmpRemove = new javax.swing.JButton();
        btnEmpSave = new javax.swing.JButton();
        txtEmpCode = new javax.swing.JTextField();
        txtEmpName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSalary = new javax.swing.JTextField();
        btnSaveFile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Department");
        tree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        tree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                treeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tree);

        pDep.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Department Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), java.awt.Color.blue)); // NOI18N

        jLabel1.setText("Dept.Code:");

        jLabel2.setText("Dept.Name:");

        btnDepNew.setText("New");
        btnDepNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepNewActionPerformed(evt);
            }
        });

        btnDepRemove.setText("Remove");
        btnDepRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepRemoveActionPerformed(evt);
            }
        });

        btnDepSave.setText("Save");
        btnDepSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pDepLayout = new javax.swing.GroupLayout(pDep);
        pDep.setLayout(pDepLayout);
        pDepLayout.setHorizontalGroup(
            pDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDepLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pDepLayout.createSequentialGroup()
                        .addGroup(pDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pDepLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDepCode, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pDepLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtDepName, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(37, Short.MAX_VALUE))
                    .addGroup(pDepLayout.createSequentialGroup()
                        .addComponent(btnDepNew, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(btnDepRemove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDepSave, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
        );
        pDepLayout.setVerticalGroup(
            pDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDepLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDepCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(pDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDepName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(pDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDepNew)
                    .addComponent(btnDepRemove)
                    .addComponent(btnDepSave))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pEmp.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Employee Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), java.awt.Color.blue)); // NOI18N

        jLabel3.setText("Emp.Code:");

        jLabel4.setText("Emp.Name:");

        btnEmpNew.setText("New");
        btnEmpNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpNewActionPerformed(evt);
            }
        });

        btnEmpRemove.setText("Remove");
        btnEmpRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpRemoveActionPerformed(evt);
            }
        });

        btnEmpSave.setText("Save");
        btnEmpSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpSaveActionPerformed(evt);
            }
        });

        jLabel5.setText("Salary:");

        javax.swing.GroupLayout pEmpLayout = new javax.swing.GroupLayout(pEmp);
        pEmp.setLayout(pEmpLayout);
        pEmpLayout.setHorizontalGroup(
            pEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pEmpLayout.createSequentialGroup()
                .addGroup(pEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pEmpLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnEmpNew, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(btnEmpRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEmpSave, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pEmpLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pEmpLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtEmpName, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))
                            .addGroup(pEmpLayout.createSequentialGroup()
                                .addGroup(pEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pEmpLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(39, 39, 39)
                                        .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pEmpLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtEmpCode, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(29, 29, 29))
        );
        pEmpLayout.setVerticalGroup(
            pEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEmpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEmpCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(pEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(pEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEmpNew)
                    .addComponent(btnEmpRemove)
                    .addComponent(btnEmpSave))
                .addContainerGap())
        );

        btnSaveFile.setText("Save To File");
        btnSaveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pEmp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pDep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSaveFile)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDepNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepNewActionPerformed
        this.addNewDep = true;
        this.txtDepCode.setText("");
        this.txtDepName.setText("");
        this.txtEmpCode.setText("");
        this.txtEmpName.setText("");
        this.txtSalary.setText("");
        this.txtDepCode.setEditable(true);
        this.txtDepCode.requestFocus();
    }//GEN-LAST:event_btnDepNewActionPerformed

    private void btnDepRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepRemoveActionPerformed
        if (this.curDepNode.getChildCount() > 0) {
            String msg = "Remove all employee before deleting a department.";
            JOptionPane.showConfirmDialog(this, msg);
        } else {
            int response = JOptionPane.showConfirmDialog(this, "Delete this department - OK?");
            if (response == JOptionPane.OK_OPTION) {
                root.remove(this.curDepNode);
                tree.updateUI();
            }
        }
    }//GEN-LAST:event_btnDepRemoveActionPerformed

    private void btnDepSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepSaveActionPerformed
        String code = this.txtDepCode.getText().trim().toUpperCase();
        txtDepCode.setText(code);
        String name = this.txtDepName.getText().trim();
        txtDepName.setText(name);
        if (!BasicValidator.validateCode(code, "[A-Z]{2}")) {
            JOptionPane.showConfirmDialog(this, "The code isn't suitable(XX)!");
        } else {
            if (addNewDep == true) {
                Department newDep = new Department(code, name);
                root.add(new DefaultMutableTreeNode(newDep));
            } else {
                ((Department) curDepNode.getUserObject()).setDepName(name);
            }
            this.tree.updateUI();
            this.addNewDep = false;
        }

    }//GEN-LAST:event_btnDepSaveActionPerformed

    private void btnEmpNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpNewActionPerformed
        this.addNewEmp = true;
        this.txtEmpCode.setText("");
        this.txtEmpName.setText("");
        this.txtSalary.setText("");
        this.txtEmpCode.setEditable(true);
        this.txtEmpCode.requestFocus();
    }//GEN-LAST:event_btnEmpNewActionPerformed

    private void btnEmpRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpRemoveActionPerformed
        if (this.curEmpNode != null) {
            int response = JOptionPane.showConfirmDialog(this, "Delete this employee- OK?");
            if (response == JOptionPane.OK_OPTION) {
                curDepNode.remove(this.curEmpNode);
                tree.updateUI();
            }
        }
    }//GEN-LAST:event_btnEmpRemoveActionPerformed

    private void btnEmpSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpSaveActionPerformed
        try {
//            if (curDepNode == null){
//                JOptionPane.showConfirmDialog(this, "Invalid");
//            }
            String code = this.txtEmpCode.getText().trim().toUpperCase();
            txtEmpCode.setText(code);
            String name = this.txtEmpName.getText().trim();
            txtEmpName.setText(name);
            String salaryStr = this.txtSalary.getText().trim();
            txtSalary.setText(salaryStr);
            int sal = Integer.parseInt(salaryStr);
            
            if (!BasicValidator.validateCode(code, "E[0-9]{3}") || !BasicValidator.validateName(name) || !BasicValidator.validateSalary(sal)) {
                JOptionPane.showConfirmDialog(this, "Please check your info(Code:EXXX, Name >= 5, Salary > 1)");
                
            } else {
                if (addNewEmp == true) {
                    Employee newEmp = new Employee(code, name, sal);
                    curDepNode.add(new DefaultMutableTreeNode(newEmp));
                    
                } else {
                    Employee emp = (Employee) (curEmpNode.getUserObject());
                    emp.setEmpName(name);
                    emp.setSalary(sal);
                }
                this.tree.updateUI();
                this.addNewEmp = false;
            }
        } catch (Exception e) {
           // e.printStackTrace();
           JOptionPane.showConfirmDialog(this, "Please choose department");
        }
        
    }//GEN-LAST:event_btnEmpSaveActionPerformed

    private void btnSaveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveFileActionPerformed
        if (root.getChildCount() == 0) {
            return;
        }
        String S;
        try {
            FileWriter f = new FileWriter(filename);
            PrintWriter pf = new PrintWriter(f);
            Enumeration depts = root.children();
            while (depts.hasMoreElements()) {
                DefaultMutableTreeNode depNode = (DefaultMutableTreeNode) depts.nextElement();
                Department dept = (Department) (depNode.getUserObject());
                S = dept.getDepCode() + "-" + dept.getDepName() + ":";
                pf.println(S);
                Enumeration emps = depNode.children();
                while (emps.hasMoreElements()) {
                    DefaultMutableTreeNode empNode = (DefaultMutableTreeNode) emps.nextElement();
                    Employee emp = (Employee) (empNode.getUserObject());
                    S = emp.getEmpCode() + "," + emp.getEmpName() + "," + emp.getSalary();
                    pf.println(S);
                }
            }
            pf.close();
            f.close();
            JOptionPane.showConfirmDialog(this, "Data are saved to the file " + filename);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(this, e);
        }
    }//GEN-LAST:event_btnSaveFileActionPerformed

    private void treeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_treeMouseClicked
        tree.cancelEditing();
        TreePath path = tree.getSelectionPath();
        if (path == null) {
            return;
        }
        DefaultMutableTreeNode selectedNode = null;
        selectedNode = (DefaultMutableTreeNode) (path.getLastPathComponent());
        Object selectedObj = selectedNode.getUserObject();
        if (selectedNode == root) {
            this.curDepNode = this.curDepNode = null;
        } else if (selectedObj instanceof Department) {
            this.curDepNode = selectedNode;
            this.curEmpNode = null;
            
        } else if (selectedObj instanceof Employee) {
            curEmpNode = selectedNode;
            curDepNode = (DefaultMutableTreeNode) (selectedNode.getParent());
        }
        viewDeptAndEmp();
    }//GEN-LAST:event_treeMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(DepartmentManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DepartmentManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DepartmentManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DepartmentManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>
        //</editor-fold>

        try {
            setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel(new SubstanceChallengerDeepLookAndFeel());
        } catch (Exception e) {
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DepartmentManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDepNew;
    private javax.swing.JButton btnDepRemove;
    private javax.swing.JButton btnDepSave;
    private javax.swing.JButton btnEmpNew;
    private javax.swing.JButton btnEmpRemove;
    private javax.swing.JButton btnEmpSave;
    private javax.swing.JButton btnSaveFile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pDep;
    private javax.swing.JPanel pEmp;
    private javax.swing.JTree tree;
    private javax.swing.JTextField txtDepCode;
    private javax.swing.JTextField txtDepName;
    private javax.swing.JTextField txtEmpCode;
    private javax.swing.JTextField txtEmpName;
    private javax.swing.JTextField txtSalary;
    // End of variables declaration//GEN-END:variables
}
