/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aabairline;

import aabairline.pojo.TicketingAgent;
import aabairline.supporters.SupporterImp.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author anguy
 */
public class FXMLHomeController implements Initializable {
    @FXML
    private Label lbUserName;
    @FXML
    private Label lbName;
    @FXML
    private Label userName;
    @FXML
    private Label lbGender;
    @FXML
    private Label lbEmpId;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setupUserInfo();
        
    }    
    
    public void bookingBtnHandler(ActionEvent event) throws IOException{
        ModifiedNode.openChidrenWindow("FXMLBooking.fxml", "images/ticket-book.png"
                , event);
        
    }
    
    public void flightEditorBtnHandler(ActionEvent event) throws IOException{
        ModifiedNode.openChidrenWindow("FXMLFlightSchedule.fxml"
                , "images/scheduler-icon-29.jpg.png"
                , event);    
    }
    
    public void flightDetailBtnHandler(ActionEvent event) throws IOException{
        ModifiedNode.openChidrenWindow("FXMLFlying.fxml"
                , "images/0d2af7d0e45d8c095cf44faf4ab63335.png"
                , event);
    }
    
    public void logoutBtnHandler(ActionEvent event) throws URISyntaxException{
        ModifiedNode.myAlert(Alert.AlertType.CONFIRMATION, "Logout"
                , "You've just click logout button!"
                , "Are you sure to logout?"
                , "images/login.png")
                .showAndWait().ifPresent(rep ->{
                    if(rep == ButtonType.OK){
                        Stage stage = new Stage();
                        try {
                            stage.setScene(new Scene(FXMLLoader.load(getClass()
                                    .getResource("FXMLLogin.fxml"))));
                        } catch (IOException ex) {
                            Logger.getLogger(FXMLHomeController.class.getName())
                                    .log(Level.SEVERE, null, ex);
                        }
                        stage.initStyle(StageStyle.UNDECORATED);
                        stage.getIcons().add(new Image(getClass()
                                .getResource("images/login.png").toString()));
                        
                        stage.show();
                        
                         ((Stage)((Node)event.getSource()).getScene().getWindow())
                                 .close();
                    }
                });   
    }
    
    public void setupUserInfo(){
        lbEmpId.setText(FXMLLoginController.currentUser.getTa_Id());
        lbName.setText(FXMLLoginController.currentUser.getName());
        lbUserName.setText(FXMLLoginController.currentUser.getTa_AccountId());
        lbGender.setText(FXMLLoginController.currentUser.getGender());
    }
}
