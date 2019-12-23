/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aabairline;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author anguy
 */
public class FXMLLoginController implements Initializable {

    Button btnCancel;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public void loginHandler(ActionEvent e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("FXMLHome.fxml"));
        Stage stg = new Stage();
        stg.setScene(new Scene(root));
        stg.setMaximized(true);
        stg.show();
    }
    
    public void cancelHandler(){
        Platform.exit();
    }
}
