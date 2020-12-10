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
 * @author harry
 */
@WebServlet("/role")
public class UserRoleServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public UserRoleServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (User.role.equals("admin")) {

            RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/user.admin.jsp");
            RequetsDispatcherObj.forward(request, response);
        }
        if (User.role.equals("doctor")) {

            RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/user.doctor.jsp");
            RequetsDispatcherObj.forward(request, response);
        }
        if (User.role.equals("nurse")) {

            RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/user.nurse.jsp");
            RequetsDispatcherObj.forward(request, response);
        }
        if (User.role.equals("client")) {

            RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/user.client.jsp");
            RequetsDispatcherObj.forward(request, response);
        }
    }
}
