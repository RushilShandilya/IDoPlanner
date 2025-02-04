package com.cdac.idoplanner.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Admins")
public class Admin {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="adminId")
    Integer adminId;

    @Column(name="name")
    String name;
    @Column(name="email",unique=true , nullable = false)
    String email;

    @Column(name="passwordHash")
    String passwordHash;

    public Admin(){

    }

    public Admin(String name, String email, String passwordHash) {
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
