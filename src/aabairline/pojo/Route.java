/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aabairline.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author anguy
 */
@Entity
@Table(name = "route")
public class Route implements Serializable {
    @Id
    @Column(name = "R_ID")
    private String id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TakeOffPlace")
    private AirportInfo takeOffAP;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ArrivalPlace")
    private AirportInfo arrivalAP;
    
    @Column(name = "R_DETAIL")
    private String detail;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "route")
    private List<FlightInfo> flightInfos;

    @Override
    public String toString() {
        return detail;
    }
    
    public Route() {
    }
    
    public Route(String id, AirportInfo arrivalAP, AirportInfo takeOffAP, String detail, List<FlightInfo> flgInfos) {
        this.id = id;
        this.arrivalAP = arrivalAP;
        this.takeOffAP = takeOffAP;
        this.detail = detail;
        this.flightInfos = flgInfos;
    }

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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

    public List<FlightInfo> getFlgInfos() {
        return flightInfos;
    }

    public void setFlgInfos(List<FlightInfo> flgInfos) {
        this.flightInfos = flgInfos;
    }
    
    
}
