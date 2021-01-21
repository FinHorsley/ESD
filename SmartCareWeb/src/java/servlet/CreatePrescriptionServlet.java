/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;
//--------------imports
import DAO.CreatePrescriptionDAO;
import beans.PChoiceBean;
import beans.PrescriptionBean;
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
@WebServlet("/setp")
public class CreatePrescriptionServlet extends HttpServlet {

    public CreatePrescriptionServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//Copying all the input parameters in to local variables
        String SID = PChoiceBean.sid;
        
        String CID = request.getParameter("ClientChoice");//getting the varibles from the form of jsp file
        String MedicineName = request.getParameter("MedicineName");//getting the varibles from the form of jsp file
        String MedicineQuantity = request.getParameter("MedicineQuantity");//getting the varibles from the form of jsp file
        String Repeat = request.getParameter("repeatp");//getting the varibles from the form of jsp file
        String StartDate = request.getParameter("pStartDate");//getting the varibles from the form of jsp file
        String EndDate = request.getParameter("pEndDate");//getting the varibles from the form of jsp file

//Using Java Beans - An easiest way to play with group of related data
        PrescriptionBean PPBean = null;
        PPBean = new PrescriptionBean();

        PPBean.setSid(SID);//setting the varibles to class values based of the forms submited reasults
        PPBean.setCid(CID);//setting the varibles to class values based of the forms submited reasults
        PPBean.setMedicine(MedicineName);//setting the varibles to class values based of the forms submited reasults
        PPBean.setQuantity(MedicineQuantity);//setting the varibles to class values based of the forms submited reasults
        PPBean.setRepeating(Repeat);//setting the varibles to class values based of the forms submited reasults
        PPBean.setIssuedate(StartDate);//setting the varibles to class values based of the forms submited reasults
        PPBean.setEnddate(EndDate); //setting the varibles to class values based of the forms submited reasults

        CreatePrescriptionDAO CreatePrescriptionDAO = new CreatePrescriptionDAO();

        //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
        String bookingRegistered = CreatePrescriptionDAO.PrescriptionCreate(PPBean);

        if (bookingRegistered.equals("SUCCESS")) //On success, you can display a message to user on Home page
        {        //request dispatcha to redirect the servlet to the genrate.invoice.jsp page once it has completed its operations
            request.getRequestDispatcher("/user.nurse.jsp").forward(request, response);
        } else //On Failure, display a meaningful message to the User.
        {        //request dispatcha to redirect the servlet to the genrate.invoice.jsp page once it has completed its operations
            request.setAttribute("errMessage", bookingRegistered);
            request.getRequestDispatcher("/prescription.create.jsp").forward(request, response);
        }

    }
}
