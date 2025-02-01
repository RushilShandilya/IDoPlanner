package com.cdac.idoplanner.service.admins;

import com.cdac.idoplanner.entities.Admin;
import com.cdac.idoplanner.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;

    public void createAdmin(Admin admin){
        adminRepository.save(admin);
    }

    public Admin getAdmin(Integer adminId) {
        return adminRepository.getByAdminId(adminId);
    }
}
