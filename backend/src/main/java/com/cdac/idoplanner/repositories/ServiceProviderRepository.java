package com.cdac.idoplanner.repositories;

import com.cdac.idoplanner.entities.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceProviderRepository extends JpaRepository<ServiceProvider,Integer> {

    ServiceProvider findBySpId(Integer spId);

    ServiceProvider findBySpEmail(String email);
}
