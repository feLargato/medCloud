package com.medcloud.config.service;

import com.medcloud.admin.model.Admin;
import com.medcloud.admin.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {

		Admin admin = adminRepository.findByUser(user);

		return new CustomUserDetails(admin);
		
	}

}