/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;
//--------------imports
import DAO.DBConnection;
import DAO.OperationDAO;
import beans.OperationBean;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
@WebServlet("/OperationCreation")
public class OperationRegisterServlet extends HttpServlet {

    public OperationRegisterServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Copying all the input parameters in to local variables
        String EID = request.getParameter("EmployeeChoice");//getting the varibles from the form of jsp file
        String CID = request.getParameter("ClientChoice");//getting the varibles from the form of jsp file
        String ODATE = request.getParameter("odate");//getting the varibles from the form of jsp file
        String OTIME = request.getParameter("otime");//getting the varibles from the form of jsp file
        String NSLOT = request.getParameter("nslot");//getting the varibles from the form of jsp file

        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        OperationBean OperationBean = new OperationBean();
        try {
            con = DBConnection.createConnection(); //connecting to database
            //connecting to database
            statement = con.createStatement();
            String sql = "SELECT * FROM default_prices"; //select statment for getting prices from the database
            resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                String CHARGE = resultSet.getString("operation");//getting the varibles from the form of jsp file
                OperationBean.setCharge(CHARGE);
            }
        } catch (SQLException e) {
        }
        
        //Using Java Beans - An easiest way to play with group of related data
        OperationBean.setEid(EID);//setting the varibles to class values based of the forms submited reasults
        OperationBean.setCid(CID);//setting the varibles to class values based of the forms submited reasults
        OperationBean.setOdate(ODATE); //setting the varibles to class values based of the forms submited reasults
        OperationBean.setOtime(OTIME);  //setting the varibles to class values based of the forms submited reasults
        OperationBean.setNslot(NSLOT); //setting the varibles to class values based of the forms submited reasults
        

        OperationDAO OperationDAO = new OperationDAO();

        //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
        String bookingRegistered = OperationDAO.Operation(OperationBean);

        if (bookingRegistered.equals("SUCCESS")) //On success, you can display a message to user on Home page
        {        //request dispatcha to redirect the servlet to the genrate.invoice.jsp page once it has completed its operations
            request.getRequestDispatcher("/user.client.jsp").forward(request, response);
        } else //On Failure, display a meaningful message to the User.
        {        //request dispatcha to redirect the servlet to the genrate.invoice.jsp page once it has completed its operations
            request.setAttribute("errMessage", bookingRegistered);
            request.getRequestDispatcher("/booking.jsp").forward(request, response);
        }
    }
}
