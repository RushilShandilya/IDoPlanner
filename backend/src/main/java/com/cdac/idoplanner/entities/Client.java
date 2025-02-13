package com.cdac.idoplanner.entities;
import jakarta.persistence.*;

import java.util.List;

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
    private Integer phoneNumber;

    @Column(name = "passwordHash", length = 255 , nullable=false)
    private String passwordHash;

	@OneToMany(
			cascade=CascadeType.ALL
	)
	@Column(name="bookingId")
	private List<Booking> bookings;

	public Client(){

	}

	public Client(String name, String email, Integer phoneNumber, String passwordHash) {
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

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
    
    
}
 