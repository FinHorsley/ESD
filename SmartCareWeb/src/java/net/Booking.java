/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net;

/**
 *
 * @author kamil
 */
public class Booking {
    private int employeeID;
    private int clientID;
    private int slotDate;
    private int slotTime;

    /**
     * @return the employeeID
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * @param employeeID the employeeID to set
     */
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * @return the clientID
     */
    public int getClientID() {
        return clientID;
    }

    /**
     * @param clientID the clientID to set
     */
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    /**
     * @return the slotDate
     */
    public int getSlotDate() {
        return slotDate;
    }

    /**
     * @param slotDate the slotDate to set
     */
    public void setSlotDate(int slotDate) {
        this.slotDate = slotDate;
    }

    /**
     * @return the slotTime
     */
    public int getSlotTime() {
        return slotTime;
    }

    /**
     * @param slotTime the slotTime to set
     */
    public void setSlotTime(int slotTime) {
        this.slotTime = slotTime;
    }


}
