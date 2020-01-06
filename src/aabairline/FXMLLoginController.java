/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aabairline;

import static aabairline.Utils.getTicketingAgentsByTxt;
import aabairline.pojo.*;
import aabairline.supporters.SupporterImp.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author anguy
 */
public class FXMLLoginController implements Initializable {
    @FXML 
    private TextField txtUsername;
    @FXML 
    private TextField txtPassword;
    
    public static TicketingAgent currentUser;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public void loginHandler(ActionEvent e) throws IOException, URISyntaxException{ 
        if(txtUsername.getText().equals("") || 
                txtPassword.getText().equals("")){
            
            ModifiedNode.myAlert(Alert.AlertType.ERROR, "Error"
                    , "All field is required!", "Please fill all fields!"
                    , "images/cancel.png").show();
        }else{
           
            if(!getTicketingAgentsByTxt(txtUsername.getText()).isEmpty()
                    && txtPassword.getText()
                            .equals(getTicketingAgentsByTxt(txtUsername.getText())
                                    .get(0)
                                    .getTa_Password())){
                try {
                    currentUser = getTicketingAgentsByTxt(txtUsername
                            .getText()).get(0);
                    ((Stage)((Node) e.getSource())
                        .getScene().getWindow()).close();
                    openHome(e);
                } catch (IOException ex) {
                    Logger.getLogger(FXMLLoginController.class.getName())
                            .log(Level.SEVERE, null, ex);
                }   

            }else{
                try {
                    ModifiedNode.myAlert(Alert.AlertType.ERROR, "Error"
                            , "User name or password is wrong!"
                            , "Please try again!"
                            , "images/cancel.png").show();
                } catch (URISyntaxException ex) {
                    Logger.getLogger(FXMLLoginController.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }  
        }
        
    }
    
    public void closeBtnHandler() throws URISyntaxException{
        Platform.exit();
    }
    
    public void openHome(ActionEvent event) throws IOException{
        Stage stg = new Stage();
        stg.setScene(new Scene(FXMLLoader.load(getClass()
                .getResource("FXMLHome.fxml"))));
        stg.getIcons().add(new Image(getClass()
                .getResource("images/MainLogo.png").toString()));
        stg.initStyle(StageStyle.UNDECORATED);
        stg.show();
    }
}
