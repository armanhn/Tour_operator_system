/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatingtouroperatorsystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
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
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author arman
 */
public class TouristViewQueriesSceneController implements Initializable {

    @FXML
    private TextField topic;
    @FXML
    private TextArea msg;
    @FXML
    private RadioButton hotel;
    @FXML
    private RadioButton travel;
    @FXML
    private RadioButton refund;
    
        ToggleGroup group;
        
        File queries = new File("Queries.bin");

    File login = new File("Login.bin");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        group = new ToggleGroup();
        hotel.setToggleGroup(group);
        travel.setToggleGroup(group);
        refund.setToggleGroup(group);
        hotel.setSelected(true);
    }    

    @FXML
    private void post(ActionEvent event) {
        
        String customertopic = topic.getText();
        String message = msg.getText();
  
        
        String type="";
        if(hotel.isSelected())
        {
            type = "Hotel";
        }
        else if(travel.isSelected())
        {
            type = "Travel";
        }
        else if(refund.isSelected())
        {
            type = "Refund";
        }
        
        String str = "";
        try{
            ObjectInputStream in= null;
        in = new ObjectInputStream(new FileInputStream(login));  
        Login l= null;
        
        try{
            
            while( (l = (Login) in.readObject() ) != null )
            {

                    str = l.getE();
    
            }
        }
        catch(Exception e1)
        {
        }
        in.close();  
        }catch(Exception e)
        {
            
        }
        
    Queries q = new Queries();
    q.setQueries(str,type,customertopic,message);
        
        
             FileOutputStream fos;
            ObjectOutputStream out=null;
            try{
                 if(queries.exists())
                 {
                     out = new AppendableObjectOutputStream(new FileOutputStream(queries,true));
                 }
                 else
                 {
                     out = new ObjectOutputStream(new FileOutputStream(queries));
                 }
                 
                 out.writeObject(q);
                 
            }catch(Exception e){
             
            }
    
            finally{
               try{
                    out.close();
                }catch(Exception ex){}
            }
        
    }

    @FXML
    private void prev(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("TouristDashboard.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene2);
        window.show();
    }

    
    
    class AppendableObjectOutputStream extends ObjectOutputStream {
    public AppendableObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {}
    } 
    
}
