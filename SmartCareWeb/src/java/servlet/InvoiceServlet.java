/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;
//--------------imports
import beans.InvoiceBean;
import DAO.InvoiceDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 //--------------imports
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
         String EmployeeID = request.getParameter("EmployeeChoice"); //getting the varibles from the form of jsp file
         String ClientID = request.getParameter("ClientChoice"); //getting the varibles from the form of jsp file
         String SlotID = request.getParameter("SlotChoice"); //getting the varibles from the form of jsp file
         String PrescriptionID = request.getParameter("PrescriptionChoice"); //getting the varibles from the form of jsp file
         
         InvoiceBean InvoiceBean = new InvoiceBean();
        //Using Java Beans - An easiest way to play with group of related data
         InvoiceBean.setEID(EmployeeID); //setting the varibles to class values based of the forms submited reasults
         InvoiceBean.setCID(ClientID); //setting the varibles to class values based of the forms submited reasults
         InvoiceBean.setSID(SlotID); //setting the varibles to class values based of the forms submited reasults
         InvoiceBean.setPID(PrescriptionID); //setting the varibles to class values based of the forms submited reasults
         
         InvoiceDAO InvoiceDAO = new InvoiceDAO();
         
        //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
         String makeInvoice = InvoiceDAO.InvoiceUser(InvoiceBean);
         
         if(makeInvoice.equals("SUCCESS"))   //On success, you can display a message to user on Home page
         {        //request dispatcha to redirect the servlet to the genrate.invoice.jsp page once it has completed its operations
            request.getRequestDispatcher("/user.admin.jsp").forward(request, response);
         }
         else   //On Failure, display a meaningful message to the User.
         {        //request dispatcha to redirect the servlet to the genrate.invoice.jsp page once it has completed its operations
            request.setAttribute("errMessage", makeInvoice);
            request.getRequestDispatcher("/create.invoice.jsp").forward(request, response);
         }
     }
}