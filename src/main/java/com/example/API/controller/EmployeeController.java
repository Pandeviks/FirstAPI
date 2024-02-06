package com.example.API.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.API.model.Employee;

@RestController
public class EmployeeController {
	ConcurrentMap<String, Employee> employee = new ConcurrentHashMap<>();
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable String id) {
		return employee.get(id);
	}
	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployees(){
		return new ArrayList<Employee>(employee.values());
		
	}
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee employ) {
		employee.put(employ.getEmpId(), employ);

		return employ;
		
	}

}
