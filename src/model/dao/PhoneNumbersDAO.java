/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dto.*;
import utils.DBConnector;
/**
 *
 * @author KHOI
 */
public class PhoneNumbersDAO {
    private final String SQL_CREATE = "Insert into PhoneNumbers(CustomerID, PhoneNumber)  values "
                                                                    + "(?,?)",
                            SQL_READALL = "Select * from PhoneNumbers",
                            SQL_READ_BY_CUSROMER_ID = "Select * from PhoneNumbers where CustomerID = ?",
                            SQL_READ_BY_PHONE_ID = "Select * from PhoneNumbers where PhoneID = ?",
                            SQL_UPDATE = "Update PhoneNumbers Set CustomerID=?, PhoneNumber=? where PhoneID=?",
                            SQL_DELETE = "Delete from PhoneNumbers where PhoneID=?";
    Connection conn;
    PreparedStatement prs;

    public PhoneNumbersDAO() {
        this.conn = new DBConnector().getConn();
    }
    
    public int create (PhoneNumbers phone){
        try {
            prs = conn.prepareStatement(SQL_CREATE);
            prs.setInt(1, phone.getCustomerID());
            prs.setString(2, phone.getPhoneNumber());
            int newCreated = prs.executeUpdate();
            System.out.println((newCreated!=0)? (newCreated + " phone number created") : "Something wrong! Check the input values");
            return newCreated;
        } catch (SQLException ex) {
            Logger.getLogger(CustomersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public List<PhoneNumbers> readAll(){
        List<PhoneNumbers> listCustomers = new ArrayList<>();
        int phoneID,customerID ;
        String phoneNumber;
        try {
            prs= conn.prepareStatement(SQL_READALL);
            ResultSet res = prs.executeQuery();
            while (res.next()){
                phoneID = res.getInt("PhoneID");
                customerID = res.getInt("CustomerID");
                phoneNumber = res.getString("PhoneNumber");
                listCustomers.add(new PhoneNumbers(phoneID, customerID, phoneNumber));
            }
            return listCustomers;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        //try{ return listCustomers;} catch (NullPointerException ex){ throw ex;}
        return null;
    }
    
    public List<PhoneNumbers> readByCustomerID(int id){
        try {
            prs = conn.prepareStatement(SQL_READ_BY_CUSROMER_ID);
            prs.setInt(1, id);
            ResultSet res = prs.executeQuery();
            List<PhoneNumbers> listPhones = new ArrayList<>();
            while(res.next()){
                int customerID = res.getInt("CustomerID");
                int phoneID = res.getInt("PhoneID");
                String phoneNumber = res.getString("PhoneNumber");
                listPhones.add(new PhoneNumbers(phoneID, customerID, phoneNumber));
            }
            return listPhones;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public PhoneNumbers readByPhoneID(int id){
        try {
            prs = conn.prepareStatement(SQL_READ_BY_PHONE_ID);
            prs.setInt(1, id);
            ResultSet res = prs.executeQuery();
            while(res.next()){
                int customerID = res.getInt("CustomerID");
                int phoneID = res.getInt("PhoneID");
                String phoneNumber = res.getString("PhoneNumber");
                return (new PhoneNumbers(phoneID, customerID, phoneNumber));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public int update(PhoneNumbers phone){
        try {
            prs = conn.prepareStatement(SQL_UPDATE);
            prs.setInt(1, phone.getCustomerID());
            prs.setInt(3, phone.getPhoneID());
            prs.setString(2, phone.getPhoneNumber());
            int newUpdated = prs.executeUpdate();
            System.out.println((newUpdated!=0)? (newUpdated + " phone number updated") : "Something wrong! Check the input values");
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
            System.out.println((deleted!=0)? (deleted + " phone number deleted") : "Something wrong! Check the input values");
            return deleted;
        } catch (SQLException ex) {
            Logger.getLogger(CustomersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
