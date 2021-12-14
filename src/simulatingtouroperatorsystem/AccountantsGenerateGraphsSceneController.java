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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author arman
 */
public class AccountantsGenerateGraphsSceneController implements Initializable {

    @FXML
    private PieChart chart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void generateReportButtonOnClick(ActionEvent event) {
        int b=0;
        int m=0;
        int v=0;
        File f = new File("BookTicket.txt");
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
                
                   if(A[counter+5].equals("Bkash"))
                   {
                       b++;
                   }
                   if(A[counter+5].equals("Master"))
                   {
                       m++;
                   }
                   if(A[counter+5].equals("Visa"))
                   {
                       v++;
                   }
     
            }
          
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccountantViewSellHistorySceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
         ObservableList <PieChart.Data> list = FXCollections.observableArrayList(
            new PieChart.Data("Bkash",b),
            new PieChart.Data("Master",m),
            new PieChart.Data("Visa",v)

        );
        chart.setData(list);
        
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
