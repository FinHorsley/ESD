/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOA;

import beans.EmployeeRegisterBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Harry Marsh
 */
public class EmployeeUserRegisterDAO {

    public String EmployeeregisterUser(EmployeeRegisterBean registerBean) {
        String userName = registerBean.geteUserName();
        String password = registerBean.getePassword();
        String role = "Not Approved: " + registerBean.geteType();

        Connection con = null;
        PreparedStatement preparedStatement = null;
        
        try {
            con = DBConnection.createConnection();
            String query = "insert into users(uname,passwd,role) values (?,?,?)"; //Insert user details into the table 'USERS'
            preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
            preparedStatement.setString(1, userName); //Using the get.UserName function in the RegisterBean to get inputed data from registration.jsp
            preparedStatement.setString(2, password); //Using the get.password function in the RegisterBean to get inputed data from registration.jsp
            preparedStatement.setString(3, role); //Using the get.password function in the RegisterBean to get inputed data from registration.jsp             
            int i = preparedStatement.executeUpdate();

            if (i != 0) //Just to ensure data has been inserted into the database
            {
                return "SUCCESS";
            }
        } catch (SQLException e) {
        }
        return "Failed: User table not updated";  // On failure, send a message from here.
    }
}
