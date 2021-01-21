/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.InvoiceBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author kamil
 */
public class InvoiceDAO {
    
        public String InvoiceUser(InvoiceBean InvoiceBean)
        {
        String EmployeeID = InvoiceBean.getEID();//setting the strings for the sql query from class
        String ClientID = InvoiceBean.getCID();//setting the strings for the sql query from class
        String SlotID = InvoiceBean.getSID();//setting the strings for the sql query from class
        String PrescriptionID = InvoiceBean.getPID();//setting the strings for the sql query from class
        
        Connection con = null;
        PreparedStatement preparedStatement = null;
        
        try {
            con = DBConnection.createConnection();
            String query = "insert into invoice(eid,cid,sid,pid) values (?,?,?,?)"; //Insert user details into the table 'USERS'
            preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
            preparedStatement.setString(1, EmployeeID); //Using the set function  to set inputed data 
            preparedStatement.setString(2, ClientID); //Using the set function  to set inputed data    
            preparedStatement.setString(3, SlotID); //Using the set function  to set inputed data 
            preparedStatement.setString(4, PrescriptionID); //Using the set function  to set inputed data 
            
            int i = preparedStatement.executeUpdate();

            if (i != 0) //Just to ensure data has been inserted into the database
            {
                return "SUCCESS";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Failed: Invoice table not updated";  // On failure, send a message from here.
    }
    
}
