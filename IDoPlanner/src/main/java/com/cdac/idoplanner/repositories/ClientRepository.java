package com.cdac.idoplanner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.idoplanner.entities.Client;
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
