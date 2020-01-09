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
@Table (name = "ticketing_agent")
public class TicketingAgent implements Serializable{
    @Id
    @Column(name = "TA_ID")
    private String ta_Id;
    @Column(name = "TA_NAME", length = 50, nullable = true)
    private String name;
    @Column(name = "TA_IDNUMBER", length = 50, nullable = true)
    private String idNumber;
    
    @Column(name = "TA_GENDER", length = 45, nullable = true)
    private String gender;
    
    @Column(name = "TA_PHONE", length = 50, nullable = true)
    private String phone;
    @Column(name = "TA_DAYOFBIRTRH", length = 50, nullable = true)
    private String dayOfBirth;
    
    @Column(name = "TA_ACCOUNTID", length = 50, nullable = true)
    private String ta_AccountId;
    @Column(name = "TA_PASSWORD", length = 50, nullable = true)
    private String ta_Password;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "taId")
    private List<Ticket> tickets;

//    @Override
//    public String toString() {
//        return super.toString();
//    }
    
    public TicketingAgent(String ta_Id, String name, String idNumber, String gender, String phone, String dayOfBirth, String ta_AccountId, String ta_Password) {
        this.ta_Id = ta_Id;
        this.name = name;
        this.idNumber = idNumber;
        this.gender = gender;
        this.phone = phone;
        this.dayOfBirth = dayOfBirth;
        this.ta_AccountId = ta_AccountId;
        this.ta_Password = ta_Password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    
    public TicketingAgent() {
    }

    /**
     * @return the ta_Id
     */
    public String getTa_Id() {
        return ta_Id;
    }

    /**
     * @param ta_Id the ta_Id to set
     */
    public void setTa_Id(String ta_Id) {
        this.ta_Id = ta_Id;
    }

    /**
     * @return the ta_AccountId
     */
    public String getTa_AccountId() {
        return ta_AccountId;
    }

    /**
     * @param ta_AccountId the ta_AccountId to set
     */
    public void setTa_AccountId(String ta_AccountId) {
        this.ta_AccountId = ta_AccountId;
    }

    /**
     * @return the ta_Password
     */
    public String getTa_Password() {
        return ta_Password;
    }

    /**
     * @param ta_Password the ta_Password to set
     */
    public void setTa_Password(String ta_Password) {
        this.ta_Password = ta_Password;
    }
    

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
    

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
