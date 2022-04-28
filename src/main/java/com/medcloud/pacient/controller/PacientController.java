package com.medcloud.pacient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medcloud.pacient.model.Pacient;
import com.medcloud.pacient.service.PacientService;

@RestController
@RequestMapping("pacient")
public class PacientController {

	@Autowired
	private PacientService pacientService;
	
	@PostMapping
	public Pacient save(@RequestBody Pacient pacient) {
		
		return pacientService.save(pacient);
	}
	
	@GetMapping("{email}")
	public Pacient findByEmail(@PathVariable String email) {
		return pacientService.getPacientByEmail(email);
	}
	
}
