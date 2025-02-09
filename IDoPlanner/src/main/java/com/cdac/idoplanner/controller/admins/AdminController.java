package com.cdac.idoplanner.controller.admins;

import com.cdac.idoplanner.dto.AdminDTO;
import com.cdac.idoplanner.entities.Admin;
import com.cdac.idoplanner.service.admins.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AdminController {
    //Methods to be added later
    @Autowired
    AdminService adminService;

    @PostMapping("/admin/register")
    public ResponseEntity<Map<String,String>> createAdmin(@RequestBody AdminDTO adminDTO){
        Admin admin = new Admin();

        admin.setEmail(adminDTO.getEmail());
        admin.setName(adminDTO.getName());
        admin.setPasswordHash(adminDTO.getPassword());

        Map<String,String> hashMap = new HashMap<>();
        hashMap.put("message",adminService.createAdmin(admin));

        return ResponseEntity.ok(hashMap);
    }

    @PostMapping("/admin/login")
    public ResponseEntity<AdminDTO> getAdmin(@RequestBody AdminDTO dto){
        return adminService.findByEmail(dto.getEmail());
    }

    @DeleteMapping("/admin/deleteAdmin")
    public ResponseEntity<String> deleteAdmin(@RequestBody AdminDTO dto){
        return adminService.deleteByEmail(dto.getEmail());
    }
}
