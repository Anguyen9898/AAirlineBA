/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aabairline.supporters;

import aabairline.Utils;
import aabairline.pojo.AirportInfo;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import aabairline.supporters.SupporterImp.*;
import java.net.URISyntaxException;
import java.time.LocalDate;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.TabPane;

/**
 *
 * @author anguy
 */
public class FlightSearch{
    private static TabPane scheduleTab;
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
    
    private static final Integer[] arrAges = {0, 1, 2, 3, 4, 5};
    
    public FlightSearch(Button btnOWay, Button btnRTrip, GridPane returnDateTxtField
            , ComboBox<AirportInfo> departure,  ComboBox<AirportInfo> destination
            , DatePicker depDate, DatePicker reDate, ComboBox<Integer> txtAdult
            , ComboBox<Integer> txtChild, ComboBox<Integer> txtInfant, TabPane scheduleTab)
    {
        
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
        FlightSearch.scheduleTab = scheduleTab;
        //Excute
        FlightSearch.init();
    }
    
    public static void init(){
        returnDateTxtField.setVisible(false);
        
        //Oneway is default chosen
        btnOWay.getStyleClass().add("BookingBtnColorChange");
        
        //FlightBooking Tab
        btnOWay.setOnMouseClicked(e->{
            bookingBtnEffect(btnOWay, btnRTrip, returnDateTxtField
                    , false, "BookingBtnColorChange");
        });
      
        btnRTrip.setOnMouseClicked(e->{
            bookingBtnEffect(btnRTrip, btnOWay
                    ,returnDateTxtField, true, "BookingBtnColorChange");
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
            MyNode.myAlert(Alert.AlertType.WARNING, "Warning"
            , "All fields are empty!", "Please fill all fields", "").show();
        }else{
            loadScheduleTab();
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
            if(newValue != null)
                getDestination(newValue);
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
        reDate.setValue(MyDate.getCurrentDate());
    }
    
    /**
     * Method set Schedule Tab 's text when button search is on click
     */
    public static void loadScheduleTab(){  
        scheduleTab.getTabs().get(7).setText(MyDate.getYear(depDate.getValue()));
        
        LocalDate nextDate = depDate.getValue();
        scheduleTab.getTabs().get(0).setText(MyDate.subYear(nextDate));

        for(int i = setFirstTab(); i < scheduleTab.getTabs().size() - 1; i++){
            nextDate = MyDate.getNextDate(nextDate, 1);
            scheduleTab.getTabs().get(i).setText(MyDate.subYear(nextDate));
        }
        openScheduleTab();
    }
    
    /**
     * 
     * @return 
     */
    public static int setFirstTab(){
        int count = 0;
        LocalDate lastDate = depDate.getValue();
        for(int i = 1; i < scheduleTab.getTabs().size(); i++){
            if(!MyDate.isCurrentDate(lastDate)  && i <= 3 ){
                int j = i;
                while(j > 0){
                    scheduleTab.getTabs().get(j).setText(scheduleTab.getTabs()
                            .get(j - 1).getText());
                    j = j - 1;
                }
                lastDate = MyDate.getLastDate(lastDate, 1);
                scheduleTab.getTabs().get(0).setText(MyDate.subYear(lastDate));
                
                count++;
            }
        }
        
        return count + 1;
    }
    /**
     * Method open chosen date tab
     */
    public static void openScheduleTab(){
        scheduleTab.getTabs().forEach(tab ->{
            if(MyDate.subYear(depDate.getValue()).equals(tab.getText())){
                scheduleTab.getSelectionModel().select(tab);
            }
        });
    }
}
