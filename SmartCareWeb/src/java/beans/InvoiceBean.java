/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author kamil
 */
public class InvoiceBean {
    
    private String ClientName;
    private String ClientID;
    private String ClientAddress;
    private String ConsultationType;
    private String ConsultationTime;

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String ClientName) {
        this.ClientName = ClientName;
    }

    public String getClientID() {
        return ClientID;
    }

    public void setClientID(String ClientID) {
        this.ClientID = ClientID;
    }

    public String getClientAddress() {
        return ClientAddress;
    }

    public void setClientAddress(String ClientAddress) {
        this.ClientAddress = ClientAddress;
    }

    public String getConsultationType() {
        return ConsultationType;
    }

    public void setConsultationType(String ConsultationType) {
        this.ConsultationType = ConsultationType;
    }

    public String getConsultationTime() {
        return ConsultationTime;
    }

    public void setConsultationTime(String ConsultationTime) {
        this.ConsultationTime = ConsultationTime;
    }

    

    
}
