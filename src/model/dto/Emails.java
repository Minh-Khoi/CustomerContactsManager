/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dto;

import java.util.*;
import java.io.*;

public class Emails implements Serializable, Comparable<Emails>{
    private int email_ID, customerID;
    private String email;

    public Emails(int email_ID, int customerID, String email) {
        this.email_ID = email_ID;
        this.customerID = customerID;
        this.email = email;
    }

    public int getEmail_ID() {
        return email_ID;
    }

    public void setEmail_ID(int email_ID) {
        this.email_ID = email_ID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Emails{" + "email_ID=" + email_ID + ", customerID=" + customerID + ", email=" + email + '}';
    }
    
    
    @Override
    public int compareTo(Emails o) {
        return this.getCustomerID() - o.getCustomerID(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
