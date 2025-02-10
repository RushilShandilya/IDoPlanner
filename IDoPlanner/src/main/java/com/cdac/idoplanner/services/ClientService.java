package com.cdac.idoplanner.services;

import java.util.List;

import com.cdac.idoplanner.dto.ClientDTO;

	public interface ClientService {

	public String registerNewClient(ClientDTO dto);

	public List<ClientDTO> allClients();

	public  boolean updateClient(ClientDTO dto);

	public  boolean deleteClient(int clientId);

	public  boolean authenticateClient(String email, String passwordHash);


	ClientDTO findByEmailAndPassword(String email, String passwordHash);
	}


