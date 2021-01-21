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
public class SlotBean {
    private static String sid;
    private static String eid;
    private static String cid;
    private static String sdate;
    private static String stime;
    private static String sreason;
    
    public static String getSid() {//getter for class value
        return sid;
    }

    public static void setSid(String sid) {//setter for class value
        SlotBean.sid = sid;
    }

    public static String getEid() {//getter for class value
        return eid;
    }

    public static void setEid(String eid) {//setter for class value
        SlotBean.eid = eid;
    }

    public static String getCid() {//getter for class value
        return cid;
    }

    public static void setCid(String cid) {//setter for class value
        SlotBean.cid = cid;
    }

    public static String getSdate() {//getter for class value
        return sdate;
    }

    public static void setSdate(String sdate) {//setter for class value
        SlotBean.sdate = sdate;
    }

    public static String getStime() {//getter for class value
        return stime;
    }

    public static void setStime(String stime) {//setter for class value
        SlotBean.stime = stime;
    }

    public static String getSreason() {//getters for class value
        return sreason;
    }

    public static void setSreason(String sreason) {//setter for class value
        SlotBean.sreason = sreason;
    }




}
