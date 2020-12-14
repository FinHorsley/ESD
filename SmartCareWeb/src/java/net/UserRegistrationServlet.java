/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/register")
public class UserRegistrationServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String n = request.getParameter("userName");
        String p = request.getParameter("userPass");
        String e = request.getParameter("userEmail");
        String c = request.getParameter("userAddress");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/SmartCare", "Harry", "123");

            PreparedStatement ps = con.prepareStatement("insert into users values(?,?,?,?)");

            ps.setString(1, n);
            ps.setString(2, p);
            ps.setString(4, e);
            ps.setString(5, c);

            int i = ps.executeUpdate();
            if (i > 0) {
                out.print("You are successfully registered...");
            }

        } catch (ClassNotFoundException | SQLException e2) {
            System.out.println(e2);
        }

        out.close();
    }

}
