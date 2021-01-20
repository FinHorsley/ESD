/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

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
    private final String issueDate;
    private final String endDate;
    
    public PrescriptionBean(Integer ID, String cId, String medicine, int quantity, Boolean repeating, String issueDate, String endDate){
        this.ID = ID;
        this.cId = cId;
        this.medicine = medicine;
        this.quantity = quantity;
        this.repeating = repeating;
        this.issueDate = issueDate;
        this.endDate = endDate;
    }
    
    public PrescriptionBean(String cId, String medicine, int quantity, Boolean repeating, String issueDate, String endDate){
        this.ID = null;
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

    public String getIssueDate() {
        return issueDate;
    }

    public String getEndDate() {
        return endDate;
    }
}