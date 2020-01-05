/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aabairline.pojo;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author anguy
 */
@Entity
@Table(name = "flight_info")
public class FlightInfo implements Serializable {
    @Id
    @Column(name = "F_ID")
    private String id;
    
    @Column(name = "F_TAKEOFFDATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date takeOfDate;
    
    @Column(name = "F_TAKEOFFTIME")
    private Time takeOfTime;
    
    @Column(name = "F_ARRIVALDATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date arrivalDate;
    
    @Column(name = "F_ARRIVALTIME")
    private Time arrivalTime;
    
    @Column(name = "F_PRICE")
    private double price;
   
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "F_ROUTE")
    private Route route;
    
    
    public FlightInfo() {
    }

    public FlightInfo(String id, Date takeOfDate, Time takeOfTime, Date arrivalDate, Time arrivalTime, double price, Route route) {
        this.id = id;
        this.takeOfDate = takeOfDate;
        this.takeOfTime = takeOfTime;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.route = route;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTakeOfDate() {
        return takeOfDate;
    }

    public void setTakeOfDate(Date takeOfDate) {
        this.takeOfDate = takeOfDate;
    }

    public Time getTakeOfTime() {
        return takeOfTime;
    }

    public void setTakeOfTime(Time takeOfTime) {
        this.takeOfTime = takeOfTime;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}
