package com.cdac.idoplanner.controller.serviceprovider;

import com.cdac.idoplanner.dto.ServiceProviderDTO;
import com.cdac.idoplanner.entities.Service;
import com.cdac.idoplanner.entities.ServiceProvider;
import com.cdac.idoplanner.service.serviceprovider.ServiceProviderService;
import com.cdac.idoplanner.service.services.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

        String serviceName = sService.getServiceName(spDTO.getServiceId());

        sp.setService(new Service(serviceName));

        spService.addServiceProvider(sp);

    }

    @GetMapping("serviceProvider/getServiceProvider")
    public ServiceProvider getServiceProviderById(@RequestParam Integer spId){
        return spService.getServiceProviderById(spId);
    }
}
