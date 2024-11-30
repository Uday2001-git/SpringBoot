package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Employee;
import com.springboot.repository.EmployeeRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Transactional(rollbackForClassName = { "java.lang,Exception" })
	public Employee saveEmployee(Employee emp) {
		return employeeRepository.save(emp);

	}
	@Transactional(rollbackForClassName = { "java.lang,Exception" })
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();

	}
	@Transactional(rollbackForClassName = { "java.lang,Exception" })
	public Employee getEmployee(Long id) {
		return employeeRepository.findById(id).get();
	}

	@Transactional(rollbackForClassName = { "java.lang,Exception" })
	public Employee updateEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}
	@Transactional(rollbackForClassName = { "java.lang,Exception" })
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}
}
