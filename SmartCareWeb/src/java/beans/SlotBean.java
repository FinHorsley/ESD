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
    
    public static String getSid() {
        return sid;
    }

    public static void setSid(String sid) {
        SlotBean.sid = sid;
    }

    public static String getEid() {
        return eid;
    }

    public static void setEid(String eid) {
        SlotBean.eid = eid;
    }

    public static String getCid() {
        return cid;
    }

    public static void setCid(String cid) {
        SlotBean.cid = cid;
    }

    public static String getSdate() {
        return sdate;
    }

    public static void setSdate(String sdate) {
        SlotBean.sdate = sdate;
    }

    public static String getStime() {
        return stime;
    }

    public static void setStime(String stime) {
        SlotBean.stime = stime;
    }

    public static String getSreason() {
        return sreason;
    }

    public static void setSreason(String sreason) {
        SlotBean.sreason = sreason;
    }




}
