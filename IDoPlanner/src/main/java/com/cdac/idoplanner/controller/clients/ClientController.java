package com.cdac.idoplanner.controller.clients;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.IDoPlanner.DTO.ClientDTO;
import com.cdac.idoplanner.service.clients.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	ClientService clientService;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerClient(@RequestBody ClientDTO clientDTO) {
        boolean isRegistered = clientService.registerNewClient(clientDTO);
        if (isRegistered) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Client registered successfully.");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Client with this email already exists.");
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
	@PostMapping("/authenticate")
    public ResponseEntity<String> authenticateClient(@RequestParam String email, @RequestParam String passwordHash) {
        boolean isAuthenticated = clientService.authenticateClient(email, passwordHash);
        if (isAuthenticated) {
            return ResponseEntity.ok("Authentication successful.");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password.");
    }

}
