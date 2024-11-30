package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.entity.Employee;
import com.springboot.service.EmployeeService;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/add_Employee")
	public String addEmployee(Model model) {
		model.addAttribute(new Employee());
		return "add_Employee";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@Validated Employee employee, BindingResult result) {
		if (result.hasErrors())
			return "add_Employee";
		employeeService.saveEmployee(employee);
		return "add_success";

	}

	@GetMapping("/get_All")
	public String getAll(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployee());
		return "get_All";
	}

	@GetMapping("/editEmployee/{id}")
	public String editEmployee(@PathVariable("id") Long id, Model model) {
		Employee emp = employeeService.getEmployee(id);
		model.addAttribute(emp);
		return "edit_Employee";
		
	}

	@PostMapping("/updateEmployee")
	public String updateEmployee(@Validated Employee employee, BindingResult result) {
		if (result.hasErrors())
			return "edit_Employee";
		employeeService.updateEmployee(employee);
		return "update_success";
		
	}

	@GetMapping("/deleteEmployee/{id}")
	@RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable("id") Long id) {
		employeeService.deleteEmployee(id);
		return "redirect:/get_All";
		
	}
}
