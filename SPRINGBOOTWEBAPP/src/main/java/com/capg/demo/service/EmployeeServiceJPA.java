package com.capg.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.demo.Dao.EmployeeDaoJPA;
import com.capg.demo.bean.Employee;
import com.sun.el.stream.Optional;

@Service
public class EmployeeServiceJPA implements EmployeeService{

	@Autowired
	private EmployeeDaoJPA eDao;
	
	@Override
	public List<Employee> printAllEmployee() {
		return eDao.findAll();
	}

	@Override
	public Employee getEmployee(int empid) {
		if(eDao.findById(empid).isPresent()) {
			return eDao.findById(empid).get();
		}
		else {
			return null;
		}
	}

	@Override
	public List<Employee> createEmployeeNew(Employee emp) {
		eDao.saveAndFlush(emp);
		return eDao.findAll();
	}

	@Override
	public List<Employee> removeEmployee(int empid) {
		eDao.deleteById(empid);
		return eDao.findAll();
	}

	@Override
	public List<Employee> updateEmployeeData(Employee emp) {
		eDao.saveAndFlush(emp);
		return eDao.findAll();
	}

}
