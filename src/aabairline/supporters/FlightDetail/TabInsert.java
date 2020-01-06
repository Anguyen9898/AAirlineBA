/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aabairline.supporters.FlightDetail;

import aabairline.Utils;
import aabairline.pojo.Employee;
import aabairline.pojo.FlightInfo;
import aabairline.pojo.Flying;
import aabairline.pojo.Plane;
import aabairline.supporters.SupporterImp;
import java.net.URISyntaxException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author anguy
 */
public class TabInsert { 
    private static ComboBox<FlightInfo> cbFlightId; 
    private static ComboBox<Employee> cbMain; 
    private static ComboBox<Employee> cbSide; 
    private static ComboBox<Employee> cbAT1; 
    private static ComboBox<Employee> cbAT2; 
    private static ComboBox<Employee> cbAT3; 
    private static ComboBox<Plane> cbPlane;
    
    private static TableView<FlightInfo> tbFlightsIn;
    private static TableView<Flying> tbFlyingsIn;
    List<FlightInfo> flights = new ArrayList<>();

    public TabInsert(ComboBox<FlightInfo> cbFlightId, ComboBox<Employee> cbMain
            , ComboBox<Employee> cbSide, ComboBox<Employee> cbAT1
            , ComboBox<Employee> cbAT2, ComboBox<Employee> cbAT3
            , ComboBox<Plane> cbPlane, TableView<FlightInfo> flightsIn
            , TableView<Flying> flyingsIn) {
        this.cbFlightId = cbFlightId;
        this.cbMain = cbMain;
        this.cbSide = cbSide;
        this.cbAT1 = cbAT1;
        this.cbAT2 = cbAT2;
        this.cbAT3 = cbAT3;
        this.cbPlane = cbPlane;
        this.tbFlightsIn = flightsIn;
        this.tbFlyingsIn = flyingsIn;
        init();
    }

    
    public void init(){
       setupCbID();
       setupCbEmployees();
       setupCbPlane();
       setupTableView();
    }
    
    public static void setupCbID(){
        ObservableList<FlightInfo> list = FXCollections.observableArrayList();
        Utils.getFlightInfo().forEach(fId ->{
            if(Utils.getFlyingById(fId).isEmpty()){
                cbFlightId.getItems().add(fId); 
                list.add(fId);
                
            }
        }); 
        //setup undetai-flight tableview 
        tbFlightsIn.setItems(list);
        
        if(!cbFlightId.getItems().isEmpty()){
            cbFlightId.getSelectionModel().select(0);
        }
    }
    
    public void setupCbEmployees(){
        if(!Utils.getEmployees("pl").isEmpty()){
            cbMain.getItems().addAll(Utils.getEmployees("pl"));
            cbSide.getItems().addAll(Utils.getEmployees("pl"));
        }
        
        if(!Utils.getEmployees("fa").isEmpty()){
            cbAT1.getItems().addAll(Utils.getEmployees("fa"));
            cbAT2.getItems().addAll(Utils.getEmployees("fa"));
            cbAT3.getItems().addAll(Utils.getEmployees("fa"));
        }
    }
    
    public void setupCbPlane(){
        if(!Utils.getPlanes().isEmpty()){
            cbPlane.getItems().addAll(Utils.getPlanes());
        }
    }
    
    public static void setupTableView(){
        //flight table view
        tbFlightsIn.getColumns().get(0).setCellValueFactory(
                new PropertyValueFactory<>("id"));
        tbFlightsIn.getColumns().get(1).setCellValueFactory(
                new PropertyValueFactory<>("takeOfDate"));
        tbFlightsIn.getColumns().get(2).setCellValueFactory(
                new PropertyValueFactory<>("takeOfTime"));
        tbFlightsIn.getColumns().get(3).setCellValueFactory(
                new PropertyValueFactory<>("arrivalDate"));
        tbFlightsIn.getColumns().get(4).setCellValueFactory(
                new PropertyValueFactory<>("arrivalTime"));
         tbFlightsIn.getColumns().get(5).setCellValueFactory(
                new PropertyValueFactory<>("route"));
        tbFlightsIn.getColumns().get(6).setCellValueFactory(
                new PropertyValueFactory<>("price"));
        
        //flight detail table view
        tbFlyingsIn.getColumns().get(0).setCellValueFactory(
                new PropertyValueFactory<>("flightId"));
        tbFlyingsIn.getColumns().get(1).setCellValueFactory(
                new PropertyValueFactory<>("pilotMain"));
        tbFlyingsIn.getColumns().get(2).setCellValueFactory(
                new PropertyValueFactory<>("pilotSide"));
        tbFlyingsIn.getColumns().get(3).setCellValueFactory(
                new PropertyValueFactory<>("fa1"));
        tbFlyingsIn.getColumns().get(4).setCellValueFactory(
                new PropertyValueFactory<>("fa2"));
        tbFlyingsIn.getColumns().get(5).setCellValueFactory(
                new PropertyValueFactory<>("fa3"));
        tbFlyingsIn.getColumns().get(6).setCellValueFactory(
                new PropertyValueFactory<>("planeId"));
        
        ObservableList<Flying> list = FXCollections.observableArrayList();
        Utils.getFlying().forEach(f ->{
            list.add(f);
        });
        tbFlyingsIn.setItems(list);
        tableRowListener();
    }
    
    public static void tableRowListener(){
        tbFlightsIn.setRowFactory(value ->{
            TableRow<FlightInfo> row = new TableRow();
            row.setOnMouseClicked(v ->{
                cbFlightId.getSelectionModel().select(row.getItem());  
            });
            return row;
        });
    }
    
    public static void finishHandler() throws URISyntaxException{
        if(isAllEmpty()){
            SupporterImp.ModifiedNode.myAlert(Alert.AlertType.ERROR,
                                     "Error",
                                     "All fields are required!",
                                     "Please select all!",
                                     "images/cancel.png")
                                    .show();
        }else{
             SupporterImp.ModifiedNode.myAlert(Alert.AlertType.CONFIRMATION,
                     "Insert row", "You're adding new flight detail into table",
                     "Are you sure to add?", "images/cancel.png")
                     .showAndWait().ifPresent(rep ->{
                         if(rep == ButtonType.OK){
                             saveFlying();
                         }
                     });
        }
    }
    
    public static boolean isAllEmpty(){
        return (cbMain.getSelectionModel().isEmpty()
                ||cbSide.getSelectionModel().isEmpty()
                ||cbAT1.getSelectionModel().isEmpty()
                ||cbAT2.getSelectionModel().isEmpty()
                ||cbAT3.getSelectionModel().isEmpty()
                ||cbPlane.getSelectionModel().isEmpty());
                
    }
     public static void saveFlying(){
         if(Utils.addOrUpdateFlying(
                new Flying(cbFlightId.getSelectionModel().getSelectedItem()
                        , cbMain.getSelectionModel().getSelectedItem()
                        , cbSide.getSelectionModel().getSelectedItem()
                        , cbAT1.getSelectionModel().getSelectedItem()
                        , cbAT2.getSelectionModel().getSelectedItem()
                        , cbAT3.getSelectionModel().getSelectedItem()
                        , cbPlane.getSelectionModel().getSelectedItem()))){
                    //update
                    setupTableView();
                    setupCbID();
                    
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Sucessful");
                    alert.show();   
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Failed");
                alert.show();
            }
     }
}
