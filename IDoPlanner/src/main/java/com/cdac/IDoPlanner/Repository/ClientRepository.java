package com.cdac.IDoPlanner.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.IDoPlanner.Entity.Client;
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
	 Optional<Client> findByEmail(String email);
}
