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
@Table(name = "country")
public class Country implements Serializable {
    @Id
    @Column(name = "CT_ID", nullable = true)
    private String id;
    @Column(name = "CT_NAME", nullable = true)
    private String name;
    @Column(name = "CT_PPrefix", nullable = true)
    private String phonePrefix;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
    private List<Customer> countries;
    public Country() {
    }
    
    public Country(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
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

    public List<Customer> getCountries() {
        return countries;
    }

    public void setCountries(List<Customer> countries) {
        this.countries = countries;
    }

    public String getPhonePrefix() {
        return phonePrefix;
    }

    public void setPhonePrefix(String phonePrefix) {
        this.phonePrefix = phonePrefix;
    }
}
