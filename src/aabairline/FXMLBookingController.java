/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aabairline;
import aabairline.supporters.FlightSearch;
import aabairline.supporters.Payment;
import aabairline.supporters.Extras;
import aabairline.supporters.SupporterImp;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author anguy
 */
public class FXMLBookingController implements Initializable{
    @FXML
    private TabPane BookingTab;
    @FXML
    private Button btnFinish;
    @FXML
    private Button btnNext;
    @FXML
    private Button btnBack;
    
    //FlightSearch_Tab
    @FXML
    private TabPane scheduleTab;
    @FXML
    private Tab yearTab;
    @FXML
    private Button btnOWay;
    @FXML
    private Button btnRTrip;
    @FXML
    private GridPane returnDateTxtField;
    @FXML
    private ComboBox<String> departure;
    @FXML
    private ComboBox<String> destination;
    @FXML
    private DatePicker depDate;
    @FXML
    private DatePicker reDate;
    @FXML
    private TextField txtAdult;
    @FXML
    private TextField txtChild;
    @FXML
    private TextField txtInfant;
    @FXML
    private ListView lvDate;
    @FXML
    private ListView lvTime;
    
    //Payment_Tab
    @FXML
    private Tab paymentTab;
    @FXML
    private BorderPane cashMethod;
    @FXML
    private BorderPane cardMethod;
    @FXML
    private CheckBox payIma;
     @FXML
    private CheckBox payLater;
    @FXML
    private GridPane cashShow;
    @FXML
    private GridPane cardShow;
    @FXML
    private Label txtCash;
    @FXML
    private Label txtCredit;
    @FXML
    private Label closeCash;
    @FXML
    private Label closeCard;
    
    //Extras
    @FXML
    private CheckBox seatCheckBox;
    @FXML
    private CheckBox luggCheckBox;
    @FXML
    private GridPane luggSelect;
    @FXML
    private ListView seatSelect;
    @FXML
    private CheckBox lugg20kg;
    @FXML
    private CheckBox lugg25kg;
    @FXML
    private CheckBox lugg30kg;
    @FXML
    private CheckBox lugg35kg;
    @FXML
    private CheckBox lugg40kg;
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        BookingTab.getTabs().forEach(tab ->{
               if(BookingTab.getTabs().indexOf(tab) != 0){
                    tab.setDisable(true);
               }
        });
        btnFinish.setDisable(true);
        btnNext.setDisable(true);
        btnBack.setDisable(true);
        SupporterImp.MyDate.disablePastDate(depDate);
        SupporterImp.MyDate.disablePastDate(reDate);

        new FlightSearch(btnOWay, btnRTrip, returnDateTxtField, departure, destination
                , depDate, reDate, txtAdult, txtChild, txtInfant, scheduleTab, yearTab);
        
        //Payment tab
        new Payment(btnFinish, paymentTab, cashMethod, cardMethod, payIma, payLater
                , cashShow, cardShow, txtCash, txtCredit, closeCash, closeCard);
        
        //Extras tab
        new Extras(seatCheckBox, luggCheckBox, luggSelect, seatSelect, lugg20kg
                , lugg25kg, lugg30kg, lugg35kg, lugg40kg);
    }
    
    
     /**
     * Search Flight Button Handler
     * @param event
     * @throws java.net.URISyntaxException
     */
    public void searchBtnHandler(ActionEvent event) throws URISyntaxException{
        FlightSearch.SearchBtnHandler();
    }
    
    /**
     * Exit Button Handler
     * @param event
     * @throws java.net.URISyntaxException
     */
    public void exitBtnHandler(ActionEvent event) throws URISyntaxException{
        SupporterImp.MyAlert.createAlert(Alert.AlertType.CONFIRMATION, "Exit", 
                "Are you sure to exit!", "", "images/cancel.png").showAndWait()
                .ifPresent(respone ->{
                    if(respone == ButtonType.OK)
                        Platform.exit();
                });
    }
    
    /**
     * Next Button Handler
     * @param event 
     */
    public void nextBtnHandler(ActionEvent event){
        int i = BookingTab.getSelectionModel().getSelectedIndex();
        if(i < 3)
            BookingTab.getSelectionModel().select(BookingTab.getTabs().get(i + 1));
    }
    
    /**
     * Back Button Handler
     * @param event 
     */
    public void backBtnHandler(ActionEvent event){
        int i = BookingTab.getSelectionModel().getSelectedIndex();
        if(i > 0)
            BookingTab.getSelectionModel().select(BookingTab.getTabs().get(i - 1));
    }
}