/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatingtouroperatorsystem;

import java.io.Serializable;

/**
 *
 * @author emo
 */
public class Queries implements Serializable{
    
    private String customeremail;
    private String type;
    private String subject;
    private String message;
    
    public void setQueries(String customeremail,String type,String subject,String message)
    {
        this.customeremail = customeremail;
        this.type = type;
        this.subject = subject;
        this.message = message ;
    }

    public String getType() {
        return type;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCustomerEmail() {
        return customeremail;
    }

    public void setCustomerEmail(String customeremail) {
        this.customeremail = customeremail;
    }
    
    
    
}
