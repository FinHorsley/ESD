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
    
    public static String getPID() {
        return PID;
    }

    public static void setPID(String PID) {
        InvoiceBean.PID = PID;
    }
    

    public String getIID() {
        return IID;
    }

    public void setIID(String IID) {
        this.IID = IID;
    }

    public String getEID() {
        return EID;
    }

    public void setEID(String EID) {
        this.EID = EID;
    }

    public String getCID() {
        return CID;
    }

    public void setCID(String CID) {
        this.CID = CID;
    }

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }


}
