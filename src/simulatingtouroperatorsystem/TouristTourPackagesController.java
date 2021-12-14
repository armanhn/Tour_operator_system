/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatingtouroperatorsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author arman
 */
public class TouristTourPackagesController implements Initializable {

    @FXML
    private TextArea packagearea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          File f = new File("PromotePackage.txt");
        Scanner scan;
        try {
            scan = new Scanner(f);
             String[] A= null;
            String str = "";
            
            while( scan.hasNextLine() )
            {
                A = scan.nextLine().split(",");  
            }
            for(int i=0; i< A.length ; i+=4 )
            {
                int counter = i;
                
                 
                str = str + A[counter] + "," + A[counter+1] + "," + A[counter+2] + ","  
                     +   A[counter+3] + "\n";
     
            }
            
            packagearea.setText(str);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccountantViewSellHistorySceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    



    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("TouristDashboard.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene2);
        window.show();
    }
    
}
