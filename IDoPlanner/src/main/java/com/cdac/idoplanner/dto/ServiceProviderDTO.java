package com.cdac.idoplanner.dto;

public class ServiceProviderDTO {
    String spName;
    String spEmail;
    Integer spPhoneNumber;
    String spPassword;
    String serviceName;

    public ServiceProviderDTO(){

    }

    public ServiceProviderDTO(String spName, String spEmail, Integer spPhoneNumber, String spPassword,String serviceName) {
        this.spName = spName;
        this.spEmail = spEmail;
        this.spPhoneNumber = spPhoneNumber;
        this.spPassword=spPassword;
        this.serviceName = serviceName;
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

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getSpPassword(){return spPassword;}

    public void setSpPassword(String spPassword){
        this.spPassword = spPassword;
    }
}
