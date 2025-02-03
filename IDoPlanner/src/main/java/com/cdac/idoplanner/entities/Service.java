package com.cdac.idoplanner.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Services")
@Getter
@Setter
@NoArgsConstructor
public class Service {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer serviceId;

    String serviceName;
}
