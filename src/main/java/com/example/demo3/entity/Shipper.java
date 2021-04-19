package com.example.demo3.entity;

import javax.persistence.*;


@Entity
@Table(name = "shippers")
public class Shipper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer shipperid;
    @Column(nullable = false)
    private String companyname;
    private String phone;

    public Integer getShipperid() {
        return shipperid;
    }

    public void setShipperid(Integer shipperid) {
        this.shipperid = shipperid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
