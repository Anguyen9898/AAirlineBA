/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aabairline.supporters;

import aabairline.pojo.FlightInfo;
import aabairline.pojo.Route;
import java.sql.Time;
import java.util.Date;
import javafx.scene.control.CheckBox;

/**
 *
 * @author anguy
 */
public class SelectedFlight extends FlightInfo{
    CheckBox cb;

    public SelectedFlight(CheckBox cb, String id, Date takeOfDate, Time takeOfTime
            , Date arrivalDate, Time arrivalTime, double price, Route route) {
        super(id, takeOfDate, takeOfTime, arrivalDate, arrivalTime, price, route);
        this.cb = cb;
    }
    
}
