/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatingtouroperatorsystem;

import java.io.Serializable;


public class Login implements Serializable{
    String e;
    String p;
    
    
    public void set(String e,String p)
    {
        this.e = e;
        this.p = p;
    }

    public void setE(String e) {
        this.e = e;
    }

    public void setP(String p) {
        this.p = p;
    }

    public String getE() {
        return e;
    }

    public String getP() {
        return p;
    }
    
    
    
}
