package com.cdac.idoplanner.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cdac.idoplanner.dto.ClientDTO;
import com.cdac.idoplanner.entities.Client;
import com.cdac.idoplanner.repositories.ClientRepository;
@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    ClientRepository clientRepository;
    
    @Autowired 
    PasswordEncoder passwordEncoder;
	@Override
	public String registerNewClient(ClientDTO dto) {
		Optional<Client> existingClient = clientRepository.findByEmail(dto.getEmail());
        if (existingClient.isPresent()) {
            return "Client already exist"; // Client already exists
        }
        Client client = new Client();
        client.setName(dto.getName());
        client.setEmail(dto.getEmail());
        client.setPhoneNumber(dto.getPhoneNumber());
        client.setPasswordHash(passwordEncoder.encode(dto.getPassword()));
        
        clientRepository.save(client);
        return "Client added successfully";
	}

	@Override
	public List<ClientDTO> allClients() {
		 List<Client> clients = clientRepository.findAll();
	        return clients.stream()
	                      .map(c -> new ClientDTO( c.getName(), c.getEmail(), c.getPhoneNumber()))
	                      .collect(Collectors.toList());
	    }
	

	@Override
	public boolean updateClient(ClientDTO dto) {
		 Optional<Client> existingClient = clientRepository.findByEmail(dto.getEmail());
	        if (existingClient.isPresent()) {
	            Client client = existingClient.get();
	            client.setName(dto.getName());
	            client.setEmail(dto.getEmail());
	            client.setPhoneNumber(dto.getPhoneNumber());
	            client.setPasswordHash(dto.getPassword());
	            
	            if(dto.getPassword() != null && !dto.getPassword().isEmpty()) {
	            	client.setPasswordHash(passwordEncoder.encode(dto.getPassword()));
	            }
	            clientRepository.save(client);
	            return true;
	        }
	        return false;
	}

	@Override
	public boolean deleteClient(int clientId) {
		Optional<Client> client = clientRepository.findById(clientId);
        if (client.isPresent()) {
            clientRepository.delete(client.get());
            return true;
        }
        return false; // Client not found
    }
	

	@Override
	public boolean authenticateClient(String email, String passwordHash) {
		 Optional<Client> client = clientRepository.findByEmail(email);
	        return client.isPresent() && passwordEncoder.matches(passwordHash,client.get().getPasswordHash());
	    }

	@Override
	public ClientDTO findByEmailAndPassword(String email, String passwordHash) {
		ClientDTO clientDTO = new ClientDTO();
		Client client = clientRepository.findByEmail(email).orElse(null);

		clientDTO.setEmail(client.getEmail());
		clientDTO.setName(client.getName());
		clientDTO.setPhoneNumber(client.getPhoneNumber());

		return clientDTO;
	}


}
