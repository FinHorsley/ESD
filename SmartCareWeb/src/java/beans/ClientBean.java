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
public class ClientBean {
    
    private static String cid;
    private static String cname;
    private static String caddress;
    private static String ctype;
    private static String uname;
    
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {//setter for class value
        this.cid = cid;
    }

    public String getCname() {//getter for class value
        return cname;
    }

    public void setCname(String cname) {//setter for class value
        this.cname = cname;
    }

    public String getCaddress() {//getter for class value
        return caddress;
    }

    public void setCaddress(String caddress) {//setter for class value
        this.caddress = caddress;
    }

    public String getCtype() {//getter for class value
        return ctype;
    }

    public void setCtype(String ctype) {//setter for class value
        this.ctype = ctype;
    }

    public String getUname() {//getter for class value
        return uname;
    }

    public void setUname(String uname) {//setter for class value
        this.uname = uname;
    }



}
