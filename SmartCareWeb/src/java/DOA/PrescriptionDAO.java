/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOA;

import beans.PrescriptionBean;
import java.sql.*;
/**
 *
 * @author finhorsley
 */
public final class PrescriptionDAO {
     public static void insertPrescription(PrescriptionBean prescription) {
        Connection con = DBConnection.createConnection();

        try {
            PreparedStatement ps = con.prepareStatement("insert into prescription (cID, medicine, quantity, repeating, issuedate, enddate) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, prescription.getcId());
            ps.setString(2, prescription.getMedicine());
            ps.setInt(3, prescription.getQuantity());
            ps.setBoolean(4, prescription.getRepeating());
            ps.setDate(5, prescription.getIssueDate());
            ps.setDate(6, prescription.getEndDate());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
     
     public static PrescriptionBean getPrescription(int id) {
        Connection con = DBConnection.createConnection();
        
        try {
            PreparedStatement statement = con.prepareStatement("select * from prescription where id = ?");
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {
                if (rs.getInt(1) == id) {
                    PrescriptionBean prescription = new PrescriptionBean(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getInt(4),
                            rs.getBoolean(5),
                            rs.getDate(6),
                            rs.getDate(7)
                    );

                    rs.close();
                    return prescription;
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        
        return null;
    }
}