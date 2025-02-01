package com.cdac.idoplanner.repositories;

import com.cdac.idoplanner.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
     Admin getByAdminId(Integer adminId);
}
