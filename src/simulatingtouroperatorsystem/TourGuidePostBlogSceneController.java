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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author arman
 */
public class TourGuidePostBlogSceneController implements Initializable {

    @FXML
    private TextField nameTxt;
    @FXML
    private TextField topicTxt;
    @FXML
    private RadioButton experienceBlogRB;
    @FXML
    private RadioButton informationBlogRB;
    @FXML
    private TextArea blogBodyTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void postButtonOnClick(ActionEvent event) {
        String n = nameTxt.getText();
        String t = topicTxt.getText();
        String b = blogBodyTxt.getText();
        
        
        
        String type="";
        if(experienceBlogRB.isSelected())
        {
            type = "Experience";
        }
        else if(informationBlogRB.isSelected())
        {
            type = "Information";
        }
       
       
        
        String concat = n+ ","+ type + "," +  t + "," + b  + "," ;
        
        File f = new File("TourGuideBlogs.txt");
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
    private void backButtonOnClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("TourGuideDashboardScene.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene2);
        window.show();
    }
    
}
