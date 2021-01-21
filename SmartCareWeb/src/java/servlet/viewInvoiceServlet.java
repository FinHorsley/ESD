/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;
//--------------imports
import DAO.DBConnection;
import DAO.DBConnection;
import DAO.UserDAO;
import beans.ClientBean;
import beans.EmployeeBean;
import beans.InvoiceBean;
import beans.PrescriptionBean;
import beans.SlotBean;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//--------------imports

/**
 *
 * @author Kamil Lukomski

 */

@WebServlet("/viewinvoice")
public class viewInvoiceServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public viewInvoiceServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        String IID = request.getParameter("InvoiceChoice"); //geting data from form in viewinvoice.jsp

        try {
            Connection con = null; //conection to the database
            con = DBConnection.createConnection(); //using the java class DBConnection to connnect to db
            String sql = "select * from invoice where iid=?"; //query for collecting data from the database.
            PreparedStatement statement = con.prepareStatement(sql); //exacute query against the prepared statment
            statement.setString(1, IID); //setting the "?" to the variable IID

            ResultSet result = statement.executeQuery();//Exacute query
            
            //create a new invoice class
            InvoiceBean IBean = null;
            if (result.next()) {
                IBean = new InvoiceBean();
                IBean.setIID(result.getString("iid")); //setting varibles to the class values
                IBean.setEID(result.getString("eid")); //setting varibles to the class values
                IBean.setCID(result.getString("cid")); //setting varibles to the class values
                IBean.setSID(result.getString("sid")); //setting varibles to the class values

            }
            String EID = IBean.getEID(); //getting values from the class 

            Connection con1 = null; //conection to the database
            con1 = DBConnection.createConnection(); //using the java class DBConnection to connnect to db
            String sql1 = "select * from employee where eid=?"; //query for collecting data from the database.
            PreparedStatement statement1 = con1.prepareStatement(sql1);
            statement1.setString(1, EID);

            ResultSet result1 = statement1.executeQuery();
            EmployeeBean EBean = null;
            if (result1.next()) {
                EBean = new EmployeeBean();
                EBean.setEid(result1.getString("eid"));//setting the varibles to class values based of the forms submited reasults
                EBean.setEname(result1.getString("ename"));//setting the varibles to class values based of the forms submited reasults
                EBean.setEaddress(result1.getString("eaddress"));//setting the varibles to class values based of the forms submited reasults
                EBean.setUname(result1.getString("uname"));//setting the varibles to class values based of the forms submited reasults
            }

            String CID = IBean.getCID();
            String ENAME = EBean.getEname();
            System.out.println("CID IS: " + CID);

            Connection con2 = null; //conection to the database
            con2 = DBConnection.createConnection(); //using the java class DBConnection to connnect to db
            String sql2 = "select * from clients where cid=?"; //query for collecting data from the database.
            PreparedStatement statement2 = con2.prepareStatement(sql2);
            statement2.setString(1, CID);

            ResultSet result2 = statement2.executeQuery();

            ClientBean CBean = null;
            if (result2.next()) {
                CBean = new ClientBean();
                CBean.setCid(result2.getString("cid"));//setting the varibles to class values based of the forms submited reasults
                CBean.setCname(result2.getString("cname"));//setting the varibles to class values based of the forms submited reasults
                CBean.setCaddress(result2.getString("caddress"));//setting the varibles to class values based of the forms submited reasults
                CBean.setCtype(result2.getString("ctype"));//setting the varibles to class values based of the forms submited reasults
                CBean.setUname(result2.getString("uname"));//setting the varibles to class values based of the forms submited reasults
            }

            String SID = IBean.getSID();
            Connection con3 = null; //conection to the database
            con3 = DBConnection.createConnection(); //using the java class DBConnection to connnect to db
            String sql3 = "select * from booking_slots where sid=?"; //query for collecting data from the database.
            PreparedStatement statement3 = con3.prepareStatement(sql3);
            statement3.setString(1, SID);

            ResultSet result3 = statement3.executeQuery();

            SlotBean SBean = null;
            if (result3.next()) {
                SBean = new SlotBean();
                SBean.setCid(result3.getString("sid"));//setting the varibles to class values based of the forms submited reasults
                SBean.setEid(result3.getString("eid"));//setting the varibles to class values based of the forms submited reasults
                SBean.setCid(result3.getString("cid"));//setting the varibles to class values based of the forms submited reasults
                SBean.setSdate(result3.getString("sdate"));//setting the varibles to class values based of the forms submited reasults
                SBean.setStime(result3.getString("stime"));//setting the varibles to class values based of the forms submited reasults
                SBean.setSreason(result3.getString("sreason"));//setting the varibles to class values based of the forms submited reasults
            }
            String PID = IBean.getPID();
            Connection con4 = null; //conection to the database
            con4 = DBConnection.createConnection(); //using the java class DBConnection to connnect to db
            String sql4 = "select * from prescription where pid=?"; //query for collecting data from the database.
            PreparedStatement statement4 = con4.prepareStatement(sql4);
            statement4.setString(1, PID);

            ResultSet result4 = statement4.executeQuery();

            PrescriptionBean PBean = null;
            if (result4.next()) {
                PBean = new PrescriptionBean();
                PBean.setPid(result4.getString("pid"));//setting the varibles to class values based of the forms submited reasults
                PBean.setCid(result4.getString("cid"));//setting the varibles to class values based of the forms submited reasults
                PBean.setSid(result4.getString("sid"));//setting the varibles to class values based of the forms submited reasults
                PBean.setMedicine(result4.getString("medicine"));//setting the varibles to class values based of the forms submited reasults
                PBean.setQuantity(result4.getString("quantity"));//setting the varibles to class values based of the forms submited reasults
                PBean.setRepeating(result4.getString("repeating"));//setting the varibles to class values based of the forms submited reasults
                PBean.setIssuedate(result4.getString("issuedate"));//setting the varibles to class values based of the forms submited reasults
                PBean.setEnddate(result4.getString("enddate"));//setting the varibles to class values based of the forms submited reasults
            }

        } catch (SQLException e) {

        }
        //request dispatcha to redirect the servlet to the genrate.invoice.jsp page once it has completed its operations
        RequestDispatcher dispatcher = request.getRequestDispatcher("generate.invoice.jsp");
        dispatcher.forward(request, response);

    }
}
