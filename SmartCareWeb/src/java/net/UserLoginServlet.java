/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net;

import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author Harry Marsh
 */
@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public UserLoginServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String uname = request.getParameter("uname"); //geting data from the users database
        String passwd = request.getParameter("passwd"); //geting data from the users database
        UserDAO userDao = new UserDAO();

        try {
            User user = userDao.checkLogin(uname, passwd);
            String destPage = "login.jsp";

            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user); //cheacking data inputed vs data stored in the database
                destPage = "home.jsp";
            } else {
                String message = "Invalid username/password"; //if input is not the same as database attribute output an error
                request.setAttribute("message", message);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}
