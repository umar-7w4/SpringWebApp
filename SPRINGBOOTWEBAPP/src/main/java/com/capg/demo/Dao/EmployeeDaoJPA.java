package com.capg.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.demo.bean.Employee;

@Repository
public interface EmployeeDaoJPA extends JpaRepository<Employee,Integer>{
	
}
