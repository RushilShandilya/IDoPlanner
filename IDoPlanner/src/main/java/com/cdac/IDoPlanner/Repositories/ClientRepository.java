package com.cdac.IDoPlanner.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.IDoPlanner.Entity.Client;
@Repository
public interface ClientRepository extends JpaRepository<Client, ID> {

}
