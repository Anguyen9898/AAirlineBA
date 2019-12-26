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
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "C_COUNTRY", updatable = false, insertable = false)
    private Country country;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "C_NATIONALITY", updatable = false, insertable = false)
    private Country nationality;

    public Customer() {
    }

    public Customer(String id, String name, String idNum, String phone, Date dayOfBirth
            , String address, Country country, Country nationality) {
        this.id = id;
        this.name = name;
        this.idNum = idNum;
        this.phone = phone;
        this.dayOfBirth = dayOfBirth;
        this.address = address;
//        this.country = country;
//        this.nationality = nationality;
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

//    public Country getCountry() {
//        return country;
//    }
//
//    public void setCountry(Country country) {
//        this.country = country;
//    }
//
//    public Country getNationality() {
//        return nationality;
//    }
//
//    public void setNationality(Country nationality) {
//        this.nationality = nationality;
//    }
}
