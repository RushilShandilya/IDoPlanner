package com.cdac.idoplanner.entities;

import jakarta.persistence.*;

@Entity
@Table(name="ServiceProviders")
public class ServiceProvider{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer spId;

    String spName;

    @Column(unique=true)
    String spEmail;

    Integer spNumber;

    String spPasswordHash;

    @ManyToOne
    @JoinColumn(name="serviceId")
    Service service;

    public ServiceProvider(){

    }

    public ServiceProvider(String spName, String spEmail, Integer spNumber, Service service) {
        this.spName = spName;
        this.spEmail = spEmail;
        this.spNumber = spNumber;
        this.service = service;
    }

    public Integer getSpId() {
        return spId;
    }

    public void setSpId(Integer spId) {
        this.spId = spId;
    }

    public String getSpName() {
        return spName;
    }

    public void setSpName(String spName) {
        this.spName = spName;
    }

    public String getSpEmail() {
        return spEmail;
    }

    public void setSpEmail(String spEmail) {
        this.spEmail = spEmail;
    }

    public Integer getSpNumber() {
        return spNumber;
    }

    public void setSpNumber(Integer spNumber) {
        this.spNumber = spNumber;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
