package com.example.Emp_System.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Emp_System.Dao.EmpDao;
import com.example.Emp_System.Model.Employee;
@Service
public class EmpService {
	
	// Object initialized for DAO class as in that class we extends Jparepository
	// And from Jparepository class we can take various method for crud operation.
	@Autowired
	EmpDao repo;
	
	/*
	 * Method for saving the details of employees.
	 * */
	public void addEmployee(Employee e) {
		repo.save(e);
	}
	
	/*
	 * Method for listing all employee details.
	 * */
	public List<Employee> getEmployee() {
		return repo.findAll();
	}
	
	/*
	 * Method for fetching a particular employee details
	 * */
	public Employee getMe(int id) {
		Optional<Employee> e = repo.findById(id);
		return e.get();
	}
	
	/*
	 * Method for updating the details of a employee.
	 * */
	public void updateEmployee(Employee e) {
		repo.save(e);
	}
	
	/*
	 * Method for deleting a record.
	 * */
	public void delEmp(int id) {
		repo.deleteById(id);	}
}
