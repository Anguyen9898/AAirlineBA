/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aabairline.pojo;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author anguy
 */
@Entity
@Table(name = "route")
public class Route implements Serializable {
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Arrival_ID")
    private AirportInfo takeOffAP;
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TakeOff_ID")
    private AirportInfo arrivalAP;

    public Route() {
    }

    public Route(AirportInfo takeOffAP, AirportInfo arrivalAP) {
        this.takeOffAP = takeOffAP;
        this.arrivalAP = arrivalAP;
    }
    
    public AirportInfo getTakeOffAP() {
        return takeOffAP;
    }
    
    public void setTakeOffAP(AirportInfo takeOffAP) {
        this.takeOffAP = takeOffAP;
    }

    public AirportInfo getArrivalAP() {
        return arrivalAP;
    }

    public void setArrivalAP(AirportInfo arrivalAP) {
        this.arrivalAP = arrivalAP;
    }
}
