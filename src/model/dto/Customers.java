/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dto;

import java.util.*;
import java.io.*;

public class Customers implements Serializable, Comparable<Customers>, Comparator<Customers>{
    private int customerID ;
    private String customerName, address;

    public Customers(){
        
    }
    
    public Customers(int customerID, String customerName, String address) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.address = address;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customers{" + "customerID=" + customerID + ", customerName=" + customerName + ", address=" + address + '}';
    }
    
    @Override
    public int compareTo(Customers o) {
        return this.getCustomerName().compareToIgnoreCase(o.getCustomerName()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compare(Customers o1, Customers o2) {
        return o1.getCustomerName().compareToIgnoreCase(o2.getCustomerName()); //To change body of generated methods, choose Tools | Templates.
    }
    
}
