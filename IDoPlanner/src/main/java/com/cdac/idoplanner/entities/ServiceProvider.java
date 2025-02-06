package com.cdac.idoplanner.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name="ServiceProviders")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ServiceProvider{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer spId;

    String spName;

    @Column(unique=true , nullable = false)
    String spEmail;
    @Column(nullable = false)
    Integer spNumber;

    @Column(name="spPasswordHash")
    String spPasswordHash;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="serviceId")
    Service service;

    public ServiceProvider(){

    }

    public ServiceProvider(String spName, String spEmail, String spPasswordHash, Integer spNumber, Service service) {
        this.spName = spName;
        this.spEmail = spEmail;
        this.spNumber = spNumber;
        this.service = service;
        this.spPasswordHash = spPasswordHash;
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

    public String getSpPasswordHash() {
        return spPasswordHash;
    }

    public void setSpPasswordHash(String spPasswordHash) {
        this.spPasswordHash = spPasswordHash;
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
