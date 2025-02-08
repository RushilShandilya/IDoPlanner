package com.cdac.idoplanner.controller.admins;

import com.cdac.idoplanner.dto.AdminDTO;
import com.cdac.idoplanner.entities.Admin;
import com.cdac.idoplanner.service.admins.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {
    //Methods to be added later
    @Autowired
    AdminService adminService;

    @PostMapping("/admin/createAdmin")
    public void createAdmin(@RequestBody AdminDTO adminDTO){
        Admin admin = new Admin();

        admin.setEmail(adminDTO.getEmail());
        admin.setName(adminDTO.getName());
        admin.setPasswordHash(adminDTO.getPassword());

        adminService.createAdmin(admin);
    }

    @GetMapping("/admin/getAdmin")
    public Admin getAdmin(@RequestParam Integer adminId){
        return adminService.getAdmin(adminId);
    }

    @PutMapping("/admin/updateAdmin")
    public void updateAdmin(@RequestBody AdminDTO adminDTO){
        adminService.updateAdmin(adminDTO);
    }

    @DeleteMapping("/admin/deleteAdmin")
    public void deleteAdmin(@RequestParam Integer adminId){
        adminService.deleteAdmin(adminId);
    }
}
