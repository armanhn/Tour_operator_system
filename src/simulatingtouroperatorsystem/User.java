/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatingtouroperatorsystem;

import java.io.Serializable;


public abstract class User implements Serializable{
    
    private String name;
    private String phone;
    private String email;
    private String password;
    private String address;
    private String gender;
    
    
    public void setUser(String name,String phone,String email,String password, String address,String gender)
    {
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.password = password;
        this.email = email;
        this.phone = phone;
        
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    
    
    
    
}
