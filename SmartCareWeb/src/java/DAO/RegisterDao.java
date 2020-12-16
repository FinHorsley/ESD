/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import BEAN.RegisterBean;
/**
 *
 * @author Harry Marsh
 */
public class RegisterDao { 
     public String registerUser(RegisterBean registerBean)
     {
         String email = registerBean.getEmail();
         String userName = registerBean.getUserName();
         String password = registerBean.getPassword();
         String role = "client";
         Connection con = null;
         PreparedStatement preparedStatement = null;         
         try
         {
             con = DBConnection.createConnection();
             String query = "insert into users(email,uname,passwd,role) values (?,?,?,?)"; //Insert user details into the table 'USERS'
             preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
             preparedStatement.setString(1, email); //Using the get.email function in the RegisterBean to get inputed data from registration.jsp
             preparedStatement.setString(2, userName); //Using the get.UserName function in the RegisterBean to get inputed data from registration.jsp
             preparedStatement.setString(3, password); //Using the get.password function in the RegisterBean to get inputed data from registration.jsp
             preparedStatement.setString(4, role); //Using the get.password function in the RegisterBean to get inputed data from registration.jsp             
             int i= preparedStatement.executeUpdate();
             
             if (i!=0)  //Just to ensure data has been inserted into the database
             return "SUCCESS"; 
         }
         catch(SQLException e)
         {
         }       
         return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
     }
}
