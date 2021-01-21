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
    
    public String getUname() { //getter for class value
        return uname;
    }

    public String getRole() { //getter for class value
        return role;
    }

    public String getPasswd() { //getter for class value
        return passwd;
    }
    
    public void setUname(String uname) { //setter for class value
        this.uname = uname;
    }

    public void setRole(String role) {//setter for class value
        this.role = role;
    }

    public void setPasswd(String passwd) {//setter for class value
        this.passwd = passwd;
    }
    
}
