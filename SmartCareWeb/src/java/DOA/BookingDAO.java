/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOA;

import beans.BookingBean;
import beans.UserBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Harry Marsh & Kamil Lukomski
 */
public class BookingDAO {

    public String BookingUser(BookingBean BookingBean) {
        String eid = BookingBean.getEid();

        Connection con5 = null;
        PreparedStatement statement5 = null;
        ResultSet resultSet5 = null;

        String Username = UserBean.uname;
        try {
            
            con5 = DBConnection.createConnection();
            String sql5 = "SELECT cid FROM clients WHERE uname = ?"; //query for collecting data from the database.
            statement5 = con5.prepareStatement(sql5);
            statement5.setString(1, Username);

            resultSet5 = statement5.executeQuery();

            while (resultSet5.next()) {
                String cid = resultSet5.getString("cid");
                BookingBean.setCid(cid);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        String cid = BookingBean.getCid();

        String sdate = BookingBean.getSdate();
        String stime = BookingBean.getStime();

        Connection con = null;
        PreparedStatement preparedStatement = null;
        try {
            con = DBConnection.createConnection();
            String query = "insert into booking_slots(eid,cid,sdate,stime) values (?,?,?,?)"; //Insert user details into the table 'USERS'
            preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
            preparedStatement.setString(1, eid); //Using the get.email function in the RegisterBean to get inputed data from registration.jsp
            preparedStatement.setString(2, cid); //Using the get.UserName function in the RegisterBean to get inputed data from registration.jsp
            preparedStatement.setString(3, sdate); //Using the get.password function in the RegisterBean to get inputed data from registration.jsp
            preparedStatement.setString(4, stime); //Using the get.password function in the RegisterBean to get inputed data from registration.jsp             
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
