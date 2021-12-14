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
public class ManagerDashboardSceneController implements Initializable {

    @FXML
    private TableView<Employee> tableview;
    @FXML
    private TableColumn<String,String> namecol;
    @FXML
    private TableColumn<String,String> idcol;
    @FXML
    private TableColumn<String,String> mobilecol;
    @FXML
    private TableColumn<String,String> emailcol;
    @FXML
    private TableColumn<String,String> addresscol;
    @FXML
    private TableColumn<String,String> desigcol;
    @FXML
    private TableColumn<String,String> gendercol;
    @FXML
    private TableColumn<String,String> salarycol;
    
    File f = new File("Employees.bin");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        namecol.setCellValueFactory(new PropertyValueFactory<String,String>("name"));
        idcol.setCellValueFactory(new PropertyValueFactory<String,String>("employeeId"));
        gendercol.setCellValueFactory(new PropertyValueFactory<String,String>("gender"));
        mobilecol.setCellValueFactory(new PropertyValueFactory<String,String>("phone"));
        addresscol.setCellValueFactory(new PropertyValueFactory<String,String>("address"));
        desigcol.setCellValueFactory(new PropertyValueFactory<String,String>("designation"));
        salarycol.setCellValueFactory(new PropertyValueFactory<String,String>("salary"));
        emailcol.setCellValueFactory(new PropertyValueFactory<String,String>("email"));
        
        
        try{
            ObjectInputStream in= null;
        in = new ObjectInputStream(new FileInputStream(f));  
        Employee e= null;
        String str = "";
        try{
            
            while( (e = (Employee) in.readObject() ) != null )
            {

                   tableview.getItems().add(e);
    
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
    private void createTourPackageButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("ManagerNewPackage.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void accountsReportButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("ManagerViewReport.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void addEmployee(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("ManagerAddEmployee.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void viewSellReportButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("ManagerViewSellReport.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void createBudgetsButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("ManagerBudget.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void logOutButtonClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene1);
        window.show();
    }
    
}
