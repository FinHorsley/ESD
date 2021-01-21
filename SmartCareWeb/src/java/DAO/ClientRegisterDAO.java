/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.RegisterBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Harry Marsh
 */
public class ClientRegisterDAO {

    public String registerUser(RegisterBean registerBean) {
        String cname = registerBean.getName();//setting the strings for the sql query from class
        String caddress = registerBean.getAddress();//setting the strings for the sql query from class
        String ctype = registerBean.getType();//setting the strings for the sql query from class
        String uname = registerBean.getUserName();//setting the strings for the sql query from class

        Connection con = null;
        PreparedStatement preparedStatement = null;
        try {
            con = DBConnection.createConnection();
            String queryC = "insert into clients(cname,caddress,ctype,uname) values (?,?,?,?)"; //Insert user details into the table 'USERS'
            preparedStatement = con.prepareStatement(queryC); //Making use of prepared statements here to insert bunch of data
            preparedStatement.setString(1, cname); //Using the set function  to set inputed data 
            preparedStatement.setString(2, caddress); //Using the set function  to set inputed data 
            preparedStatement.setString(3, ctype); //Using the set function  to set inputed data            
            preparedStatement.setString(4, uname); //Using the set function  to set inputed data 

            int f = preparedStatement.executeUpdate();

            if (f != 0) //Just to ensure data has been inserted into the database
            {
                return "SUCCESS";
            }
        } catch (SQLException e) {
        }
        return "Failed: Client table not updated";  // On failure, send a message from here.
    }
}
