/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aabairline.supporters;

import aabairline.Utils;
import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.FormatStyle;
import java.util.Date;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.util.converter.LocalDateStringConverter; 

/**
 *
 * @author anguy
 */
public interface SupporterImp{
   
    public static class MyDate{
         
        public static LocalDate getCurrentDate(){
            return LocalDate.now();
        }
        
        public static Boolean isCurrentDate(LocalDate localDate){
            return localDate.equals(LocalDate.now());
        }
 
        public static LocalDateStringConverter setDateFormat(){
            return new LocalDateStringConverter(FormatStyle.FULL);
        }
        
        public static String convertDateToString(LocalDate date){
            return setDateFormat().toString(date);
        }
        
        public static LocalDate convertDateFromString(String str){
            return setDateFormat().fromString(str);
        }
        
       
        public static void disablePastDate(DatePicker dp){
            dp.setDayCellFactory((picker) -> {
                return new DateCell(){
                    @Override
                    public void updateItem(LocalDate date, boolean empty) {
                        super.updateItem(date, empty);
                        setDisable(empty || date.compareTo(LocalDate.now()) < 0);
                    }
                };
            });
        }
        
        public static Date convertToDateViaInstant(LocalDate dateToConvert) {
                return Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
        }
        
        public LocalDate convertToLocalDateVia(Date dateToConvert) {
            return Instant.ofEpochMilli(dateToConvert.getTime())
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
}
//        public static String subYear(LocalDate date){
//            String str = convertDateToString(date);
//            return str.substring(0, str.length() - 6);
//        }
//         
//        public static String getYear(LocalDate date) {
//            return String.valueOf(date.getYear());
//        }
//        
//        
//        public static LocalDate getNextDate(LocalDate date, int i){
//            return date.plusDays(i);
//        }
//        
//        public static LocalDate getLastDate(LocalDate date, int i){
//           if(!isCurrentDate(date)){
//               return date.minusDays(i);
//           }
//           return date;
//        }
    }
    
    public static class TextSupporter{
        
        private static List<String> strings;

        public static void setStrings(List<String> strings) {
            TextSupporter.strings = strings;
        }
        
        public static void txtSelectAll(TextField txt){
            txt.setOnMouseClicked(e->{
                if(txt.isFocused() && !txt.getText().isEmpty()){
                    txt.selectAll();
                }
            });
        }
    }
    
    public static class ModifledNode{
        
        public static URL getResource(String name){
            return aabairline.AABAirLine.class.getResource(name);
        }
      
        public static Alert myAlert(Alert.AlertType aType, String title
                , String header, String content, String iconImg) throws URISyntaxException{
            Alert a = new Alert(aType);
            a.setTitle(title);
            a.setHeaderText(header);
            a.setContentText(content);
            ((Stage)a.getDialogPane().getScene().getWindow()).getIcons()
                    .add(new Image(getResource(iconImg)
                            .toString()));
           
            return a;
        }
        
        public class myCheckBox extends CheckBox{
            public myCheckBox(){
                super();
                this.setDisable(true);
                this.getStyleClass().add("MyCheckBox");
                this.setSelected(true);
            }
        }
       
        
//        public static ProgressIndicator myIndicator(double startIndex){
//            ProgressIndicator pi = new ProgressIndicator();
//            pi.setProgress(startIndex++);
//            return pi;
//        }
//        
//        public static void myListView(ListView<GridPane> lv){
//            
//            lv.setOrientation(Orientation.HORIZONTAL);
//            lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
//
//            lv.getSelectionModel().selectedItemProperty()
//            .addListener((ObservableValue<? extends GridPane> observable
//                    , GridPane oldValue, GridPane newValue) -> {
//
//               if(oldValue != null && newValue != null){
//                    ((CheckBox)(oldValue.getChildren().get(0))).setSelected(false);
//                    ((CheckBox)(newValue.getChildren().get(0))).setSelected(true);
//               }else{
//                    GridPane gp = (GridPane)lv.getSelectionModel()
//                            .getSelectedItem();
//                    if(gp != null){
//                        CheckBox cb = (CheckBox)gp.getChildren().get(0);
//                        cb.setSelected(true);
//                    }  
//               }
//            });
//        }
    }
    
    public static class CreateID{
        public static String newCustomer(){
            return String.format("%s%05d", "cus", (Utils.countCustomer()+ 1));
        }
        
         public static String newTicket(){
            return String.format("%s%05d", "tik", (Utils.countCustomer()+ 1));
        }
    }
    
//    public static class TicketDateLoader{
//     
//        /**
//        * Method set Schedule Tab 's text when button search is on click
//        * 
//         *@param scheduleTab
//         * @param depDate
//        * @throws java.io.IOException
//        */
//       public static void loadScheduleTab(TabPane scheduleTab, DatePicker depDate) 
//               throws IOException{  
//           
//           scheduleTab.getTabs().get(7).setText(MyDate.getYear(depDate.getValue()));
//
//           LocalDate nextDate = depDate.getValue();
//           scheduleTab.getTabs().get(0).setText(MyDate.subYear(nextDate));
//
//           for(int i = setLefttTabs(scheduleTab, depDate); 
//                   i < scheduleTab.getTabs().size() - 1; i++){
//               
//               nextDate = MyDate.getNextDate(nextDate, 1);
//               scheduleTab.getTabs().get(i).setText(MyDate.subYear(nextDate));
//           }
//           openChosenDateTab(scheduleTab, depDate);
//           //ticketsList();
//   //        setTicketSelectorUI();
//       }
//
//       /**
//        * Method set schedule's left tabs
//         * @param scheduleTab
//         * @param depDate
//        * @return 
//        */
//       public static int setLefttTabs(TabPane scheduleTab, DatePicker depDate){
//           int count = 0;
//           LocalDate lastDate = depDate.getValue();
//           for(int i = 1; i < scheduleTab.getTabs().size(); i++){
//               if(!MyDate.isCurrentDate(lastDate)  && i <= 3 ){
//                   int j = i;
//                   while(j > 0){
//                       scheduleTab.getTabs().get(j).setText(scheduleTab.getTabs()
//                               .get(j - 1).getText());
//                       j = j - 1;
//                   }
//                   lastDate = MyDate.getLastDate(lastDate, 1);
//                   scheduleTab.getTabs().get(0).setText(MyDate.subYear(lastDate));
//
//                   count++;
//               }
//           }
//
//           return count + 1;
//       }
//       /**
//        * Method open chosen date tab
//         * @param scheduleTab
//         * @param depDate
//        */
//       public static void openChosenDateTab(TabPane scheduleTab, DatePicker depDate){
//           scheduleTab.getTabs().forEach(tab ->{
//               if(MyDate.subYear(depDate.getValue()).equals(tab.getText())){
//                   scheduleTab.getSelectionModel().select(tab);
//               }
//           });
//       }
//    }
}
