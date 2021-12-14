/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatingtouroperatorsystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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

/**
 * FXML Controller class
 *
 * @author arman
 */
public class TravelCounsellorAdviseClientsController implements Initializable {

    @FXML
    private TextField clientTxtfield;
    @FXML
    private TextField destinationTxtfield;
    @FXML
    private TextField durationTxtfield;
    @FXML
    private TextField priceTxtfield;
    @FXML
    private TextArea adviseTxt;
    @FXML
    private TextArea hoteltext;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File f1 = new File("Queries.bin");
         ObjectInputStream in= null;
        try {  
            in = new ObjectInputStream(new FileInputStream(f1));
             Queries s=null;
        String str = "";
        try{
          
            while( (s = (Queries) in.readObject() ) != null )
            {
                if(s.getType().equals("Hotel"))
                {
                   str =  str  + s.getCustomerEmail() + "," +s.getSubject() + "," + s.getMessage() + "\n";

                }

    
            }
            
         
        }
        catch(Exception e1)
        {
        }
        in.close();  
        hoteltext.setText(str);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccounantRefundQueriesSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AccounantRefundQueriesSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }    

    @FXML
    private void submitButtonOnClick(ActionEvent event) {
    
        String client = clientTxtfield.getText();
        String destination = destinationTxtfield.getText();
        String duration = durationTxtfield.getText();
        String price = priceTxtfield.getText();
        String advice = adviseTxt.getText();
        
        String concat = client + "," + destination + "," + duration + "," + price + "," + advice + ",";
        
         File f = new File("ClientsAdvice.txt");
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
              
              bw.write(concat );
              
              bw.close();
              fw.close();
      
          }catch(Exception e)
          {
              
          }
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("TravelCounsellorDashboard.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene1);
        window.show();
    }
    
}
