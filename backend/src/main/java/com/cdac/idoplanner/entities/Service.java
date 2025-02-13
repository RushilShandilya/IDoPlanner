package com.cdac.idoplanner.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Services")
public class Service {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer serviceId;

    String serviceName;

    public Service(){}

    public Service(String serviceName){
        this.serviceName = serviceName;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
