/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;
import bean.InvoiceBean;
import DOA.InvoiceDAO;
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
@WebServlet("/invoice") 
public class InvoiceServlet extends HttpServlet {
 
     public InvoiceServlet() {
     }
 
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Copying all the input parameters in to local variables
         String ClientName = request.getParameter("clientname");
         String ClientID = request.getParameter("clientid");
         String ClientAddress = request.getParameter("clientaddress");
         String ConsultationType = request.getParameter("consultationtype");
         String ConsultationTime = request.getParameter("consultationtime");
         
         InvoiceBean InvoiceBean = new InvoiceBean();
        //Using Java Beans - An easiest way to play with group of related data
         InvoiceBean.setClientName(ClientName);
         InvoiceBean.setClientID(ClientID);
         InvoiceBean.setClientAddress(ClientAddress);
         InvoiceBean.setConsultationType(ConsultationType);
         InvoiceBean.setConsultationTime(ConsultationTime);
         
         InvoiceDAO InvoiceDAO = new InvoiceDAO();
         
        //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
         String makeInvoice = InvoiceDAO.InvoiceUser(InvoiceBean);
         
         if(makeInvoice.equals("SUCCESS"))   //On success, you can display a message to user on Home page
         {
            request.getRequestDispatcher("/user.nurse.jsp").forward(request, response);
         }
         else   //On Failure, display a meaningful message to the User.
         {
            request.setAttribute("errMessage", makeInvoice);
            request.getRequestDispatcher("/create.invoice.jsp").forward(request, response);
         }
     }
}