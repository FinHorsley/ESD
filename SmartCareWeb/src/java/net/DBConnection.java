/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net;

/**
 *
 * @author harry
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static final String URL = "jdbc:mysql://localhost:1527/";
    static final String DATABASE_NAME = "SmartCare";
    static final String USERNAME = "Harry";
    static final String PASSWORD = "123";

    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL + DATABASE_NAME, USERNAME, PASSWORD);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}
