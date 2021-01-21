/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;
//--------------imports
import DAO.EmployeeRegisterDAO;
import DAO.EmployeeUserRegisterDAO;
import beans.EmployeeRegisterBean;
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
@WebServlet("/EmployeeRegister")
public class EmployeeUserRegisterServlet extends HttpServlet {

    public EmployeeUserRegisterServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Copying all the input parameters in to local variables
        String ename = request.getParameter("name");//getting the varibles from the form of jsp file
        String euserName = request.getParameter("uname");//getting the varibles from the form of jsp file
        String epassword = request.getParameter("passwd");//getting the varibles from the form of jsp file
        String etype = request.getParameter("type");//getting the varibles from the form of jsp file
        String eaddress = request.getParameter("address"); //getting the varibles from the form of jsp file

        EmployeeRegisterBean registerBean = new EmployeeRegisterBean();
        //Using Java Beans - An easiest way to play with group of related data
        registerBean.seteName(ename); //setting the varibles to class values based of the forms submited reasults
        registerBean.seteUserName(euserName); //setting the varibles to class values based of the forms submited reasults
        registerBean.setePassword(epassword); //setting the varibles to class values based of the forms submited reasults
        registerBean.seteType(etype); //setting the varibles to class values based of the forms submited reasults
        registerBean.seteAddress(eaddress); //setting the varibles to class values based of the forms submited reasults

        EmployeeUserRegisterDAO registerDao = new EmployeeUserRegisterDAO();
        EmployeeRegisterDAO ClientRegisterDAO = new EmployeeRegisterDAO();
        //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
        String userRegistered = registerDao.EmployeeregisterUser(registerBean);
        String ClientRegistered = ClientRegisterDAO.EmployeeregisterUser(registerBean);

        if (userRegistered.equals("SUCCESS") && ClientRegistered.equals("SUCCESS")) //On success, you can display a message to user on Home page
        {        //request dispatcha to redirect the servlet to the genrate.invoice.jsp page once it has completed its operations
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else if (userRegistered.equals("SUCCESS") && (!ClientRegistered.equals("SUCCESS"))) //On Failure, display a meaningful message to the User.
        {        //request dispatcha to redirect the servlet to the genrate.invoice.jsp page once it has completed its operations
            request.setAttribute("errMessage", ClientRegistered);
            request.getRequestDispatcher("/registration.jsp").forward(request, response);
            
        } else if ((!userRegistered.equals("SUCCESS")) && ClientRegistered.equals("SUCCESS")) //On Failure, display a meaningful message to the User.
        {        //request dispatcha to redirect the servlet to the genrate.invoice.jsp page once it has completed its operations
            request.setAttribute("errMessage", userRegistered);
            request.getRequestDispatcher("/registration.employee.jsp").forward(request, response);
        }
        
    }
}
