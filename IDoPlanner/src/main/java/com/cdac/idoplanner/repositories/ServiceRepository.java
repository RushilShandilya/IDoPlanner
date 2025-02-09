package com.cdac.idoplanner.repositories;

import com.cdac.idoplanner.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServiceRepository extends JpaRepository<Service,Integer> {

    @Query("SELECT s.serviceName FROM Service s WHERE s.serviceId=:serviceId")
    String findServiceNameById(@Param("serviceId")Integer serviceId);

    Optional<Service> findById(Integer serviceId);

    Service findByServiceName(String serviceName);
}
