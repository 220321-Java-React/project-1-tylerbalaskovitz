package com.revature.services;

import java.util.ArrayList;

import com.revature.daos.EmployeeDAO;
import com.revature.models.Employee;

//The service layer contains additional business logic needed to process rquests/responses
//It probably won't be doing much here, but it comes into play with more things like login.
public class EmployeeService {

	//We need an EmployeeDAO class so that we can call our getEmployees() method.
	EmployeeDAO eDAO = new EmployeeDAO();
	
	
	//this method gets all employees from the DAO (we will call this method from the Handler in the
	//controller layer).
	//This method will be pretty simple since we don't really need to process any data - just send it around
	public ArrayList<Employee> getEmployees(){
		
		//get the list of employees from the DAO
		ArrayList<Employee> employees = eDAO.getEmployees();
		
		
		
		//return that List of employees.
		return employees;
		
	}
	
	
	
	
	
}
