package com.cdac.idoplanner.service.clients;

import java.util.List;

import com.cdac.idoplanner.dto.ClientDTO;

	public interface ClientService {

	public boolean registerNewClient(ClientDTO dto);

	public List<ClientDTO> allClients();

	public  boolean updateClient(ClientDTO dto);

	public  boolean deleteClient(int clientId);

	public  boolean authenticateClient(String email, String passwordHash);
	
	
	}


