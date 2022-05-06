package com.revature.services;

import java.util.ArrayList;

import com.revature.daos.ErsDAO;
import com.revature.models.Employee;
import com.revature.models.ErsReimbursement;

//The service layer contains additional business logic needed to process rquests/responses
//It probably won't be doing much here, but it comes into play with more things like login.
public class ErsService {

	//We need an EmployeeDAO class so that we can call our getEmployees() method.
	ErsDAO eDAO = new ErsDAO();
	
	
	//this method gets all employees from the DAO (we will call this method from the Handler in the
	//controller layer).
	//This method will be pretty simple since we don't really need to process any data - just send it around
	public ArrayList<ErsReimbursement> getEmployees(){
		
		//get the list of employees from the DAO
		ArrayList<ErsReimbursement> getReimbursements = eDAO.displayAllReimbursements();
		
		
		
		//return that List of employees.
		return getReimbursements;
		
	}
	
	
	
	
	
}
