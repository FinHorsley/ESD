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
public class UserBean {

    public static String uname;
    public static String role;
    private String passwd;
    
    public String getUname() {
        return uname;
    }

    public String getRole() {
        return role;
    }

    public String getPasswd() {
        return passwd;
    }
    
    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    
}
