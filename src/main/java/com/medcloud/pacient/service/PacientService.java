package com.medcloud.pacient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medcloud.pacient.model.Address;
import com.medcloud.pacient.model.Pacient;
import com.medcloud.pacient.repository.AddressRepository;
import com.medcloud.pacient.repository.PacienteRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PacientService {

	@Autowired
	private PacienteRepository pacienteRepository;
	@Autowired
	private AddressRepository addressRepository;
	
	
	public Pacient save(Pacient pacient) {
		Pacient createdPacient;
		try {
			createdPacient = pacienteRepository.save(pacient);
		}
		catch (Exception e) {
			log.info(String.format("An error occurred while saving pacient's data: %s", e.getMessage()));
			throw e;
		}
		
		Address address = createdPacient.getAddress();
		address.setPacientId(createdPacient.getId());
		
		Address pacientAddress = saveAddress(address);
		createdPacient.setAddress(pacientAddress);
		
		return createdPacient;
		
	}
	
	
	public Address saveAddress(Address address) {
		
		try {
			return addressRepository.save(address);
		}
		catch (Exception e) {
			log.info(String.format("An error occurred while saving pacient's address data: %s", e.getMessage()));
			throw e;
		}
		
	}
	
	public Pacient getPacientByEmail(String email) {
		Pacient pacient; 
		try {
			pacient = pacienteRepository.findByEmail(email);
			pacient.setAddress(addressRepository.findByPacientId(pacient.getId()));
		}
		catch (Exception e) {
			log.info(String.format("An error occurred while getting pacient's data: ", e.getMessage()));
			
			throw e;
		}
		
		return pacient;
		
	}
	
	
}
