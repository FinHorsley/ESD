/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DOA.EmployeeRegisterDAO;
import DOA.EmployeeUserRegisterDAO;
import beans.EmployeeRegisterBean;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Harry Marsh
 */
@WebServlet("/EmployeeRegister")
public class EmployeeUserRegisterServlet extends HttpServlet {

    public EmployeeUserRegisterServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Copying all the input parameters in to local variables
        String ename = request.getParameter("name");
        String euserName = request.getParameter("uname");
        String epassword = request.getParameter("passwd");
        String etype = request.getParameter("type");
        String eaddress = request.getParameter("address");

        EmployeeRegisterBean registerBean = new EmployeeRegisterBean();
        //Using Java Beans - An easiest way to play with group of related data
        registerBean.seteName(ename);
        registerBean.seteUserName(euserName);
        registerBean.setePassword(epassword);
        registerBean.seteType(etype);
        registerBean.seteAddress(eaddress);

        EmployeeUserRegisterDAO registerDao = new EmployeeUserRegisterDAO();
        EmployeeRegisterDAO ClientRegisterDAO = new EmployeeRegisterDAO();
        //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
        String userRegistered = registerDao.EmployeeregisterUser(registerBean);
        String ClientRegistered = ClientRegisterDAO.EmployeeregisterUser(registerBean);

        if (userRegistered.equals("SUCCESS") && ClientRegistered.equals("SUCCESS")) //On success, you can display a message to user on Home page
        {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else if (userRegistered.equals("SUCCESS") && (!ClientRegistered.equals("SUCCESS"))) //On Failure, display a meaningful message to the User.
        {
            request.setAttribute("errMessage", ClientRegistered);
            request.getRequestDispatcher("/registration.jsp").forward(request, response);
            
        } else if ((!userRegistered.equals("SUCCESS")) && ClientRegistered.equals("SUCCESS")) //On Failure, display a meaningful message to the User.
        {
            request.setAttribute("errMessage", userRegistered);
            request.getRequestDispatcher("/registration.jsp").forward(request, response);
        }
        
    }
}
