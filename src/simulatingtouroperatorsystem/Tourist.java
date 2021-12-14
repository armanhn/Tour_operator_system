/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatingtouroperatorsystem;

import java.io.Serializable;
import java.util.ArrayList;


public class Tourist extends User implements Serializable{
    
    private String feedback;
    private String destination;
    private String date;
    private String passportNumber ;
    private String packageId;
    private String paymentMethod;
    
    
    public void setTourist(String name,String phone,String email,String password, String address,String gender)
    {
         setUser(name,phone,email,password,address,gender);
    }
    
    public void bookTicket(String destination,String date, String passportNumber,String packageId,String paymentMethod)
    {
        this.date = date;
        this.destination = destination;
        this.packageId = packageId;
        this.passportNumber = passportNumber;
        this.paymentMethod = paymentMethod;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getFeedback() {
        return feedback;
    }

    public String getDestination() {
        return destination;
    }

    public String getDate() {
        return date;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getPackageId() {
        return packageId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
    
    
    
}
