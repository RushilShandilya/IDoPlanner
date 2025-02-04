package com.cdac.idoplanner.dto;

public class ServiceProviderDTO {
    String spName;
    String spEmail;
    String spPhoneNumber;
    String spPassword;
    String serviceId;

    public ServiceProviderDTO(){

    }

    public ServiceProviderDTO(String spName, String spEmail, String spPhoneNumber, String spPassword,String serviceId) {
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

    public String getSpPhoneNumber() {
        return spPhoneNumber;
    }

    public void setSpPhoneNumber(String spPhoneNumber) {
        this.spPhoneNumber = spPhoneNumber;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }
}
