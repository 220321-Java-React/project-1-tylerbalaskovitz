package com.revature.controllers;

import java.util.ArrayList;
import java.util.logging.Handler;

import com.google.gson.Gson;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;

public class EmployeeController {

	//we need an EmployeeService object
		EmployeeService es = new EmployeeService();
		
		
		//this handler will get the HTTP get request for all employees, and send back the
		//employees from the database.
		public Handler getEmployeesHandler = (ctx) -> {
			
			if(ctx.req.getSession(true) != null) {
				
				
			
			
			
			//we need an ArrayList of Employee objects. (This is grabbed from the service layer)
			ArrayList<Employee> employees = es.getEmployees();
			
			
			
			//we need a GSON object to convert our Java object into JSON
			//(since we can only transfer JSON, not Java)
			Gson gson = new Gson();
			
			
			
			
			//use the JSON .toJSON() method to turn our Java into JSON
			String JSONEmployees = gson.toJson(employees);
			
			//Give a response containg our JSON string back to the webpage (or wherever the HTTP request
			//came from.
			ctx.result(JSONEmployees); // .result() sends a response of data back
			ctx.status(200); //.status() sets the HTTP status code. 200 stands for "Ok"
			} else {
				ctx.status(401);
			}
			
		};
	
}
