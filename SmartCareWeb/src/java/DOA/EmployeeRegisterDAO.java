/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOA;

import beans.EmployeeRegisterBean;
import beans.RegisterBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Harry Marsh
 */
public class EmployeeRegisterDAO {

    public String EmployeeregisterUser(EmployeeRegisterBean registerBean) {
        String ename = registerBean.geteName();
        String eaddress = registerBean.geteAddress();
        String uname = registerBean.geteUserName();

        Connection con = null;
        PreparedStatement preparedStatement = null;
        try {
            con = DBConnection.createConnection();
            String queryC = "insert into employee(ename,eaddress,uname) values (?,?,?)"; //Insert user details into the table 'USERS'
            preparedStatement = con.prepareStatement(queryC); //Making use of prepared statements here to insert bunch of data
            preparedStatement.setString(1, ename); //Using the get.UserName function in the RegisterBean to get inputed data from registration.jsp
            preparedStatement.setString(2, eaddress); //Using the get.password function in the RegisterBean to get inputed data from registration.jsp            
            preparedStatement.setString(3, uname); //Using the get.password function in the RegisterBean to get inputed data from registration.jsp

            int f = preparedStatement.executeUpdate();

            if (f != 0) //Just to ensure data has been inserted into the database
            {
                return "SUCCESS";
            }
        } catch (SQLException e) {
        }
        return "Failed: Employee table not updated";  // On failure, send a message from here.
    }
}
