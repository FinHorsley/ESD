/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net;

/**
 *
 * @author harry
 */
// User profiles
public class LoginBean {

    private String uname;
    private String passwd;

    public String getuname() {
        return uname;
    }

    public void setuname(String uname) {
        this.uname = uname;
    }

    public String getpasswd() {
        return passwd;
    }

    public void setpasswd(String passwd) {
        this.passwd = passwd;
    }
}
