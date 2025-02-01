package com.cdac.idoplanner.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="admins")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Admin {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="adminId")
    Integer adminId;

    @Column(name="name")
    String name;
    @Column(name="email")
    String email;

    @Column(name="passwordHash")
    String passwordHash;
}
