/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DOA.DBConnection;
import DOA.UserDAO;
import beans.ClientBean;
import beans.EmployeeBean;
import beans.InvoiceBean;
import beans.PrescriptionBean;
import beans.SlotBean;
import beans.UserBean;
import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author harry
 */
@WebServlet("/viewinvoice")
public class viewInvoiceServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public viewInvoiceServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String IID = request.getParameter("InvoiceChoice"); //geting data from the users database
        System.out.println("IID IS: " + IID);

        try {
            Connection con = null; //conection to the database
            con = DBConnection.createConnection(); //using the java class DBConnection to connnect to db
            String sql = "select * from invoice where iid=?"; //query for collecting data from the database.
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, IID);

            ResultSet result = statement.executeQuery();
            InvoiceBean IBean = null;
            if (result.next()) {
                IBean = new InvoiceBean();
                IBean.setIID(result.getString("iid"));
                IBean.setEID(result.getString("eid"));
                IBean.setCID(result.getString("cid"));
                IBean.setSID(result.getString("sid"));

            }
            String EID = IBean.getEID();
            System.out.println("EID IS: " + EID);

            Connection con1 = null; //conection to the database
            con1 = DBConnection.createConnection(); //using the java class DBConnection to connnect to db
            String sql1 = "select * from employee where eid=?"; //query for collecting data from the database.
            PreparedStatement statement1 = con1.prepareStatement(sql1);
            statement1.setString(1, EID);

            ResultSet result1 = statement1.executeQuery();
            EmployeeBean EBean = null;
            if (result1.next()) {
                EBean = new EmployeeBean();
                EBean.setEid(result1.getString("eid"));
                EBean.setEname(result1.getString("ename"));
                EBean.setEaddress(result1.getString("eaddress"));
                EBean.setUname(result1.getString("uname"));
            }

            String CID = IBean.getCID();
            String ENAME = EBean.getEname();
            System.out.println("CID IS: " + CID);
            System.out.println("Ename IS: " + ENAME);

            Connection con2 = null; //conection to the database
            con2 = DBConnection.createConnection(); //using the java class DBConnection to connnect to db
            String sql2 = "select * from clients where cid=?"; //query for collecting data from the database.
            PreparedStatement statement2 = con2.prepareStatement(sql2);
            statement2.setString(1, CID);

            ResultSet result2 = statement2.executeQuery();

            ClientBean CBean = null;
            if (result2.next()) {
                CBean = new ClientBean();
                CBean.setCid(result2.getString("cid"));
                CBean.setCname(result2.getString("cname"));
                CBean.setCaddress(result2.getString("caddress"));
                CBean.setCtype(result2.getString("ctype"));
                CBean.setUname(result2.getString("uname"));
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
                SBean.setCid(result3.getString("sid"));
                SBean.setEid(result3.getString("eid"));
                SBean.setCid(result3.getString("cid"));
                SBean.setSdate(result3.getString("sdate"));
                SBean.setStime(result3.getString("stime"));
                SBean.setSreason(result3.getString("sreason"));
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
                PBean.setPid(result4.getString("pid"));
                PBean.setCid(result4.getString("cid"));
                PBean.setSid(result4.getString("sid"));
                PBean.setMedicine(result4.getString("medicine"));
                PBean.setQuantity(result4.getString("quantity"));
                PBean.setRepeating(result4.getString("repeating"));
                PBean.setIssuedate(result4.getString("issuedate"));
                PBean.setEnddate(result4.getString("enddate"));
            }

        } catch (SQLException e) {

        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("generate.invoice.jsp");
        dispatcher.forward(request, response);

    }
}
