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
public class PrescriptionBean {

    private static String pid;
    private static String cid;
    private static String sid;
    private static String medicine;
    private static String quantity;
    private static String repeating;
    private static String issuedate;
    private static String enddate;

    public String getPid() {//getter for class value
        return pid;
    }

    public void setPid(String pid) {//setter for class value
        this.pid = pid;
    }

    public String getCid() {//getter for class value
        return cid;
    }

    public void setCid(String cid) {//setter for class value
        this.cid = cid;
    }

    public String getSid() {//getter for class value
        return sid;
    }

    public void setSid(String sid) {//setter for class value
        this.sid = sid;
    }

    public String getMedicine() {//getter for class value
        return medicine;
    }

    public void setMedicine(String medicine) {//setter for class value
        this.medicine = medicine;
    }

    public String getQuantity() {//getter for class value
        return quantity;
    }

    public void setQuantity(String quantity) {//setter for class value
        this.quantity = quantity;
    }

    public String getRepeating() {//getter for class value
        return repeating;
    }

    public void setRepeating(String repeating) {//setter for class value
        this.repeating = repeating;
    }

    public String getIssuedate() {//getter for class value
        return issuedate;
    }

    public void setIssuedate(String issuedate) {//setter for class value
        this.issuedate = issuedate;
    }

    public String getEnddate() {//getter for class value
        return enddate;
    }

    public void setEnddate(String enddate) {//setter for class value
        this.enddate = enddate;
    }

}
