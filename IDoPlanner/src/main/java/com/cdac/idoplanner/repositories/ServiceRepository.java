package com.cdac.idoplanner.repositories;

import com.cdac.idoplanner.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service,Integer> {

    String findByServiceId(Integer serviceId);
}
