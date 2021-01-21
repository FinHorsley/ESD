/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.PrescriptionBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Harry Marsh
 */
public class CreatePrescriptionDAO {

    public String PrescriptionCreate(PrescriptionBean PPBean) {

        String Sid = PPBean.getSid();//setting the strings for the sql query from class
        String Cid = PPBean.getCid();//setting the strings for the sql query from class
        String Medicine = PPBean.getMedicine();//setting the strings for the sql query from class
        String Quantity = PPBean.getQuantity();//setting the strings for the sql query from class
        String Repeating = PPBean.getRepeating();//setting the strings for the sql query from class
        String Issuedate = PPBean.getIssuedate();//setting the strings for the sql query from class
        String Enddate = PPBean.getEnddate();//setting the strings for the sql query from class

        Connection con = null;
        PreparedStatement preparedStatement = null;
        try {
            con = DBConnection.createConnection();
            String query = "insert into prescription(cid,sid,medicine,quantity,repeating,issuedate,enddate) values (?,?,?,?,?,?,?)"; //Insert user details into the table 'USERS'
            preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
            preparedStatement.setString(1, Cid); //Using the set function  to set inputed data 
            preparedStatement.setString(2, Sid); //Using the set function  to set inputed data 
            preparedStatement.setString(3, Medicine); //Using the set function  to set inputed data 
            preparedStatement.setString(4, Quantity); //Using the set function  to set inputed data 
            preparedStatement.setString(5, Repeating); //Using the set function  to set inputed data 
            preparedStatement.setString(6, Issuedate); //Using the set function  to set inputed data 
            preparedStatement.setString(7, Enddate); //Using the set function  to set inputed data 
            int i = preparedStatement.executeUpdate();

            if (i != 0) //Just to ensure data has been inserted into the database
            {
                return "SUCCESS";
            }
        } catch (SQLException e) {
        }
        return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
    }
}
