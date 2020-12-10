/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net;

import java.sql.*;

/**
 *
 * @author harry
 */
public class UserDAO {

    public User checkLogin(String uname, String passwd) throws SQLException,
            ClassNotFoundException {
        String jdbcURL = "jdbc:derby://localhost:1527/SmartCare";
        String dbUser = "Harry";
        String dbPassword = "123";

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        String sql = "select * from users where uname=? and passwd=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, uname);
        statement.setString(2, passwd);

        ResultSet result = statement.executeQuery();

        User user = null;

        if (result.next()) {
            user = new User();
            user.setRole(result.getString("role"));
            user.setUname(uname);
        }

        connection.close();

        return user;
    }
}
