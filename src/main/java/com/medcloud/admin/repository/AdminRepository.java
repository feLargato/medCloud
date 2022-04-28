package com.medcloud.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medcloud.admin.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{

	Admin findByUser(String user);
}
