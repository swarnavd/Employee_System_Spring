package com.example.Emp_System.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Emp_System.Model.Employee;

public interface EmpDao extends JpaRepository<Employee, Integer>{
	

}
