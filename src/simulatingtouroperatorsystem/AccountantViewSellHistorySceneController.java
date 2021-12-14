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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author arman
 */
public class AccountantViewSellHistorySceneController implements Initializable {

    @FXML
    private Label area;

    /**
     * Initializes the controller class.
     */
    File f = new File("BookTicket.txt");
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
            Scanner scan;
        try {
            scan = new Scanner(f);
             String[] A= null;
            String str = "";
            
            while( scan.hasNextLine() )
            {
                A = scan.nextLine().split(",");  
            }
            
            for(int i=0; i< A.length ; i+=6 )
            {
                int counter = i;
                
                 
                str = str + "Emaile-" +A[counter] + "," + "Date-"
               +A[counter+1] + "," +"Passport No.-" + A[counter+2] + "," +"Package ID-" 
               + A[counter+3] + "," +"Destination-" + A[counter+4] +"," +"Payment-" + A[counter+5]+ "\n";
     
            }
            
            area.setText(str);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccountantViewSellHistorySceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
           
       
    }    

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("AccountantDashboardScene.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene1);
        window.show();
    }
    
}
