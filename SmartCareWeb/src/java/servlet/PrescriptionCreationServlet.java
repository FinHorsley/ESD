/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DOA.PrescriptionDAO;
import beans.PrescriptionBean;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author finhorsley
 */
@WebServlet("/booking") 
public final class PrescriptionCreationServlet extends HttpServlet {
 
     public PrescriptionCreationServlet() {
     }
 
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrescriptionBean prescription = new PrescriptionBean(
                request.getParameter("cId"),
                request.getParameter("medicine"),
                Integer.parseInt(request.getParameter("quantity")),
                Boolean.parseBoolean(request.getParameter("repeating")),
                request.getParameter("issuedate"),
                request.getParameter("enddate")
            );
        
            PrescriptionDAO.insertPrescription(prescription);
     }
}