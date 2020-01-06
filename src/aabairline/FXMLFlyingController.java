/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aabairline;

import aabairline.pojo.Employee;
import aabairline.pojo.FlightInfo;
import aabairline.pojo.Flying;
import aabairline.pojo.Plane;
import aabairline.supporters.FlightDetail.TabInsert;
import aabairline.supporters.FlightDetail.TabUpdate;
import aabairline.supporters.SupporterImp;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author binbo
 */
public class FXMLFlyingController implements Initializable {
    @FXML
    TabPane tb;
    //Insert tab
    @FXML 
    private ComboBox<FlightInfo> cbIdIn;
    @FXML 
    private ComboBox<Employee> cbMainIn;
    @FXML 
    private ComboBox<Employee> cbSideIn;
    @FXML 
    private ComboBox<Employee> cbAT1In;
    @FXML 
    private ComboBox<Employee> cbAT2In;
    @FXML 
    private ComboBox<Employee> cbAT3In;
    @FXML 
    private ComboBox<Plane> cbPlaneIn;
    @FXML
    private TableView<FlightInfo> tbFlightsIn;
    @FXML
    private TableView<Flying> tbFlyingsIn;
    //Update Tab
    @FXML 
    private ComboBox<FlightInfo> cbIdIn2;
    @FXML 
    private ComboBox<Employee> cbMainIn2;
    @FXML 
    private ComboBox<Employee> cbSideIn2;
    @FXML 
    private ComboBox<Employee> cbAT1In2;
    @FXML 
    private ComboBox<Employee> cbAT2In2;
    @FXML 
    private ComboBox<Employee> cbAT3In2;
    @FXML 
    private ComboBox<Plane> cbPlaneIn2;
    @FXML
    private TableView<Flying> tbFlyingsUp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new TabInsert(cbIdIn, cbMainIn, cbSideIn, cbAT1In, cbAT2In, cbAT3In
                , cbPlaneIn, tbFlightsIn, tbFlyingsIn);
        
        new TabUpdate(cbIdIn2, cbMainIn2, cbSideIn2, cbAT1In2, cbAT2In2, cbAT3In2
                , cbPlaneIn2, tbFlyingsUp);
    }    
    
    public void exitBtnHandler(ActionEvent event) throws URISyntaxException{
        SupporterImp.ModifiedNode.myAlert(Alert.AlertType.CONFIRMATION, "Exit Flight Detail", 
                "Are you sure to exit!", "", "images/cancel.png").showAndWait()
                .ifPresent(respone ->{
                    if(respone == ButtonType.OK)
                        ((Stage)((Node)(event.getSource())).getScene().getWindow())
                                .close();
                });
    } 
    
    public void finishBtnHanlder(ActionEvent event) throws URISyntaxException{
        if(tb.getSelectionModel().getSelectedIndex() == 0)
            TabInsert.finishHandler();
        else
            TabUpdate.finishHandler();
    }
    
    public void insertBtnHandler(ActionEvent e){
        tb.getSelectionModel().select(0);
            
    }
    
    public void updateBtnHandler(ActionEvent e){
        tb.getSelectionModel().select(1);
    }
}
