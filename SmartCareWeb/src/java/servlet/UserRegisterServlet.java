/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DOA.ClientRegisterDAO;
import beans.RegisterBean;
import DOA.RegisterDao;
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
@WebServlet("/Register")
public class UserRegisterServlet extends HttpServlet {

    public UserRegisterServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Copying all the input parameters in to local variables
        String name = request.getParameter("name");
        String userName = request.getParameter("uname");
        String password = request.getParameter("passwd");
        String type = request.getParameter("type");
        String address = request.getParameter("address");

        RegisterBean registerBean = new RegisterBean();
        //Using Java Beans - An easiest way to play with group of related data
        registerBean.setName(name);
        registerBean.setUserName(userName);
        registerBean.setPassword(password);
        registerBean.setType(type);
        registerBean.setAddress(address);

        RegisterDao registerDao = new RegisterDao();
        ClientRegisterDAO ClientRegisterDAO = new ClientRegisterDAO();
        //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
        String userRegistered = registerDao.registerUser(registerBean);
        String ClientRegistered = ClientRegisterDAO.registerUser(registerBean);

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
