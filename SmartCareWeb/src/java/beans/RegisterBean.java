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

    public String getUserName() {//getter for class value
        return uname;
    }

    public void setUserName(String uname) { //setter for class value
        this.uname = uname;
    }

    public String getPassword() {//getter for class value
        return passwd;
    }

    public void setPassword(String passwd) {//setter for class value
        this.passwd = passwd;
    }

    public void setName(String name) {//setter for class value
        this.name = name;
    }

    public String getName() {//getter for class value
        return name;
    }
    
    public void setAddress(String address) {//setter for class value
        this.address = address;
    }

    public String getAddress() {//getter for class value
        return address;
    }
    
    public void setType(String type) {//setter for class value
        this.type = type;
    }

    public String getType() {//getter for class value
        return type;
    }
}
