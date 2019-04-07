/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dto.*;
import utils.DBConnector;

public class CustomersDAO {
    private final String SQL_CREATE = "Insert into Customers(CustomerName, Address)  values "
                                                                    + "(?,?)",
                            SQL_READALL = "Select * from Customers",
                            SQL_READ_BY_ID = "Select * from Customers where CustomerID = ?",
                            SQL_UPDATE = "Update Customers Set CustomerName=?, Address=? where CustomerID=?",
                            SQL_DELETE = "Delete from Customers where CustomerID=?";
    Connection conn;
    PreparedStatement prs;

    public CustomersDAO() {
        this.conn = new DBConnector().getConn();
    }
    
    
    public int create (Customers customer){
        try {
            prs = conn.prepareStatement(SQL_CREATE);
            prs.setString(1, customer.getCustomerName());
            prs.setString(2, customer.getAddress());
            int newCreated = prs.executeUpdate();
            System.out.println((newCreated!=0)? (newCreated + " customers created") : "Something wrong! Check the input values");
            return newCreated;
        } catch (SQLException ex) {
            Logger.getLogger(CustomersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public List<Customers> readAll(){
        List<Customers> listCustomers = new ArrayList<>();
        int customerID ;
        String customerName, address;
        try {
            prs= conn.prepareStatement(SQL_READALL);
            ResultSet res = prs.executeQuery();
            while (res.next()){
                customerID = res.getInt("CustomerID");
                customerName = res.getString("CustomerName");
                address = res.getString("Address");
                listCustomers.add(new Customers(customerID, customerName, address));
            }
            return listCustomers;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        //try{ return listCustomers;} catch (NullPointerException ex){ throw ex;}
        return null;
    }
    
    public Customers readByID(int id){
        try {
            prs = conn.prepareStatement(SQL_READ_BY_ID);
            prs.setInt(1, id);
            ResultSet res = prs.executeQuery();
            int customerID = res.getInt("CustomerID");
            String customerName = res.getString("CustomerName");
            String address = res.getString("Address");
            return new Customers(customerID, customerName, address);
        } catch (SQLException ex) {
            Logger.getLogger(CustomersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int update(Customers customer){
        try {
            prs = conn.prepareStatement(SQL_UPDATE);
            prs.setInt(3, customer.getCustomerID());
            prs.setString(1, customer.getCustomerName());
            prs.setString(2, customer.getAddress());
            int newUpdated = prs.executeUpdate();
            System.out.println((newUpdated!=0)? (newUpdated + " customers updated") : "Something wrong! Check the input values");
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
            System.out.println((deleted!=0)? (deleted + " customers deleted") : "Something wrong! Check the input values");
            return deleted;
        } catch (SQLException ex) {
            Logger.getLogger(CustomersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
   
}
