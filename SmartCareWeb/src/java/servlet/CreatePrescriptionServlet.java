/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DOA.CreatePrescriptionDAO;
import beans.PChoiceBean;
import beans.PrescriptionBean;
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
@WebServlet("/setp")
public class CreatePrescriptionServlet extends HttpServlet {

    public CreatePrescriptionServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//Copying all the input parameters in to local variables
        String SID = PChoiceBean.sid;
        
        
        System.out.println("SID BEFORE CREATION = " + SID);

        String CID = request.getParameter("ClientChoice");
        String MedicineName = request.getParameter("MedicineName");
        String MedicineQuantity = request.getParameter("MedicineQuantity");
        String Repeat = request.getParameter("repeatp");
        String StartDate = request.getParameter("pStartDate");
        String EndDate = request.getParameter("pEndDate");

//Using Java Beans - An easiest way to play with group of related data
        PrescriptionBean PPBean = null;
        PPBean = new PrescriptionBean();

        PPBean.setSid(SID);
        PPBean.setCid(CID);
        PPBean.setMedicine(MedicineName);
        PPBean.setQuantity(MedicineQuantity);
        PPBean.setRepeating(Repeat);
        PPBean.setIssuedate(StartDate);
        PPBean.setEnddate(EndDate);

        CreatePrescriptionDAO CreatePrescriptionDAO = new CreatePrescriptionDAO();

        //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
        String bookingRegistered = CreatePrescriptionDAO.PrescriptionCreate(PPBean);

        if (bookingRegistered.equals("SUCCESS")) //On success, you can display a message to user on Home page
        {
            request.getRequestDispatcher("/user.nurse.jsp").forward(request, response);
        } else //On Failure, display a meaningful message to the User.
        {
            request.setAttribute("errMessage", bookingRegistered);
            request.getRequestDispatcher("/prescription.create.jsp").forward(request, response);
        }

    }
}
