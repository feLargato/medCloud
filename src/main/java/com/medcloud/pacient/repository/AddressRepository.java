package com.medcloud.pacient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medcloud.pacient.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{
	
	Address findByPacientId(Long pacientId);
	
}
