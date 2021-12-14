/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatingtouroperatorsystem;

import java.io.Serializable;


public class Accountant extends Employee implements Serializable{
     private float totalProfit;

    public void setTotalProfit(float totalProfit) {
        this.totalProfit = totalProfit;
    }

    public float getTotalProfit() {
        return totalProfit;
    }
    
}
