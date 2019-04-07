/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dto;

import java.util.*;
import java.io.*;

public class PhoneNumbers implements Serializable, Comparable<PhoneNumbers>{
    private int phoneID, customerID;
    private String phoneNumber;

    public PhoneNumbers(int phoneID, int customerID, String phoneNumber) {
        this.phoneID = phoneID;
        this.customerID = customerID;
        this.phoneNumber = phoneNumber;
    }

    public int getPhoneID() {
        return phoneID;
    }

    public void setPhoneID(int phoneID) {
        this.phoneID = phoneID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return  phoneNumber ;
    }

    @Override
    public int compareTo(PhoneNumbers o) {
        return this.getCustomerID() -o.getCustomerID(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
