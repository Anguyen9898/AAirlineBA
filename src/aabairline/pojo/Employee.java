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
 * @author binbo
 */
@Entity
@Table(name = "employee")
public class Employee implements Serializable{
    @Id
    @Column(name = "E_ID", length = 100)
    private String e_Id;
    @Column(name = "E_NAME", length = 50, nullable = true)
    private String e_Name;
    @Column(name = "E_DAYOFBIRTH", nullable = true)
    private String e_DayOfBirth;
    @Column(name = "E_IDNUMBER", length = 50, nullable = true)
    private String e_IdNumber;
    @Column(name = "E_GENDER", length = 50, nullable = true)
    private String e_Gender;
    @Column(name = "E_POSITION", length = 50, nullable = true)
    private String e_Position;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pilotMain")
    private List<Flying> mainPilots;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pilotSide")
    private List<Flying> sidePilots;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fa1")
    private List<Flying> fa1s;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fa2")
    private List<Flying> fa2s;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fa3")
    private List<Flying> fa3s;

    @Override
    public String toString() {
        return e_Id + " " + e_Name;
    }
    
    
    /**
     * @return the e_Id
     */
    public String getE_Id() {
        return e_Id;
    }

    /**
     * @param e_Id the e_Id to set
     */
    public void setE_Id(String e_Id) {
        this.e_Id = e_Id;
    }

    /**
     * @return the e_Name
     */
    public String getE_Name() {
        return e_Name;
    }

    /**
     * @param e_Name the e_Name to set
     */
    public void setE_Name(String e_Name) {
        this.e_Name = e_Name;
    }

    /**
     * @return the e_DayOfBirth
     */
    public String getE_DayOfBirth() {
        return e_DayOfBirth;
    }

    /**
     * @param e_DayOfBirth the e_DayOfBirth to set
     */
    public void setE_DayOfBirth(String e_DayOfBirth) {
        this.e_DayOfBirth = e_DayOfBirth;
    }

    /**
     * @return the e_IdNumber
     */
    public String getE_IdNumber() {
        return e_IdNumber;
    }

    /**
     * @param e_IdNumber the e_IdNumber to set
     */
    public void setE_IdNumber(String e_IdNumber) {
        this.e_IdNumber = e_IdNumber;
    }

    /**
     * @return the e_Gender
     */
    public String getE_Gender() {
        return e_Gender;
    }

    /**
     * @param e_Gender the e_Gender to set
     */
    public void setE_Gender(String e_Gender) {
        this.e_Gender = e_Gender;
    }

    /**
     * @return the e_Position
     */
    public String getE_Position() {
        return e_Position;
    }

    /**
     * @param e_Position the e_Position to set
     */
    public void setE_Position(String e_Position) {
        this.e_Position = e_Position;
    }

    public Employee(String e_Id, String e_Name, String e_DayOfBirth, String e_IdNumber, String e_Gender, String e_Position) {
        this.e_Id = e_Id;
        this.e_Name = e_Name;
        this.e_DayOfBirth = e_DayOfBirth;
        this.e_IdNumber = e_IdNumber;
        this.e_Gender = e_Gender;
        this.e_Position = e_Position;
    }

    public Employee() {
    }

    public List<Flying> getMainPilots() {
        return mainPilots;
    }

    public void setMainPilots(List<Flying> mainPilots) {
        this.mainPilots = mainPilots;
    }

    public List<Flying> getSidePilots() {
        return sidePilots;
    }

    public void setSidePilots(List<Flying> sidePilots) {
        this.sidePilots = sidePilots;
    }

    

    public void setFa1s(List<Flying> fa1s) {
        this.fa1s = fa1s;
    }

    public List<Flying> getFa2s() {
        return fa2s;
    }

    public void setFa2s(List<Flying> fa2s) {
        this.fa2s = fa2s;
    }

    public List<Flying> getFa3s() {
        return fa3s;
    }

    public void setFa3s(List<Flying> fa3s) {
        this.fa3s = fa3s;
    }
   
}
