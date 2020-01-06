/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aabairline.supporters.recyclebin;

import aabairline.Utils;
import aabairline.pojo.*;
import aabairline.supporters.SupporterImp.ModifiedNode;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;


public class OnewayTicketUI {
//    
//    private static ListView<GridPane> lv;
//    
//    public OnewayTicketUI() { }
//    
//    public void init(TabPane tpOneWay, Date date) throws IOException{
//        tpOneWay.getTabs().setAll(((TabPane)FXMLLoader
//                .load(MyNode.getResource("FXMLOWTSelector.fxml"))).getTabs());
//        setupListView(tpOneWay, date);
//        
//        
//    }
//    
//    public static void setupListView(TabPane tb, Date date) {
//        lvListener(tb, date);
//        tb.getSelectionModel().selectedItemProperty().addListener((observable
//                , oldValue, newValue) -> {
//            
//            clearSelected(((ListView)((GridPane)oldValue.getContent())
//                    .getChildren().get(1)));
//            
//            lvListener(newValue.getTabPane(), date);
//           
//        });        
//    }    
//    
//    public static void lvListener(TabPane tb, Date date){
//        try {
//                lv = ((ListView)((GridPane)
//                        tb.getSelectionModel().getSelectedItem()
//                        .getContent())
//                        .getChildren().get(1));
//       
//                lv.getItems().setAll(list(date));
//                MyNode.myListView(lv);
//                
//            } catch (IOException ex) {
//                Logger.getLogger(OnewayTicketUI.class.getName())
//                        .log(Level.SEVERE, null, ex);
//            }
//    }
//    
//    public static void clearSelected(ListView mLv){
//        if(mLv != null){
//            if (mLv.getSelectionModel().getSelectedItem() != null)
//                mLv.getSelectionModel()
//                        .clearSelection(mLv.getSelectionModel().getSelectedIndex());
//       }
//    }
//    
//    private static List<GridPane> list(Date date) throws IOException{
//        ObservableList<GridPane> list = FXCollections
//                .observableArrayList();
//        
//        
//        List<FlightInfo> flightSchedules = Utils.getFlightInfosByDate(date);
//        
//        flightSchedules.forEach(flight ->{ 
//            try {
//                GridPane gridUI;
//                TicketUI ticketUI = new TicketUI();
//                ticketUI.setText(flight.getTakeOfTime().toString()
//                    , flight.getTakeOfDate().toString()
//                    , flight.getArrivalTime().toString()
//                    , flight.getArrivalDate().toString());
//            
//                gridUI = ticketUI.getGridUI();
//                list.add(gridUI);
//            } catch (IOException ex) {
//                Logger.getLogger(OnewayTicketUI.class.getName()).log(Level.SEVERE, null, ex);
//            } 
//        });
//        return list;
//     }
}
