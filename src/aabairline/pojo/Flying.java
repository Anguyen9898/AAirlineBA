/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aabairline.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.Table;
import javax.transaction.Transactional;

/**
 *
 * @author binbo
 */
@Entity
@Table(name = "flying")
@Transactional
public class Flying implements Serializable{
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "F_ID")
    private FlightInfo flightId;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MainPilot")
    private Employee pilotMain;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SidePilot")
    private Employee pilotSide;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "F_Attendant1")
    private Employee fa1;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "F_Attendant2")
    private Employee fa2;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "F_Attendant3")
    private Employee fa3;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PL_ID")
    private Plane planeId;

    public Flying() {
    }
    
    public Flying(FlightInfo fId, Employee mPilot, Employee sPilot, Employee fa1
            , Employee fa2, Employee fa3, Plane pId) {
        this.flightId = fId;
        this.pilotMain = mPilot;
        this.pilotSide = sPilot;
        this.fa1 = fa1;
        this.fa2 = fa2;
        this.fa3 = fa3;
        this.planeId = pId;
    }

    public FlightInfo getFlightId() {
        return flightId;
    }

    public void setFlightId(FlightInfo flightId) {
        this.flightId = flightId;
    }

    public Employee getPilotMain() {
        return pilotMain;
    }

    public void setPilotMain(Employee pilotMain) {
        this.pilotMain = pilotMain;
    }

    public Employee getPilotSide() {
        return pilotSide;
    }

    public void setPilotSide(Employee pilotSide) {
        this.pilotSide = pilotSide;
    }

    public Employee getFa1() {
        return fa1;
    }

    public void setFa1(Employee fa1) {
        this.fa1 = fa1;
    }

    public Employee getFa2() {
        return fa2;
    }

    public void setFa2(Employee fa2) {
        this.fa2 = fa2;
    }

    public Employee getFa3() {
        return fa3;
    }

    public void setFa3(Employee fa3) {
        this.fa3 = fa3;
    }

    public Plane getPlaneId() {
        return planeId;
    }

    public void setPlaneId(Plane planeId) {
        this.planeId = planeId;
    }

    
    
}
