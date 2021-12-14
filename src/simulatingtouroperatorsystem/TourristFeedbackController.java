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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;


public class TourristFeedbackController implements Initializable {

    @FXML
    private TextField topic;
    @FXML
    private RadioButton travel;
    @FXML
    private RadioButton hotel;
    @FXML
    private TextArea message;

    ToggleGroup group;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       group = new ToggleGroup();
        hotel.setToggleGroup(group);
        travel.setToggleGroup(group);
        hotel.setSelected(true);
    }    

    @FXML
    private void post(ActionEvent event) {
        String t = topic.getText();
        String m = message.getText();
        
        
        
        String type="";
        if(travel.isSelected())
        {
            type = "Travel";
        }
        else if(hotel.isSelected())
        {
            type = "Hotel";
        }
       
        File login = new File("Login.bin");
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
        
        String concat = str + ","+ type + "," +  t + "," + m  + "," ;
        
        File f = new File("TouristFeedback.txt");
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
