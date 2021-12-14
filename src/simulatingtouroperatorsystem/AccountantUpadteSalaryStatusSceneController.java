/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatingtouroperatorsystem;

import java.io.File;
import java.io.FileInputStream;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author arman
 */
public class AccountantUpadteSalaryStatusSceneController implements Initializable {

    @FXML
    private TableView<Employee> salaryStatusTableView;
    @FXML
    private TableColumn<String, String> empIdColumn;
    @FXML
    private TableColumn<String, String> EmpNameColumn;
    @FXML
    private TableColumn<String, String> designationColumn;
    @FXML
    private TableColumn<String, String> statusColumn;

    /**
     * Initializes the controller class.
     */
        File f = new File("Employees.bin");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      empIdColumn.setCellValueFactory(new PropertyValueFactory<String,String>("employeeId"));
      EmpNameColumn.setCellValueFactory(new PropertyValueFactory<String,String>("name"));
      designationColumn.setCellValueFactory(new PropertyValueFactory<String,String>("designation"));
      statusColumn.setCellValueFactory(new PropertyValueFactory<String,String>("salary"));
      
      
       try{
            ObjectInputStream in= null;
        in = new ObjectInputStream(new FileInputStream(f));  
        Employee e= null;
        String str = "";
        try{
            
            while( (e = (Employee) in.readObject() ) != null )
            {

                   salaryStatusTableView.getItems().add(e);
    
            }
        }
        catch(Exception e1)
        {
        }
        in.close();  
        }catch(Exception e)
        {
            
        }
      
    }    

    @FXML
    private void backButtonClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("AccountantDashboardScene.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene1);
        window.show();
    }
    
}
