package com.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.entity.MyEmployee;
import com.springboot.repository.MyEmployeeRepository;

@Service
public class MyEmployeeService implements UserDetailsService {

	@Autowired
	private MyEmployeeRepository myEmployeeRepository;
	
	public MyEmployee saveMyEmp(MyEmployee myEmployee) {
		return myEmployeeRepository.save(myEmployee);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<MyEmployee> myEmployee = myEmployeeRepository.findByEmail(username);
		Optional<MyEmployee> myEmployee1 = myEmployeeRepository.findByUsername(username);
		 if(myEmployee.isPresent()) return myEmployee.get();
		 throw new UsernameNotFoundException("Username is not Found Please Enter Valid Username or Email");
	}
}
