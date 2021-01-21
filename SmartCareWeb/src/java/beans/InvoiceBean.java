/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author kamil
 */
public class InvoiceBean {
    
    private static String IID;
    private static String EID;
    private static String CID;
    private static String SID;
    private static String PID;
    
    public static String getPID() {//getter for class value
        return PID;
    }

    public static void setPID(String PID) {//setter for class value
        InvoiceBean.PID = PID;
    }
    

    public String getIID() {//getter for class value
        return IID;
    }

    public void setIID(String IID) {//setter for class value
        this.IID = IID;
    }

    public String getEID() {//getter for class value
        return EID;
    }

    public void setEID(String EID) {//setter for class value
        this.EID = EID;
    }

    public String getCID() {//getter for class value
        return CID;
    }

    public void setCID(String CID) {//setter for class value
        this.CID = CID;
    }

    public String getSID() {//getter for class value
        return SID;
    }

    public void setSID(String SID) {//setter for class value
        this.SID = SID;
    }


}
