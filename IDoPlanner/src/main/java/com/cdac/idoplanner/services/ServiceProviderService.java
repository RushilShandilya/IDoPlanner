package com.cdac.idoplanner.services;

import com.cdac.idoplanner.dto.ServiceProviderDTO;
import com.cdac.idoplanner.entities.ServiceProvider;
import com.cdac.idoplanner.repositories.ServiceProviderRepository;
import com.cdac.idoplanner.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class ServiceProviderService {

    @Autowired
    ServiceProviderRepository spRepository;

    @Autowired
    ServiceRepository sRepository;

    public String addServiceProvider(ServiceProviderDTO spDTO) {
        ServiceProvider sp = new ServiceProvider();

        System.out.println(spDTO.getSpEmail());

        sp.setSpEmail(spDTO.getSpEmail());
        sp.setSpName(spDTO.getSpName());
        sp.setSpNumber(spDTO.getSpPhoneNumber());
        sp.setSpPasswordHash(spDTO.getSpPassword());
        sp.setService(sRepository.findByServiceName(spDTO.getServiceName()));

        ServiceProvider x = spRepository.save(sp);

        return (x!=null)?"Successful":"Unsuccessful";
    }

    public ServiceProviderDTO getServiceProvider(String email) {

        ServiceProvider sp = spRepository.findBySpEmail(email);

        System.out.println(sp.getSpEmail());

        ServiceProviderDTO dto = new ServiceProviderDTO();

        dto.setSpName(sp.getSpName());
        dto.setSpEmail(sp.getSpEmail());
        dto.setSpPhoneNumber(sp.getSpNumber());

        return dto;
    }

    public ServiceProvider getServiceProviderById(Integer spId){
        return spRepository.findBySpId(spId);
    }
}
