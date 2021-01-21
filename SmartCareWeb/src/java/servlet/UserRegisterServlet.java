/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;
//--------------imports

import DAO.ClientRegisterDAO;
import beans.RegisterBean;
import DAO.RegisterDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//--------------imports

/**
 *
 * @author Harry Marsh
 */
@WebServlet("/Register")
public class UserRegisterServlet extends HttpServlet {

    public UserRegisterServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Copying all the input parameters in to local variables
        String name = request.getParameter("name"); //getting the varibles from the form of jsp file
        String userName = request.getParameter("uname");//getting the varibles from the form of jsp file
        String password = request.getParameter("passwd");//getting the varibles from the form of jsp file
        String type = request.getParameter("type");//getting the varibles from the form of jsp file
        String address = request.getParameter("address");//getting the varibles from the form of jsp file

        RegisterBean registerBean = new RegisterBean();
        //Using Java Beans - An easiest way to play with group of related data
        registerBean.setName(name); //setting the varibles to class values based of the forms submited reasults
        registerBean.setUserName(userName); //setting the varibles to class values based of the forms submited reasults
        registerBean.setPassword(password); //setting the varibles to class values based of the forms submited reasults
        registerBean.setType(type); //setting the varibles to class values based of the forms submited reasults
        registerBean.setAddress(address); //setting the varibles to class values based of the forms submited reasults

        RegisterDao registerDao = new RegisterDao();
        ClientRegisterDAO ClientRegisterDAO = new ClientRegisterDAO();
        //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
        String userRegistered = registerDao.registerUser(registerBean);
        String ClientRegistered = ClientRegisterDAO.registerUser(registerBean);

        if (userRegistered.equals("SUCCESS") && ClientRegistered.equals("SUCCESS")) //On success, you can display a message to user on Home page
        {
            //request dispatcha to redirect the servlet to the genrate.invoice.jsp page once it has completed its operations
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else if (userRegistered.equals("SUCCESS") && (!ClientRegistered.equals("SUCCESS"))) //On Failure, display a meaningful message to the User.
        {
            //request dispatcha to redirect the servlet to the genrate.invoice.jsp page once it has completed its operations
            request.setAttribute("errMessage", ClientRegistered);
            request.getRequestDispatcher("/registration.jsp").forward(request, response);

        } else if ((!userRegistered.equals("SUCCESS")) && ClientRegistered.equals("SUCCESS")) //On Failure, display a meaningful message to the User.
        {
            //request dispatcha to redirect the servlet to the genrate.invoice.jsp page once it has completed its operations
            request.setAttribute("errMessage", userRegistered);
            request.getRequestDispatcher("/registration.jsp").forward(request, response);
        }

    }
}
