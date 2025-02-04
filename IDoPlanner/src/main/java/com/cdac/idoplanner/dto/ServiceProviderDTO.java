package com.cdac.idoplanner.dto;

public class ServiceProviderDTO {
    String spName;
    String spEmail;
    Integer spPhoneNumber;
    String spPassword;
    Integer serviceId;

    public ServiceProviderDTO(){

    }

    public ServiceProviderDTO(String spName, String spEmail, Integer spPhoneNumber, String spPassword,Integer serviceId) {
        this.spName = spName;
        this.spEmail = spEmail;
        this.spPhoneNumber = spPhoneNumber;
        this.spPassword=spPassword;
        this.serviceId = serviceId;
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

    public Integer getSpPhoneNumber() {
        return spPhoneNumber;
    }

    public void setSpPhoneNumber(Integer spPhoneNumber) {
        this.spPhoneNumber = spPhoneNumber;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }
}
