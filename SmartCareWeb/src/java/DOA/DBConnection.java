/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOA;

/**
 *
 * @author Harry Marsh
 */

//importing sql functions
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection createConnection() { //creating connection to SmartCare database
        Connection con = null;
        String url = "jdbc:derby://localhost:1527/SmartCare"; //derby database URL followed by the database name
        String username = "Harry"; //derby username
        String password = "123"; //derby password
        System.out.println("In DBConnection.java class ");

        try {
            try {
                Class.forName("com.mysql.jdbc.Driver"); //loading MySQL drivers. This differs for database servers 
            } catch (ClassNotFoundException e) {
            }
            con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
            System.out.println("Printing connection object " + con);
        } catch (SQLException e) {
            //catch any errors or exeptions in the connection to the database
                    }
        return con;
    }
}
