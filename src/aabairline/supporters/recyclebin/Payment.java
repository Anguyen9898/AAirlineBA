/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aabairline.supporters.recyclebin;

import aabairline.FXMLBookingController;
import aabairline.supporters.Booking.FlightSearch;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author anguy
 */
    public class Payment{
    
    private static Button btnFinish;
    private static Tab paymentTab;
    private static BorderPane cashMethod;
    private static BorderPane cardMethod;
    private static CheckBox payIma;
    private static CheckBox payLater;
    private static GridPane cashShow;
    private static GridPane cardShow;
    private static Label txtCash;
    private static Label txtCredit;
    private static Label closeCash;
    private static Label closeCard;
    

    private static Label schDate;
    private static Label schDeparture;
    private static Label schDestination;
    private static Label schId;
    private static Label schDepTime;
    private static Label schDesTime;

    public Payment(Button btnFinish, Tab paymentTab, BorderPane cashMethod
            , BorderPane cardMethod, CheckBox payIma, CheckBox payLater
            , GridPane cashShow, GridPane cardShow, Label txtCash, Label txtCredit
            , Label closeCash, Label closeCard,Label schDate, Label schDeparture
            , Label schDestination, Label schId, Label schDepTime, Label schDesTime){
        Payment.btnFinish = btnFinish;
        Payment.paymentTab = paymentTab;
        Payment.cashMethod = cashMethod;
        Payment.cardMethod = cardMethod;
        Payment.payIma = payIma;
        Payment.payLater = payLater;
        Payment.cashShow = cashShow;
        Payment.cardShow = cardShow;
        Payment.txtCash = txtCash;
        Payment.txtCredit = txtCredit;
        Payment.closeCash = closeCash;
        Payment.closeCard = closeCard;
        
        Payment.schDate = schDate;
        Payment.schDepTime = schDepTime;
        Payment.schDeparture = schDeparture;
        Payment.schDesTime = schDesTime;
        Payment.schDestination = schDestination;
        Payment.schId= schId;
        
        Payment.init();
    }
    public static void init(){
        //Set Visible to hided nodes
        cashShow.setVisible(false);
        cardShow.setVisible(false);
        
        txtCash.setVisible(false);
        txtCash.setPrefWidth(0);
        txtCredit.setVisible(false);
        txtCredit.setPrefWidth(0);
        
        //Set Disible to hided nodes
        cashMethod.setDisable(true);
        cashMethod.getStyleClass().add("PaymentMethodDisable");
        cardMethod.setDisable(true);
        cardMethod.getStyleClass().add("PaymentMethodDisable");
        
        //OnClick-Animation
        cashMethod.setOnMouseClicked(e->{
            ShowOrHidePaymentMethod(cashShow, cardShow, cashMethod
                    , cardMethod, "PaymentMethodOnClick");
        });
        
        cardMethod.setOnMouseClicked(e->{
            ShowOrHidePaymentMethod(cardShow, cashShow
                    , cardMethod, cashMethod, "PaymentMethodOnClick");
        });
        
        closeCash.setOnMouseClicked(e->{
            ShowOrHidePaymentMethod(cashShow, cashShow, 
                    cashMethod, cashMethod, "PaymentMethodOnClick");
        });
        
        closeCard.setOnMouseClicked(e->{
            ShowOrHidePaymentMethod(cardShow, cardShow, 
                    cardMethod, cardMethod, "PaymentMethodOnClick");
        });
        
        payIma.setOnAction(e->{
            if(payIma.isSelected()){
                payLater.setSelected(false);
                payLater.getParent().getStyleClass().removeAll("PaymentTimeOnChecked");
                payIma.getParent().getStyleClass().add("PaymentTimeOnChecked");
                cashMethod.getParent().getStyleClass()
                        .add("PaymentTimeOnChecked");
                cashMethod.setDisable(false);
                cashMethod.getStyleClass().removeAll("PaymentMethodDisable");
                cardMethod.setDisable(false);
                cardMethod.getStyleClass().removeAll("PaymentMethodDisable");
            }else{
                payIma.getParent().getStyleClass().removeAll("PaymentTimeOnChecked");
                cashMethod.getParent().getStyleClass()
                        .removeAll("PaymentTimeOnChecked");
                cashMethod.setDisable(true);
                cashMethod.getStyleClass().add("PaymentMethodDisable");
                cardMethod.setDisable(true);
                cardMethod.getStyleClass().add("PaymentMethodDisable");
                ShowOrHidePaymentMethod(cashShow, cashShow, 
                    cashMethod, cashMethod, "PaymentMethodOnClick");
                ShowOrHidePaymentMethod(cardShow, cardShow, 
                    cardMethod, cardMethod, "PaymentMethodOnClick");
            }
        });
        
        payLater.setOnAction(e->{
            if(payLater.isSelected()){
                payIma.setSelected(false);
                payLater.getParent().getStyleClass().add("PaymentTimeOnChecked");
                payIma.getParent().getStyleClass().removeAll("PaymentTimeOnChecked");
                cashMethod.getParent().getStyleClass()
                        .removeAll("PaymentTimeOnChecked");
                cashMethod.setDisable(true);
                cashMethod.getStyleClass().add("PaymentMethodDisable");
                cardMethod.setDisable(true);
                cardMethod.getStyleClass().add("PaymentMethodDisable");
                ShowOrHidePaymentMethod(cashShow, cashShow, 
                    cashMethod, cashMethod, "PaymentMethodOnClick");
                ShowOrHidePaymentMethod(cardShow, cardShow, 
                    cardMethod, cardMethod, "PaymentMethodOnClick");
            }else{
                payLater.getParent().getStyleClass().removeAll("PaymentTimeOnChecked");
            }
        });
        
        paymentTab.setOnSelectionChanged(e->{
            if(paymentTab.isSelected()){
                btnFinish.setVisible(true);
            }
            else
                btnFinish.setDisable(false);
        });
    }
    
    
    /**
     * This method to show or hide while payment methods are chosen
     * @param shownMethod
     * @param hidedMethod
     * @param clickedBtn
     * @param unClickedBtn
     * @param cssStyle 
     */
    
    private static void ShowOrHidePaymentMethod(Pane shownMethod, Pane hidedMethod,
        BorderPane clickedBtn, BorderPane unClickedBtn, String cssStyle){
        
        //Clicked Button
        clickedBtn.getStyleClass().add(cssStyle);
        GridPane.setColumnSpan(clickedBtn, 2);
        clickedBtn.getLeft().setVisible(true);
        ((Label)clickedBtn.getLeft()).setPrefWidth(280);
        shownMethod.setVisible(true);
        //unClicked Button
        unClickedBtn.getStyleClass().removeAll(cssStyle);
        GridPane.setColumnSpan(unClickedBtn, 1);
        unClickedBtn.getLeft().setVisible(false);
        ((Label)unClickedBtn.getLeft()).setPrefWidth(0);
        hidedMethod.setVisible(false);
    }
    
    public static void setSchedule(){
        if(FlightSearch.selectedFlight != null){
            schDate.setText("(" + FlightSearch.selectedFlight.getTakeOfDate()
                    .toString()
                    + ") - (" 
                    + FlightSearch.selectedFlight.getArrivalDate().toString() + ")");
            
            schDepTime.setText(FlightSearch.selectedFlight.getTakeOfTime().toString());
            schDesTime.setText(FlightSearch.selectedFlight.getArrivalTime().toString());
            schDeparture.setText(FlightSearch.selectedFlight.getRoute()
                    .getTakeOffAP().toString());
            schDestination.setText(FlightSearch.selectedFlight.getRoute()
                    .getArrivalAP().toString());
            schId.setText(FlightSearch.selectedFlight.getId());
        }
    }
}
