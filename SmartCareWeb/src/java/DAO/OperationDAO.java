/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.BookingBean;
import beans.OperationBean;
import beans.UserBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Harry Marsh & Kamil Lukomski
 */
public class OperationDAO {

    public String Operation(OperationBean OperationBean) {
        String EID = OperationBean.getEid();//setting the strings for the sql query from class
        String CID = OperationBean.getCid();//setting the strings for the sql query from class
        String ODATE = OperationBean.getOdate();//setting the strings for the sql query from class
        String OTIME = OperationBean.getOtime();//setting the strings for the sql query from class
        String NSLOT = OperationBean.getNslot();//setting the strings for the sql query from class
        String CHARGE = OperationBean.getCharge();//setting the strings for the sql query from class
        
        Connection con = null;
        PreparedStatement preparedStatement = null;
        try {
            con = DBConnection.createConnection();
            String query = "insert into operations(eid,cid,odate,otime,nslot,charge) values (?,?,?,?,?,?)"; //Insert user details into the table 'USERS'
            preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
            preparedStatement.setString(1, EID);//Using the set function  to set inputed data 
            preparedStatement.setString(2, CID); //Using the set function  to set inputed data 
            preparedStatement.setString(3, ODATE); //Using the set function  to set inputed data 
            preparedStatement.setString(4, OTIME); //Using the set function  to set inputed data 
            preparedStatement.setString(5, NSLOT); //Using the set function  to set inputed data 
            preparedStatement.setString(6, CHARGE); //Using the set function  to set inputed data 
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
