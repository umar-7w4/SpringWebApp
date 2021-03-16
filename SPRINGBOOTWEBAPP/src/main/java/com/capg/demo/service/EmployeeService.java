package com.capg.demo.service;

import java.util.List;

import com.capg.demo.bean.Employee;

public interface EmployeeService {
	

	public List<Employee> printAllEmployee();
	public Employee getEmployee(int empid);
	public  List<Employee> createEmployeeNew(Employee emp);
	public List<Employee> removeEmployee(int empid);
	public List<Employee> updateEmployeeData(Employee emp);
}
