/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;
//--------------imports
import beans.BookingBean;
import DAO.BookingDAO;
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
@WebServlet("/booking") 
public class ClientBookingServlet extends HttpServlet {
 
     public ClientBookingServlet() {
     }
 
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Copying all the input parameters in to local variables
         String eid = request.getParameter("EmployeeChoice");//getting the varibles from the form of jsp file
         String slotDate = request.getParameter("sdate");//getting the varibles from the form of jsp file
         String slotTime = request.getParameter("stime");//getting the varibles from the form of jsp file
         String Reason = request.getParameter("sreason");//getting the varibles from the form of jsp file
         
         BookingBean BookingBean = new BookingBean();
        //Using Java Beans - An easiest way to play with group of related data
         BookingBean.setEid(eid);
         BookingBean.setSdate(slotDate);//setting the varibles to class values 
         BookingBean.setStime(slotTime);//setting the varibles to class values 
         BookingBean.setSreason(Reason);//setting the varibles to class values 
            
         
         BookingDAO BookingDAO = new BookingDAO();
         
        //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
         String bookingRegistered = BookingDAO.BookingUser(BookingBean);
         
         if(bookingRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
         {        //request dispatcha to redirect the servlet to the genrate.invoice.jsp page once it has completed its operations
            request.getRequestDispatcher("/user.client.jsp").forward(request, response);
         }
         else   //On Failure, display a meaningful message to the User.
         {        //request dispatcha to redirect the servlet to the genrate.invoice.jsp page once it has completed its operations
            request.setAttribute("errMessage", bookingRegistered);
            request.getRequestDispatcher("/booking.jsp").forward(request, response);
         }
     }
}