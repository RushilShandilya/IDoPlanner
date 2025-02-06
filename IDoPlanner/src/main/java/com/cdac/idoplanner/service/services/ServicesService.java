package com.cdac.idoplanner.service.services;

import com.cdac.idoplanner.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ServicesService {

    @Autowired
    ServiceRepository serviceRepository;

    public String getServiceName(Integer serviceId){
        return serviceRepository.findServiceNameById(serviceId);
    }

    public com.cdac.idoplanner.entities.Service findById(Integer serviceId) {
        return serviceRepository.findById(serviceId).orElseThrow(()->new RuntimeException("Service is not present"));
    }
}
