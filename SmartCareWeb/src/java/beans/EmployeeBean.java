/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author harry
 */
public class EmployeeBean {
    private static String eid;
    private static String ename;
    private static String eaddress;
    private static String uname;
    
    public String getEid() {//getter for class value
        return eid;
    }

    public void setEid(String eid) {//setter for class value
        this.eid = eid;
    }

    public String getEname() {//getter for class value
        return ename;
    }

    public void setEname(String ename) {//setter for class value
        this.ename = ename;
    }

    public String getEaddress() {//getter for class value
        return eaddress;
    }

    public void setEaddress(String eaddress) {//setter for class value
        this.eaddress = eaddress;
    }

    public String getUname() {//getter for class value
        return uname;
    }

    public void setUname(String uname) {//setter for class value
        this.uname = uname;
    }

}
