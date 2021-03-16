package com.capg.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.demo.bean.Employee;
import com.capg.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class MyController {
	
	@Autowired
	private EmployeeService jpaService;
	
	/*
	 * To Print Data in Particular format
	produces = MediaType.APPLICATION_XML_VALUE
	produces = MediaType.APPLICATION_JSON_VALUE
	*/
	
	@GetMapping
	public List<Employee> detailsEmployee(){
		return  jpaService.printAllEmployee();	
	}
	
	
	@GetMapping("/{eid}")
	public ResponseEntity<Employee> getfindEmployee(@PathVariable("eid")int empid) {
		Employee e =   jpaService.getEmployee(empid);
		if(e!=null) {
			return new ResponseEntity<Employee>(e,HttpStatus.OK);
		}
		else {
			return  new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}
	
	/*
	 * To Takes Data in Particular format
	consumes = MediaType.APPLICATION_XML_VALUE
	consumes = MediaType.APPLICATION_JSON_VALUE
	*/
	
	@PostMapping(value = "/create")
	public  List<Employee> saveEmployee(@RequestBody Employee emp) {
		return  jpaService.createEmployeeNew(emp);
	}
	
	@DeleteMapping("{empid}")
	public List<Employee> deleteEmployeeData(@PathVariable int empid){
		return  jpaService.removeEmployee(empid);
	}
	
	@PutMapping(value="/update")
	public List<Employee> updateEmployeeData(@RequestBody Employee emp){
		return  jpaService.updateEmployeeData(emp);
		
	}
}
