/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aabairline.supporters;

import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.format.FormatStyle;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.util.converter.LocalDateStringConverter; 

/**
 *
 * @author anguy
 */
public interface SupporterImp{
   
    public static class MyDate{
        private static String year;
         
        public static String getYear() {
            return year;
        }
        
        public static LocalDate getCurrentDate(){
            return LocalDate.now();
        }
        
        public static Boolean isCurrentDate(LocalDate localDate){
            return localDate.equals(LocalDate.now());
        }
        
        public static LocalDate getNextDate(LocalDate date, int i){
            return date.plusDays(i);
        }
        
        public static LocalDate getLastDate(LocalDate date, int i){
           if(!isCurrentDate(date)){
               return date.minusDays(i);
           }
           return null;
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
        
        public static String subYear(LocalDate date){
            String str = convertDateToString(date);
            year = str.substring(str.length() - 4, str.length());
            return str.substring(0, str.length() - 6);
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
    
    public static class MyAlert{
        
        public static Alert createAlert(Alert.AlertType aType, String title
                , String header, String content, String iconImg) throws URISyntaxException{
            Alert a = new Alert(aType);
            a.setTitle(title);
            a.setHeaderText(header);
            a.setContentText(content);
            ((Stage)a.getDialogPane().getScene().getWindow()).getIcons()
                    .add(new Image(aabairline.AABAirLine.class.getResource(iconImg)
                            .toString()));
           
            return a;
        }
    }
    
    public static class FlightRoute{
        
    }
}
