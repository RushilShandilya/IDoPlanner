package com.cdac.idoplanner.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.idoplanner.dto.ClientDTO;
import com.cdac.idoplanner.services.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	ClientService clientService;
	
	@PostMapping("/register")
	public ResponseEntity<Map<String,String>> registerClient(@RequestBody ClientDTO clientDTO) {
        Map<String,String> hashMap = new HashMap<>();
        hashMap.put("message",clientService.registerNewClient(clientDTO));

        return ResponseEntity.ok(hashMap);
    }
	@GetMapping("/all")
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        List<ClientDTO> clients = clientService.allClients();
        return ResponseEntity.ok(clients);
    }
	@PutMapping("/update")
    public ResponseEntity<String> updateClient(@RequestBody ClientDTO clientDTO) {
        boolean isUpdated = clientService.updateClient(clientDTO);
        if (isUpdated) {
            return ResponseEntity.ok("Client updated successfully.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found.");
    }
	@DeleteMapping("/delete/{clientId}")
    public ResponseEntity<String> deleteClient(@PathVariable int clientId) {
        boolean isDeleted = clientService.deleteClient(clientId);
        if (isDeleted) {
            return ResponseEntity.ok("Client deleted successfully.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found.");
    }
	@PostMapping("/login")
    public ResponseEntity<ClientDTO> authenticateClient(@RequestBody ClientDTO rc) {
        ClientDTO clientDTO = clientService.findByEmailAndPassword(rc.getEmail(), rc.getPassword());
        if (clientDTO!=null) {
            return ResponseEntity.ok(clientDTO);
        }
        return ResponseEntity.ok(null);
    }

}
