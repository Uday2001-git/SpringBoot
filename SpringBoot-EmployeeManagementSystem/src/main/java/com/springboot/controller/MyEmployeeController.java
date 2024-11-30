package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.entity.MyEmployee;
import com.springboot.service.MyEmployeeService;

@Controller
public class MyEmployeeController {

	@Autowired
	private MyEmployeeService myEmployeeService;
	
	@GetMapping("/addMyEmployee")
	public String addMyEmployee(Model model) {
		model.addAttribute(new MyEmployee());
		return "add_MyEmployee";
	}

	@PostMapping("/saveMyEmployee")
	public String saveMyEmployee(MyEmployee myEmp) {
		myEmployeeService.saveMyEmp(myEmp);
		return "/login";

	}
}
