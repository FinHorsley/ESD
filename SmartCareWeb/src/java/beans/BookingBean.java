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

    public String getEid() {
        return eid;
    }

    public String getCid() {
        return cid;
    }

    public String getSdate() {
        return sdate;
    }

    public String getStime() {
        return stime;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }
 

}
