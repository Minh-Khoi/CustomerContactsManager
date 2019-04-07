/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.*;
import utils.*;
import model.dao.*;
import model.dto.*;

/**
 *
 * @author KHOI
 */
public class TEST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EmailDAO emailDAO = new EmailDAO();
//        emailDAO.create(new Emails(1, 1, "Minh KHooi VI DAI"));
//        emailDAO.create(new Emails(1, 2, "fkdjgf jf"));
//        emailDAO.create(new Emails(1, 2, "vdfhinkl vdf"));
//        emailDAO.create(new Emails(1, 3, "dfj hnk j lbk"));
//        emailDAO.create(new Emails(1, 6, "dkf hbjkn lb njhcoih"));
//        emailDAO.create(new Emails(1, 4, "sdg g g bdd"));
//        emailDAO.create(new Emails(1, 4, "asd vdfg vcs"));
//        emailDAO.create(new Emails(1, 2, "as vf gvfd"));
//        emailDAO.create(new Emails(1, 5, "asg fgdf "));
        
//        List<Emails> list= emailDAO.readByCustomerID(4);
//        for(Emails e : list){
//            System.out.println(e.toString());
//        }
//        emailDAO.update(new Emails(6, 7, emailDAO.readByEmail_ID(7).getEmail()));
//        emailDAO.update(new Emails(9, emailDAO.readByEmail_ID(7).getCustomerID(), "0981235336"));
        emailDAO.delete(8);
    }
    
}
