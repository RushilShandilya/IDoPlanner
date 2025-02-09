package com.cdac.idoplanner.controller.serviceprovider;

import com.cdac.idoplanner.dto.ServiceProviderDTO;
import com.cdac.idoplanner.entities.Service;
import com.cdac.idoplanner.entities.ServiceProvider;
import com.cdac.idoplanner.service.serviceproviders.ServiceProviderService;
import com.cdac.idoplanner.service.services.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class ServiceProviderController {

    @Autowired
    ServiceProviderService spService;

    @PostMapping("serviceProvider/register")
    public ResponseEntity<Map<String,String>> addServiceProvider(@RequestBody ServiceProviderDTO spDTO){
        Map<String , String> hashMap = new HashMap<>();
        hashMap.put("message", spService.addServiceProvider(spDTO));

        return ResponseEntity.ok(hashMap);
    }

    @PostMapping("serviceProvider/login")
    public ResponseEntity<ServiceProviderDTO> getServiceProvider(@RequestBody ServiceProviderDTO spDTO){
        System.out.println(spDTO.getSpEmail() + " in controller");
        return ResponseEntity.ok(spService.getServiceProvider(spDTO.getSpEmail()));
    }
}
