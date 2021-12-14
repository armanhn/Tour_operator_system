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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;


public class TouristBookTicketSceneController implements Initializable {

    @FXML
    private TextField date;
    @FXML
    private ComboBox<String> dest;
    @FXML
    private RadioButton visa;
    @FXML
    private RadioButton master;
    @FXML
    private RadioButton bkash;
    @FXML
    private TextField passn;
    @FXML
    private TextField packid;

    File f = new File("BookTicket.txt");
    File login = new File("login.bin");
    ToggleGroup group;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        group = new ToggleGroup();
        bkash.setToggleGroup(group);
        master.setToggleGroup(group);
        visa.setToggleGroup(group);
        bkash.setSelected(true);
        
        dest.getItems().addAll("Dhaka","Ctg","Khulna");
        
    }    

    @FXML
    private void submit(ActionEvent event) {
        
        String buydate = date.getText();
        String passNumber = passn.getText();
        String packageid = packid.getText();
        
        String des = dest.getValue().toString();
        
        String pay="";
        if(bkash.isSelected())
        {
            pay = "Bkash";
        }
        else if(master.isSelected())
        {
            pay = "Master";
        }
        else if(visa.isSelected())
        {
            pay = "Visa";
        }
        
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
        
        String concat = str + ","+ buydate + "," +  passNumber + "," + packageid  + "," +des + "," + pay + ",";
        
        
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
    private void prev(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("TouristDashboard.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene2);
        window.show();
    }
    
}
