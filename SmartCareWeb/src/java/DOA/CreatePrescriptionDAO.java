/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOA;

import beans.PrescriptionBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Harry Marsh
 */
public class CreatePrescriptionDAO {

    public String PrescriptionCreate(PrescriptionBean PPBean) {

        String Sid = PPBean.getSid();
        System.out.println("Sid = " + Sid);

        String Cid = PPBean.getCid();
        System.out.println("Cid = " + Cid);
        String Medicine = PPBean.getMedicine();
        System.out.println("Medicine = " + Medicine);
        String Quantity = PPBean.getQuantity();
        System.out.println("Quantity = " + Quantity);
        String Repeating = PPBean.getRepeating();
        System.out.println("Repeating = " + Repeating);
        String Issuedate = PPBean.getIssuedate();
        System.out.println("Issuedate = " + Issuedate);
        String Enddate = PPBean.getEnddate();
        System.out.println("Enddate = " + Enddate);

        Connection con = null;
        PreparedStatement preparedStatement = null;
        try {
            con = DBConnection.createConnection();
            String query = "insert into prescription(cid,sid,medicine,quantity,repeating,issuedate,enddate) values (?,?,?,?,?,?,?)"; //Insert user details into the table 'USERS'
            preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
            preparedStatement.setString(1, Cid); //Using the get.email function in the RegisterBean to get inputed data from registration.jsp
            preparedStatement.setString(2, Sid); //Using the get.UserName function in the RegisterBean to get inputed data from registration.jsp
            preparedStatement.setString(3, Medicine); //Using the get.password function in the RegisterBean to get inputed data from registration.jsp
            preparedStatement.setString(4, Quantity); //Using the get.password function in the RegisterBean to get inputed data from registration.jsp
            preparedStatement.setString(5, Repeating); //Using the get.password function in the RegisterBean to get inputed data from registration.
            preparedStatement.setString(6, Issuedate); //Using the get.password function in the RegisterBean to get inputed data from registration.jsp 
            preparedStatement.setString(7, Enddate); //Using the get.password function in the RegisterBean to get inputed data from registration.jsp 
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
