/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aabairline;

import aabairline.pojo.FlightInfo;
import aabairline.pojo.Route;
import aabairline.supporters.SupporterImp.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Time;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author binbo
 */
public class FXMLFlightScheduleController implements Initializable {
    @FXML 
    private TextField txtFlightId;
    @FXML 
    private DatePicker dpTakeOffDate ;
    @FXML 
    private TextField txtTakeOffTime;
    @FXML 
    private ComboBox<Route> cbRoute;
    @FXML 
    private TextField txtArrivalTime;
    @FXML 
    private DatePicker dpArrivalDate;
    @FXML 
    private TextField txtPrice;
    @FXML 
    private TableView<FlightInfo> tbFlightInfo;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cbRoute.getItems().addAll(Utils.getRoute());
        cbRoute.getSelectionModel().select(0);
        setupTableView();
        //Set Currency text filed
        txtPrice.setOnKeyTyped(event-> {
            String typedCharacter = event.getCharacter();
            event.consume();

            if (typedCharacter.matches("\\d*")) {
                String currentText = txtPrice.getText().replaceAll("\\.", "")
                        .replace(",", "");
                long longVal = Long.parseLong(currentText.concat(typedCharacter));
                txtPrice.setText(new DecimalFormat("#,##0").format(longVal));
            }
        });
//        txtPrice.textProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue.matches("\\d*")) {
//                String currentText = txtPrice.getText().replaceAll("\\.", "")
//                        .replace(",", "");
//                long longVal = Long.parseLong(currentText.concat(newValue));
//                txtPrice.setText(new DecimalFormat("#,##0").format(longVal));
//            }
//        } );
        
        dpTakeOffDate.valueProperty().addListener((observable, oldValue, newValue) -> {
            dpArrivalDate.setValue(newValue);
        });
        
        dpArrivalDate.valueProperty().addListener((observable, oldValue, newValue) ->{
            if(newValue.compareTo(dpTakeOffDate.getValue()) < 0){
                try {
                    ModifiedNode.myAlert(Alert.AlertType.ERROR, "Date picker error!", "error"
                            , "Arrival date can't be before departure date!",
                            "images/cancel.png").showAndWait()
                            .ifPresent(rep ->{
                                if(rep == ButtonType.OK)
                                    dpArrivalDate.setValue(dpTakeOffDate.getValue());
                            });
                } catch (URISyntaxException ex) {
                    Logger.getLogger(FXMLFlightScheduleController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public void insertBtnHandler(ActionEvent e) throws URISyntaxException{
        if(!Utils.getFlightInfoById(txtFlightId.getText()).isEmpty()){
            ModifiedNode.myAlert(Alert.AlertType.CONFIRMATION,
                "Warning",
                "This flight ID's already been in data! ",
                "Do you want to update instead?",
                "images/cancel.png")
               .showAndWait().ifPresent(rep ->{
                   if(rep == ButtonType.OK){
                    try {
                        addOrUpdateFlight();
                    } catch (URISyntaxException ex) {
                        Logger.getLogger(FXMLFlightScheduleController.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
                   }
            });
        } else{
            addOrUpdateFlight();
        }
    }
    
    public void updateBtnHandler(ActionEvent e) throws URISyntaxException{
        if(Utils.getFlightInfoById(txtFlightId.getText()).isEmpty()){
            ModifiedNode.myAlert(Alert.AlertType.CONFIRMATION,
                "Warning",
                "Not found this ID in data! ",
                "Do you want to add new flight instead?",
                "images/cancel.png")
               .showAndWait().ifPresent(rep ->{
                    if(rep == ButtonType.OK){
                        try {
                            addOrUpdateFlight();
                        } catch (URISyntaxException ex) {
                            Logger.getLogger(FXMLFlightScheduleController.class.getName())
                                    .log(Level.SEVERE, null, ex);
                        }
                    }
            });
        }
        else{
            addOrUpdateFlight();
        }
    }
    
    public boolean isAllEmpty(){
        return (txtFlightId.getText().equals("")
                || dpTakeOffDate.getValue() == null
                || txtTakeOffTime.getText().equals("")
                || dpArrivalDate.getValue() == null
                || txtArrivalTime.getText().equals("")
                || cbRoute.getSelectionModel().isEmpty()
                || txtPrice.getText().equals(""));
    }

    public void addOrUpdateFlight() throws URISyntaxException{
        if(isAllEmpty()){
            ModifiedNode.myAlert(Alert.AlertType.ERROR,
                                     "Error",
                                     "All fields are required!",
                                     "Please fill all!",
                                     "images/cancel.png")
                                    .show();
        }else{
            if(Utils.addOrUpdateFlightInfo(
                new FlightInfo(txtFlightId.getText()
                        , MyDate.convertToDateViaInstant(dpTakeOffDate.getValue())
                        , Time.valueOf(txtTakeOffTime.getText())
                        , MyDate.convertToDateViaInstant(dpArrivalDate.getValue())
                        , Time.valueOf(txtArrivalTime.getText())
                        , Double.valueOf(txtPrice.getText().replace(",", ""))
                        , cbRoute.getSelectionModel().getSelectedItem()))){
                
                    setupTableView();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Sucessful");
                    alert.show();
                    //update table       
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Failed");
                alert.show();
            }
        }
    }
    
    public void deleteBtnHandler(ActionEvent e) throws URISyntaxException{ 
        if("".equals(txtFlightId.getText())
                || Utils.getFlightInfoById(txtFlightId.getText()).isEmpty()){
            ModifiedNode.myAlert(Alert.AlertType.ERROR,
                                     "Error",
                                     "Delete failed",
                                     "You haven't selected no row yet!",
                                     "images/cancel.png")
                                    .show();
            
        }else{
            FlightInfo selected = Utils.getFlightInfoById(txtFlightId.getText())
                    .get(0);
            ModifiedNode.myAlert(Alert.AlertType.CONFIRMATION,
                     "Delete row", "You're deleting this row out of this table",
                     "Are you sure to delete?", "images/cancel.png")
            .showAndWait().ifPresent(rep -> {
                if (rep == ButtonType.OK) {
                    if(!Utils.getFlyingById(selected).isEmpty()){
                        try {
                            ModifiedNode.myAlert(Alert.AlertType.CONFIRMATION
                                    , "Relationship constraint"
                                    , "This flight has data on flying table!"
                                    ,"Are you sure to delete it too?"
                                    , "images/cancel.png")
                                    .showAndWait().ifPresent(rep1 ->{
                                        if(rep1 == ButtonType.OK){
                                            //delelte flying first
                                            Utils.deleteFlyingById(Utils
                                                    .getFlyingById(selected)
                                                    .get(0));
                                        }
                                    });
                        } catch (URISyntaxException ex) {
                            Logger.getLogger(FXMLFlightScheduleController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    //delete flight
                    deleteFlight(selected);
                }
            });
        }
        
    }
    
    public void deleteFlight(FlightInfo selected){
            if (Utils.deleteFlightById(selected)){
                setupTableView();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Delete sucessfully");
                alert.show();
                //update table       
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Delete failed");
                alert.show();
            }
    }
    
    public void setupTableView(){
        tbFlightInfo.getColumns().get(0).setCellValueFactory(
                new PropertyValueFactory<>("id"));
        tbFlightInfo.getColumns().get(1).setCellValueFactory(
                new PropertyValueFactory<>("takeOfDate"));
        tbFlightInfo.getColumns().get(2).setCellValueFactory(
                new PropertyValueFactory<>("takeOfTime"));
        tbFlightInfo.getColumns().get(3).setCellValueFactory(
                new PropertyValueFactory<>("arrivalDate"));
        tbFlightInfo.getColumns().get(4).setCellValueFactory(
                new PropertyValueFactory<>("arrivalTime"));
        tbFlightInfo.getColumns().get(5).setCellValueFactory(
                new PropertyValueFactory<>("route"));
        tbFlightInfo.getColumns().get(6).setCellValueFactory(
                new PropertyValueFactory<>("price"));
        
        tbFlightInfo.getItems().setAll(Utils.getFlightInfo());
        tableRowListener();     
    }
    
    public void tableRowListener(){
        tbFlightInfo.setRowFactory(value ->{
            TableRow<FlightInfo> row = new TableRow<>();
            row.setOnMouseClicked(v ->{
                txtFlightId.setText(row.getItem().getId());
                dpTakeOffDate.setValue(MyDate.convertToLocalDateVia(row.getItem()
                        .getTakeOfDate()));
                txtTakeOffTime.setText(row.getItem().getTakeOfTime().toString());
                txtArrivalTime.setText(row.getItem().getArrivalTime().toString());
                dpArrivalDate.setValue(MyDate.convertToLocalDateVia(row.getItem()
                        .getArrivalDate()));
                txtPrice.setText(String.valueOf(row.getItem().getPrice()));
                
                cbRoute.getSelectionModel().select(row.getItem().getRoute());
                
            });
            return row;
        });
       
    }
    
    public void backBtnHandler(ActionEvent event) throws URISyntaxException{
        ModifiedNode.myAlert(Alert.AlertType.CONFIRMATION, "Exit Flight Editor", 
                "Are you sure to exit!", "", "images/cancel.png").showAndWait()
                .ifPresent(respone ->{
                    if(respone == ButtonType.OK)
                        ((Stage)((Node)(event.getSource())).getScene().getWindow())
                                .close();
                });
    } 
}
