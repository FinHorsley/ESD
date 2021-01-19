/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOA;

import bean.InvoiceBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author kamil
 */
public class InvoiceDAO {
    
        public String InvoiceUser(InvoiceBean InvoiceBean)
        {
        String ClientName = InvoiceBean.getClientName();
        String ClientID = InvoiceBean.getClientID();
        String ClientAddress = InvoiceBean.getClientAddress();
        String ConsultationType = InvoiceBean.getConsultationType();
        String ConsultationTime = InvoiceBean.getConsultationTime();
        
        Connection con = null;
        PreparedStatement preparedStatement = null;
        
        try {
            con = DBConnection.createConnection();
            String query = "insert into invoice(clientname,clientid,clientaddress,consultationtype,consultationtime) values (?,?,?,?,?)"; //Insert user details into the table 'USERS'
            preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
            preparedStatement.setString(1, ClientName); //Using the get.password function in the RegisterBean to get inputed data from registration.jsp
            preparedStatement.setString(2, ClientID); //Using the get.password function in the RegisterBean to get inputed data from registration.jsp 
            preparedStatement.setString(3, ClientAddress); //Using the get.password function in the RegisterBean to get inputed data from registration.jsp
            preparedStatement.setString(4, ConsultationType); //Using the get.password function in the RegisterBean to get inputed data from registration.jsp
            preparedStatement.setString(5, ConsultationTime); //Using the get.password function in the RegisterBean to get inputed data from registration.jsp
            int i = preparedStatement.executeUpdate();

            if (i != 0) //Just to ensure data has been inserted into the database
            {
                return "SUCCESS";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Failed: User table not updated";  // On failure, send a message from here.
    }
    
}
