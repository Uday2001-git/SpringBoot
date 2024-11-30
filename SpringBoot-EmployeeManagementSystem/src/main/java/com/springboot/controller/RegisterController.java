package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.entity.MyEmployee;
import com.springboot.repository.MyEmployeeRepository;

@Controller
public class RegisterController {

	@Autowired
	private MyEmployeeRepository myEmployeeRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/signup")
	public String signup(MyEmployee myEmployee, Model model) {
		model.addAttribute(myEmployee);
		return "register";

	}

	@GetMapping("/users")
	public String users(Model model) {
		model.addAttribute("users", myEmployeeRepository.findAll());
		return "users";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute MyEmployee myEmployee) {
		myEmployee.setPassword(passwordEncoder.encode(myEmployee.getPassword()));
		myEmployeeRepository.save(myEmployee);
		return "registrationSuccess";
	}
}
