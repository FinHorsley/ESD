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

    public String geteUserName() {
        return euname;
    }

    public void seteUserName(String euname) {
        this.euname = euname;
    }

    public String getePassword() {
        return epasswd;
    }

    public void setePassword(String epasswd) {
        this.epasswd = epasswd;
    }

    public void seteName(String ename) {
        this.ename = ename;
    }

    public String geteName() {
        return ename;
    }
    
    public void seteAddress(String eaddress) {
        this.eaddress = eaddress;
    }

    public String geteAddress() {
        return eaddress;
    }
    
    public void seteType(String etype) {
        this.etype = etype;
    }

    public String geteType() {
        return etype;
    }
}
