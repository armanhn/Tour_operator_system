
package simulatingtouroperatorsystem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class CreateAccountController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private TextField address;
    @FXML
    private TextField phone;
    @FXML
    private TextField gender;
    
    File tour = new File("Tourist.bin");


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    



    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene2);
        window.show();
    }

    @FXML
    private void create(ActionEvent event) {
        Tourist t = new Tourist();
        t.setTourist(name.getText(), phone.getText(), email.getText(), password.getText(), address.getText(), gender.getText());
         
            FileOutputStream fos;
            ObjectOutputStream out=null;
            try{
                 if(tour.exists())
                 {
                     out = new AppendableObjectOutputStream(new FileOutputStream(tour,true));
                 }
                 else
                 {
                     out = new ObjectOutputStream(new FileOutputStream(tour));
                 }
                 
                 out.writeObject(t);
                 
            }catch(Exception e){
             
            }
    
            finally{
               try{
                    out.close();
                }catch(Exception ex){}
            }
        
        
    }
    
    
    class AppendableObjectOutputStream extends ObjectOutputStream {
    public AppendableObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {}
    } 
    
}
