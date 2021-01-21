/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import beans.PChoiceBean;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author harry
 */
@WebServlet("/createp")
public class setPerscriptionServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public setPerscriptionServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String PChoice = request.getParameter("PChoice"); //geting data from the users database
        System.out.println("PChoice IS: "+ PChoice);
   
        PChoiceBean PBean = new PChoiceBean();
        PBean.setSid(PChoice);
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("prescription.create.jsp");
        dispatcher.forward(request, response);

    }
}
