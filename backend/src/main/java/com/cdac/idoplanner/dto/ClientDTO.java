package com.cdac.idoplanner.dto;

public class ClientDTO {
	private String name;
    private String email;
    private Integer phoneNumber;
    private String password;

	public ClientDTO(){

	}

    public ClientDTO( String name, String email, Integer phoneNumber, String password) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
    public ClientDTO( String name, String email, Integer phoneNumber) {
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
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "ClientDTO [name=" + name + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", password=" + password + "]";
	}
    
}


