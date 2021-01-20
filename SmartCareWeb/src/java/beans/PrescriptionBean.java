/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.*;

/**
 *
 * @author finhorsley
 */
public class PrescriptionBean {
    private final Integer ID;
    private final String cId;
    private final String medicine;
    private final Integer quantity;
    private final Boolean repeating;
    private final Date issueDate;
    private final Date endDate;
    
    public PrescriptionBean(Integer ID, String cId, String medicine, int quantity, Boolean repeating, Date issueDate, Date endDate){
        this.ID = ID;
        this.cId = cId;
        this.medicine = medicine;
        this.quantity = quantity;
        this.repeating = repeating;
        this.issueDate = issueDate;
        this.endDate = endDate;
    }

    public Integer getID() {
        return ID;
    }

    public String getcId() {
        return cId;
    }

    public String getMedicine() {
        return medicine;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Boolean getRepeating() {
        return repeating;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}