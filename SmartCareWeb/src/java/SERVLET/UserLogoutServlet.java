/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLET;

import java.io.*;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author Harry Marsh
 */
@WebServlet("/logout")
public class UserLogoutServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public UserLogoutServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) { //removes all details about user when logged out so unable to access areas without login
            session.removeAttribute("user");

            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp"); //returns to main page
            dispatcher.forward(request, response);
        }
    }
}
