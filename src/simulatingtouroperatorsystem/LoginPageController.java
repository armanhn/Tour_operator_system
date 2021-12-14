/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatingtouroperatorsystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginPageController implements Initializable {

    @FXML
    private ComboBox<String> user;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    File f = new File("Employees.bin");
    File login = new File("Login.bin");
    File tour = new File("Tourist.bin");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        user.getItems().addAll("Tourist","Manager","Accountant","Travel Counsellor","Tour Guide");
        user.setValue("Tourist");
        
        
    }    

    @FXML
    private void signin(ActionEvent event) throws IOException {
        
        String u = username.getText();
        String p = password.getText();
        
        if(user.getValue().toString() == "Tourist")
        {
            
             try{
            ObjectInputStream in= null;
        in = new ObjectInputStream(new FileInputStream(tour));  
        Tourist t= null;

        try{
            
            while( (t = (Tourist) in.readObject() ) != null )
            {

                   if(t.getPassword().equals(p) && t.getEmail().equals(u) && user.getValue().toString().equals("Tourist"))
                   {
                       
                       Login l = new Login();
                       l.set(u, p);
                       
                         FileOutputStream fos;
                        ObjectOutputStream out=null;
                        try{
                             
                                 out = new ObjectOutputStream(new FileOutputStream(login));
                             
                
                             out.writeObject(l);

                        }catch(Exception ex){

                        }

                        finally{
                           try{
                                out.close();
                            }catch(Exception ex){}
                        }
                       
                       
                       Parent mainSceneParent = FXMLLoader.load(getClass().getResource("TouristDashboard.fxml"));
                        Scene scene1 = new Scene(mainSceneParent);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                        window.setScene(scene1);
                        window.show();
                   }
    
            }
        }
        catch(Exception e1)
        {
        }
        in.close();  
        }catch(Exception e)
        {
            
        }
          
            

        
        
        }
        else if(user.getValue().toString() == "Manager")
        {
            
             try{
                ObjectInputStream in= null;
            in = new ObjectInputStream(new FileInputStream(f));  
            Employee e= null;

            try{
            
            while( (e = (Employee) in.readObject() ) != null )
            {

                   if(e.getPassword().equals(p) && e.getEmail().equals(u) && e.getDesignation().equals(user.getValue()))
                   {
                       
                       Login l = new Login();
                       l.set(u, p);
                       
                         FileOutputStream fos;
                        ObjectOutputStream out=null;
                        try{
                             
                                 out = new ObjectOutputStream(new FileOutputStream(login));
                             
                
                             out.writeObject(l);

                        }catch(Exception ex){

                        }

                        finally{
                           try{
                                out.close();
                            }catch(Exception ex){}
                        }
                       
                       
                             Parent mainSceneParent = FXMLLoader.load(getClass().getResource("ManagerDashboardScene.fxml"));
                                Scene scene1 = new Scene(mainSceneParent);
                                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                                window.setScene(scene1);
                                window.show();
                        }
    
                    }
                }
                catch(Exception e1)
                {
                }
                in.close();  
                }catch(Exception e)
                {

                }
            
       
        }
        else if(user.getValue().toString().equals("Accountant"))
        {
             try{
                ObjectInputStream in= null;
            in = new ObjectInputStream(new FileInputStream(f));  
            Employee e= null;

            try{
            
            while( (e = (Employee) in.readObject() ) != null )
            {

                   if(e.getPassword().equals(p) && e.getEmail().equals(u) && e.getDesignation().equals(user.getValue()))
                   {
                       
                       Login l = new Login();
                       l.set(u, p);
                       
                         FileOutputStream fos;
                        ObjectOutputStream out=null;
                        try{
                             
                                 out = new ObjectOutputStream(new FileOutputStream(login));
                             
                
                             out.writeObject(l);

                        }catch(Exception ex){

                        }

                        finally{
                           try{
                                out.close();
                            }catch(Exception ex){}
                        }
                       
                       
                            Parent mainSceneParent = FXMLLoader.load(getClass().getResource("AccountantDashboardScene.fxml"));
                             Scene scene1 = new Scene(mainSceneParent);
                             Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                             window.setScene(scene1);
                             window.show();
                        }
    
                    }
                }
                catch(Exception e1)
                {
                }
                in.close();  
                }catch(Exception e)
                {

                }
        
        }
        
        
        else if(user.getValue().toString() == "Travel Counsellor")
        {
              try{
                ObjectInputStream in= null;
            in = new ObjectInputStream(new FileInputStream(f));  
            Employee e= null;

            try{
            
            while( (e = (Employee) in.readObject() ) != null )
            {

                   if(e.getPassword().equals(p) && e.getEmail().equals(u) && e.getDesignation().equals(user.getValue()))
                   {
                       
                       Login l = new Login();
                       l.set(u, p);
                       
                         FileOutputStream fos;
                        ObjectOutputStream out=null;
                        try{
                             
                                 out = new ObjectOutputStream(new FileOutputStream(login));
                             
                
                             out.writeObject(l);

                        }catch(Exception ex){

                        }

                        finally{
                           try{
                                out.close();
                            }catch(Exception ex){}
                        }
                       
                       
                           Parent mainSceneParent = FXMLLoader.load(getClass().getResource("TravelCounsellorDashboard.fxml"));
                            Scene scene1 = new Scene(mainSceneParent);
                            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                            window.setScene(scene1);
                            window.show();
                        }
    
                    }
                }
                catch(Exception e1)
                {
                }
                in.close();  
                }catch(Exception e)
                {

                }
        
        }        
        else if(user.getValue().toString() == "Tour Guide")
        {
            
            try{
                ObjectInputStream in= null;
            in = new ObjectInputStream(new FileInputStream(f));  
            Employee e= null;

            try{
            
            while( (e = (Employee) in.readObject() ) != null )
            {

                   if(e.getPassword().equals(p) && e.getEmail().equals(u) && e.getDesignation().equals(user.getValue()))
                   {
                       
                       Login l = new Login();
                       l.set(u, p);
                       
                         FileOutputStream fos;
                        ObjectOutputStream out=null;
                        try{
                             
                                 out = new ObjectOutputStream(new FileOutputStream(login));
                             
                
                             out.writeObject(l);

                        }catch(Exception ex){

                        }

                        finally{
                           try{
                                out.close();
                            }catch(Exception ex){}
                        }
                       
                       
                             Parent mainSceneParent = FXMLLoader.load(getClass().getResource("TourGuideDashboardScene.fxml"));
                                Scene scene1 = new Scene(mainSceneParent);
                                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                                window.setScene(scene1);
                                window.show();
                        }
    
                    }
                }
                catch(Exception e1)
                {
                }
                in.close();  
                }catch(Exception e)
                {

                }
            
            
      
        }
         
        
    }

    @FXML
    private void createAccount(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene1);
        window.show();
        
    }
    
    
    
}
