/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Harry Marsh
 */
public class EmployeeRegisterBean {

    private String ename;
    private String eaddress;
    private String etype;
    private String euname;
    private String epasswd;

    public String geteUserName() {//getter for class value
        return euname;
    }

    public void seteUserName(String euname) {//setter for class value
        this.euname = euname;
    }

    public String getePassword() {//getter for class value
        return epasswd;
    }

    public void setePassword(String epasswd) {//setter for class value
        this.epasswd = epasswd;
    }

    public void seteName(String ename) {//setter for class value
        this.ename = ename;
    }

    public String geteName() {//getter for class value
        return ename;
    }
    
    public void seteAddress(String eaddress) {//setter for class value
        this.eaddress = eaddress;
    }

    public String geteAddress() {//getter for class value
        return eaddress;
    }
    
    public void seteType(String etype) {//setter for class value
        this.etype = etype;
    }

    public String geteType() {//getter for class value
        return etype;
    }
}
