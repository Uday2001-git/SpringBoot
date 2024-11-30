package com.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.MyEmployee;
import java.util.List;


public interface MyEmployeeRepository extends JpaRepository<MyEmployee, Long> {

	Optional<MyEmployee> findByUsername(String username);
	Optional<MyEmployee>  findByEmail(String email);
}
