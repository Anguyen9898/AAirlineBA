    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aabairline.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author anguy
 */
@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    @Id
    @Column(name = "C_ID")
    private String id;
    @Column(name = "C_NAME", length = 50, nullable = true)
    private String name;
    @Column(name = "C_IDNUMBER", length = 50, nullable = true)
    private String idNum;
    @Column(name = "C_PHONE", length = 50, nullable = true)
    private String phone;
    @Column(name = "C_DAYOFBIRTH", length = 50, nullable = true)
    @Temporal(TemporalType.DATE)
    private Date dayOfBirth;
    @Column(name = "C_ADDRESS", length = 50, nullable = true)
    private String address;
    @Column(name = "C_EMAIL", length = 50, nullable = true)
    private String email;
    
    @Column(name = "C_GENDER", length = 50, nullable = true)
    private String gender;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "C_COUNTRY", updatable = true, insertable = true)
    private Country country;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cusId")
    private List<Ticket> tickets;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bookerId")
    private List<Ticket> bookers;
    
    public Customer() {
        
    }

    public Customer(String id, String name, String idNum, String phone
            , Date dayOfBirth, String address, String email
            , String gender, Country country) {
        this.id = id;
        this.name = name;
        this.idNum = idNum;
        this.phone = phone;
        this.dayOfBirth = dayOfBirth;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.country = country;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Ticket> getBookers() {
        return bookers;
    }

    public void setBookers(List<Ticket> bookers) {
        this.bookers = bookers;
    }
    
    
}
