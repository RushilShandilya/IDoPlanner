package com.cdac.idoplanner.controller.serviceprovider;

import com.cdac.idoplanner.dto.ServiceProviderDTO;
import com.cdac.idoplanner.entities.Service;
import com.cdac.idoplanner.entities.ServiceProvider;
import com.cdac.idoplanner.service.serviceproviders.ServiceProviderService;
import com.cdac.idoplanner.service.services.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ServiceProviderController {

    @Autowired
    ServiceProviderService spService;

    @Autowired
    ServicesService sService;

    @PostMapping("serviceProvider/addServiceProvider")
    public void addServiceProvider(@RequestBody ServiceProviderDTO spDTO){
        ServiceProvider sp = new ServiceProvider();

        sp.setSpEmail(spDTO.getSpEmail());
        sp.setSpName(spDTO.getSpName());
        sp.setSpNumber(spDTO.getSpPhoneNumber());
        sp.setSpPasswordHash(spDTO.getSpPassword());

        Service existingService = sService.findById(spDTO.getServiceId());

        sp.setService(existingService);

        spService.addServiceProvider(sp);

    }

    @GetMapping("serviceProvider/getServiceProvider")
    public ServiceProvider getServiceProviderById(@RequestParam Integer spId){
        return spService.getServiceProviderById(spId);
    }
}
