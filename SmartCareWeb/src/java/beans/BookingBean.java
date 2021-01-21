/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Harry Marsh & Kamil Lukomski
 */
public class BookingBean {

    private String eid;
    private String cid;
    private String sdate;
    private String stime;
    private String sreason;

    public String getEid() {//getter for class value
        return eid;
    }

    public String getCid() {//getter for class value
        return cid;
    }

    public String getSdate() {//getter for class value
        return sdate;
    }

    public String getStime() {//getter for class value
        return stime;
    }

    public String getSreason() {//getter for class value
        return sreason;
    }

    public void setEid(String eid) {//setter for class value
        this.eid = eid;
    }

    public void setCid(String cid) {//setter for class value
        this.cid = cid;
    }

    public void setSdate(String sdate) {//setter for class value
        this.sdate = sdate;
    }

    public void setStime(String stime) {//setter for class value
        this.stime = stime;
    }

    public void setSreason(String sreason) {//setter for class value
        this.sreason = sreason;
    }

}
