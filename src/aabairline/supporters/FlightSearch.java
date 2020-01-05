package aabairline.supporters;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import aabairline.Utils;
import aabairline.pojo.*;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import aabairline.supporters.*;
import aabairline.supporters.SupporterImp.MyDate;
import aabairline.supporters.SupporterImp.ModifledNode;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.control.TableRow;

/**
 *
 * @author anguy
 */
public class FlightSearch{
    private static TableView<FlightInfo> scheduleTa;
    private static Button btnOWay;
    private static Button btnRTrip;
    private static GridPane returnDateTxtField;
    
    private static ComboBox<AirportInfo> cbDepart;
    private static ComboBox<AirportInfo> cbDes;
    
    private static DatePicker depDate;
    private static DatePicker reDate;
    
    private static ComboBox<Integer> cbAdult;
    private static ComboBox<Integer> cbChild;
    private static ComboBox<Integer> cbInfant;
   
    private static Label lbPrice;
    
    private static final Integer[] arrAges = {0, 1, 2, 3, 4, 5};
    
    private static boolean isRTrip = false;
    
    private static AirportInfo depId;
    private static AirportInfo reId;
    
    private static FlightInfo selectedFlight;
    
    
    public FlightSearch(Button btnOWay, Button btnRTrip, GridPane returnDateTxtField
            , ComboBox<AirportInfo> departure,  ComboBox<AirportInfo> destination
            , DatePicker depDate, DatePicker reDate, ComboBox<Integer> txtAdult
            , ComboBox<Integer> txtChild, ComboBox<Integer> txtInfant
            , TableView scheduleTab, Label lbPrice)
            throws IOException{
        
        FlightSearch.btnOWay = btnOWay;
        FlightSearch.btnRTrip = btnRTrip;
        FlightSearch.returnDateTxtField = returnDateTxtField;
        FlightSearch.cbDepart = departure;
        FlightSearch.cbDes = destination;
        FlightSearch.depDate = depDate;
        FlightSearch.reDate = reDate;
        FlightSearch.cbAdult = txtAdult;
        FlightSearch.cbChild = txtChild;
        FlightSearch.cbInfant = txtInfant;
        FlightSearch.scheduleTa = scheduleTab;
        FlightSearch.lbPrice = lbPrice;
        //Excute
        FlightSearch.init();
  
    }
    
    public static void init() throws IOException{
        returnDateTxtField.setVisible(false);
        
        //Oneway is default chosen
        btnOWay.getStyleClass().add("BookingBtnColorChange");
             
        //FlightBooking Tab
        btnOWay.setOnMouseClicked(e->{
            bookingBtnEffect(btnOWay, btnRTrip, returnDateTxtField
                    , false, "BookingBtnColorChange");
            isRTrip = false;
            
        });
      
        btnRTrip.setOnMouseClicked(e->{
            bookingBtnEffect(btnRTrip, btnOWay
                    ,returnDateTxtField, true, "BookingBtnColorChange");
            isRTrip = true;
        });
        FlightSearch.loadComboBox();
//        FlightSearch.loadDestinationCBox();
        FlightSearch.setUpDatePicker();
        //Setup combobox adult age
        cbAdult.getItems().addAll(arrAges);
        cbAdult.getSelectionModel().select(1);
        //Setup combobox child age
        cbChild.getItems().addAll(arrAges);
        cbChild.getSelectionModel().select(0);
        //Setup combobox infant age
        cbInfant.getItems().addAll(0, 1);
        cbInfant.getSelectionModel().select(0);
    }
      
    /**
     * This method to change button's color when it's on clicked
     * @param btn1
     * @param btn2 
     * @param shownPane 
     * @param isFieldShown 
     * @param cssStyle 
     */
    private static void bookingBtnEffect(Node btn1, Node btn2, Pane shownPane,
            Boolean isFieldShown, String cssStyle){
        btn1.getStyleClass().add(cssStyle);
        btn2.getStyleClass().removeAll(cssStyle);
        shownPane.setVisible(isFieldShown);
    }
    
    /**
     * Method check all fields is empty
     * @return 
     */
    private static boolean isAllEmpty(){
        return cbDepart.getPromptText().equals("Select Departure" )
                && cbDes.getPromptText().equals("Select Destination")
                && cbAdult.getSelectionModel().getSelectedItem().equals(0) 
                && cbChild.getSelectionModel().getSelectedItem().equals(0)
                && cbInfant.getSelectionModel().getSelectedItem().equals(0);
    }
    
    /**
     * Search Flight Button Handler
     * @throws java.net.URISyntaxException
     */
    public static void searchBtnHandler() throws URISyntaxException{
        if(isAllEmpty()){
            ModifledNode.myAlert(Alert.AlertType.WARNING, "Warning"
            , "All fields are empty!", "Please fill all fields", "").show();
        }else{
            setupTicketTable();
        }
    }
    
    /**
     * Method load data into combo box
     */
    public static void loadComboBox(){
        //Combobox departure
        cbDepart.getItems().addAll(Utils.getAirportInfos());
        //Combobox destination
        cbDes.getItems().addAll(Utils.getAirportInfos());
        
        cbDepart.valueProperty().addListener((ObservableValue<? extends AirportInfo> 
                observable, AirportInfo oldValue, AirportInfo newValue) -> {
            if(newValue != null){
                getDestination(newValue);
                
                depId = newValue; //get selected departure airport
            }
        });
        
        cbDes.valueProperty().addListener((observable, oldValue, newValue) -> {
            reId = newValue; //get selected return airport
        });
    }
    
     /**
     * Method get destination list when departure was chosen
     * @param ai
     */
    public static void getDestination(AirportInfo ai){
        List<AirportInfo> desList = new ArrayList<>();
            Utils.getDestinationByAId(ai).forEach(i ->{
                desList.add(i.getArrivalAP());
            });
            
        cbDes.getItems().setAll(desList);
    }
    
    /**
     * setup date picker
     */
    private static void setUpDatePicker(){
        //Date Picker's date format
        depDate.setConverter(MyDate.setDateFormat());
        reDate.setConverter(MyDate.setDateFormat());
        //Get current date first
        depDate.setValue(MyDate.getCurrentDate());
        reDate.setValue(depDate.getValue());
        
        reDate.valueProperty().addListener(((observable, oldValue, newValue) -> {
            if(newValue.compareTo(depDate.getValue()) < 0){
                try {
                    ModifledNode.myAlert(Alert.AlertType.ERROR, "Date picker error!", "error"
                            , "Return date can't be before departure date!",
                            "images/cancel.png").showAndWait()
                            .ifPresent(rep ->{
                                if(rep == ButtonType.OK)
                                    reDate.setValue(depDate.getValue());
                            });

                } catch (URISyntaxException ex) {
                    Logger.getLogger(FlightSearch.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
        }));
    }
    
     /**
     * Method set ticket-selector's UI
     * 
     * @throws java.net.URISyntaxException
     */
    public static void setupTicketTable() throws URISyntaxException{  
        scheduleTa.getColumns().get(0).setCellFactory(value ->{
            TableCell cell = new TableCell();
            cell.setGraphic(ModifledNode.myCheckBox());
            return cell;
        });
        scheduleTa.getColumns().get(1).setCellValueFactory(
                new PropertyValueFactory<>("id"));
        scheduleTa.getColumns().get(2).setCellValueFactory(
                new PropertyValueFactory<>("takeOfDate"));
        scheduleTa.getColumns().get(3).setCellValueFactory(
                new PropertyValueFactory<>("takeOfTime"));
        scheduleTa.getColumns().get(4).setCellValueFactory(
                new PropertyValueFactory<>("arrivalDate"));
        scheduleTa.getColumns().get(5).setCellValueFactory(
                new PropertyValueFactory<>("arrivalTime"));
         scheduleTa.getColumns().get(6).setCellValueFactory(
                new PropertyValueFactory<>("price"));
        
        scheduleTa.setItems(getFlightList());
        getSelectedTicket();
    }  
    
    public static ObservableList<FlightInfo> getFlightList() 
            throws URISyntaxException{
        
        ObservableList<FlightInfo> list = FXCollections.observableArrayList();
        Date departDate = MyDate.convertToDateViaInstant(depDate.getValue());
        
        if(getRoute() != null){
            getRoute().forEach(route ->{
                setupFlightList(list, departDate, route);
                if(list.isEmpty()){
                    try {
                        notFoundAlert();
                    } catch (URISyntaxException ex) {
                        Logger.getLogger(FlightSearch.class.getName())
                                .log(Level.SEVERE, null, ex);
                    }
                }
            });
        }
        else{
           notFoundAlert();
        }
        
        return list;
    }
    
    public static List<Route> getRoute(){
        if(depId != null && reId != null){
            return Utils.getRoutesByAirportId(depId, reId);
        }
        return null;
    }
    
    public static void setupFlightList(ObservableList<FlightInfo> list,
            Date departDate, Route route){   
                Utils.getFlightInfosByCon(departDate, route)
                        .forEach(flight ->{
                            list.add(flight); 
                });
    }
    
    public static void getSelectedTicket(){
        scheduleTa.setRowFactory(value -> {
            TableRow<FlightInfo> row = new TableRow<>();
            
            row.setOnMouseClicked(e ->{
                //Set CheckBox
                if(!row.isEmpty()){ 
                    scheduleTa.getColumns().get(0)
                            .getCellData(row.getIndex());
                 
                        for (int i = 0; i < scheduleTa.getItems()
                               .size(); i++) {
                            if(i != row.getIndex()){
                  
                            }
                        }
                }
                //get price
                lbPrice.setText(String.valueOf(row.getItem().getPrice()));
            });
            return row;
            
        });
    }
    
    public static void notFoundAlert() throws URISyntaxException{
         ModifledNode.myAlert(Alert.AlertType.ERROR, "error"
            , "Don't have any flights", "Don't have any flights"
                 , "images/cancel.png").show();
    }
    
    public static void getCompleteTicket(){
         //Complete a ticket
//        new CompleteBooking.TicketInfo(cbDepart.getSelectionModel().getSelectedItem().toString()
//                , cbDes.getSelectionModel().getSelectedItem().toString()
//                , depDate.getValue().toString()
//                , .ge
//                , depTime
//                , arrTime
//                , id)
    }
}
