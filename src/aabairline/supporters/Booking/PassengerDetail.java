/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aabairline.supporters.Booking;

import aabairline.Utils;
import aabairline.supporters.SupporterImp.*;
import aabairline.pojo.Country;
import aabairline.pojo.Customer;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

/**
 *
 * @author anguy
 */
public class PassengerDetail {

    private static TabPane passengerTab;
    private static ComboBox<String> passGender;
    private static ComboBox<String> bookerGender;
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

    private static final String[] arrSuffix = {"Male", "Female"};
    public static int passengerCount;
    public static int childrenCount;
    public static int infantCount;
    
    public static Customer newCus;
    
//    public PassengerDetail(){
//        
//    }
//
//    public void setPassengerCount(int passengerCount) {
//        this.passengerCount = passengerCount;
//    }

    public PassengerDetail(TabPane passengerTab, ComboBox<String> passGender,
             ComboBox<String> bookerGender, ComboBox<String> phoneArea,
             ComboBox<String> cusId, ComboBox<Country> nationality,
             ComboBox<Country> country, DatePicker dateOfBirth, TextField txtPassFMName,
             TextField txtFName, TextField txtIDNum, TextField txtEmail,
             TextField txtPhoneNum, TextField txtAdress, ComboBox<String> cbAccom) {
        
        PassengerDetail.passengerTab = passengerTab;
        PassengerDetail.passGender = passGender;
        PassengerDetail.bookerGender = bookerGender;
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
        
        
        dateOfBirth.setConverter(MyDate.setDateFormat());
        dateOfBirth.setValue(LocalDate.of(1960, Month.JANUARY, 1));
        
        //Setup Combobox
        passGender.getItems().addAll(arrSuffix);
        
        bookerGender.getItems().addAll(arrSuffix);
        
        cbCountry.getItems().addAll(Utils.getCountry());
        
        cbNationality.getItems().addAll(Utils.getCountry());
        
        cbPPrefix.getItems().addAll(Utils.getPhonePrefix());
        
        cbCusId.setDisable(true);
        
        cbCusId.disableProperty()
                .bind(((CheckBox)(passengerTab.getTabs().get(0).getGraphic()))
                .selectedProperty().not());
        
        String strId = CreateID.newCustomer();
        cbCusId.getItems().add(strId);
        cbCusId.getSelectionModel().select(strId);
        
        Utils.getCustomer().forEach(item ->{
            cbCusId.getItems().add(item.getId());
        });
        
        cbCusId.getSelectionModel().selectedItemProperty().addListener(listener ->{
            setIfOldCustomer(cbCusId.getSelectionModel().getSelectedItem());     
        });
        
        bookerGender.valueProperty().bind(passGender.valueProperty());
        bookerGender.valueProperty().addListener((ObservableValue<? extends String> 
                observable, String oldValue, String newValue) ->{
            bookerGender.valueProperty().unbind();
        });
            
        txtPassFMName.textProperty().addListener(e -> {
            txtFName.setText(txtPassFMName.getText());
        });
    }
    
    public static void setIfOldCustomer(String id){
        if(Utils.getCustomerById(id).get(0) != null){
            txtPassFMName.setText(Utils.getCustomerById(id).get(0).getName());
            txtAdress.setText(Utils.getCustomerById(id).get(0).getAddress());
            txtEmail.setText(Utils.getCustomerById(id).get(0).getEmail());
            txtIDNum.setText(Utils.getCustomerById(id).get(0).getIdNum());
            txtPhoneNum.setText(Utils.getCustomerById(id).get(0).getPhone());
            
            cbCountry.getSelectionModel().select(Utils.getCustomerById(id).get(0)
                    .getCountry());
            
            cbNationality.getSelectionModel().select(Utils.getCustomerById(id).get(0)
                    .getCountry());
            
            dateOfBirth.setValue(MyDate.convertToLocalDateVia(
                    Utils.getCustomerById(id).get(0).getDayOfBirth())
            );
            if(Utils.getCustomerById(id).get(0).getGender().equals("Nam")){
                passGender.getSelectionModel().select("Male");
                bookerGender.getSelectionModel().select("Male");
            }else{
                passGender.getSelectionModel().select("Female");
                bookerGender.getSelectionModel().select("Female");
            }
            newCus = Utils.getCustomerById(id).get(0);
        }
    }
    
//    public static void setExtrasPassTab(URL location) throws IOException{
//       int size = passengerTab.getTabs().size();
//       //Clear if it do second time
//        if(size > 1){
//           for(int i = size - 1; i > 0; i--){
//               passengerTab.getTabs().remove(i);
//           }
//        }
//        for(int i = 1; i < passengerCount; i++){
//            Tab tab = ((TabPane)FXMLLoader.load(location)).getTabs().get(0);  
//            tab.setText("(**) Passenger " + (i + 1));
//            passengerTab.getTabs().add(i, tab);
//        }
//        if(childrenCount > 0){
//            size = passengerTab.getTabs().size();//update passenger tab size
//            if(infantCount > 0){
//                passengerTab.getTabs().get(size - 1)
//                        .setText(passengerTab.getTabs().get(size - 1)
//                                .getText() + " (Infant)");
//                size--;
//            }
//            for(int i = 0 ; i < childrenCount; i++){
//                passengerTab.getTabs().get(size - 1)
//                        .setText(passengerTab.getTabs().get(size - 1)
//                                .getText() + " (Child)");
//                size--;
//            }
//        }
//        setupPassengerTabPane();
//    }
//    
//    public static void setupPassengerTabPane(){
////        CheckBox cb = ((CheckBox) passengerTab.getTabs().get(0).getGraphic());
////            cbCusId.disableProperty().bind(cb.selectedProperty().not());
////        List<String> arrList = new ArrayList<>();
////        //Setup combobox accompanied's items by
////         passengerTab.getTabs().forEach(tab -> {
////            arrList.add(tab.getText());
////        });
////        passengerTab.getTabs().forEach(tab -> {
////            ((VBox)((HBox)((GridPane) tab.getContent()).getChildren().get(2))
////                    .getChildren().get(1)).getChildren().forEach(node ->{
////                        if(node instanceof ComboBox){
////                            node.setDisable(true);
////                            ((ComboBox) node).getItems().addAll(arrList);
////                            ((ComboBox) node).getSelectionModel().select(0);
////                        }
////                    });
////            
////            DatePicker dp = (DatePicker)((VBox)((GridPane) tab.getContent())
////                    .getChildren().get(0)).getChildren().get(1);
////            
////            dp.setConverter(MyDate.setDateFormat());
////            dp.setValue(LocalDate.of(1960, Month.JANUARY, 1));
////        });
//    }
    
    
}
