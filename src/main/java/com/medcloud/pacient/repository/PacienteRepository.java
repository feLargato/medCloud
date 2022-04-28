package com.medcloud.pacient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medcloud.pacient.model.Pacient;

public interface PacienteRepository extends JpaRepository<Pacient, Long> {
	
	Pacient findByEmail(String email);

}
