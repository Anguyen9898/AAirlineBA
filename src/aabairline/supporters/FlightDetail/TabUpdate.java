/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aabairline.supporters.FlightDetail;

import aabairline.Utils;
import aabairline.pojo.*;
import static aabairline.supporters.FlightDetail.TabInsert.setupCbID;
import static aabairline.supporters.FlightDetail.TabInsert.setupTableView;
import aabairline.supporters.SupporterImp;
import java.net.URISyntaxException;
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
public class TabUpdate {
    private static ComboBox<FlightInfo> cbFlightId2; 
    private static ComboBox<Employee> cbMain2; 
    private static ComboBox<Employee> cbSide2; 
    private static ComboBox<Employee> cbAT12; 
    private static ComboBox<Employee> cbAT22; 
    private static ComboBox<Employee> cbAT32; 
    private static ComboBox<Plane> cbPlane;
    
    private static TableView<Flying> tbFlightsUp;

    public TabUpdate(ComboBox<FlightInfo> cbFlightId2, ComboBox<Employee> cbMain2, ComboBox<Employee> cbSide2, ComboBox<Employee> cbAT12, ComboBox<Employee> cbAT22, ComboBox<Employee> cbAT32, ComboBox<Plane> cbPlane, TableView<Flying> tbFlightsUp) {
        this.cbFlightId2 = cbFlightId2;
        this.cbMain2 = cbMain2;
        this.cbSide2 = cbSide2;
        this.cbAT12 = cbAT12;
        this.cbAT22 = cbAT22;
        this.cbAT32 = cbAT32;
        this.cbPlane = cbPlane;
        this.tbFlightsUp = tbFlightsUp;
        
        init();
    }
    
    

    public static void init(){
       setupCbID();
       setupCbEmployees();
       setupCbPlane();
       setupTableView();
    }
    
    public static void setupCbID(){
        Utils.getFlying().forEach(f ->{
             cbFlightId2.getItems().addAll(f.getFlightId()); 
        });
        if(!cbFlightId2.getItems().isEmpty()){
            cbFlightId2.getSelectionModel().select(0);
        }
    }
    
    public static void setupCbEmployees(){
        if(!Utils.getEmployees("pl").isEmpty()){
            cbMain2.getItems().addAll(Utils.getEmployees("pl"));
            cbSide2.getItems().addAll(Utils.getEmployees("pl"));
            
            cbMain2.getSelectionModel().select(0);
            cbSide2.getSelectionModel().select(0);
        }
        
        if(!Utils.getEmployees("fa").isEmpty()){
            cbAT12.getItems().addAll(Utils.getEmployees("fa"));
            cbAT22.getItems().addAll(Utils.getEmployees("fa"));
            cbAT32.getItems().addAll(Utils.getEmployees("fa"));
             
            cbAT12.getSelectionModel().select(0);
            cbAT22.getSelectionModel().select(0);
            cbAT32.getSelectionModel().select(0);
        }
    }
    
    public static void setupCbPlane(){
        if(!Utils.getPlanes().isEmpty()){
            cbPlane.getItems().addAll(Utils.getPlanes());
            cbPlane.getSelectionModel().select(0);
        }
    }
    
    public static void setupTableView(){
        tbFlightsUp.getColumns().get(0).setCellValueFactory(
                new PropertyValueFactory<>("flightId"));
        tbFlightsUp.getColumns().get(1).setCellValueFactory(
                new PropertyValueFactory<>("pilotMain"));
        tbFlightsUp.getColumns().get(2).setCellValueFactory(
                new PropertyValueFactory<>("pilotSide"));
        tbFlightsUp.getColumns().get(3).setCellValueFactory(
                new PropertyValueFactory<>("fa1"));
        tbFlightsUp.getColumns().get(4).setCellValueFactory(
                new PropertyValueFactory<>("fa2"));
        tbFlightsUp.getColumns().get(5).setCellValueFactory(
                new PropertyValueFactory<>("fa3"));
        tbFlightsUp.getColumns().get(6).setCellValueFactory(
                new PropertyValueFactory<>("planeId"));
        
        ObservableList<Flying> list = FXCollections.observableArrayList();
        Utils.getFlying().forEach(f ->{
            list.add(f);
        });
        tbFlightsUp.setItems(list);
        tableRowListener();
    }
    
    public static void tableRowListener(){
        tbFlightsUp.setRowFactory(value ->{
            TableRow<Flying> row = new TableRow();
            row.setOnMouseClicked(v ->{
                cbFlightId2.getSelectionModel().select(row.getItem().getFlightId());
                cbMain2.getSelectionModel().select(row.getItem().getPilotMain());
                cbSide2.getSelectionModel().select(row.getItem().getPilotSide());
                cbAT12.getSelectionModel().select(row.getItem().getFa1());
                cbAT22.getSelectionModel().select(row.getItem().getFa2());
                cbAT32.getSelectionModel().select(row.getItem().getFa3());
            });
            return row;
        });
    }
    
     public static void finishHandler() throws URISyntaxException{
        SupporterImp.ModifiedNode.myAlert(Alert.AlertType.CONFIRMATION,
                "Insert row", "You're changing flight detail",
                "Are you sure to update?", "images/login.png")
                .showAndWait().ifPresent(rep ->{
                    if(rep == ButtonType.OK){
                        update();
                    }
                });
    }
    
     public static void update(){
         if(Utils.addOrUpdateFlying(
                new Flying(cbFlightId2.getSelectionModel().getSelectedItem()
                        , cbMain2.getSelectionModel().getSelectedItem()
                        , cbSide2.getSelectionModel().getSelectedItem()
                        , cbAT12.getSelectionModel().getSelectedItem()
                        , cbAT22.getSelectionModel().getSelectedItem()
                        , cbAT32.getSelectionModel().getSelectedItem()
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
