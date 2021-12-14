/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatingtouroperatorsystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author arman
 */
public class TouristHireGuideController implements Initializable {

    @FXML
    private ComboBox<String> location;
    @FXML
    private TextField date;
    @FXML
    private TextArea msg;
    
    File login = new File("Login.bin");
    File f = new File("HireGuideList.txt");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        location.getItems().addAll("Dhaka","CTG","Khulna");
    }    

    @FXML
    private void hire(ActionEvent event) {
        
        String buydate = date.getText();
        String message = msg.getText();
        
        
        String des = location.getValue().toString();
        
       
        
        String str = "";
        try{
            ObjectInputStream in= null;
        in = new ObjectInputStream(new FileInputStream(login));  
        Login l= null;
        
        try{
            
            while( (l = (Login) in.readObject() ) != null )
            {

                    str = l.getE();
    
            }
        }
        catch(Exception e1)
        {
        }
        in.close();  
        }catch(Exception e)
        {
            
        }
        
        String concat = str + ","+ buydate + "," +  message + "," ;
        
        
        FileWriter fw = null;
          BufferedWriter bw = null;
          try{
              
              if(f.exists())
              {
                  fw = new FileWriter(f,true);
              }
              else
              {
                  fw = new FileWriter(f);
              }
              
              bw = new BufferedWriter(fw);
              
              bw.write(concat);
              
              bw.close();
              fw.close();
      
          }catch(Exception e)
          {
              
          }
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("TouristDashboard.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene2);
        window.show();
    }
    
}
