/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatingtouroperatorsystem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;


public class ManagerAddEmployeeController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField id;
    @FXML
    private TextField number;
    @FXML
    private TextField address;
    @FXML
    private ComboBox<String> desig;
    @FXML
    private RadioButton male;
    @FXML
    private RadioButton female;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private TextField salary;

    File f = new File("Employees.bin");
    /**
     * Initializes the controller class.
     */
    ToggleGroup empgrp;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        desig.getItems().addAll("Accountant","Tour Guide","Travel Counsellor","Manager");
        
        empgrp = new ToggleGroup();
        male.setToggleGroup(empgrp);
        female.setToggleGroup(empgrp);
        male.setSelected(true);
    }    

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("ManagerDashboardScene.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene2);
        window.show();
    }

    @FXML
    private void submitOnClick(ActionEvent event) {
        
        String empname = name.getText();
        String empphone = number.getText();
        String empaddress = address.getText();
        String empemail = email.getText();
        String emppass = password.getText();
        float empsal = Float.parseFloat(salary.getText());
        String empid = id.getText();
        
        String empdesig = desig.getValue().toString();
        
        String gender= "";
        if(male.isSelected())
        {
            gender = "Male";
        }
        else
        {
            gender = "female";
        }
        
        
        if(desig.getValue().toString().equals("Accountant"))
        {
            Accountant a = new Accountant();
            a.setEmployee( empname, empphone, empemail, emppass,  empaddress, gender, empid,  empdesig, empsal);
            
            FileOutputStream fos;
            ObjectOutputStream out=null;
            try{
                 if(f.exists())
                 {
                     out = new AppendableObjectOutputStream(new FileOutputStream(f,true));
                 }
                 else
                 {
                     out = new ObjectOutputStream(new FileOutputStream(f));
                 }
                 
                 out.writeObject(a);
                 
            }catch(Exception e){
             
            }
    
            finally{
               try{
                    out.close();
                }catch(Exception ex){}
            }
        }
        
         if(desig.getValue().toString().equals("Tour Guide"))
        {
            Guide g = new Guide();
            g.setEmployee( empname, empphone, empemail, emppass,  empaddress, gender, empid,  empdesig, empsal);
            
            FileOutputStream fos;
            ObjectOutputStream out=null;
            try{
                 if(f.exists())
                 {
                     out = new AppendableObjectOutputStream(new FileOutputStream(f,true));
                 }
                 else
                 {
                     out = new ObjectOutputStream(new FileOutputStream(f));
                 }
                 
                 out.writeObject(g);
                 
            }catch(Exception e){
             
            }
    
            finally{
               try{
                    out.close();
                }catch(Exception ex){}
            }
        }
         
         
         
        if(desig.getValue().toString().equals("Travel Counsellor"))
        {
            Counsellor c = new Counsellor();
            c.setEmployee( empname, empphone, empemail, emppass,  empaddress, gender, empid,  empdesig, empsal);
            
            FileOutputStream fos;
            ObjectOutputStream out=null;
            try{
                 if(f.exists())
                 {
                     out = new AppendableObjectOutputStream(new FileOutputStream(f,true));
                 }
                 else
                 {
                     out = new ObjectOutputStream(new FileOutputStream(f));
                 }
                 
                 out.writeObject(c);
                 
            }catch(Exception e){
             
            }
    
            finally{
               try{
                    out.close();
                }catch(Exception ex){}
            }
        }
        
        if(desig.getValue().toString().equals("Manager"))
        {
            Manager m = new Manager();
            m.setEmployee( empname, empphone, empemail, emppass,  empaddress, gender, empid,  empdesig, empsal);
            
            FileOutputStream fos;
            ObjectOutputStream out=null;
            try{
                 if(f.exists())
                 {
                     out = new AppendableObjectOutputStream(new FileOutputStream(f,true));
                 }
                 else
                 {
                     out = new ObjectOutputStream(new FileOutputStream(f));
                 }
                 
                 out.writeObject(m);
                 
            }catch(Exception e){
             
            }
    
            finally{
               try{
                    out.close();
                }catch(Exception ex){}
            }
        }
        
        
    }
    
    
    
    class AppendableObjectOutputStream extends ObjectOutputStream {
    public AppendableObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {}
    } 
    
}
