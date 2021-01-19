/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOA;
import beans.BookingBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Harry Marsh & Kamil Lukomski
 */
public class BookingDAO { 
     public String BookingUser(BookingBean BookingBean)
     {
         String eid = BookingBean.getEid();
         String cid = BookingBean.getCid();
         String sdate = BookingBean.getSdate();         
         String stime = BookingBean.getStime();

         Connection con = null;
         PreparedStatement preparedStatement = null;         
         try
         {
             con = DBConnection.createConnection();
             String query = "insert into booking_slots(eid,cid,sdate,stime) values (?,?,?,?)"; //Insert user details into the table 'USERS'
             preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
             preparedStatement.setString(1, eid); //Using the get.email function in the RegisterBean to get inputed data from registration.jsp
             preparedStatement.setString(2, cid); //Using the get.UserName function in the RegisterBean to get inputed data from registration.jsp
             preparedStatement.setString(3, sdate); //Using the get.password function in the RegisterBean to get inputed data from registration.jsp
             preparedStatement.setString(4, stime); //Using the get.password function in the RegisterBean to get inputed data from registration.jsp             
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
