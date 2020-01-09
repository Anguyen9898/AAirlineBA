/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aabairline.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author binbo
 */
@Entity
@Table(name = "ticket")
public class Ticket implements Serializable {
    @Id
    @Column(name = "TicketId")
    private String id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "C_ID")
    private Customer cusId;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "F_ID")
    private FlightInfo flightId;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TA_ID")
    private TicketingAgent taId;
     
    @Column(name = "DEPARTURE_DATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date depDate;
    
    @Column(name = "BOOKING_TIME", length = 50, nullable = true)
    private String bookingTime;
    
    @Column(name = "IS_ROUNDTRIP", length = 50, nullable = true)
    private boolean isRoundTrip;
    
    @Column(name = "PRICE", length = 50, nullable = true)
    private double price;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Booker")
    private Customer bookerId;

    public Ticket() {
    }

    public Ticket(String id, Customer cusId, FlightInfo flightId, TicketingAgent taId, Date depDate, String bookingTime, boolean isRoundTrip, double price, Customer bookerId) {
        this.id = id;
        this.cusId = cusId;
        this.flightId = flightId;
        this.taId = taId;
        this.depDate = depDate;
        this.bookingTime = bookingTime;
        this.isRoundTrip = isRoundTrip;
        this.price = price;
        this.bookerId = bookerId;
    }

    

    public Customer getCusId() {
        return cusId;
    }

    public void setCusId(Customer cusId) {
        this.cusId = cusId;
    }

    
    public FlightInfo getFlightId() {
        return flightId;
    }

    public void setFlightId(FlightInfo flightId) {
        this.flightId = flightId;
    }

    
    public TicketingAgent getTaId() {
        return taId;
    }

    public void setTaId(TicketingAgent taId) {
        this.taId = taId;
    }

    public Date getDepDate() {
        return depDate;
    }

    public void setDepDate(Date depDate) {
        this.depDate = depDate;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public boolean isIsRoundTrip() {
        return isRoundTrip;
    }

    public void setIsRoundTrip(boolean isRoundTrip) {
        this.isRoundTrip = isRoundTrip;
    }
    
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Customer getBookerId() {
        return bookerId;
    }

    public void setBookerId(Customer bookerId) {
        this.bookerId = bookerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
}
