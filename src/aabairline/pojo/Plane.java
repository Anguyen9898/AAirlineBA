/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aabairline.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author binbo
 */
@Entity
@Table(name = "plane")
public class Plane implements Serializable {
    @Id
    @Column(name = "PL_ID", length = 100)
    private String id;
    @Column(name = "PL_SEATAMOUNT")
    private int a_Name;
    @Column(name = "PL_EMPTYSEATAMOUNT")
    private int a_Address;
     
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "planeId")
    private List<Flying> planes;

    @Override
    public String toString() {
        return id;
    } 

    public Plane(String id, int a_Name, int a_Address) {
        this.id = id;
        this.a_Name = a_Name;
        this.a_Address = a_Address;
    }

    public Plane() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getA_Name() {
        return a_Name;
    }

    public void setA_Name(int a_Name) {
        this.a_Name = a_Name;
    }

    public int getA_Address() {
        return a_Address;
    }

    public void setA_Address(int a_Address) {
        this.a_Address = a_Address;
    }

    public List<Flying> getPlanes() {
        return planes;
    }

    public void setPlanes(List<Flying> planes) {
        this.planes = planes;
    }
    
    
}
