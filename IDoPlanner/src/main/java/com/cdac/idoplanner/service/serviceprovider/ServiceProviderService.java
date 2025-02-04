package com.cdac.idoplanner.service.serviceprovider;

import com.cdac.idoplanner.entities.ServiceProvider;
import com.cdac.idoplanner.repositories.ServiceProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class ServiceProviderService {
    @Autowired
    ServiceProviderRepository spRepository;

    public void addServiceProvider(ServiceProvider sp) {
        spRepository.save(sp);
    }

    public ServiceProvider getServiceProviderById(@RequestParam Integer spId){
        return spRepository.findBySpId(spId);
    }
}
