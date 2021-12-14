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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class ManagerNewPackageController implements Initializable {

    @FXML
    private TextField dest;
    @FXML
    private TextField dur;
    @FXML
    private TextField price;
    @FXML
    private TextArea details;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("ManagerDashboardScene.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void submit(ActionEvent event) {
        String destination = dest.getText();
        String duration = dur.getText();
        String cost = price.getText();
        String info = details.getText();
        
        
        
        
       
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
        
        String concat = str + ","+ destination + "," +  duration + "," + cost  + "," + info  + ",";
        
        File f = new File("NewPackages.txt");
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
    
}
