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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;


public class ManagerViewReportController implements Initializable {

    @FXML
    private BarChart<String, Number> chart;
    @FXML
    private PieChart chart1;

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
    private void load(ActionEvent event) {
        
        int goalCounter = 0;
        int b=0;
        int m=0;
        int v=0;
                    
        String [] passport = null;
        String [] payment = null;
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

                passport[i]= A[counter+2];
                payment [i]= A[counter+5];
            }
            for(int i=0; i< A.length ; i+=6 )
            {
                int counter = i;
                for(int j = 0; j< passport.length;i++){
                    if(A[counter+2] == passport[j] && A[counter+5] == payment [j] ){
                        goalCounter++;
                    }
                }
            }
          
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccountantViewSellHistorySceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
        for(int i=0; i<passport.length;i++){
        series.getData().add(new XYChart.Data<String,Number>(passport[i],goalCounter++));
        
        }
        chart.getData().add(series);

        
        
        
         ObservableList <PieChart.Data> list = FXCollections.observableArrayList(
            new PieChart.Data("Bkash",b),
            new PieChart.Data("Master",m),
            new PieChart.Data("Visa",v)

        );
        chart1.setData(list);
    }
    
}
