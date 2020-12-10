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
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {

    public static String loginCheck(LoginBean loginBean) {
        String query = "select * from users where uname=? and passwd=?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, loginBean.getuname());
            ps.setString(2, loginBean.getpasswd());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return "true";
            } else {
                return "false";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "error";
    }
}
