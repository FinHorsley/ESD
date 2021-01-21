/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.UserBean;
import java.sql.*;

/**
 *
 * @author Harry Marsh
 */
public class UserDAO {

    public UserBean checkLogin(String uname, String passwd) throws SQLException,
            ClassNotFoundException {
        
        Connection con = null; //conection to the database
        con = DBConnection.createConnection(); //using the java class DBConnection to connnect to db
        String sql = "select * from users where uname=? and passwd=?"; //query for collecting data from the database.
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, uname); 
        statement.setString(2, passwd);
        

        ResultSet result = statement.executeQuery();

        UserBean user = null;

        if (result.next()) {
            user = new UserBean();
            user.setRole(result.getString("role"));
            user.setUname(uname);
        }

        con.close();

        return user;
    }
}
