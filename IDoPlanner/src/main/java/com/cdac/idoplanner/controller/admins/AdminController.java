package com.cdac.idoplanner.controller.admins;

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
    public void createAdmin(@RequestBody Admin admin){
        adminService.createAdmin(admin);
    }

    @GetMapping("/admin/getAdmin")
    public void getAdmin(@RequestParam Integer adminId){
        Admin admin = adminService.getAdmin(adminId);
        System.out.println(admin);
    }
}
