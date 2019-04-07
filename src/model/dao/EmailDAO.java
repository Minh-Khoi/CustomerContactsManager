/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dto.*;
import utils.DBConnector;

public class EmailDAO {
    private final String SQL_CREATE = "Insert into Emails(CustomerID, Email)  values "
                                                                    + "(?,?)",
                            SQL_READALL = "Select * from Emails",
                            SQL_READ_BY_CUSROMER_ID = "Select * from Emails where CustomerID = ?",
                            SQL_READ_BY_PHONE_ID = "Select * from Emails where Email_ID = ?",
                            SQL_UPDATE = "Update Emails Set CustomerID=?, Email=? where Email_ID=?",
                            SQL_DELETE = "Delete from Emails where Email_ID=?";
    
    Connection conn;
    PreparedStatement prs;

    public EmailDAO() {
        this.conn = new DBConnector().getConn();
    }
    
    public int create (Emails email){
        try {
            prs = conn.prepareStatement(SQL_CREATE);
            prs.setInt(1, email.getCustomerID());
            prs.setString(2, email.getEmail());
            int newCreated = prs.executeUpdate();
            System.out.println((newCreated!=0)? (newCreated + " email created") : "Something wrong! Check the input values");
            return newCreated;
        } catch (SQLException ex) {
            Logger.getLogger(CustomersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public List<Emails> readAll(){
        List<Emails> listEmails = new ArrayList<>();
        int email_ID,customerID ;
        String email;
        try {
            prs= conn.prepareStatement(SQL_READALL);
            ResultSet res = prs.executeQuery();
            while (res.next()){
                email_ID = res.getInt("Email_ID");
                customerID = res.getInt("CustomerID");
                email = res.getString("Email");
                listEmails.add(new Emails(email_ID, customerID, email));
            }
            return listEmails;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<Emails> readByCustomerID(int id){
        try {
            prs = conn.prepareStatement(SQL_READ_BY_CUSROMER_ID);
            prs.setInt(1, id);
            ResultSet res = prs.executeQuery();
            List<Emails> listEmails = new ArrayList<>();
            while(res.next()){
                int customerID = res.getInt("CustomerID");
                int email_ID = res.getInt("Email_ID");
                String email = res.getString("Email");
                listEmails.add(new Emails(email_ID, customerID, email));
            }
            return listEmails;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public Emails readByEmail_ID(int id){
        try {
            prs = conn.prepareStatement(SQL_READ_BY_PHONE_ID);
            prs.setInt(1, id);
            ResultSet res = prs.executeQuery();
            while(res.next()){
                int customerID = res.getInt("CustomerID");
                int email_ID = res.getInt("Email_ID");
                String email = res.getString("Email");
                return (new Emails(email_ID, customerID, email));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public int update(Emails email){
        try {
            prs = conn.prepareStatement(SQL_UPDATE);
            prs.setInt(1, email.getCustomerID());
            prs.setInt(3, email.getEmail_ID());
            prs.setString(2, email.getEmail());
            int newUpdated = prs.executeUpdate();
            System.out.println((newUpdated!=0)? (newUpdated + " email updated") : "Something wrong! Check the input values");
            return newUpdated;
        } catch (SQLException ex) {
            Logger.getLogger(CustomersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public int delete (int id){
        try {
            prs = conn.prepareStatement(SQL_DELETE);
            prs.setInt(1, id);
            int deleted = prs.executeUpdate();
            System.out.println((deleted!=0)? (deleted + " email deleted") : "Something wrong! Check the input values");
            return deleted;
        } catch (SQLException ex) {
            Logger.getLogger(CustomersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
