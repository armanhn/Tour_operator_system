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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author arman
 */
public class TravelCounsellorGenerateSellReportController implements Initializable {

    @FXML
    private BarChart<String, Number> chart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("TravelCounsellorDashboard.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void generate(ActionEvent event) {
        int counterdhaka=0;
        int counterctg=0;
        int counterkhulna=0;
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
                
                   if(A[counter+4].equals("Dhaka"))
                   {
                       counterdhaka++;
                   }
                   if(A[counter+4].equals("Khulna"))
                   {
                       counterkhulna++;
                   }
                   if(A[counter+4].equals("Ctg"))
                   {
                       counterctg++;
                   }
     
            }
          
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccountantViewSellHistorySceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
        series.getData().add(new XYChart.Data<String,Number>("Dhaka",counterdhaka));
        series.getData().add(new XYChart.Data<String,Number>("Ctg",counterctg));
        series.getData().add(new XYChart.Data<String,Number>("Khulna",counterkhulna));
        chart.getData().add(series);
    }
    
}
