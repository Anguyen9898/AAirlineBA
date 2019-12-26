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
@Table(name = "airport_info")
public class AirportInfo implements Serializable{
    @Id
    @Column(name = "A_ID", length = 100)
    private String a_Id;
    @Column(name = "A_NAME", length = 50, nullable = true)
    private String a_Name;
    @Column(name = "A_ADDRESS", length = 50, nullable = true)
    private String a_Address;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "arrivalAP")
    private List<Route> routes;

    public AirportInfo() {
        
    }
    
    public AirportInfo(String a_Id, String a_Name, String a_Address) {
        this.a_Id = a_Id;
        this.a_Name = a_Name;
        this.a_Address = a_Address;
    }

    @Override
    public String toString() {
        return this.a_Address + " - Sân bay " + this.a_Name + " (" 
                    + this.a_Id + ")";
    }
    
    public String getA_Id() {
        return a_Id;
    }

    public void setA_Id(String a_Id) {
        this.a_Id = a_Id;
    }

    public String getA_Name() {
        return a_Name;
    }

    public void setA_Name(String a_Name) {
        this.a_Name = a_Name;
    }

    public String getA_Address() {
        return a_Address;
    }

    public void setA_Address(String a_Address) {
        this.a_Address = a_Address;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }
    
    
}
