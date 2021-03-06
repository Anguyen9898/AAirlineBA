/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aabairline;
import aabairline.supporters.Booking.PassengerDetail;
import aabairline.supporters.Booking.FlightSearch;
import aabairline.pojo.*;
import aabairline.supporters.*;
import aabairline.supporters.SupporterImp.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
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
    @FXML
    private Label lbPrice;
    
    //FlightSearch_Tab
    @FXML
    private TableView scheduleTa;
    @FXML
    private Button btnOWay;
    @FXML
    private Button btnRTrip;
    @FXML
    private GridPane returnDateTxtField;
    @FXML
    private ComboBox<AirportInfo> departure;
    @FXML
    private ComboBox<AirportInfo> destination;
    @FXML
    private DatePicker depDate;
    @FXML
    private DatePicker reDate;
    @FXML
    private ComboBox<Integer> cbAdult;
    @FXML
    private ComboBox<Integer> cbChild;
    @FXML
    private ComboBox<Integer> cbInfant;
    @FXML
    private Label lbTicket;
    
    //Passenger_Tab
    @FXML
    private TabPane passengerTab;
    @FXML
    private ComboBox<String> gender;
    @FXML
    private ComboBox<String> phoneArea;
    @FXML
    private ComboBox<String> cbCusId;
    @FXML
    private ComboBox<Country> nationality;
    @FXML
    private ComboBox<Country> country;
    @FXML
    private ComboBox<String> cbAccom;
    @FXML
    private DatePicker dateOfBirth;
    @FXML
    private TextField txtPassFMName;
    @FXML
    private TextField txtFullName;
    @FXML
    private TextField txtIDNum;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtPhoneNum;
    @FXML
    private TextField txtAdress;
    @FXML
    private ComboBox<String> bookerGender;
    
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
    
    @FXML
    private Label schDate;
    @FXML
    private Label schDeparture;
    @FXML
    private Label schDestination;
    @FXML
    private Label schId;
    @FXML
    private Label schDepTime;
    @FXML
    private Label schDesTime;
    
    //Extras
//    @FXML
//    private CheckBox seatCheckBox;
//    @FXML
//    private CheckBox luggCheckBox;
//    @FXML
//    private GridPane luggSelect;
//    @FXML
//    private ListView seatSelect;
//    @FXML
//    private CheckBox lugg20kg;
//    @FXML
//    private CheckBox lugg25kg;
//    @FXML
//    private CheckBox lugg30kg;
//    @FXML
//    private CheckBox lugg35kg;
//    @FXML
//    private CheckBox lugg40kg;
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //FlightSearch tab
        try {
            new FlightSearch(btnOWay, btnRTrip, returnDateTxtField, departure
                    , destination, depDate, reDate, cbAdult, cbChild, cbInfant
                    , scheduleTa, lbPrice, lbTicket);
        } catch (IOException ex) {
            Logger.getLogger(FXMLBookingController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        //Passenger tab
        new PassengerDetail(passengerTab, gender, bookerGender, phoneArea, cbCusId
                , nationality, country, dateOfBirth, txtPassFMName, txtFullName
                , txtIDNum, txtEmail, txtPhoneNum, txtAdress, cbAccom);
        
//        //Payment tab
//        new Payment(btnFinish, paymentTab, cashMethod, cardMethod, payIma, payLater
//                , cashShow, cardShow, txtCash, txtCredit, closeCash, closeCard
//                , schDate, schDeparture, schDestination, schId, schDepTime
//                , schDesTime);
        
//        //Extras tab
//        new Extras(seatCheckBox, luggCheckBox, luggSelect, seatSelect, lugg20kg
//                , lugg25kg, lugg30kg, lugg35kg, lugg40kg);
        
//        BookingTab.getSelectionModel().selectedItemProperty().addListener(listener ->{
//            if(BookingTab.getSelectionModel().isSelected(3)){
//                Payment.setSchedule();
//            }
//        });
    }
    
    
     /**
     * Search Flight Button Handler
     * @param event
     * @throws java.net.URISyntaxException
     * @throws java.io.IOException
     */
    public void searchBtnHandler(ActionEvent event) throws URISyntaxException
            , IOException{
        FlightSearch.searchBtnHandler();
    }
    
    /**
     * Exit Button Handler
     * @param event
     * @throws java.net.URISyntaxException
     */
    public void exitBtnHandler(ActionEvent event) throws URISyntaxException{
        ModifiedNode.myAlert(Alert.AlertType.CONFIRMATION, "Exit Flight-Booking", 
                "Are you sure to exit!", "", "images/cancel.png").showAndWait()
                .ifPresent(respone ->{
                    if(respone == ButtonType.OK)
                        ((Stage)((Node)(event.getSource())).getScene().getWindow())
                                .close();
                });
    }
    
    /**
     * Next Button Handler
     * @param event 
     * @throws java.io.IOException 
     */
    public void nextBtnHandler(ActionEvent event) throws IOException, URISyntaxException{
        //Move to next tab
        nextTab();
//        //Create passenger detail tab
//        tabPassengerAmout();
    }
    
    public void nextTab() throws URISyntaxException{
        int i = BookingTab.getSelectionModel().getSelectedIndex();
          //next tab
        if(i < 1){
            BookingTab.getSelectionModel().select(BookingTab.getTabs().get(i + 1));
            
        }
    }
    public int getAdultCount(){
        return cbAdult.getSelectionModel().getSelectedItem();
    }
    
    public int getChildrenCount(){
        return cbChild.getSelectionModel().getSelectedItem();
    }
    
    public int getInfantCount(){
        return cbInfant.getSelectionModel().getSelectedItem();
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
    
    public void btnFinishHandler(ActionEvent event) throws URISyntaxException{
        PassengerDetail.setIfOldCustomer(cbCusId.getSelectionModel()
                .getSelectedItem());  
        //save or update ticket
         ModifiedNode.myAlert(Alert.AlertType.CONFIRMATION
                , "Save Ticket", "Are you sure to finish booking", ""
                , "images/login.png")
                .showAndWait()
                .ifPresent(rep ->{
                    if(rep == ButtonType.OK){
                        if(Utils.addOrUpdateTicket(getTicket())
                                && Utils.addOrUpdateCustomer(getCustomer())){
                            new Alert(Alert.AlertType.INFORMATION
                                    , "Add or Update Sucessfull").show();
                        }else{
                            new Alert(Alert.AlertType.INFORMATION
                                    , "Add or Update Failed").show();
                        }
                    }
                });
        
         
    }
    
    public Customer getCustomer(){
        if(PassengerDetail.newCus == null){
             PassengerDetail.newCus = new Customer(
                     cbCusId.getSelectionModel().getSelectedItem()
                     , txtPassFMName.getText()
                     , txtIDNum.getText()
                     , txtPhoneNum.getText()
                     , MyDate.convertToDateViaInstant(dateOfBirth.getValue())
                     , txtAdress.getText()
                     , txtEmail.getText()
                     , gender.getSelectionModel().getSelectedItem()
                     , country.getSelectionModel().getSelectedItem());
        }else{
            PassengerDetail.newCus.setName(txtPassFMName.getText());
            PassengerDetail.newCus.setIdNum(txtIDNum.getText());
            PassengerDetail.newCus.setPhone(txtPhoneNum.getText());
            PassengerDetail.newCus.setDayOfBirth(MyDate
                    .convertToDateViaInstant(dateOfBirth.getValue()));
            PassengerDetail.newCus.setAddress(txtAdress.getText());
            PassengerDetail.newCus.setEmail(txtEmail.getText());
            PassengerDetail.newCus.setGender(gender.getSelectionModel()
                    .getSelectedItem());
            PassengerDetail.newCus.setCountry(country.getSelectionModel()
                    .getSelectedItem());
            
        }
        return  PassengerDetail.newCus;
    }
    
    public Ticket getTicket(){
        return new Ticket(CreateID.newTicket(),
                getCustomer()
                , FlightSearch.selectedFlight
                , FXMLLoginController.currentUser
                , FlightSearch.selectedFlight.getTakeOfDate()
                , LocalDate.now().toString()
                , false
                , FlightSearch.selectedFlight.getPrice()
                , getCustomer());
    }
    
    //    public void tabPassengerAmout() throws IOException{
//        int sum = getAdultCount() + getChildrenCount() + getInfantCount();
//        PassengerDetail.childrenCount = getChildrenCount();
//        PassengerDetail.infantCount = getInfantCount();
//        if(sum > 1){
//            PassengerDetail.passengerCount = sum;
//            PassengerDetail.setExtrasPassTab(this.getClass()
//                    .getResource("FXMLExtrasPassenger.fxml"));
//        }
//    }
}