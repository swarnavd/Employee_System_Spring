package com.example.Emp_System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Emp_System.Model.Employee;
import com.example.Emp_System.Service.EmpService;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {
	// Object of service class is initialized as we need the service methods in our controller class.
	@Autowired
	private EmpService emp;
	
	/*
	 * This is the url mapping for the home page where we can see all the registered employee in a list
	 * view and we edit or delete the records from this page.
	 * */
	@GetMapping("/")
	public String home(ModelMap m) {
		List<Employee> em = emp.getEmployee();
		m.addAttribute("em", em);
		return "index";
	}
	
	/*
	 * This is the url maping for save the details of employee.
	 * */
	@RequestMapping("/addemp")
	public String addemp() {
		return "addemp.html";
	}
	
	/*
	 * Url mapped for editing the employee records.
	 * */
	@RequestMapping("/edit/{id}")
	public String editemp(@PathVariable int id,ModelMap m) {
		Employee e = emp.getMe(id);
		m.addAttribute("em",e);
		return "edit.html";
	}
	
	@PostMapping("/register")
	public String regemp(@ModelAttribute Employee e, HttpSession session,Model m) {
		System.out.println(e);
		emp.addEmployee(e);
		session.setAttribute("msg", "Employee added succesfully");
		return "addemp.html";
	}
	
	/*
	 * Url mapped for the method where all the edited details of records are persisted.
	 * */
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e) {
		System.out.println(e);
		emp.updateEmployee(e);
		
		return "redirect:/";
	}
	
	/*
	 * Url mapped for deletion of records.
	 * */
	@RequestMapping("/delete/{id}")
	public String delemp(@PathVariable int id) {
		emp.delEmp(id);
		return "redirect:/";
	}
}

