/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aabairline.supporters;

import aabairline.Utils;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

/**
 *
 * @author anguy
 */
public class FlightSearch{
    private static TabPane scheduleTab;
    private static Button btnOWay;
    private static Button btnRTrip;
    private static GridPane returnDateTxtField;
    
    private static ComboBox<String> departure;
    private static ComboBox<String> destination;
    
    private static DatePicker depDate;
    private static DatePicker reDate;
    
    private static TextField txtAdult;
    private static TextField txtChild;
    private static TextField txtInfant;
    
    private static Tab yearTab;
    
    public FlightSearch(Button btnOWay, Button btnRTrip, GridPane returnDateTxtField
            , ComboBox<String> departure,  ComboBox<String> destination
            , DatePicker depDate, DatePicker reDate, TextField txtAdult
            , TextField txtChild, TextField txtInfant, TabPane scheduleTab, Tab year) {
        
        FlightSearch.btnOWay = btnOWay;
        FlightSearch.btnRTrip = btnRTrip;
        FlightSearch.returnDateTxtField = returnDateTxtField;
        FlightSearch.departure = departure;
        FlightSearch.destination = destination;
        FlightSearch.depDate = depDate;
        FlightSearch.reDate = reDate;
        FlightSearch.txtAdult = txtAdult;
        FlightSearch.txtChild = txtChild;
        FlightSearch.txtInfant = txtInfant;
        FlightSearch.scheduleTab = scheduleTab;
        FlightSearch.yearTab = year;
        //Excute
        FlightSearch.init();
    }
    
    public static void init(){
        returnDateTxtField.setVisible(false);
        
        //Oneway is default chosen
        btnOWay.getStyleClass().add("BookingBtnColorChange");
        
        //FlightBooking Tab
        btnOWay.setOnMouseClicked(e->{
            ButtonBookingnEffect(btnOWay, btnRTrip, returnDateTxtField
                    , false, "BookingBtnColorChange");
        });
      
        btnRTrip.setOnMouseClicked(e->{
            ButtonBookingnEffect(btnRTrip, btnOWay
                    ,returnDateTxtField, true, "BookingBtnColorChange");
        });
        
        FlightSearch.loadDepartureCBox();
        FlightSearch.loadDestinationCBox();
        FlightSearch.setUpDatePicker();

//        FlightSearch.datePickerHandler(depDate);
//        FlightSearch.datePickerHandler(reDate);

        TextSupporter.txtSelectAll(txtAdult);
        TextSupporter.txtSelectAll(txtChild);
        TextSupporter.txtSelectAll(txtInfant);
    }
      
    /**
     * This method to change button's color when it's on clicked
     * @param btn1
     * @param btn2 
     * @param shownPane 
     * @param isFieldShown 
     * @param cssStyle 
     */
    private static void ButtonBookingnEffect(Node btn1, Node btn2, Pane shownPane,
            Boolean isFieldShown, String cssStyle){
        btn1.getStyleClass().add(cssStyle);
        btn2.getStyleClass().removeAll(cssStyle);
        shownPane.setVisible(isFieldShown);
    }
    
     private static void loadDepartureCBox(){
        departure.getItems().addAll(loadAirportInfo());
    }
    
    private static void loadDestinationCBox(){
        List<String> list = loadAirportInfo();
        String selectedItem = departure.getValue();
        if(selectedItem !=null){
            list.remove(departure.getItems().indexOf(selectedItem));
        }
        destination.getItems().addAll(list);
    }
    
    private static ArrayList<String> loadAirportInfo(){
        ArrayList<String> arrStr = new ArrayList<>();
       
        Utils.getAirportInfos().forEach((item) -> {
            arrStr.add(item.getA_Address()+ " (" + item.getA_Id() + ")");
        });
        return arrStr;
    }
    
    private static void setUpDatePicker(){
        //Date Picker's date format
        depDate.setConverter(MyDate.setDateFormat());
        reDate.setConverter(MyDate.setDateFormat());
        //Get current date first
        depDate.setValue(MyDate.getCurrentDate());
        reDate.setValue(MyDate.getCurrentDate());
    }
 
    private static boolean isAllEmpty(){
        return departure.getPromptText().equals("Select Departure" )
                && destination.getPromptText().equals("Select Destination")
                && txtAdult.getText().isEmpty() && txtChild.getText().isEmpty()
                && txtInfant.getText().isEmpty();
    }
    
    /**
     * Search Flight Button Handler
     * @throws java.net.URISyntaxException
     */
    public static void SearchBtnHandler() throws URISyntaxException{
        if(isAllEmpty()){
            MyAlert.createAlert(Alert.AlertType.WARNING, "Warning"
            , "All fields are empty!", "Please fill all fields", "").show();
        }else{
            loadScheduleDate();
        }
    }
    
    public static void loadScheduleDate(){
        
        LocalDate depDateVal = depDate.getValue();
        LocalDate lastDate = MyDate.getLastDate(depDateVal, 1);
        LocalDate nextDate = MyDate.getNextDate(depDateVal, 1);
        
//        List<LocalDate> localDates = new ArrayList<>();
//        LocalDate nextDate = MyDate.convertDateFromString(depDate
//                .getEditor().getText());//first value
//        LocalDate lastDate = MyDate.convertDateFromString(depDate
//                .getEditor().getText());//first value
        
        //get last dates
//        do {            
//            lastDate = MyDate.getLastDate(lastDate, 1);
//            if(lastDate != null){
//                if(localDates.isEmpty()){
//                    localDates.add(lastDate);
//                }else{
//                    localDates.add(0, lastDate);
//                }
//            }
//        } while(lastDate != null);
//        
//        //get next dates
//        int length = scheduleTab.getTabs().size() - localDates.size();
//        for (int i = 0; i < length; i++) {
//            localDates.add(nextDate);
//            nextDate = MyDate.getNextDate(nextDate, 1);
//        }
//        
//        //show dates
//        for (int i = 0; i < scheduleTab.getTabs().size(); i++) {
//            scheduleTab.getTabs().get(i).setText(MyDate.subYear(localDates.get(i)));
//        }
        
        if(MyDate.isCurrentDate(depDateVal)){
            //First tab 
            //Get date value & cut year off
            scheduleTab.getTabs().get(0).setText(MyDate.subYear(depDateVal)); 
            //Other tabs
            for (int i = 1; i < (scheduleTab.getTabs().size() - 1); i++) {
                scheduleTab.getTabs().get(i).setText(MyDate.subYear(nextDate));
                nextDate = MyDate.getNextDate(nextDate, 1);
            }
        }else{
            scheduleTab.getTabs().get(3).setText(MyDate.subYear(depDateVal));
            for (int i = 4; i < (scheduleTab.getTabs().size() - 1); i++) {
               scheduleTab.getTabs().get(i).setText(MyDate.subYear(nextDate));
               nextDate = MyDate.getNextDate(nextDate, 1);
            }
            for (int i = 2; i >= 0; i--) {
               scheduleTab.getTabs().get(i).setText(MyDate.subYear(lastDate));
               lastDate = MyDate.getLastDate(lastDate, 1);
            }
        }
        yearTab.setText(MyDate.getYear());
        openScheduleTab();
    }
    
    public static void openScheduleTab(){
        scheduleTab.getTabs().forEach(tab ->{
            if(MyDate.subYear(depDate.getValue()).equals(tab.getText())){
                scheduleTab.getSelectionModel().select(tab);
            }
        });
    }
}
