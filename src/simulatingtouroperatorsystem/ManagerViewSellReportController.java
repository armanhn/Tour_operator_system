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


public class ManagerViewSellReportController implements Initializable {

    @FXML
    private TextArea report;

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
    private void show(ActionEvent event) {
       
        File f = new File("BookTicket.txt");
        String str = "";
        Scanner scan;
        try {
            scan = new Scanner(f);
             String[] A= null;
            
            
            while( scan.hasNextLine() )
            {
                A = scan.nextLine().split(",");  
            }
            for(int i=0; i< A.length ; i+=6 )
            {
                int counter = i;
                
                  str = str + A[counter] + ","+ A[counter+1] + ","+ A[counter+2] + ","+ A[counter+3] + ","+ A[counter+4] + ","+ A[counter+5] + "\n";
     
            }
          
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccountantViewSellHistorySceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        report.setText(str);
    }
    
}
