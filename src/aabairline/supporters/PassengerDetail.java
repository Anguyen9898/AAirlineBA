/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aabairline.supporters;

import aabairline.Utils;
import aabairline.supporters.SupporterImp.*;
import aabairline.pojo.Country;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author anguy
 */
public class PassengerDetail {

    private static TabPane passengerTab;
    private static ComboBox<String> passSuffix;
    private static ComboBox<String> bookerSuffix;
    private static ComboBox<String> cbPPrefix;
    private static ComboBox<String> cbCusId;
    private static ComboBox<Country> cbNationality;
    private static ComboBox<Country> cbCountry;
    private static ComboBox<String> cbAccom;
    private static DatePicker dateOfBirth;

    private static TextField txtPassFMName;
    private static TextField txtFName;
    private static TextField txtIDNum;
    private static TextField txtEmail;
    private static TextField txtPhoneNum;
    private static TextField txtAdress;

    private static final String[] arrSuffix = {"Mr.", "Ms.", "Mrs."};
    public static int passengerCount;
    public static int childrenCount;
    public static int infantCount;
    
//    public PassengerDetail(){
//        
//    }
//
//    public void setPassengerCount(int passengerCount) {
//        this.passengerCount = passengerCount;
//    }

    public PassengerDetail(TabPane passengerTab, ComboBox<String> passSuffix,
             ComboBox<String> bookerSuffix, ComboBox<String> phoneArea,
             ComboBox<String> cusId, ComboBox<Country> nationality,
             ComboBox<Country> country, DatePicker dateOfBirth, TextField txtPassFMName,
             TextField txtFName, TextField txtIDNum, TextField txtEmail,
             TextField txtPhoneNum, TextField txtAdress, ComboBox<String> cbAccom) {
        
        PassengerDetail.passengerTab = passengerTab;
        PassengerDetail.passSuffix = passSuffix;
        PassengerDetail.bookerSuffix = bookerSuffix;
        PassengerDetail.cbPPrefix = phoneArea;
        PassengerDetail.cbCusId = cusId;
        PassengerDetail.cbNationality = nationality;
        PassengerDetail.cbCountry = country;
        PassengerDetail.dateOfBirth = dateOfBirth;
        PassengerDetail.txtPassFMName = txtPassFMName;
        PassengerDetail.txtFName = txtFName;
        PassengerDetail.txtIDNum = txtIDNum;
        PassengerDetail.txtEmail = txtEmail;
        PassengerDetail.txtPhoneNum = txtPhoneNum;
        PassengerDetail.txtAdress = txtAdress;
        PassengerDetail.cbAccom = cbAccom;

        init();
    }

    public static void init() {
        cbCusId.setDisable(true);
        
        dateOfBirth.setConverter(MyDate.setDateFormat());
        dateOfBirth.setValue(LocalDate.of(1960, Month.JANUARY, 1));
        
        //Setup Combobox
        passSuffix.getItems().addAll(arrSuffix);
        bookerSuffix.getItems().addAll(arrSuffix);
        cbCountry.getItems().addAll(Utils.getCountry());
        cbCountry.getItems().addAll(Utils.getCountry());
        cbNationality.getItems().addAll(Utils.getCountry());
        cbPPrefix.getItems().addAll(Utils.getPhonePrefix());
        
        String strId = CreateID.newCustomer();
        cbCusId.getItems().add(strId);
        cbCusId.getSelectionModel().select(strId);
        
        Utils.getCustomer().forEach(item ->{
             cbCusId.getItems().add(item.getId());
        });

        bookerSuffix.valueProperty().bind(passSuffix.valueProperty());
        bookerSuffix.valueProperty().addListener((ObservableValue<? extends String> 
                observable, String oldValue, String newValue) ->{
            bookerSuffix.valueProperty().unbind();
        });
        
            
        txtPassFMName.textProperty().addListener(e -> {
            txtFName.setText(txtPassFMName.getText());
        });
    }
    
    public static void setExtrasPassTab(URL location) throws IOException{
       int size = passengerTab.getTabs().size();
       //Clear if it do second time
        if(size > 1){
           for(int i = size - 1; i > 0; i--){
               passengerTab.getTabs().remove(i);
           }
        }
        for(int i = 1; i < passengerCount; i++){
            Tab tab = ((TabPane)FXMLLoader.load(location)).getTabs().get(0);  
            tab.setText("(**) Passenger " + (i + 1));
            passengerTab.getTabs().add(i, tab);
        }
        if(childrenCount > 0){
            size = passengerTab.getTabs().size();//update passenger tab size
            if(infantCount > 0){
                passengerTab.getTabs().get(size - 1)
                        .setText(passengerTab.getTabs().get(size - 1)
                                .getText() + " (Infant)");
                size--;
            }
            for(int i = 0 ; i < childrenCount; i++){
                passengerTab.getTabs().get(size - 1)
                        .setText(passengerTab.getTabs().get(size - 1)
                                .getText() + " (Child)");
                size--;
            }
        }
        setupPassengerTabPane();
    }
    
    public static void setupPassengerTabPane(){
        CheckBox cb = ((CheckBox) passengerTab.getTabs().get(0).getGraphic());
            cbCusId.disableProperty().bind(cb.selectedProperty().not());
        List<String> arrList = new ArrayList<>();
        //Setup combobox accompanied's items by
         passengerTab.getTabs().forEach(tab -> {
            arrList.add(tab.getText());
        });
        passengerTab.getTabs().forEach(tab -> {
            ((VBox)((HBox)((GridPane) tab.getContent()).getChildren().get(2))
                    .getChildren().get(1)).getChildren().forEach(node ->{
                        if(node instanceof ComboBox){
                            node.setDisable(true);
                            ((ComboBox) node).getItems().addAll(arrList);
                            ((ComboBox) node).getSelectionModel().select(0);
                        }
                    });
            
            DatePicker dp = (DatePicker)((VBox)((GridPane) tab.getContent())
                    .getChildren().get(0)).getChildren().get(1);
            
            dp.setConverter(MyDate.setDateFormat());
            dp.setValue(LocalDate.of(1960, Month.JANUARY, 1));
        });
    }
}
