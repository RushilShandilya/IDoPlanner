package com.cdac.idoplanner.service.services;

import com.cdac.idoplanner.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicesService {

    @Autowired
    ServiceRepository serviceRepository;

    public String getServiceName(Integer serviceId){
        return serviceRepository.findByServiceId(serviceId);
    }
}
