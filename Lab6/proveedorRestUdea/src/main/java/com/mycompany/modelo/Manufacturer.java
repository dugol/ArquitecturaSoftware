package com.mycompany.modelo;
// Generated Nov 22, 2017 12:53:44 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Manufacturer generated by hbm2java
 */
@Entity
@Table(name="MANUFACTURER"
    ,schema="APP"
)
@XmlRootElement
public class Manufacturer  implements java.io.Serializable {


     private int manufacturerId;
     private String name;
     private String addressline1;
     private String addressline2;
     private String city;
     private String state;
     private String zip;
     private String phone;
     private String fax;
     private String email;
     private String rep;

    public Manufacturer() {
    }

	
    public Manufacturer(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }
    public Manufacturer(int manufacturerId, String name, String addressline1, String addressline2, String city, String state, String zip, String phone, String fax, String email, String rep) {
       this.manufacturerId = manufacturerId;
       this.name = name;
       this.addressline1 = addressline1;
       this.addressline2 = addressline2;
       this.city = city;
       this.state = state;
       this.zip = zip;
       this.phone = phone;
       this.fax = fax;
       this.email = email;
       this.rep = rep;
    }
   
     @Id 

    
    @Column(name="MANUFACTURER_ID", unique=true, nullable=false)
    public int getManufacturerId() {
        return this.manufacturerId;
    }
    
    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    
    @Column(name="NAME", length=30)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="ADDRESSLINE1", length=30)
    public String getAddressline1() {
        return this.addressline1;
    }
    
    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    
    @Column(name="ADDRESSLINE2", length=30)
    public String getAddressline2() {
        return this.addressline2;
    }
    
    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    
    @Column(name="CITY", length=25)
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    
    @Column(name="STATE", length=2)
    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }

    
    @Column(name="ZIP", length=10)
    public String getZip() {
        return this.zip;
    }
    
    public void setZip(String zip) {
        this.zip = zip;
    }

    
    @Column(name="PHONE", length=12)
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    @Column(name="FAX", length=12)
    public String getFax() {
        return this.fax;
    }
    
    public void setFax(String fax) {
        this.fax = fax;
    }

    
    @Column(name="EMAIL", length=40)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="REP", length=30)
    public String getRep() {
        return this.rep;
    }
    
    public void setRep(String rep) {
        this.rep = rep;
    }




}


