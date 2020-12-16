/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLET;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import BEAN.BookingBean;
import DAO.BookingDAO;
 
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
         String eid = request.getParameter("eid");
         String cid = request.getParameter("cid");
         String slotDate = request.getParameter("sdate");
         String slotTime = request.getParameter("stime");
         
         BookingBean BookingBean = new BookingBean();
        //Using Java Beans - An easiest way to play with group of related data
         BookingBean.setEid(eid);
         BookingBean.setCid(cid);
         BookingBean.setSdate(slotDate);
         BookingBean.setStime(slotTime);
         
         BookingDAO BookingDAO = new BookingDAO();
         
        //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
         String bookingRegistered = BookingDAO.BookingUser(BookingBean);
         
         if(bookingRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
         {
            request.getRequestDispatcher("/user.client.jsp").forward(request, response);
         }
         else   //On Failure, display a meaningful message to the User.
         {
            request.setAttribute("errMessage", bookingRegistered);
            request.getRequestDispatcher("/booking.jsp").forward(request, response);
         }
     }
}