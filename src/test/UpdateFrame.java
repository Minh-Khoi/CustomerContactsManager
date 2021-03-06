/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.swing.*;
import java.util.*;
import java.util.function.ObjDoubleConsumer;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;
import model.dao.*;
import model.dto.*;
/**
 *
 * @author KHOI
 */
public class UpdateFrame extends javax.swing.JFrame {
    private String cusName;
    /**
     * Creates new form UpdateFrame
     */
    public UpdateFrame(String customerName) {
        cusName=customerName;
        initComponents();
        this.setSize(690, 612);
        this.setLocationRelativeTo(null);
        jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Update Contact of "+ customerName , javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, 
                                                                                                        javax.swing.border.TitledBorder.DEFAULT_POSITION, 
                                                                                                        new java.awt.Font("Arial", 1, 18), 
                                                                                                        new java.awt.Color(0, 51, 51)));
        setDatas();
    }
    /**
     * find the Customer whose has the name 
     * @param name
     * @return a Customers
     */
    private Customers readCustomerByName(String name) {
        CustomersDAO cusDAO = new CustomersDAO();
        List<Customers> cusList=cusDAO.readAll();
        if(cusList.size()>0){
            for(Customers cus :cusList){
                if(cus.getCustomerName().equalsIgnoreCase(name)) return cus;
            }
        }
        return null;
    }
    /**
     * Set a Vector<Object> in order to set data for phoneNUmbersTable. With this params as a column of row.
     * @param phoneID
     * @param customerID
     * @param phoneNumber
     * @return a Vector<Object>
     */
    private Vector<Object> datasForPhonesTable(int phoneID, int customerID, String phoneNumber){
        Object[] datasArray = {phoneID, customerID,phoneNumber};
        return new Vector<>(Arrays.asList(datasArray));
    }
    /**
     * Set a Vector<Object> in order to set data for emailsTable. With this params as a column of row.
     * @param emailID
     * @param customerID
     * @param email
     * @return a Vector<Object>
     */
    private Vector<Object> datasForEmailsTable(int emailID, int customerID, String email){
        Object[] datasArray = {emailID, customerID,email};
        return new Vector<>(Arrays.asList(datasArray));
    }
    /**
     * Set Datas for addressField, phoneNumbersTable, and emailsTable
     */
    private void setDatas(){
        CustomersDAO customersDAO = new CustomersDAO();
        PhoneNumbersDAO phoneDAO = new PhoneNumbersDAO();
        EmailDAO emailDAO = new EmailDAO();
        // Set data for customer Address
        String address = readCustomerByName(cusName).getAddress();
        addressField.setText(address);
        // Set datas for Phone Table
        Vector<Vector<Object>> datasPhone = new Vector<Vector<Object>>();
        List<PhoneNumbers> phoneNumbersList = phoneDAO.readByCustomerID(readCustomerByName(cusName).getCustomerID());
        for(PhoneNumbers phone : phoneNumbersList){
            int phoneID= phone.getPhoneID(), customerID=phone.getCustomerID();
            String phoneNumber = phone.getPhoneNumber();
            datasPhone.add(datasForPhonesTable(phoneID, customerID, phoneNumber));
        }
        Object[] columnNameForPhoneTable = {"Phone ID", "Customer ID", "Phone Number"};
        phoneNumbersTable = new JTable(datasPhone, new Vector(Arrays.asList(columnNameForPhoneTable)));
        jScrollPane1.setViewportView(phoneNumbersTable);
        // Set datas for Email Table
        Vector<Vector<Object>> datasEmail = new Vector<Vector<Object>>();
        List<Emails> emailsList = emailDAO.readByCustomerID(readCustomerByName(cusName).getCustomerID());
        for(Emails em : emailsList){
            int emID= em.getEmail_ID(), customerID= em.getCustomerID();
            String email = em.getEmail();
            datasEmail.add(datasForEmailsTable(emID, customerID, email));
        }
        Object[] columnNameForEmailsTable = {"Email ID", "Customer ID", "Email"};
        emailsTable = new JTable(datasEmail, new Vector(Arrays.asList(columnNameForEmailsTable)));
        jScrollPane2.setViewportView(emailsTable);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        phoneNumbersTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        emailsTable = new javax.swing.JTable();
        addressField = new javax.swing.JTextField();
        buttonSubmit = new javax.swing.JButton();
        phoneNumbersField = new javax.swing.JTextField();
        emailsField = new javax.swing.JTextField();
        deletePhoneButton = new javax.swing.JButton();
        deleteEmailButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Update Contact", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 24), new java.awt.Color(0, 51, 51))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Address");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Phone Numbers");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Emails");

        phoneNumbersTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(phoneNumbersTable);

        emailsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(emailsTable);

        addressField.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        buttonSubmit.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        buttonSubmit.setText("Submit");
        buttonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSubmitActionPerformed(evt);
            }
        });

        phoneNumbersField.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        emailsField.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        deletePhoneButton.setText("Delete");
        deletePhoneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePhoneButtonActionPerformed(evt);
            }
        });

        deleteEmailButton.setForeground(new java.awt.Color(51, 0, 51));
        deleteEmailButton.setText("Delete");
        deleteEmailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEmailButtonActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 0, 51));
        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(deletePhoneButton)
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(deleteEmailButton)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 2, Short.MAX_VALUE))
                            .addComponent(emailsField)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phoneNumbersField)
                            .addComponent(addressField))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phoneNumbersField, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(deletePhoneButton)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(emailsField)
                        .addGap(2, 2, 2)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(deleteEmailButton)))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(113, 113, 113))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteEmailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEmailButtonActionPerformed
        int indexDeleted = emailsTable.getSelectedRow(), emID = (int) emailsTable.getValueAt(indexDeleted, 0);
        EmailDAO emailDAO = new EmailDAO();
        emailDAO.delete(emID);
        setDatas();
    }//GEN-LAST:event_deleteEmailButtonActionPerformed

    private void deletePhoneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePhoneButtonActionPerformed
        int indexDeleted = phoneNumbersTable.getSelectedRow(), phoneID = (int) phoneNumbersTable.getValueAt(indexDeleted, 0);
        PhoneNumbersDAO phoneDAO = new PhoneNumbersDAO();
        phoneDAO.delete(phoneID);
        setDatas();
    }//GEN-LAST:event_deletePhoneButtonActionPerformed

    /**
     * Check if a Phone Numbers EXISTING in database or NOT (check DUPLICATED)
     * @param phone
     * @return boolean: TRUE if Phone Number is EXISTING in database
     */
    private boolean phoneNumbersExisting(String phone){
        PhoneNumbersDAO dao = new PhoneNumbersDAO();
        List<PhoneNumbers> list = dao.readAll();
        if(list.size()>0){
            for(PhoneNumbers ph : list){
                if(ph.getPhoneNumber().equals(phone)) return true;
            }
        }
        return false;
    }
    /**
     * Check if an  email EXISTING in database or NOT (check DUPLICATED)
     * @param email
     * @return boolean: TRUE if email is EXISTING in database
     */
    private boolean emailsExisting(String email){
        EmailDAO dao = new EmailDAO();
        List<Emails> list = dao.readAll();
        if(list.size()>0){
            for(Emails e : list){
                if(e.getEmail().equals(email)) return true;
            }
        }
        return false;
    }
    private void buttonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSubmitActionPerformed
        String address = addressField.getText(), phoneNumber = phoneNumbersField.getText(), email=emailsField.getText();
        PhoneNumbersDAO phoneDAO = new PhoneNumbersDAO();
        EmailDAO emailsDAO = new EmailDAO();
        CustomersDAO customerDAO=new CustomersDAO();
        
        if(address.length()>0 || ((phoneNumber.length()!=0 && Pattern.matches("^[0-9]*$", phoneNumber) )) || (email.length()>0 )){
            // Update Address 
            customerDAO.update(new Customers(readCustomerByName(cusName).getCustomerID(), cusName, address));
            // Add phone numbers valid (length>0 and only digits) and not-duplicated content
            if (phoneNumber.length()!=0 && Pattern.matches("^[0-9]*$", phoneNumber)){ 
                if(!phoneNumbersExisting(phoneNumber))
                                        phoneDAO.create(new PhoneNumbers(0, readCustomerByName(cusName).getCustomerID(), phoneNumber));
                else JOptionPane.showMessageDialog(null, "Some thing wrong!! The entered informations are duplicated");
            }
            // Add Email valid (length >0) and not-duplicated 
            if(email.length()>0) { 
                if(!emailsExisting(email)) 
                            emailsDAO.create(new Emails(0, readCustomerByName(cusName).getCustomerID(), email));
                else JOptionPane.showMessageDialog(null, "Some thing wrong!! The entered informations are duplicated");
            }
            setDatas();
        } else {
            JOptionPane.showMessageDialog(null, "Some thing wrong!! All fields are empty ");
        }
    }//GEN-LAST:event_buttonSubmitActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateFrame("To Lam").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressField;
    private javax.swing.JButton buttonSubmit;
    private javax.swing.JButton deleteEmailButton;
    private javax.swing.JButton deletePhoneButton;
    private javax.swing.JTextField emailsField;
    private javax.swing.JTable emailsTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField phoneNumbersField;
    private javax.swing.JTable phoneNumbersTable;
    // End of variables declaration//GEN-END:variables
}
