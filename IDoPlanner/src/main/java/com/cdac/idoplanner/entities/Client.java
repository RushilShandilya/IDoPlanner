package com.cdac.idoplanner.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clientId")
    private Integer clientId;

    @Column(name = "name", length = 100 , nullable=false)
    private String name;

    @Column(name = "email", length = 100, unique = true , nullable = false)
    private String email;

    @Column(name = "phoneNumber",unique=true , nullable = false)
    private Long phoneNumber;

    @Column(name = "passwordHash", length = 255 , nullable=false)
    private String passwordHash;

	public Client(){

	}

	public Client(String name, String email, Long phoneNumber, String passwordHash) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.passwordHash = passwordHash;
	}

	public Integer getClientId() {
		return clientId;
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
    
    
}
 