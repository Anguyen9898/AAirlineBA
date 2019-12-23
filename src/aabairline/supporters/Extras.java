/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aabairline.supporters;

import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

/**
 *
 * @author anguy
 */
public class Extras {
    private static CheckBox seatCheckBox;
    private static CheckBox luggCheckBox;
    private static GridPane luggSelect;
    private static ListView seatSelect;
   
    private static CheckBox lugg20kg;
    private static CheckBox lugg25kg;
    private static CheckBox lugg30kg;
    private static CheckBox lugg35kg;
    private static CheckBox lugg40kg;
    
    private static final ArrayList<CheckBox> arrCheckBox 
            = new ArrayList<CheckBox>();

    public Extras(CheckBox seatCheckBox, CheckBox luggCheckBox, GridPane luggSelect, ListView seatSelect, CheckBox lugg20kg, CheckBox lugg25kg, CheckBox lugg30kg, CheckBox lugg35kg, CheckBox lugg40kg) {
        Extras.seatCheckBox = seatCheckBox;
        Extras.luggCheckBox = luggCheckBox;
        Extras.luggSelect = luggSelect;
        Extras.seatSelect = seatSelect;
        Extras.lugg20kg = lugg20kg;
        Extras.lugg25kg = lugg25kg;
        Extras.lugg30kg = lugg30kg;
        Extras.lugg35kg = lugg35kg;
        Extras.lugg40kg = lugg40kg;
        
        arrCheckBox.add(lugg20kg);
        arrCheckBox.add(lugg25kg);
        arrCheckBox.add(lugg30kg);
        arrCheckBox.add(lugg35kg);
        arrCheckBox.add(lugg40kg);
        Extras.init();
    }
    
    public static void init(){
        seatSelect.setVisible(false);
        luggSelect.setVisible(false);
        
        seatCheckBox.setOnMouseClicked(e -> {
            checkedSelection(seatCheckBox, seatSelect);
        });
        
        luggCheckBox.setOnMouseClicked(e -> {
            checkedSelection(luggCheckBox, luggSelect);
        });
        
        lugg20kg.setOnMouseClicked(e ->{
            luggSeclection(0);
        });
        
        lugg25kg.setOnMouseClicked(e ->{
            luggSeclection(1);
        });
        
        lugg30kg.setOnMouseClicked(e ->{
            luggSeclection(2);
        });
        
        lugg35kg.setOnMouseClicked(e ->{
            luggSeclection(3);
        });
        
        lugg40kg.setOnMouseClicked(e ->{
            luggSeclection(4);
        });
    }
    
    public static void checkedSelection(CheckBox checkBox, Node node){
        if(checkBox.isSelected()){
            node.setVisible(true);
            node.getParent().getStyleClass().add("ExtrasGrdBoxOnChecked");
                    
        }else{
            node.setVisible(false);
            node.getParent().getStyleClass().removeAll("ExtrasGrdBoxOnChecked");
        }
    }
    
    public static void luggSeclection(int index){
       if(arrCheckBox.get(index).isSelected()){
           for (int i = 0; i < arrCheckBox.size(); i++) {
               if(i != index){
                   arrCheckBox.get(i).setSelected(false);
                   arrCheckBox.get(i)
                           .getParent()
                           .getStyleClass()
                           .removeAll("SelectboxOnChecked");
               }
               else{
                   arrCheckBox.get(i)
                           .getParent()
                           .getStyleClass()
                           .add("SelectboxOnChecked");
               }
           }
       }else{
           arrCheckBox.get(index)
                .getParent()
                .getStyleClass()
                .removeAll("SelectboxOnChecked");
       }
    }
}
