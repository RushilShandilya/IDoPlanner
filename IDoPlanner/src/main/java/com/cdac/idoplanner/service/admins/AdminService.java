package com.cdac.idoplanner.service.admins;

import com.cdac.idoplanner.dto.AdminDTO;
import com.cdac.idoplanner.entities.Admin;
import com.cdac.idoplanner.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;

    public String createAdmin(Admin admin){
        Admin returnedAdmin = adminRepository.save(admin);
        return (returnedAdmin!=null)?"Successful":"Couldn't save string";
    }

    public ResponseEntity<AdminDTO> findByEmail(String email) {
        Admin admin = adminRepository.findByEmail(email);
        AdminDTO adminDTO = new AdminDTO();

        adminDTO.setEmail(admin.getEmail());
        adminDTO.setName((admin.getName()));

        return (adminDTO!=null)?ResponseEntity.ok(adminDTO):ResponseEntity.status(404).body(null);
    }

    public ResponseEntity<String> deleteByEmail(String email) {
        return null;
    }
}
