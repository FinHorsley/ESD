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
public class RegisterBean {

    private String name;
    private String address;
    private String type;
    private String uname;
    private String passwd;

    public String getUserName() {
        return uname;
    }

    public void setUserName(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return passwd;
    }

    public void setPassword(String passwd) {
        this.passwd = passwd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
