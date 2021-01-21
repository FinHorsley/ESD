/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;
import beans.InvoiceBean;
import DAO.InvoiceDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 *
 * @author kamil
 */
@WebServlet("/invoice") 
public class InvoiceServlet extends HttpServlet {
 
     public InvoiceServlet() {
     }
 
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Copying all the input parameters in to local variables
         String EmployeeID = request.getParameter("EmployeeChoice");
         String ClientID = request.getParameter("ClientChoice");
         String SlotID = request.getParameter("SlotChoice");
         String PrescriptionID = request.getParameter("PrescriptionChoice");
         
         System.out.println("EID = "+EmployeeID );
         System.out.println("CID = "+ClientID );
         System.out.println("SID = "+SlotID );
         System.out.println("PID = "+PrescriptionID );
         
         InvoiceBean InvoiceBean = new InvoiceBean();
        //Using Java Beans - An easiest way to play with group of related data
         InvoiceBean.setEID(EmployeeID);
         InvoiceBean.setCID(ClientID);
         InvoiceBean.setSID(SlotID);
         InvoiceBean.setPID(PrescriptionID);
         
         InvoiceDAO InvoiceDAO = new InvoiceDAO();
         
        //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
         String makeInvoice = InvoiceDAO.InvoiceUser(InvoiceBean);
         
         if(makeInvoice.equals("SUCCESS"))   //On success, you can display a message to user on Home page
         {
            request.getRequestDispatcher("/user.admin.jsp").forward(request, response);
         }
         else   //On Failure, display a meaningful message to the User.
         {
            request.setAttribute("errMessage", makeInvoice);
            request.getRequestDispatcher("/create.invoice.jsp").forward(request, response);
         }
     }
}