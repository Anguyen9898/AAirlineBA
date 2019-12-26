/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aabairline.supporters;

import aabairline.Utils;
import aabairline.pojo.AirportInfo;
import aabairline.supporters.SupporterImp.*;
import aabairline.pojo.Country;
import aabairline.pojo.Customer;
import java.time.LocalDate;
import java.time.Month;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

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
    private static DatePicker dateOfBirth;

    private static TextField txtPassFMName;
    private static TextField txtPassLastName;
    private static TextField txtBookerFMName;
    private static TextField txtBookerLastName;
    private static TextField txtIDNum;
    private static TextField txtEmail;
    private static TextField txtPhoneNum;
    private static TextField txtAdress;

    private static final String[] arrSuffix = {"Mr.", "Ms.", "Mrs."};

    public PassengerDetail(TabPane passengerTab, ComboBox<String> passSuffix,
             ComboBox<String> bookerSuffix, ComboBox<String> phoneArea,
             ComboBox<String> cusId, ComboBox<Country> nationality,
             ComboBox<Country> country, DatePicker dateOfBirth, TextField txtPassFMName,
             TextField txtPassLastName, TextField txtBookerFMName,
             TextField txtBookerLastName, TextField txtIDNum, TextField txtEmail,
             TextField txtPhoneNum, TextField txtAdress) {
        
        PassengerDetail.passengerTab = passengerTab;
        PassengerDetail.passSuffix = passSuffix;
        PassengerDetail.bookerSuffix = bookerSuffix;
        PassengerDetail.cbPPrefix = phoneArea;
        PassengerDetail.cbCusId = cusId;
        PassengerDetail.cbNationality = nationality;
        PassengerDetail.cbCountry = country;
        PassengerDetail.dateOfBirth = dateOfBirth;
        PassengerDetail.txtPassFMName = txtPassFMName;
        PassengerDetail.txtPassLastName = txtPassLastName;
        PassengerDetail.txtBookerFMName = txtBookerFMName;
        PassengerDetail.txtBookerLastName = txtBookerLastName;
        PassengerDetail.txtIDNum = txtIDNum;
        PassengerDetail.txtEmail = txtEmail;
        PassengerDetail.txtPhoneNum = txtPhoneNum;
        PassengerDetail.txtAdress = txtAdress;

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
        
        passSuffix.valueProperty().addListener((ObservableValue<? extends String> 
                observable, String oldValue, String newValue) ->{
            
            bookerSuffix.getSelectionModel().select(newValue);
        });
        
        passengerTab.getTabs().forEach(tab -> {
            CheckBox cb = ((CheckBox) tab.getGraphic());
            cb.setOnAction(e -> {
                if (cb.isSelected()) {
                    cbCusId.setDisable(false);
                } else {
                    cbCusId.setDisable(true);
                    cbCusId.getSelectionModel().select(strId);
                }
            });
        });

        txtAutoComplete(txtPassFMName, txtBookerFMName);
        txtAutoComplete(txtPassLastName, txtBookerLastName);
    }

    public static void txtAutoComplete(TextField txt1, TextField txt2) {
        txt1.textProperty().addListener(e -> {
            txt2.setText(txt1.getText());
        });
    }
}
