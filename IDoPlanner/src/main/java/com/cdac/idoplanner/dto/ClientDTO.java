package com.cdac.idoplanner.dto;

public class ClientDTO {
	private String name;
    private String email;
    private Long phoneNumber;
    private String passwordHash;
    
    public ClientDTO( String name, String email, Long phoneNumber, String passwordHash) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.passwordHash = passwordHash;
    }
    public ClientDTO( String name, String email, Long phoneNumber) {
       this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	@Override
	public String toString() {
		return "ClientDTO [name=" + name + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", passwordHash=" + passwordHash + "]";
	}
    
}


