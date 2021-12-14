/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatingtouroperatorsystem;

import java.io.Serializable;


public abstract class Employee extends User implements Serializable{

    
    
    private String employeeId;
    private String designation;
    private float salary;
    
    public void setEmployee(String name,String phone,String email,String password, String address,String gender,String employeeId, String designation,float salary)
    {
        setUser(name,phone,email,password,address,gender);
        
        this.employeeId = employeeId;
        this.designation = designation;
        this.salary = salary;
    }
    
    
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getDesignation() {
        return designation;
    }

    public float getSalary() {
        return salary;
    }
    
    
    
    
    
    
}
