package com.cdac.idoplanner.repositories;

import com.cdac.idoplanner.dto.AdminDTO;
import com.cdac.idoplanner.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findByEmail(String email);

    String deleteByEmail(String email);
}
