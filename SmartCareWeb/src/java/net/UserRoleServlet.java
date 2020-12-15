/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Harry Marsh
 */
@WebServlet("/role")
public class UserRoleServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public UserRoleServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (User.role.equals("admin")) { //checks users role and depending on role redirects to their client area

            RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/user.admin.jsp"); //gives the request the peramiter of the page
            RequetsDispatcherObj.forward(request, response);
        }
        if (User.role.equals("doctor")) { //checks users role and depending on role redirects to their client area

            RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/user.doctor.jsp"); //gives the request the peramiter of the page
            RequetsDispatcherObj.forward(request, response);
        }
        if (User.role.equals("nurse")) { //checks users role and depending on role redirects to their client area

            RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/user.nurse.jsp"); //gives the request the peramiter of the page
            RequetsDispatcherObj.forward(request, response);
        }
        if (User.role.equals("client")) { //checks users role and depending on role redirects to their client area

            RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/user.client.jsp"); //gives the request the peramiter of the page
            RequetsDispatcherObj.forward(request, response);
        }
    }
}
